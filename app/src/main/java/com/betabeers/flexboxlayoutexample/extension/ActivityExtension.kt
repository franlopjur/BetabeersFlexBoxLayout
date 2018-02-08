package com.betabeers.flexboxlayoutexample.extension

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View
import android.widget.Toast

fun <T : View> View.bindView(@IdRes res: Int): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE){ findViewById<T>(res) }
}

fun <T : View> Activity.bindView(@IdRes res: Int): Lazy<T> {
    return lazy(LazyThreadSafetyMode.NONE){ findViewById<T>(res) }
}

fun <T : View> Activity.bindViews(@IdRes resources: Array<Int>): List<Lazy<T>> {
    return resources.map { bindView<T>(it) }.toList()
}

fun Activity.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}