require("kotlinjsext");

test("distinctBy does what you think", () => {
  const input = ["hello", "hello", "world"];

  const result = input.distinctBy((a) => a);

  let expected = ["hello", "world"];

  expect(result.length).toBe(expected.length);
  expect(result).toEqual(expected);
});

test("distinct does what you think", () => {
  const input = ["hello", "hello", "world"];

  const result = input.distinct();

  let expected = ["hello", "world"];

  expect(result.length).toBe(expected.length);
  expect(result).toEqual(expected);
});
