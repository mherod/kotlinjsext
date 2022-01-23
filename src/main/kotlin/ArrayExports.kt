@file:Suppress(
    "NON_EXPORTABLE_TYPE",
    "NOTHING_TO_INLINE"
)

import kotlin.collections.distinct as distinct1
import kotlin.collections.distinctBy as distinctBy1
import kotlin.collections.toList as toList1

@JsExport
inline fun <T> Array<T>.sorted(): Array<T> {
    return toList1().sortedBy { it.asDynamic() }.toTypedArray()
}

@JsExport
fun <T> Array<T>.distinct(): Array<T> {
    return toList1().distinct1().toTypedArray()
}

@JsExport
fun <T, K> Array<T>.distinctBy(selector: (T) -> K): Array<T> {
    return toList1().distinctBy1(selector).toTypedArray()
}

@JsExport
fun <T> Array<T>.toList(): List<T> = toList1()
