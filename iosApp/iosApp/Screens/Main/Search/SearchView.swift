//
//  SearchView.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 29.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct SearchView: View {
    
    let viewState: SearchViewState
    let eventHandler: (SearchEvent) -> Void
    
    var body: some View {
        ZStack {
            VStack {
                Spacer().frame(height: 26)
                CommonTextField(hint: "Seatch Game") { newValue in
                    eventHandler(SearchEvent.QueryChanged(query: newValue))
                }
                
                Spacer().frame(height: 16)
                
                ScrollView {
                    VStack {
                        ForEach(viewState.games, id: \.gameId) { game in
                            VStack {
                                Text(game.title)
                                    .foregroundColor(Color.textPrimary)
                                    .padding(EdgeInsets(top: 8, leading: 16, bottom: 8, trailing: 16))
                            }
                        }
                    }
                }
            }
        }
        .frame(maxWidth: .infinity, maxHeight: .infinity)
        .background(Color.backgroundPrimary)
    }
}
