package home

import androidx.compose.runtime.Composable
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import home.models.HomeAction
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.push
import ru.alexgladkov.odyssey.compose.local.LocalRootController

@Composable
fun HomeScreen() {
    val rootController = LocalRootController.current

    StoredViewModel(factory = { HomeViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState()
        val viewAction = viewModel.viewActions().observeAsState()

        when (viewAction.value) {
            HomeAction.ShowUserProfile -> rootController.push(
                screen = NavigationTree.Main.Profile.name
            )

            null -> Unit
        }

        HomeView(viewState.value) { event ->
            viewModel.obtainEvent(event)
        }
    }
}