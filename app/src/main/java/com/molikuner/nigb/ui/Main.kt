package com.molikuner.nigb.ui

import android.app.Application
import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.molikuner.nigb.BasicApp
import com.molikuner.nigb.R

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val a: Application = this.application
        if (a is BasicApp) {
            a.getRepository().products.observe(this, Observer {
                if (it != null) {
                    it.forEach { Log.d("NIGB: Activity: Main", "got data " + it.uuid) }
                    Log.d("NIGB: Activity: Main", "got all data")
                }
            })
        } else {
            Log.d(
                "NIGB: Activity: Main", "you started the main " +
                        "activity with an other application"
            )
        }
    }
}
