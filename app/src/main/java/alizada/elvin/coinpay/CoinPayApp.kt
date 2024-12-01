package alizada.elvin.coinpay

import android.app.Application
import timber.log.Timber

class CoinPayApp : Application() {

    override fun onCreate() {
        super.onCreate()
        setupTimberLogging()
    }

    private fun setupTimberLogging() {
        if (BuildConfig.DEBUG) {
            // Plant debug tree in debug builds
            Timber.plant(Timber.DebugTree())
        }
    }

}