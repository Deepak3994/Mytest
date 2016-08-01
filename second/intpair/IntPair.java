
class IntPair {
    private int f;
    private int s;

    public IntPair(int first, int second) {
        this.f = first;
        this.s = second;
    }

    public IntPair() {
        this(0, 0);
    }

    public int first()  { return this.f; }
    public int second() { return this.s; }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IntPair)) return false;

    	IntPair that = (IntPair) obj;
    	return (this == that ||
    	        this.f == that.f && this.s == that.s);
    }


    public static void main(String[] args) {
        IntPair np = new IntPair();
        assert(np.first() == 0 && np.second() == 0);

        IntPair p = new IntPair(-1, 999);
        assert(p.equals(p));
        IntPair q = new IntPair(-1, 999);
        assert(p.equals(q));

        IntPair r = new IntPair(-2, 65535);
        assert(r.first() == -2);
        assert(r.second() == 0XFFFF);

        r.equals(new IntPair(r.first(), r.second()));
        p.equals(new IntPair(q.first(), q.second()));

        assert(new IntPair().equals(new IntPair()));

        assert(!p.equals(null));
        assert(!new IntPair().equals(q));
    }
}