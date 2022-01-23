require("kotlinjsext");

test("contains is true when contains", () => {
  const input = "hello world";

  const result = input.contains("world");

  expect(result).toBe(true);
});

test("contains is false when doesn't contains", () => {
  const input = "hello world";

  const result = input.contains("global");

  expect(result).toBe(false);
});
