package interview.upendra.com.basicstructurekotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class CustomBroadcast : BroadcastReceiver() {

    val ACTION = "com.custom.alarm"


    override fun onReceive(context: Context?, intent: Intent?) {

        if (ACTION.equals(intent!!.action)) {

            Toast.makeText(context, "Broadcast is active", Toast.LENGTH_LONG).show()

        }

    }

}