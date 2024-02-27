//
//  LoginView.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 22.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK


struct LoginView: View {
    
    let viewState: LoginViewState
    let eventHandler: (LoginEvent) -> Void
    
    var body: some View {
        VStack {
            VStack {
                Spacer().frame(height: 36)
                Text("Login Now")
                    .foregroundColor(.textPrimary)
                    .fontWeight(.bold)
                    .font(.system(size: 24))
                
                Text("Welcome back to PlayZone! Enter your email addres and your password to enjoy the latest features of PlayZone")
                    .foregroundColor(.textPrimary.opacity(0.5))
                    .fixedSize(horizontal: false, vertical: true)
                    .multilineTextAlignment(.center)
                    .padding(EdgeInsets(top: 16, leading: 30, bottom: 0, trailing: 30))
            }
            
            Spacer().frame(height: 50)
            
            CommonTextField(hint: "Login", enabled: !viewState.isSending) { newValue in
                eventHandler(LoginEvent.EmailChanged(email: newValue))
            }
            
            Spacer().frame(height: 20)
            
            CommonTextField(hint: "Password", enabled: !viewState.isSending, isSecure: !viewState.passwordHidden) { newValue in
                eventHandler(LoginEvent.PasswordChanged(password: newValue))
            }
            
            Spacer().frame(height: 30)
            
            LoginActionView{
                eventHandler(LoginEvent.ForgotClicked())
            }
            
            Spacer().frame(height: 30)
            
            ActionBtn(title: "Login Now", enabled: !viewState.isSending) {
                eventHandler(LoginEvent.LoginClicked())
            }
            .frame(height: 56)
        }
        
        Spacer()
        
        HStack {
            Text("Don't have account?")
                .foregroundColor(.textPrimary)
                .opacity(0.5)
            
            Text("Create one")
                .foregroundColor(.tint)
                .fontWeight(/*@START_MENU_TOKEN@*/.bold/*@END_MENU_TOKEN@*/)
                .onTapGesture {
                    eventHandler(LoginEvent.RegisterClicked())
                }
        }
    }
}


#Preview {
    LoginView(viewState: LoginViewState(
        email: "Email Address",
        password: "Password",
        isSending: false,
        passwordHidden: true
    )) { even in
        
    }
    .background(Color.backgroundPrimary)
}
