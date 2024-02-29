package settings

import com.russhwolf.settings.Settings
import com.russhwolf.settings.get

class SettingsAuthDataSource(
    private val setting: Settings,
) {

    companion object {
        private const val tokenKey = "tokenKey"
    }

    fun saveToken(token: String) {
        setting.putString(tokenKey, token)
    }

    fun fetchToken(): String {
       return setting[tokenKey, ""]
    }
}