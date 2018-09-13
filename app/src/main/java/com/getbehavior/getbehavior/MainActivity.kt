package com.getbehavior.getbehavior

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playingBar.setOnUpClickListener({
            startActivity(Intent(this@MainActivity, ItemDecorationActivity::class.java))
            overridePendingTransition(R.anim.bottom_in_anim, R.anim.stay)
        })

        rev.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rev.adapter =DummyAdapter()
    }
}
