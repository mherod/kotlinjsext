const { lazy } = require("kotlinjsext");

test("lazy is lazy", () => {
  let count = 0;

  let expected = "hello";

  const lazyProvider = lazy(() => {
    count++;
    return expected;
  });

  for (let i = 0; i < 100; i++) {
    expect(lazyProvider.value).toEqual(expected);
  }
  expect(count).toBe(1);
});
