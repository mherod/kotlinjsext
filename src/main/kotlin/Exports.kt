@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

@JsExport
fun <T> lazy(initializer: () -> T): Lazy<T> = kotlin.lazy(initializer)
