package com.viewbinder

import android.app.Activity
import android.app.Dialog
import android.app.Fragment
import android.support.annotation.IdRes
import android.view.View

fun <T : View> Activity.bindView(@IdRes id: Int): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(id) }
fun Activity.bindColor(id: Int): Lazy<Int> = lazy(LazyThreadSafetyMode.NONE) { context.resources.getColor(id); }

fun <T : View> Fragment.abstractBind(@IdRes id: Int, resetter: BindingResetter)
        : ResettableLazy<T> = ResettableLazy(resetter) { view.findViewById<T>(id) }
fun Fragment.bindColor(id: Int): Lazy<Int> = lazy(LazyThreadSafetyMode.NONE) { view.context.resources.getColor(id); }

fun <T : View> View.bindView(id: Int): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(id) }
fun View.bindColor(id: Int): Lazy<Int> = lazy(LazyThreadSafetyMode.NONE) { context.resources.getColor(id); }

fun <T : View> Dialog.bindView(id: Int): Lazy<T> = lazy(LazyThreadSafetyMode.NONE) { findViewById<T>(id) }
//fun Dialog.bindColor(id: Int): Lazy<Int> = lazy(LazyThreadSafetyMode.NONE) { view.context.resources.getColor(id); }

//private fun viewNotFound(id:Int, desc: KProperty<*>): Nothing =
//        throw IllegalStateException("View ID $id for '${desc.name}' not found.")


