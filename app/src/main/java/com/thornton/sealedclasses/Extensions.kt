package com.thornton.sealedclasses

/**
 * Created by MJ Thornton
 * 2020-02-05
 *
 */

val <T> T.exhaustive: T
    get() = this