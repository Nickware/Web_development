package com.example.hyperossmoke

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(
            TextView(this).apply {
                text = "HyperOS smoke test\n\nInstalacion y arranque: OK"
                textSize = 20f
                setPadding(32, 48, 32, 32)
            },
        )
    }
}
