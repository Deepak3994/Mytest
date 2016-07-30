class Client {
    private static void testAdd() {
        Calculator calc = BasicCalculator.getInstance();
        assert(calc.put(101)
                   .put(-1)
                   .add()
                   .read() == 100);

        assert(calc.put(101)
                   .put(-1)
                   .add()
                   .put(2)
                   .sub()
                   .clear()
                   .neg()
                   .read() == -98);
    }

    private static void testDiv() {
        Calculator calc = BasicCalculator.getInstance();
        assert(calc.put(100)
                   .put(2)
                   .div()
                   .put(5)
                   .div()
                   .clear()
                   .neg()
                   .read() == -10);
    }

    private static void testGeneric() {
        Calculator calc = BasicCalculator.getInstance();
        //TODO - Add tests here.
    }

    public static void main(String args[]) {
        testAdd();
        testDiv();
        testGeneric();
    }
}
