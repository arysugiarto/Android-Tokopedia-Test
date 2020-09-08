package com.tokopedia.climbingstairs

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.tokopedia.core.loadFile

class ClimbingStairsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_climb)
        val webView = findViewById<WebView>(R.id.webView)
        webView.loadFile("climbing_stairs.html")

        // example of how to call the function
        Solution.climbStairs(10)
    }
}