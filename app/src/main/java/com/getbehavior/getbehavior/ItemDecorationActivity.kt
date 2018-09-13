package com.getbehavior.getbehavior

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other.*
import java.util.*

class ItemDecorationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)
        val adapter = HupuAdapter()
        val data = mock()
        val itemDecoration = StickHeaderItemDecoration(data)
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(TitleItemDecoration(this,data))
        recyclerView.addItemDecoration(itemDecoration)
        adapter.setData(data)
    }

    private fun mock(): List<Race> {
        val races = ArrayList<Race>()
        val random = Random()
        for (k in 0..25) {
            if (k % 5 == 0)
                races.add(Race(0, "Title ${k / 5}", "Bear", "Lake", "3  :  2"))
            else {
                val blueScore = random.nextInt(4)
                val redScore = if (blueScore == 3) 0 else 5 - blueScore
                races.add(Race(1, "", "Eve", "Adam", "$blueScore  vs  $redScore"))
            }
        }
        return races
    }
}
