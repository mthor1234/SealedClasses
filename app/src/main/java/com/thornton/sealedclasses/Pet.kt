package com.thornton.sealedclasses

/**
 * Created by MJ Thornton
 * 2020-02-05
 *
 */
sealed class Pet {
    class FiFi: Pet()
    class Bella: Pet()
    class Lucy: Pet()
    class Max: Pet()

}

