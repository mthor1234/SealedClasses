/**
 * Copyright Tandem Diabetes Care 2020.  All rights reserved.
 * Plant.kt
 * @summary:
 * @author: mthornton
 */


package com.thornton.sealedClassesFinished.filtering


sealed class CarFinished() {

    companion object {
        //TODO: Set Keyword TAG
        private const val TAG = "Plant"
    }

    class BMW: CarFinished()
    class Ferrari: CarFinished()
    class Tesla: CarFinished()
    class Honda: CarFinished()
    class Toyota: CarFinished()


    sealed class Ford: CarFinished() {
        class Mustang: Ford()
        class Fusion: Ford()
        class F150: Ford()
    }


}