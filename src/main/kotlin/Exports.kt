@file:Suppress(
    "NON_EXPORTABLE_TYPE",
    "NOTHING_TO_INLINE",
)

import kotlin.lazy as lazy

@JsExport
fun <T> lazy(initializer: () -> T) = TLazy(initializer)

@JsExport
class TLazy<T>(initializer: () -> T) {
    val value: T by lazy(initializer)
}
