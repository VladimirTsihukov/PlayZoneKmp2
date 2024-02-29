package home.models

data class HomeViewState(
    val userName: String,
    val avatarUtl: String,
    val status: String = "Morning",
)