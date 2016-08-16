class EasyClient {
    private static void testAdd() {
        EasyMathCalculator calc = EasyMathCalculator.getInstance(4);

        assert(calc.add(101, -1) == 100);

        assert(calc.neg(calc.sub(calc.add(101, -1), 2)) == -98);
    }

    private static void testDiv() {
        EasyMathCalculator calc = EasyMathCalculator.getInstance(4);

        assert(calc.neg(calc.div(calc.div(100, 2), 5)) == -10);
    }

    private static void testIncDec() {
        EasyMathCalculator calc = EasyMathCalculator.getInstance(4);
        assert(calc.inc(-1) == calc.dec(1));
        assert(calc.inc(calc.add(91, 8)) == 100);
    }

    private static void testRegisters() {
        EasyMathCalculator calc = EasyMathCalculator.getInstance(4);
        assert(calc.save(3, calc.inc(1)) == 2);
        assert(calc.read(3) == 2);
        assert(calc.save(0, calc.inc(calc.add(91, 8))) == 100);
        assert(calc.read(0) == 100);
    }

    public static void main(String args[]) {
        testIncDec();
        testAdd();
        testDiv();
        testRegisters();
    }
}
