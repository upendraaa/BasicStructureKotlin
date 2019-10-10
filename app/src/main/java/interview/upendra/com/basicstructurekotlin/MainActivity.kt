package interview.upendra.com.basicstructurekotlin

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {

    var personAdapter: PersonAdapter?=null;

    var buttonSubmit: Button?=null;
    var buttonCancel: Button?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSubmit = findViewById(R.id.btnSubmit)
        buttonCancel = findViewById(R.id.btnNext)


        buttonCancel!!.setOnClickListener({

            //Start broadcast

            var intent = Intent(this, CustomBroadcast::class.java)
            // intent.setAction("com.custom.alarm")
            intent.action = "com.custom.alarm"
            var calendar = Calendar.getInstance()
            calendar.set(Calendar.HOUR_OF_DAY, 18)
            calendar.set(Calendar.MINUTE, 38)

            var pi = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

            var am = getSystemService(Context.ALARM_SERVICE) as AlarmManager;
            am.setRepeating(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY,
                pi
            )




        })

        buttonSubmit!!.setOnClickListener({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        })
    }

    override fun onStart() {
        super.onStart()
    }
}
