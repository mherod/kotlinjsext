require("kotlinjsext")

test('distinctBy does what you think', () => {
    const input = ["hello", "hello", "world"]

    const result = input.distinctBy(a => a)

    let expected = ["hello", "world"];

    expect(result.length).toBe(expected.length);
    expect(result).toEqual(expected);
});

test("contains is true when contains", () => {

    const input = "hello world"

    const result = input.contains("world")

    expect(result).toBe(true)
})

test("contains is false when doesn't contains", () => {

    const input = "hello world"

    const result = input.contains("global")

    expect(result).toBe(false)
})
