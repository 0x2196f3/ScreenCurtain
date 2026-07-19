package com.example.screencurtain

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.TextView
import android.graphics.Color
import androidx.core.net.toUri

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_grant).setOnClickListener {
            requestPermission()
        }

        updatePermissionUI()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            updatePermissionUI()
        }
    }

    fun requestPermission() {
        val intent = Intent(
            Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
            "package:$packageName".toUri()
        )
        startActivityForResult(intent, 1)
    }

    fun updatePermissionUI() {
        val textView = findViewById<TextView>(R.id.tv_grant)

        if (Settings.canDrawOverlays(this)) {
            textView.text = "PERMISSION GRANTED"
            textView.setTextColor(Color.GREEN)
        } else {
            textView.text = "PERMISSION DENIED"
            textView.setTextColor(Color.RED)
        }
    }

}
