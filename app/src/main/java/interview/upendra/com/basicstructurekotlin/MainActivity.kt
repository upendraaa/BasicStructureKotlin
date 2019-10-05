package interview.upendra.com.basicstructurekotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

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
