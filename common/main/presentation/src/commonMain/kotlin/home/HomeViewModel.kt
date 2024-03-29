package home

import com.adeo.kviewmodel.BaseSharedViewModel
import home.models.HomeAction
import home.models.HomeEvent
import home.models.HomeViewState

class HomeViewModel: BaseSharedViewModel<HomeViewState, HomeAction, HomeEvent>(
    initialState = HomeViewState("Jon Snow", "https://upload.wikimedia.org/wikipedia/en/3/30/Jon_Snow_Season_8.png")
) {
    override fun obtainEvent(viewEvent: HomeEvent) {
        when (viewEvent) {
            HomeEvent.UserProfileClicked -> showUserProfile()
        }
    }

    private fun showUserProfile() {
        viewAction = HomeAction.ShowUserProfile
    }
}