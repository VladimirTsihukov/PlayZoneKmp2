package admin.games

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adeo.kviewmodel.compose.observeAsState
import com.adeo.kviewmodel.odyssey.StoredViewModel
import games.AdminGamesViewModel
import games.models.AdminGamesAction
import games.models.AdminGamesEvent
import navigation.NavigationTree
import ru.alexgladkov.odyssey.compose.extensions.present
import ru.alexgladkov.odyssey.compose.local.LocalRootController
import theme.Theme

@Composable
fun AdminGamesScreen() {
    val rootController = LocalRootController.current

    StoredViewModel({ AdminGamesViewModel() }) { viewModel ->
        val viewState = viewModel.viewStates().observeAsState().value
        val viewAction = viewModel.viewActions().observeAsState().value

        Column(modifier = Modifier.padding(16.dp)) {

            Row {
                Text("Game List", fontSize = 28.sp, color = Theme.colors.secondaryTextColor)

                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add game",
                    modifier = Modifier.clickable {
                        viewModel.obtainEvent(AdminGamesEvent.AddGameClick)
                    },
                    tint = Theme.colors.primaryAction,
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn {
                items(viewState.games) { game ->
                    Text(
                        text = game.title,
                        color = Theme.colors.secondaryTextColor,
                        fontWeight = FontWeight.Medium,
                    )
                }
            }
        }

        when (viewAction) {
            is AdminGamesAction.ShowAddGame -> rootController.findRootController()
                .present(screen = NavigationTree.Admin.CreateGame.name)

            null -> {}
        }

        LaunchedEffect(Unit) {
            viewModel.obtainEvent(AdminGamesEvent.ViewInited)
        }
    }
}