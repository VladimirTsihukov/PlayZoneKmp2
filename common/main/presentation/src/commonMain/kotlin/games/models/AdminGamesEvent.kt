package games.models

sealed class AdminGamesEvent {
    object AddGameClick: AdminGamesEvent()
    object ViewInited: AdminGamesEvent()
}