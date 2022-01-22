@file:Suppress("NON_EXPORTABLE_TYPE", "NOTHING_TO_INLINE")

@JsExport
inline fun <T> lazy(noinline initializer: () -> T): Lazy<T> = kotlin.lazy(initializer)
