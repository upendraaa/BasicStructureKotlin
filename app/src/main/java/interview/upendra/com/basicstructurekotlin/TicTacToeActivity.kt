package interview.upendra.com.basicstructurekotlin

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class TicTacToeActivity : AppCompatActivity() {


    var btnRequest: Button? = null;
    var btnAccept: Button? = null;
    var etUser: EditText? = null;

    val mAuth = FirebaseAuth.getInstance();
    var mDatabase = FirebaseDatabase.getInstance();
    val mReference = mDatabase.reference

    var userId: String? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        btnAccept = findViewById(R.id.btnAccept)
        btnRequest = findViewById(R.id.btnRequest)

        etUser = findViewById(R.id.etUser);

        btnRequest!!.setOnClickListener({

            mReference.child("Users").child(etUser!!.text.toString()).child("Request").push()
                .setValue(userId);
        })

        btnAccept!!.setOnClickListener({
            mReference.child("Users").child(etUser!!.text.toString()).child("Request").push()
                .setValue(userId);

        })

        incomingCalls();
    }


    fun incomingCalls() {

        mReference.child("Users").child(splitEmailId(userId!!)).child("Request")
            .addValueEventListener(
                object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot) {
                        val map = p0.value as HashMap<String, String>

                        if (map != null) {

                            for (key in map.keys) {
                                val value = map[key] as String

                                etUser!!.setText(value)

                                mReference.child("Users").child(splitEmailId(userId!!))
                                    .child("Request").setValue(true)
                                break;
                            }

                        }


                    }

                    override fun onCancelled(p0: DatabaseError) {
                    }

                }
            )

    }


    fun splitEmailId(email: String): String {

        var splits = email.split("@")
        return splits.get(0)
    }
}
