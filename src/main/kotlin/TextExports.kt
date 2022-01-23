import kotlin.text.contains as textContains

@JsExport
fun String.contains(other: String, ignoreCase: Boolean = false): Boolean {
    return textContains(other, ignoreCase)
}

@JsExport
fun String.substringBefore(delimiter: String, missingDelimiterValue: String = this): String {
    return substringBefore(delimiter, missingDelimiterValue)
}

@JsExport
fun String.substringBeforeLast(delimiter: String, missingDelimiterValue: String = this): String {
    return substringBeforeLast(delimiter, missingDelimiterValue)
}

@JsExport
fun String.substringAfter(delimiter: String, missingDelimiterValue: String = this): String {
    return substringAfter(delimiter, missingDelimiterValue)
}

@JsExport
fun String.substringAfterLast(delimiter: String, missingDelimiterValue: String = this): String {
    return substringAfterLast(delimiter, missingDelimiterValue)
}
