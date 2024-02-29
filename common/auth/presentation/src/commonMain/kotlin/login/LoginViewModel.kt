package login

import AuthRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.launch
import login.models.LoginAction
import login.models.LoginEvent
import login.models.LoginViewState

class LoginViewModel : BaseSharedViewModel<LoginViewState, LoginAction, LoginEvent>(
    initialState = LoginViewState("", "")
) {

    private val authRepository: AuthRepository = Inject.instance()

    init {
        checkUserLoginIn()
    }

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.EmailChanged -> obtainEmailChanged(viewEvent.email)
            is LoginEvent.PasswordChanged -> obtainPasswordChanged(viewEvent.password)
            is LoginEvent.LoginClicked -> sendLogin()
            LoginEvent.ForgotClicked -> openForgot()
            LoginEvent.RegisterClicked -> openRegister()
            LoginEvent.PasswordShowClick -> changePasswordVisibility()
        }
    }

    private fun checkUserLoginIn() {
        if (authRepository.isUserLoggedIn()) {
            viewAction = LoginAction.OpenMainFlow
        }
    }

    private fun changePasswordVisibility() {
        viewState = viewState.copy(passwordHidden = !viewState.passwordHidden)
    }

    private fun sendLogin() {
        viewState = viewState.copy(isSending = true)

        viewModelScope.launch {
            viewState = try {
                val response = authRepository.login(viewState.email, viewState.password)

                if (response.token.isNotBlank()) {
                    viewAction = LoginAction.OpenMainFlow
                    viewState.copy(email = "", password = "", isSending = true)

                } else {
                    viewState.copy(isSending = false)
                }

            } catch (e: Exception) {
                viewState.copy(isSending = false)
            }
        }
    }

    private fun obtainEmailChanged(email: String) {
        viewState = viewState.copy(email = email)
    }

    private fun obtainPasswordChanged(password: String) {
        viewState = viewState.copy(password = password)
    }

    private fun openForgot() {
        viewAction = LoginAction.OpenForgotPasswordScreen
    }

    private fun openRegister() {
        viewAction = LoginAction.OpenRegistrationScreen
    }
}