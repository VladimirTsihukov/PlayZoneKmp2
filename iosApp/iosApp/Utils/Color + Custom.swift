//
//  Color + Custom.swift
//  iosApp
//
//  Created by Vladimir Tishukov on 23.02.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI

extension Color {
    
    static let textPrimary = Color("primaryTextColor")
    static let textSecondaty = Color("secondaryTextColor")
    static let backgroundPrimary = Color("backgroundPrimary")
    static let secondaryBackground = Color("secondaryBackground")
    static let tint = Color("tintColor")
    static let action = Color("actionTextColor")
    
    init (hex: UInt, alpha: Double = 1) {
        self.init(
            .sRGB,
            red: Double((hex >> 16) & 0xff) / 255,
            green: Double((hex >> 08) & 0xff) / 255,
            blue: Double((hex >> 00) & 0xff) / 255,
            opacity: alpha
        )
    }
}
