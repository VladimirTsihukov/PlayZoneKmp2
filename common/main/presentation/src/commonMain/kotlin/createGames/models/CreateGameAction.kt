package createGames.models

sealed class CreateGameAction {
    object CloseScreen : CreateGameAction()
}
