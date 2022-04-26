require("kotlinjsext");

// test("let works on String", () => {
//     const actual = "test".let((it) => `${it}ing`)
//     expect(actual).toEqual("testing")
// });

// test("let works on Array", () => {
//     const actual = [0, 1, 3].let((it) => {
//         it.push(10000);
//         return it;
//     })
//     expect(actual).toEqual([0, 1, 3, 10000])
// });

// test("let works on Object", () => {
//     const actual = {v: 1}.let((it) => {
//         it.a = "0"
//         return it
//     })
//     expect(actual).toEqual({v: 1, a: "0"})
// });

// test("also works on Array", () => {
//     const actual = [0, 1, 3].also((it) => it.push(10000))
//     expect(actual).toEqual([0, 1, 3, 10000])
// });

// test("also works on Object", () => {
//     const actual = {v: 1}.also((it) => it.a = "0")
//     expect(actual).toEqual({v: 1, a: "0"})
// });

test("toCamelCasedProperties", () => {
    let expectedPropValue = "https://www.google.com/file.jpg";
    const input = {
        "icon_url": expectedPropValue
    }
    const output = input.toCamelCasedProperties()
    expect(output["iconUrl"]).toEqual(expectedPropValue)
})

test("toUnderscoredProperties", () => {
    let expectedPropValue = "https://www.google.com/file.jpg";
    const input = {
        "iconUrl": expectedPropValue
    }
    const output = input.toUnderscoredProperties()
    expect(output["icon_url"]).toEqual(expectedPropValue)
})
