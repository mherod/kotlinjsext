@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

import kotlin.text.substringAfter as substringAfter

@JsExport
fun <T> lazy(initializer: () -> T): Lazy<T> = kotlin.lazy(initializer)

@JsExport
fun String.substringAfter(delimiter: String, missingDelimiterValue: String = this): String {
    return substringAfter(delimiter, missingDelimiterValue)
}
