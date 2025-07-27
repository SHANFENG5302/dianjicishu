package com.firemout.djcs

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.firemout.djcs.R


@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var cishu :Int= 0

        fun handleClick(): Int {
            cishu += 1
            return cishu
        }
        val button1: Button = findViewById(R.id.button)
        button1.y = 700f
        var text: TextView = findViewById(R.id.textView)
        button1.setOnClickListener {
            val newCount = handleClick()
            text.text = newCount.toString()

            if (cishu > 9999) {
                button1.y = 1600f
            }

        }


    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_item -> Toast.makeText(
                this, "Made by FireMount",
                Toast.LENGTH_LONG
            ).show()
        }
        return true
    }
}