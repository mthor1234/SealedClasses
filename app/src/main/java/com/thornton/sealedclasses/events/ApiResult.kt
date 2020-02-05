/**
 * Copyright Tandem Diabetes Care 2020.  All rights reserved.
 * SocialSignIn.kt
 * @summary:
 * @author: mthornton
 */


package com.thornton.sealedclasses.events


sealed class ApiResult{

    class Success(val items: List<String>): ApiResult()
    class Failure(val error: Throwable): ApiResult()
//    object Cancelled: ApiResult()

}