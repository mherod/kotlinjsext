@file:Suppress("NON_EXPORTABLE_TYPE")

@JsExport
fun <T> Array<T>.distinct(): Array<T> {
    return toList().distinct().toTypedArray()
}

@JsExport
fun <T, K> Array<T>.distinctBy(selector: (T) -> K): Array<T> {
    return toList().distinctBy(selector).toTypedArray()
}
