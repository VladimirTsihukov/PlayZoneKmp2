//
//  HomeView.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 28.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct HomeView: View {
    
    let viewState: HomeViewState
    let eventHandler: (HomeEvent) -> Void
    
    var body: some View {
        ZStack {
            VStack {
                Spacer().frame(height: 16)
                
                HStack {
                    Spacer().frame(width: 16)
                    
                    AsyncImage(url: URL(string: viewState.avatarUtl), content: { image in
                        image
                            .resizable()
                            .aspectRatio(contentMode: /*@START_MENU_TOKEN@*/.fill/*@END_MENU_TOKEN@*/)
                            .frame(width: 56, height: 56)
                    }, placeholder: {
                        ProgressView()
                    })
                    .clipShape(/*@START_MENU_TOKEN@*/Circle()/*@END_MENU_TOKEN@*/)
                    .frame(width: 56, height: 56)
                    
                    Spacer().frame(width: 20)
                    
                    VStack {
                        Text(viewState.status)
                            .foregroundColor(.textPrimary.opacity(0.5))
                            .font(.system(size: 12))
                        
                        Spacer().frame(height: 4)
                        
                        Text(viewState.userName)
                            .foregroundColor(.textPrimary)
                            .fontWeight(.bold)
                            .font(.system(size: 12))
                    }
                    
                    Spacer()
                }
                .onTapGesture {
                    eventHandler(HomeEvent.UserProfileClicked())
                }
                
                Spacer()
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.backgroundPrimary)
        
    }
}

#Preview {
    HomeView(viewState: HomeViewState(userName: "", avatarUtl: "", status: "")) { event in
        
    }
 }
