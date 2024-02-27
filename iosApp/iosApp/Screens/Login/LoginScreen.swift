//
//  LoginScreen.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 26.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginViewScreen: View {
    
    @State private var isForgotPresented = false
    @State private var isReqistrationPresented = false
    @State private var isMainPresented = false
    
    private let viewModel = LoginViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(viewModel.viewStates())) { viewState in
            LoginView(viewState: viewState) { event in
                viewModel.obtainEvent(viewEvent: event)
            }
        }
        .sheet(isPresented: $isForgotPresented, content: {
            ForgotScreen()
        })
        .sheet(isPresented: $isReqistrationPresented, content: {
            ReqistrationScreen()
        })
        .fullScreenCover(isPresented: $isMainPresented, content: {
            MainScreen()
        })
        .onReceive(sharedPublisher(viewModel.viewActions())) { action in
            switch(action) {
            case LoginAction.OpenForgotPasswordScreen():
                isForgotPresented = true
                
            case LoginAction.OpenRegistrationScreen():
                isReqistrationPresented = true
                
            case LoginAction.OpenMainFlow():
                isMainPresented = true
                
            default:
                break
            }
        }
    }
}
