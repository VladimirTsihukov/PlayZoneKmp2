//
//  MainScreen.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 27.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct MainScreen: View {
    var body: some View {
        TabView {
            HomeScreen()
                .tabItem {
                    Label("Home", systemImage: "house")
                }
            
            SearchScreen()
                .tabItem {
                    Label("Search", systemImage: "magnifyingglass")
                }
            
            EventsScreen()
                .tabItem {
                    Label("Events", systemImage: "person.fill")
                }
            
            VideosScreen()
                .tabItem {
                    Label("Videos", systemImage: "person.fill")
                }
        }
    }
}

#Preview {
    MainScreen()
}
