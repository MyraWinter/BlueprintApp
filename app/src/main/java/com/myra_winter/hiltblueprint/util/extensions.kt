package com.myra_winter.hiltblueprint.util

import android.content.Context
import android.widget.Toast
import android.content.res.Resources
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