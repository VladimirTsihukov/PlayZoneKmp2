package search

import GamesRepository
import com.adeo.kviewmodel.BaseSharedViewModel
import di.Inject
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import search.data.SearchAction
import search.data.SearchEvent
import search.data.SearchViewState

class SearchViewModel : BaseSharedViewModel<SearchViewState, SearchAction, SearchEvent>(
    initialState = SearchViewState()
)  {

    private val gamesRepository: GamesRepository = Inject.instance()
    private var searchJob: Job? = null

    override fun obtainEvent(viewEvent: SearchEvent) {
        when(viewEvent) {
            SearchEvent.GameClicked -> showDetailGame()
            is SearchEvent.QueryChanged -> searchGame(viewEvent.query)
        }
    }

    private fun showDetailGame() {
        viewAction = SearchAction.ShowGameDetail
    }

    private fun searchGame(query: String) {
        searchJob = viewModelScope.launch {
            viewState = viewState.copy(query = query)
            searchJob?.cancel()
            delay(500)

            viewState = try {
                val games = gamesRepository.searchGame(query)
                viewState.copy(games = games)
            } catch (e: Exception) {
                viewState.copy(games = emptyList())
            }
        }
    }
}