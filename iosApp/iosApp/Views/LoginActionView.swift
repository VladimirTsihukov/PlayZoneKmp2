//
//  LoginActionView.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 25.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LoginActionView: View {
    
    let onTapClicked: () -> Void
    
    var body: some View {
        
        HStack {
            Spacer()
            
            Text("Forgot password")
                .foregroundColor(Color.tint)
                .onTapGesture {
                    onTapClicked()
                }
            
            Spacer().frame(width: 24)
        }
        
    }
}

#Preview {
    LoginActionView{}
        .background(Color.backgroundPrimary)
}
