package login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Clear
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import login.models.LoginEvent
import login.models.LoginViewState
import theme.AppTheme
import theme.Theme

@Composable
fun LoginView(state: LoginViewState, eventHolder: (LoginEvent) -> Unit) {

    Column(
        modifier = Modifier.padding(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login Now",
            color = Theme.colors.thirdTextColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            modifier = Modifier.padding(top = 15.dp),
            text = "Welcome back to PlayZone! Enter your email addres and your password to enjoy the latest features of PlayZone",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = Theme.colors.hintTextColor
        )

        Spacer(modifier = Modifier.height(50.dp))

        TextField(
            value = state.email,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = !state.isSending,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF1F2430),
                textColor = Color(0xFF696C75),
                cursorColor = Theme.colors.highlightTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            placeholder = {
                Text(text = "You login", color = Theme.colors.hintTextColor)
            },
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                eventHolder.invoke(LoginEvent.EmailChanged(it))
            })

        Spacer(modifier = Modifier.height(24.dp))

        TextField(
            value = state.password,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            enabled = !state.isSending,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF1F2430),
                textColor = Color(0xFF696C75),
                cursorColor = Theme.colors.highlightTextColor,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            visualTransformation = if (state.passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
            placeholder = {
                Text(text = "You password", color = Theme.colors.hintTextColor)
            },
            trailingIcon = {
                Icon(
                    imageVector = if (state.passwordHidden) Icons.Outlined.Clear else Icons.Outlined.Lock,
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        eventHolder.invoke(LoginEvent.PasswordShowClick)
                    },
                    tint = Theme.colors.highlightTextColor,
                )
            },
            shape = RoundedCornerShape(10.dp),
            onValueChange = {
                eventHolder.invoke(LoginEvent.PasswordChanged(it))
            })

        Spacer(modifier = Modifier.height(30.dp))

        Row(modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.weight(1f))

            Text(
                "Forgot Password",
                modifier = Modifier.clickable { eventHolder.invoke(LoginEvent.ForgotClicked) },
                color = Theme.colors.primaryAction,
                fontSize = 12.sp
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Theme.colors.primaryAction
            ),
            enabled = !state.isSending,
            shape = RoundedCornerShape(10.dp),
            onClick = {
                eventHolder.invoke(LoginEvent.LoginClicked)
            }) {
            Text(
                text = "Login Now",
                color = Theme.colors.primaryTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}


@Composable
@Preview()
fun LoginViewPreview() {
    AppTheme {
        LoginView(state = LoginViewState("email", "password")) {

        }
    }
}