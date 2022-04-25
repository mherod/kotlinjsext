@file:Suppress(
    "NON_EXPORTABLE_TYPE",
    "NOTHING_TO_INLINE",
)

import kotlin.lazy as lazy1

@JsExport
fun <T> lazy(initializer: () -> T) = TLazy(initializer)

@JsExport
class TLazy<T>(initializer: () -> T) {
    val value: T by lazy1(initializer)
}

@JsExport
fun <T, R> T.let(block: (T) -> R): R {
    return block(this)
}

@JsExport
fun <T> T.also(block: (T) -> Unit): T {
    block(this)
    return this
}

@JsExport
fun <T> T.apply(block: T.() -> Unit): T {
    block(this)
    return this
}
