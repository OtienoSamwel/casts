package com.otienosamwel.casts.extensions

import android.content.Context
import android.widget.Toast

//toast
fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
