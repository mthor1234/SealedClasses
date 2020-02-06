/**
 * Copyright Tandem Diabetes Care 2020.  All rights reserved.
 * Plant.kt
 * @summary:
 * @author: mthornton
 */


package com.thornton.sealedclasses.filtering


sealed class Car {

    companion object {
        //TODO: Set Keyword TAG
        private const val TAG = "Plant"
    }

    class BMW: Car()
    class Ferrari: Car()
    class Tesla: Car()
    class Honda: Car()
    class Toyota: Car()


    sealed class Ford: Car() {
        class Mustang: Ford()
        class Fusion: Ford()
        class F150: Ford()
    }


}