package com.kodiiiofc.urbanuniversity.mobilebrowser

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.AdapterView
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity() {

    private lateinit var gridGV: GridView

    private val list = mutableListOf(
        GridViewModal("Google", R.drawable.google, "https://www.google.com/"),
        GridViewModal("Яндекс", R.drawable.yandex, "https://ya.ru/"),
        GridViewModal("Gismeteo", R.drawable.gismeteo, "https://www.gismeteo.ru/"),
        GridViewModal("Telegram", R.drawable.telegram, "https://web.telegram.org/"),
        GridViewModal("Urban University", R.drawable.urbanuniversity, "https://urban-university.ru/"),
        GridViewModal("Альфа-банк", R.drawable.alfabank,"https://alfabank.ru/"),
    )

    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        gridGV = findViewById(R.id.gv_grid)

        val adapter = GridViewAdapter(list, this@MainActivity)
        gridGV.adapter = adapter

        gridGV.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            intentToBrowserActivity(list[position].url)
        }
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

    fun intentToBrowserActivity(url: String) {
        val intent = Intent(this, BrowserActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)


    }


}