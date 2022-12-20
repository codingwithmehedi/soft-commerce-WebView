package soft.com.softcommerce.ui.networkManager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager


class NetworkChangeReceiver : BroadcastReceiver() {
    var connectionChangeCallback: ConnectionChangeCallback? = null

    override fun onReceive(context: Context, intent: Intent?) {
        val cm = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        val isConnected = (activeNetwork != null
                && activeNetwork.isConnectedOrConnecting)
        if (connectionChangeCallback != null) {
            connectionChangeCallback!!.onConnectionChange(isConnected)
        }
    }

    @JvmName("setConnectionChangeCallback1")
    fun setConnectionChangeCallback(connectionChangeCallback: ConnectionChangeCallback?) {
        this.connectionChangeCallback = connectionChangeCallback
    }


    interface ConnectionChangeCallback {
        fun onConnectionChange(isConnected: Boolean)
    }

}