package com.himawanmasyaid.scoreboardandroid.common

import android.app.Activity
import android.content.res.Configuration
import android.content.res.Resources
import java.util.*

fun getLocale() : String {
    return Resources.getSystem().configuration.locale.language
}

fun setLocale(activity: Activity, languageCode: String?) {
    val locale = Locale(languageCode?:"id")

    // set local in application system
    Locale.setDefault(locale)
    val resources: Resources = activity.resources
    val config: Configuration = resources.configuration
    config.setLocale(locale)
    resources.updateConfiguration(config, resources.displayMetrics)
}