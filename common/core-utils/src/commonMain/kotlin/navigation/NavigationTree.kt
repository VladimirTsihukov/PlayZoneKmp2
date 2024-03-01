package navigation

object NavigationTree {

    enum class Splash {
        SplashScreen
    }


    enum class Auth {
        AuthFlow,
        Login,
        Register,
        ForgotPassword,
    }

    enum class Main {
        Dashboard,
        Event,
        Game,
        Home,
        Profile,
        Search,
        Videos,
    }
}