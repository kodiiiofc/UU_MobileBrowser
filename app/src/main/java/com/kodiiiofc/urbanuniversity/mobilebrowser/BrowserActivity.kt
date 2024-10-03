package com.kodiiiofc.urbanuniversity.mobilebrowser

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class BrowserActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar

    private lateinit var browserWV: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_browser)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        browserWV = findViewById(R.id.wv_browser)
        browserWV.webViewClient = WebViewClient()
        val url = intent.getStringExtra("url") ?: "https://www.google.com/"
        browserWV.loadUrl(url)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_exit -> { finishAffinity() }
        }

        return super.onOptionsItemSelected(item)
    }

}