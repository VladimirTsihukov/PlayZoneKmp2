//
//  CommonTextField.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 23.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct CommonTextField: View {

    
    @State private var value: String = ""
    private let hint: String
    private let enabled: Bool
    private let isSecure: Bool
    private let onValueChange: (String) -> Void
    
    init(hint: String,
         enabled: Bool = true,
         isSecure: Bool = false,
         onValueChange: @escaping (String) -> Void) {
        self.hint = hint
        self.enabled = enabled
        self.isSecure = isSecure
        self.onValueChange = onValueChange
    }
    
    var body: some View {
        ZStack(alignment: .leading) {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.secondaryBackground)
            
            if (value.isEmpty) {
                Text(hint)
                    .foregroundColor(Color.textPrimary.opacity(0.5))
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .font(.system(size: 16))
            }
            
            if isSecure {
                SecureField(value, text: $value)
                    .foregroundColor(.textPrimary)
                    .font(.system(size: 16))
                    .autocapitalization(/*@START_MENU_TOKEN@*/.none/*@END_MENU_TOKEN@*/)
                    .disableAutocorrection(true)
                    .disabled(!enabled)
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .onChange(of: value) { newValue in
                        onValueChange(newValue)
                    }            } else {
                TextField(value, text: $value)
                    .foregroundColor(.textPrimary)
                    .font(.system(size: 16))
                    .autocapitalization(/*@START_MENU_TOKEN@*/.none/*@END_MENU_TOKEN@*/)
                    .disabled(!enabled)
                    .disableAutocorrection(true)
                    .padding(EdgeInsets(top: 0, leading: 20, bottom: 0, trailing: 20))
                    .onChange(of: value) { newValue in
                        onValueChange(newValue)
                    }
            }
        }
        .frame(height: 56)
        .padding(EdgeInsets(top: 0, leading: 24, bottom: 0, trailing: 24))
    }
}

#Preview {
    CommonTextField(hint: "Your Email", enabled: true, isSecure: true, onValueChange: {newValue in
        print("CommonTextField")
    })
}
