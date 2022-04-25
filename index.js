// noinspection JSUnusedGlobalSymbols,JSUnresolvedVariable,JSUnresolvedFunction

// let {kotlin} = require("kotlin");

let e = require("./build/js/packages/kotlinjsext/kotlin/kotlinjsext");

// noinspection JSValidateTypes
String.prototype.replaceAll = function (oldValue, newValue, ignoreCase) {
    return e.replaceAll(oldValue, newValue, ignoreCase);
};

/**
 *
 * @return {kotlin.collections.ArrayList}
 */
Array.prototype.toList = function () {
    return e.toList(this);
};

/**
 *
 * @return {Array}
 */
Array.prototype.distinct = function () {
    // noinspection JSCheckFunctionSignatures
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
    // noinspection JSCheckFunctionSignatures
    return e.distinctBy(this, keyBy);
};

/**
 *
 * @template T
 * @this {Array.<T>}
 * @return {Array.<T>}
 */
Array.prototype.shuffled = function () {
    // noinspection JSCheckFunctionSignatures
    return e.shuffled(this);
};

/**
 *
 * @return {Array}
 */
Array.prototype.sorted = function () {
    return e.sorted(this);
};

// Object.prototype.let = function (block) {
//     return e.let(this, block)
// }

// Object.prototype.also = function (block) {
//     e.also(this, block)
//     return this;
// }

// Array.prototype.let = function (block) {
//     return e.let(this, block)
// }

Array.prototype.also = function (block) {
    e.also(this, block)
    return this
}

// String.prototype.let = function (block) {
//     return e.let(this, block)
// }

String.prototype.substringBefore = function (delimiter, missingDelimiterValue) {
    return e.substringBefore(this, delimiter, missingDelimiterValue);
};

String.prototype.substringBeforeLast = function (delimiter, missingDelimiterValue) {
    return e.substringBeforeLast(this, delimiter, missingDelimiterValue);
};

String.prototype.substringAfter = function (delimiter, missingDelimiterValue) {
    return e.substringAfter(this, delimiter, missingDelimiterValue);
};

String.prototype.substringAfterLast = function (delimiter, missingDelimiterValue) {
    return e.substringAfterLast(this, delimiter, missingDelimiterValue);
};

String.prototype.contains = function (other, ignoreCase = false) {
    return e.contains(this, other, ignoreCase);
};

Object.prototype.toCamelCasedProperties = function () {
    const me = this;
    Object.keys(me).forEach(key => {
        const newKey = key.replace(/-([a-z])/g, g => g[1].toUpperCase());
        me[newKey] = me[key];
        delete me[key];
    })
    return me;
}

Object.prototype.toUnderscoredProperties = function () {

}

module.exports = e;
