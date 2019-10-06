package interview.upendra.com.basicstructurekotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LoginActivity : AppCompatActivity(){

    var etEmail: EditText?=null;
    var etPassword: EditText?=null;
    var btnLogin: Button?=null;
    var mAuth:FirebaseAuth?=null;
    var mDatabase: FirebaseDatabase? = null
    var mReferenceId: DatabaseReference? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        FirebaseApp.initializeApp(this)
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance()
        mReferenceId = mDatabase!!.reference

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        //First time User
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

        if (mAuth!!.currentUser != null) {

            val currentUser = mAuth!!.currentUser;

            mReferenceId!!.child("Users").child(
                currentUser!!.uid
            ).setValue(currentUser.email)
            
            Toast.makeText(
                this,
                "Authorized User!", Toast.LENGTH_LONG
            ).show();

            val intent = Intent(this, TicTacToeActivity::class.java)
            startActivity(intent)
        }
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