package uz.coder.cryptovaluta.presentation

import android.app.Application
import com.mocklets.pluto.Pluto

class App :Application(){
    override fun onCreate() {
        Pluto.initialize(this)
        super.onCreate()
    }
}