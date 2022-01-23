@file:Suppress(
    "NON_EXPORTABLE_TYPE",
    "NOTHING_TO_INLINE"
)

import kotlin.text.contains as textContains
import kotlin.collections.distinctBy as distinctBy
import kotlin.collections.toList as toList
import kotlin.collections.toTypedArray as toTypedArray
import kotlin.text.substringAfter as substringAfter

@JsExport
fun <T> lazy(initializer: () -> T): Lazy<T> = kotlin.lazy(initializer)

@JsExport
fun String.substringAfter(delimiter: String, missingDelimiterValue: String = this): String {
    return substringAfter(delimiter, missingDelimiterValue)
}

@JsExport
fun <T, K> Array<T>.distinctBy(selector: (dynamic) -> K): Array<T> {
    return toList().distinctBy(selector).toTypedArray()
}

@JsExport
fun String.contains(other: CharSequence, ignoreCase: Boolean = false): Boolean {
    return textContains(other, ignoreCase)
}
