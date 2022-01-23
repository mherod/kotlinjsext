// noinspection JSUnusedGlobalSymbols

let {kotlin} = require("kotlin");

let {
    distinctBy,
    lazy,
    substringAfter,
    contains
} = require("./kotlinjsext");

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

/**
 *
 * @template T, K
 * @this {Array.<T>}
 * @param {function(input : T) : K} keyBy
 * @return {Array.<T>}
 */
Array.prototype.distinctBy = function (keyBy) {
    return distinctBy(this, keyBy);
};

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
