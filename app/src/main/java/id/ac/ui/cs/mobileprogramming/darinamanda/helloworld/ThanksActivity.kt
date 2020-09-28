package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_thanks.*

class ThanksActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thanks)
        thanksButton.setOnClickListener {
            thanksText.text = newText()
        }
    }
    fun newText() : String {
         return "Terima kasih karena sudah berjuang sampai hari ini"
    }
}
