// noinspection JSUnusedGlobalSymbols

let kotlin;
try {
    ({kotlin} = require("kotlin"));
} catch (e) {
    console.error(e)
}
if (kotlin === undefined) throw new Error("kotlin: Failed to init")

let kotlinjsext;
try {
    kotlinjsext = require("kotlinjsext-built");
} catch (e) {
    console.error(e)
}
if (kotlinjsext === undefined) throw new Error("kotlinjsext: Failed to init")


const lazy = kotlinjsext.lazy
if (lazy === undefined) throw new Error("kotlin: Missing lazy")

const substringAfter = kotlin.text.substringAfter_j4ogox$;
if (substringAfter === undefined) throw new Error("kotlin: Missing substringAfter")

const contains = kotlin.text.contains_li3zpu$
if (contains === undefined) throw new Error("kotlin: Missing contains")

String.prototype.replaceAll = function (oldValue, newValue, ignoreCase) {
    return kotlin.text.replace_680rmw$(this, oldValue, newValue, ignoreCase)
}

/**
 *
 * @return {kotlin.collections.ArrayList}
 */
Array.prototype.toList = function () {
    return kotlin.collections.toList_us0mfu$(this)
}

/**
 *
 * @return {Array}
 */
Array.prototype.distinct = function () {
    return kotlin.collections.distinct_7wnvza$(this.toList()).toArray();
};

const HashSet = function () {
    const delegate = kotlin.collections.HashSet_init_287e2$()
    return {
        add(value) {
            return delegate.add_11rb$(value)
        }
    }
};

/**
 *
 * @template T, K
 * @this {Array.<T>}
 * @param {function(input : T) : K} keyBy
 * @return {Array.<T>}
 */
const distinctBy = function (keyBy) {
    const result = [], set = HashSet();
    for (const each of this) if (set.add(keyBy(each))) result.push(each)
    return result;
}
Array.prototype.distinctBy = distinctBy;

/**
 *
 * @return {Array}
 */
Array.prototype.sorted = function () {
    kotlin.collections.sort_9hsmwz$(this)
    return this;
}

String.prototype.substringAfter = function (delimiter, missingDelimiterValue) {
    return substringAfter(this, delimiter, missingDelimiterValue);
}

String.prototype.contains = function (other, ignoreCase = false) {
    return contains(this, other, ignoreCase);
}

module.exports = {
    kotlin,
    lazy,
    substringAfter,
    contains,
}
