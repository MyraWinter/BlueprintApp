package com.myra_winter.hiltblueprint.util

import android.content.Context
import android.widget.Toast
import android.content.res.Resources
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.ceil

fun Context.showToast(
    msg:String,
    duration:Int = Toast.LENGTH_SHORT
) = Toast.makeText(this,msg,duration).show()


val Int.dpf: Float
    get() {
        return dp.toFloat()
    }


val Float.dpf: Float
    get() {
        return dp.toFloat()
    }

val Int.dp: Int
    get() {
        return if (this == 0) {
            0
        } else ceil((Resources.getSystem().displayMetrics.density * this).toDouble()).toInt()
    }

val Float.dp: Int
    get() {
        return if (this == 0f) {
            0
        } else ceil((Resources.getSystem().displayMetrics.density * this).toDouble()).toInt()
    }

// e.g.        val date = getCurrentDateTime()
//        val currentDateText = date.toString("dd/MM/yyyy")
fun Date.toString(format: String, locale: Locale = Locale.getDefault()): String {
    val formatter = SimpleDateFormat(format, locale)
    return formatter.format(this)
}

fun getCurrentDateTime(): Date {
    return Calendar.getInstance().time
}