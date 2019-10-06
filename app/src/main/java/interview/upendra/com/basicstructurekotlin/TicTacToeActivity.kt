package interview.upendra.com.basicstructurekotlin

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

    var tvFirst: TextView? = null;
    var tvSecond: TextView? = null;
    var tvThirt: TextView? = null;
    var tvFourth: TextView? = null;

    var tvFifth: TextView? = null;
    var tvSixth: TextView? = null;
    var tvSeventh: TextView? = null;
    var tvEighth: TextView? = null;
    var tvNinth: TextView? = null;


    val mAuth = FirebaseAuth.getInstance();
    var mDatabase = FirebaseDatabase.getInstance();
    val mReference = mDatabase.reference

    var userId: String? = null;

    var sessionId: String? = null;
    var player1 = ArrayList<Int>();
    var player2 = ArrayList<Int>();
    var playerSymbol: String? = null;

    var ActivePlayer = 1;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tic_tac_toe)

        btnAccept = findViewById(R.id.btnAccept)
        btnRequest = findViewById(R.id.btnRequest)
        etUser = findViewById(R.id.etUser);


        tvFirst = findViewById(R.id.tvFirst)
        tvSecond = findViewById(R.id.tvSecond)
        tvThirt = findViewById(R.id.tvThird);
        tvFourth = findViewById(R.id.tvFourth)
        tvFifth = findViewById(R.id.tvFifth)
        tvSixth = findViewById(R.id.tvSixth);
        tvSeventh = findViewById(R.id.tvSeventh)
        tvEighth = findViewById(R.id.tvEighth)
        tvNinth = findViewById(R.id.tvNinth);

        onClickCell(tvFirst!!)
        onClickCell(tvSecond!!)
        onClickCell(tvThirt!!)
        onClickCell(tvFourth!!)
        onClickCell(tvFifth!!)
        onClickCell(tvSixth!!)
        onClickCell(tvSeventh!!)
        onClickCell(tvEighth!!)
        onClickCell(tvNinth!!)




        btnRequest!!.setOnClickListener({

            mReference.child("Users").child(etUser!!.text.toString()).child("Request").push()
                .setValue(userId);
            playOnline(splitEmailId(userId!!) + splitEmailId(etUser!!.editableText.toString()))

        })

        btnAccept!!.setOnClickListener({
            mReference.child("Users").child(etUser!!.text.toString()).child("Request").push()
                .setValue(userId);
            playOnline(splitEmailId(etUser!!.editableText.toString()) + splitEmailId(userId!!))


        })


        incomingCalls();
    }


    fun playOnline(sessionId: String) {
        this.sessionId = sessionId;
        mReference.child("Play").removeValue()
        textViewCalls()

    }


    fun onClickCell(view: View) {

        var cellId = 0;
        when (view.id) {

            R.id.tvFirst -> cellId = 1
            R.id.tvSecond -> cellId = 2
            R.id.tvThird -> cellId = 3
            R.id.tvFourth -> cellId = 4
            R.id.tvFifth -> cellId = 5
            R.id.tvSixth -> cellId = 6
            R.id.tvSeventh -> cellId = 7
            R.id.tvEighth -> cellId = 8
            R.id.tvNinth -> cellId = 9
            else -> {

            }


        }

        mReference.child("Play").child(sessionId!!).child(cellId.toString()).setValue(userId)

        // PlayGame(cellId, view as TextView)

    }


    fun autoPlay(cellid: Int) {

        var tvSelect: TextView? = null

        when (cellid) {
            1 -> tvSelect = tvFirst
            2 -> tvSelect = tvSecond
            3 -> tvSelect = tvThirt
            4 -> tvSelect = tvFourth
            5 -> tvSelect = tvFifth
            6 -> tvSelect = tvSixth
            7 -> tvSelect = tvSeventh
            8 -> tvEighth = tvEighth
            9 -> tvNinth = tvNinth
        }

        playGame(cellid, tvSelect!!)
    }


    fun playGame(cellId: Int, textView: TextView) {

        if (ActivePlayer == 1) {

            textView.setText("X")

            ActivePlayer = 2;
            player1.add(cellId)

        } else {

            textView.setText("O")
            ActivePlayer = 1
            player2.add(cellId)


        }

    }


    fun textViewCalls() {

        mReference.child("Play").child(sessionId!!)
            .addValueEventListener(
                object : ValueEventListener {

                    override fun onDataChange(p0: DataSnapshot) {
                        val map = p0.value as HashMap<String, String>

                        if (map != null) {
                            player1.clear();
                            player2.clear()
                            for (key in map.keys) {
                                val value = map[key] as String

                                if (value.equals(userId)) {
                                    ActivePlayer = if (playerSymbol!!.equals("X")) 2 else 1
                                } else {
                                    ActivePlayer = if (playerSymbol!!.equals("X")) 1 else 2

                                }

                                autoPlay(key as Int)
                            }

                        }


                    }

                    override fun onCancelled(p0: DatabaseError) {
                    }

                });
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
