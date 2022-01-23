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

test("substringAfter 1", () => {
  const input = "hello world";

  const result = input.substringAfter(" ");

  expect(result).toEqual("world");
});

test("substringAfter 2", () => {
  const input = "hello world";

  const result = input.substringAfter("ll");

  expect(result).toEqual("o world");
});
