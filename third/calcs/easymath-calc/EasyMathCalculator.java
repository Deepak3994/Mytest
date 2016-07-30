class EasyMathCalculator implements EasyMath {
    public static final int MAX_REGISTERS = 8;

    private Calculator calc;
    private int nregs;
    private int regs[];

    private EasyMathCalculator(Calculator adapteeCalc, int nregs) {
    	assert(nregs > 0 && nregs <= MAX_REGISTERS);
    	assert(adapteeCalc != null);

    	this.calc = adapteeCalc;
    	this.nregs = nregs;
        this.regs = new int[nregs];
    }

    public int add(int x, int y) {
    	return calc.clearAll()
                   .put(x)
    	           .put(y)
    	           .add()
    	           .read();
    }

    public int sub(int x, int y) {
        return calc.clearAll()
                   .put(x)
                   .put(y)
                   .sub()
                   .read();
    }
    
    public int inc(int x) {
        return this.add(x, 1);
    }

    public int dec(int x)  {
        return this.sub(x, 1);
    }

    public int neg(int x) {
        return this.sub(0, x);
    }

    public int mul(int x, int y) {
        return calc.clearAll()
                   .put(x)
                   .put(y)
                   .mul()
                   .read();
    }
    
    public int div(int x, int y) {
        assert(y != 0);

        return calc.clearAll()
                   .put(x)
                   .put(y)
                   .div()
                   .read();
    }
    
    public int mod(int x, int y) {
        assert(y != 0);
        return x % y;
    }
    
    public int save(int reg, int data) {
    	if (reg >= 0 && reg < this.nregs) {
            this.regs[reg] = data;
            return data;
    	}

        return 0;
    }
    
    public int read(int reg) {
    	assert(reg >= 0 && reg < this.nregs);

        if (reg >= 0 && reg < this.nregs) {
            return this.regs[reg];
        }

        return 0;
    }

    public static EasyMathCalculator getInstance(int nregs) {
    	nregs = (nregs > 0 && nregs <= MAX_REGISTERS) ? nregs : MAX_REGISTERS;

        Calculator adaptee = BasicCalculator.getInstance();
        EasyMathCalculator emcalc = new EasyMathCalculator(adaptee, nregs);
        return emcalc;
    }
}