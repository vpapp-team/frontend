package com.molikuner.vpapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.molikuner.vpapp.data.local.DB
import com.molikuner.vpapp.data.local.initDB
import com.molikuner.vpapp.data.remote.API
import com.molikuner.vpapp.data.remote.types.DataStatus
import com.molikuner.vpapp.data.types.MOTDTypes
import com.molikuner.vpapp.databinding.ActivityMainBinding
import com.molikuner.vpapp.types.Time
import com.molikuner.vpapp.types.UUID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private fun <T : Any> T.log(): T {
        Log.d("NIGB: MainActivity", this.toString())
        return this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        try {
            DB.initDB(applicationContext)
            DB.queries.addMOTD(
                id = UUID("abd@cd.de"),
                day = Time.Day(0),
                type = MOTDTypes.ABSENT_TEACHER,
                message = "Ar"
            )
        } catch (e: Exception) {
            Toast.makeText(this, e.localizedMessage.log(), Toast.LENGTH_LONG).show()
        }

        try {
            CoroutineScope(Dispatchers.IO).launch {
                val result = API.standIn(DataStatus(listOf()))
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(this@MainActivity, result.toString(), Toast.LENGTH_LONG).show()
                }
            }
        } catch (e: Exception) {
            Toast.makeText(this, e.localizedMessage.log(), Toast.LENGTH_SHORT).show()
        }
    }
}
