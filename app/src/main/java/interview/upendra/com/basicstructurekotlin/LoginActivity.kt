package interview.upendra.com.basicstructurekotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity(){

    var etEmail: EditText?=null;
    var etPassword: EditText?=null;
    var btnLogin: Button?=null;
    var mAuth:FirebaseAuth?=null;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        FirebaseApp.initializeApp(this)
        mAuth = FirebaseAuth.getInstance();

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin!!.setOnClickListener({
            mAuth!!.createUserWithEmailAndPassword(etEmail!!.editableText.toString(),
                etPassword!!.editableText.toString()).addOnCompleteListener(this){
                task ->  if(task.isSuccessful)
            {
                 Toast.makeText(this,"Logged in Successful",Toast.LENGTH_LONG).show()
            }else {
                Toast.makeText(this,"Logged in Failure",Toast.LENGTH_LONG).show()

            }
            }
        })
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onPause() {
        super.onPause()
    }


    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}