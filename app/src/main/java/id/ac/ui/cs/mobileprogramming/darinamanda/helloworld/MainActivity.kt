package id.ac.ui.cs.mobileprogramming.darinamanda.helloworld

import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private var VISIBLE = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        val handler = Handler()
        val digital = findViewById<TextView>(R.id.digitalTime)
        val start = findViewById<Button>(R.id.startBtn)
        val pause = findViewById<Button>(R.id.pauseBtn)
        val reset = findViewById<Button>(R.id.resetBtn)

        pause.visibility = View.INVISIBLE
        reset.visibility = View.INVISIBLE


        val runnable = object : Runnable {
            override fun run() {
                viewModel.onRunning()
                digital.setText(viewModel.strTime.value!!).toString()
                handler.postDelayed(this, 0)
            }
        }
        start.setOnClickListener {
            viewModel.onStart()
            handler.postDelayed(runnable, 0)
            pause.visibility = View.VISIBLE
            reset.visibility = View.VISIBLE
            start.visibility = View.INVISIBLE
        }
        pause.setOnClickListener {
            viewModel.changeState()
            if (viewModel.resume.value!!) {
                viewModel.onPause()
                handler.removeCallbacks(runnable)
                pause.setText(R.string.resume).toString()
                pause.setBackgroundResource(R.drawable.resume_background)
            } else {
                handler.postDelayed(runnable, 0)
                pause.setText(R.string.pause).toString()
                pause.setBackgroundResource(R.drawable.pause_background)
            }
        }
        reset.setOnClickListener {
            viewModel.reset()
            handler.removeCallbacks(runnable)
            digital.setText(R.string.time).toString()
            pause.visibility = View.INVISIBLE
            reset.visibility = View.INVISIBLE
            start.visibility = View.VISIBLE
        }
        fab.setOnClickListener {
            finish()
            exitProcess(-1)
        }
    }

    override fun onPause() {
        super.onPause()
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.onExit()
    }

    override fun onResume() {
        super.onResume()
        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        if (VISIBLE) {
            viewModel.pausedTime()
            Toast.makeText(applicationContext, viewModel.pauseTime.value, Toast.LENGTH_LONG).show()
        }
        VISIBLE = true
    }

    override fun onBackPressed() {
        Toast.makeText(applicationContext, "Klik Button X untuk Keluar", Toast.LENGTH_LONG).show()
    }
}

