package com.thornton.sealedclasses

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.thornton.sealedclasses.Pet.*
import com.thornton.sealedclasses.events.ApiResult
import com.thornton.sealedclasses.models.Food

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        feedPets(FiFi())
        makeAPICall(ApiResult.Failure(Throwable("Error")))
    }



    // Feeding pets example w/ .exhaustive extension function
    private fun feedPets(pet: Pet){
        when(pet){
            is FiFi -> println("Feed FiFi")
            is Bella -> println("Feed Bella")
            is Lucy -> println("Feed Lucy")
            is Max -> println("Feed Max")
        }//.exhaustive
    }


    // Go over API Setup & Error handling Show Exhaustive Error
    // Show Exhaustive Error
    private fun makeAPICall(result: ApiResult){
        // Right click Show Exhaustive Error
        //1. val response = when (result) {
        when (result) {
            is ApiResult.Success -> println(result.items)
            is ApiResult.Failure -> result.error.printStackTrace()
        //2.is ApiResult.Cancelled -> doStuff()
        }
    }


    fun doStuff(){}





    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
