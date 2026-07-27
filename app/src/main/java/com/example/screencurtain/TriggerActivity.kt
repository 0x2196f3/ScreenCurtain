package com.example.screencurtain

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager

class TriggerActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE or WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
        )
        startService(Intent(this, CurtainService::class.java))
        finish()
    }
    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }
}