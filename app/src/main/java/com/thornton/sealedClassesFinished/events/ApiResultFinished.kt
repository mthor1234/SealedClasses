/**
 * Copyright Tandem Diabetes Care 2020.  All rights reserved.
 * SocialSignIn.kt
 * @summary:
 * @author: mthornton
 */


package com.thornton.sealedClassesFinished.events


sealed class ApiResultFinished{

    class Success(val items: List<String>): ApiResultFinished()
    class Failure(val error: Throwable): ApiResultFinished()
//    object Cancelled: ApiResult()

}