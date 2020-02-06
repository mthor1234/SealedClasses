/**
 * Copyright Tandem Diabetes Care 2020.  All rights reserved.
 * SignIn.kt
 * @summary:
 * @author: mthornton
 */


package com.thornton.sealedClassesFinished.signIn



// Example of handling SignIn Flow
// You can get an error & know immediately where it is. You can handle it as well
// Creates an exhaustive when-ladder for all your possibilities
// Allows you to model state easily and very readable
// You could possibly create a Sealed Class to hold all of the different Sealed Classes
    // Note Nesting can make things more verbose / grow too big
    // Kind of up to the team
    // Can't have naming conflicts
// "Why do we spend all this time of setting up state classes?
    // Compartmentalize the unknown... Focus on the problem we're trying to solve by leveraging Kotlin's Type System
    // Moves the work to the compiler... So we can focus on the most impactful things like adding features for users"

sealed class SocialSignInResult {
    data class Success(val token: String) : SocialSignInResult()
    data class Link(val token: String) : SocialSignInResult()
    data class Register(val token: String) : SocialSignInResult()
    data class Error(val errorMsg: String) : SocialSignInResult()
}


sealed class SignInResult {
    data class Success(val token: String) : SignInResult()
    data class TwoFactorAuth(val token: String) : SignInResult()
    data class Fail(val errorMsg: String) : SignInResult()
    data class RetrySocial(val errorMsg: String) : SignInResult()
}


sealed class TwoFAResult {
    object Success: TwoFAResult()
    data class TwoFactorAuth(val token: String) : TwoFAResult()
    data class Fail(val errorMsg: String) : TwoFAResult()
    data class RetrySocial(val errorMsg: String) : TwoFAResult()
}