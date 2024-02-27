//
//  SubmitBtnView.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 25.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct ActionBtn: View {
    
    let title: String
    let enabled: Bool
    let height: CGFloat = 56
    let horizontalMargin: CGFloat = 16
    let action: () -> Void
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.tint)
                .opacity(enabled ? 1.0 : 0.5)
            
            Text(title)
                .foregroundColor(.action)
        }
        .padding(EdgeInsets(top: 0, leading: horizontalMargin, bottom: 0, trailing: horizontalMargin))
        .onTapGesture {
            action()
        }
    }
}

#Preview {
    ActionBtn(title: "Create account", enabled: true) { }
        .background(Color.backgroundPrimary)
        .frame(height: 56)
}
