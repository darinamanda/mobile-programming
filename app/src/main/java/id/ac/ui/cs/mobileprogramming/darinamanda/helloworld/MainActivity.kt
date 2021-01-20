package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private external fun fivemultiplier(number: Int): Int
    private var number: Int = 0
    private lateinit var numberInput: EditText
    private lateinit var numberView: TextView
    private lateinit var submitButton: Button
    companion object {
        init {
            System.loadLibrary("multiply")
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        numberInput= findViewById(R.id.inputtext)
        numberView= findViewById(R.id.result)
        submitButton = findViewById(R.id.mulbutton)

        submitButton.setOnClickListener{
            number = fivemultiplier(numberInput.text.toString().toInt())
            Log.d("five", number.toString())
            numberView.text = number.toString()

        }
    }

}
