class CounterTest {
    private static void testCounter() {
        Counter c = new Counter();
        assert(c.value() == 0);
        assert(c.up().up().up().value() == 3);
        assert(c.up().up().up().reset().value() == 0);
    }

    private static void testCounterNotification() {
        CounterSource csrc = new CounterSource();

        CounterObserver cobs = new CounterObserver() {
            public void counterReest(int curval) {
        	    System.out.println("counter reset - val: " + curval);
            }
        };
        
        csrc.register(cobs);
        csrc.up().up().up().reset().up().reset();
        assert(csrc.value() == 0);
    }
  
    private static void testCounterSourceProtocol() {
        CounterObserver cobs = new CounterObserver() {
            public void counterReest(int curval) {
            }
        };

        CounterSource csrc = new CounterSource();
        assert(csrc.register(null) == false);
        assert(csrc.register(cobs) == true);
        assert(csrc.register(cobs) == false);
        assert(csrc.unregister(null) == false);
        assert(csrc.unregister(cobs) == true);
        assert(csrc.unregister(cobs) == false);
    }

    public static void main(String[] args) {
        testCounter();
        testCounterNotification();
        testCounterSourceProtocol();
    }
}