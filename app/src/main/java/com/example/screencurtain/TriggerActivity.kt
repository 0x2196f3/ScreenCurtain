package com.example.screencurtain

import android.app.Activity
import android.content.Intent
import android.os.Bundle

class TriggerActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startService(Intent(this, CurtainService::class.java))
        finish()
    }
    override fun onPause() {
        super.onPause()
        overridePendingTransition(0, 0)
    }
}