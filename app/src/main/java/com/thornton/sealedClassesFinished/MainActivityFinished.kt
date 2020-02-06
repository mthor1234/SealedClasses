package com.thornton.sealedClassesFinished

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import com.thornton.sealedClassesFinished.events.ApiResultFinished
import com.thornton.sealedClassesFinished.filtering.CarFinished
import com.thornton.sealedclasses.R

import kotlinx.android.synthetic.main.activity_main.*

class MainActivityFinished : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        feedPets(PetFinished.FiFi())
        makeAPICall(ApiResultFinished.Failure(Throwable("Error")))
    }


    //1. Feeding pets example w/ .exhaustive extension function
    private fun feedPets(pet: PetFinished) {
        when (pet) {
            is PetFinished.FiFi -> println("Feed FiFi")
            is PetFinished.Bella -> println("Feed Bella")
            is PetFinished.Lucy -> println("Feed Lucy")
            is PetFinished.Max -> println("Feed Max")
        }//.exhaustive
    }


    // 2. Go over API Setup & Error handling Show Exhaustive Error
    // Show Exhaustive Error
    // Show Auto-create branches
    private fun makeAPICall(result: ApiResultFinished) {
        // Right click Show Exhaustive Error
        //1. val response = when (result) {
        when (result) {
            is ApiResultFinished.Success -> println(result.items)
            is ApiResultFinished.Failure -> result.error.printStackTrace()
            //2.is ApiResult.Cancelled -> doStuff()
        }
    }

    // Just showing that you can call methods
    fun doStuff() {
        println("Do Stuff!")
    }


    // 3. Show filtering
    //      1. First Create the Standard List
    //      2. Then Uncomment the rest of the stuff.. Leave Car.Ford() for a while
    //      3. Fix Car.kt
    //      4. Comment out Car.Ford()
    private fun filteringCars(car: CarFinished) {

        // Show writing this out
        val carList: Sequence<CarFinished> = listOf(
//            Car.Ford(),
            CarFinished.Toyota(),
            CarFinished.Honda(),
            CarFinished.BMW(),
            CarFinished.Ferrari(),
            CarFinished.Tesla()
        ).asSequence()

//        when (car) {
//            is Car.Ford -> println("Found On Road Dead")
//            is Car.Toyota -> println("They never die!")
//            is Car.Honda -> println("They never die!")
//            is Car.BMW -> println("Expensive repairs")
//            is Car.Ferrari -> println("Need more money")
//            is Car.Tesla -> println("Respect")
//        }.exhaustive
//
//        val filteredList = carList.filterIsInstance<Car.Ford>()
//
//        filteredList.forEach {
//            val ford = when(it){
//                is Car.Ford -> sellIt()
//            }
//        }
    }
//
//    fun sellIt(){
//        println("Sell IT!!!")
//    }


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
