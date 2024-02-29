package search.data

sealed class SearchEvent {
    data class QueryChanged(val query: String) : SearchEvent()
    object GameClicked : SearchEvent()
}