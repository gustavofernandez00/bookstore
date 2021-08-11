package com.gustavo.bookstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gustavo.bookstore.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.main_frameLayout, HomeFragment.newInstance())
            .commit()
    }
}