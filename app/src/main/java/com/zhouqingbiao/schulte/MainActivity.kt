package com.zhouqingbiao.schulte

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun toSchulte3X3(view: View) {
        val intent = Intent(this, Schulte3X3Activity::class.java)
        startActivity(intent)
    }

    fun toSchulte4X4(view: View) {
        val intent = Intent(this, Schulte4X4Activity::class.java)
        startActivity(intent)
    }

    fun toSchulte5X5(view: View) {
        val intent = Intent(this, Schulte5X5Activity::class.java)
        startActivity(intent)
    }
}