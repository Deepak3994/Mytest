
public class TestStatPAL extends StatPAL {
	public TestStatPAL(String path) {
        super(path);
	}

    public void printCountries() {
        for (String c: this.countries) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        if (args.length < 1) return;
        TestStatPAL palstat = new TestStatPAL(args[0]);
        if (palstat.start()) {
            palstat.analyze();
            palstat.finish();

            palstat.collectCountryNames();
            palstat.printCountries();
	    }
    }
}
