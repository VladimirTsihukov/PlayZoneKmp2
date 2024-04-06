package com.tishukoff.playzonekmp2.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tishukoff.playzonekmp2.android.navigation.setupThemedNavigation

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupThemedNavigation()
    }
}
