@file:Suppress("NOTHING_TO_INLINE")

import kotlin.text.contains as textContains
import kotlin.text.replace as textReplace
import kotlin.text.substringAfter as substringAfter1
import kotlin.text.substringAfterLast as substringAfterLast1
import kotlin.text.substringBefore as substringBefore1
import kotlin.text.substringBeforeLast as substringBeforeLast1

@JsExport
fun String.replaceAll(oldValue: String, newValue: String, ignoreCase: Boolean = false): String {
    return textReplace(oldValue, newValue, ignoreCase)
}

@JsExport
fun String.contains(other: String, ignoreCase: Boolean = false): Boolean {
    return textContains(other, ignoreCase)
}

@JsExport
fun String.substringBefore(delimiter: String, missingDelimiterValue: String = this): String {
    return substringBefore1(delimiter, missingDelimiterValue)
}

@JsExport
fun String.substringBeforeLast(delimiter: String, missingDelimiterValue: String = this): String {
    return substringBeforeLast1(delimiter, missingDelimiterValue)
}

@JsExport
fun String.substringAfter(delimiter: String, missingDelimiterValue: String = this): String {
    return substringAfter1(delimiter, missingDelimiterValue)
}

@JsExport
fun String.substringAfterLast(delimiter: String, missingDelimiterValue: String = this): String {
    return substringAfterLast1(delimiter, missingDelimiterValue)
}
