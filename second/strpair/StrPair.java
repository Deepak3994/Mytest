
class StrPair {
    private String f;
    private String s;

    public StrPair(String first, String second) {
        this.f = first;
        this.s = second;
    }

    public StrPair() {
        this("", "");
    }

    public String first()  { return this.f; }
    public String second() { return this.s; }

    @Override
    public boolean equals(Object obj) {
    	if (obj == null) return false;

    	StrPair that = (StrPair) obj;
    	return (this == that ||
    	        this.f.equals(that.f) && this.s.equals(that.s));
    }


    public static void main(String[] args) {
    	StrPair np = new StrPair();
    	assert(np.first() == "" && np.second() == "");
    	assert(np.first() == np.second());
    	assert(np.first().equals(np.second()));

        StrPair p = new StrPair("location", "manipal");
        assert(p.equals(p));
        StrPair q = new StrPair("location", "manipal");
        assert(p.equals(q));

        StrPair r = new StrPair("location", "delhi");
        assert(r.first().equals("location"));
        assert(r.second().equals("delhi"));

        r.equals(new StrPair(r.first(), r.second()));
        p.equals(new StrPair(q.first(), q.second()));

        assert(new StrPair().equals(new StrPair()));

        assert(!p.equals(null));
        assert(!new StrPair().equals(q));
    }
}