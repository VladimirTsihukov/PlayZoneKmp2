//
//  HomeScreen.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 27.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct HomeScreen: View {
    
    private let viewModel = HomeViewModel()
    @State private var isProfilePresenter = false
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())) { viewState in
            HomeView(viewState: viewState) { event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
        .sheet(isPresented: $isProfilePresenter) {
            Text("Hello Profiler")
        }
        .onReceive(sharedPublisher(viewModel.viewActions())) { action in
            switch action {
            case HomeAction.ShowUserProfile():
                isProfilePresenter = true
                
            default:
                break
            }
        }
        
    }
}

#Preview {
    HomeScreen()
}
