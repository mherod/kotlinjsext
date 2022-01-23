// noinspection JSUnusedGlobalSymbols

// let {kotlin} = require("kotlin");

let e = require("./build/js/packages/kotlinjsext/kotlin/kotlinjsext");

String.prototype.replaceAll = function (oldValue, newValue, ignoreCase) {
    return e.replaceAll(oldValue, newValue, ignoreCase)
}

/**
 *
 * @return {kotlin.collections.ArrayList}
 */
Array.prototype.toList = function () {
    return e.toList(this)
}

/**
 *
 * @return {Array}
 */
Array.prototype.distinct = function () {
    return e.distinctBy(this, a => a);
};

/**
 *
 * @template T, K
 * @this {Array.<T>}
 * @param {function(input : T) : K} keyBy
 * @return {Array.<T>}
 */
Array.prototype.distinctBy = function (keyBy) {
    return e.distinctBy(this, keyBy);
};

/**
 *
 * @return {Array}
 */
Array.prototype.sorted = function () {
    return e.sorted(this);
}

String.prototype.substringBefore = function (delimiter, missingDelimiterValue) {
    return e.substringBefore(this, delimiter, missingDelimiterValue);
}

String.prototype.substringBeforeLast = function (delimiter, missingDelimiterValue) {
    return e.substringBeforeLast(this, delimiter, missingDelimiterValue);
}

String.prototype.substringAfter = function (delimiter, missingDelimiterValue) {
    return e.substringAfter(this, delimiter, missingDelimiterValue);
}

String.prototype.substringAfterLast = function (delimiter, missingDelimiterValue) {
    return e.substringAfterLast(this, delimiter, missingDelimiterValue);
}

String.prototype.contains = function (other, ignoreCase = false) {
    return e.contains(this, other, ignoreCase);
}

module.exports = e;
