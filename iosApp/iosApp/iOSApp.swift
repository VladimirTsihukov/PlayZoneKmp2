//import SwiftUI
//import SharedSDK
//
//@main
//struct iOSApp: App {
//    
//    init () {
//        PlatformSDK().doInit(configuration: PlatformConfiguration())
//    }
//    
//	var body: some Scene {
//		WindowGroup {
//			ContentView()
//		}
//	}
//}

import UIKit
import SharedSDK

@UIApplicationMain
class AppDelegate: UIResponder, UIApplicationDelegate {
    var window: UIWindow?
    
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        window = UIWindow(frame: UIScreen.main.bounds)
        let mainViewController = Main_iosKt.MainViewController()
        window?.rootViewController = mainViewController
        window?.makeKeyAndVisible()
        return true
    }
}
