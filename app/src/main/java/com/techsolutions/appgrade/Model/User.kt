package com.techsolutions.appgrade.Model

import com.techsolutions.appgrade.R
import java.io.Serializable

/**
 * Created by Udi on 6/2/2017.
 */

class User(var email : String,
           var name :  String,
           var phoneNumber: Int,
           var age : Int,
           var realm : String,
           var picture : Byte?) : Serializable {

    init {

        // Validation check
        require(phoneNumber.length() == 10) { R.string.DigitsNotValid }
        require(age > 0) { R.string.AgeNotValid }
        require(!realm.equals("בחר תחום לימודים...")) { R.string.realmNotValid }

    }

    override fun toString(): String {
        return "$email , $name , $phoneNumber , $age , $realm"
    }

    fun Int.length() = when(this) {
        0 -> 1
        else -> Math.log10(Math.abs(toDouble())).toInt() + 1
    }
}
