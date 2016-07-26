/**
   This example shows how to modularize the core functionality with the help
   of a class. The class named 'Stat' implements one simple method: finding 
   the mean of two real numbers.
 */

class Stat {
    public double mean(double x, double y) {
        return (x + y)/2;
    }
}

/**
    Implements three simple tests. Each test creates a new instance of 'Stat'
    class. Notice the use of "assert" statement.
 */

class StatTest {
    public static void main(String[] args) {
        double mean;

        mean = new Stat().mean(10.32, 11.32);
        assert(mean == 10.82);

        mean = new Stat().mean(10, 11);
        assert(mean == 10.5);

        mean = new Stat().mean(10, 10);
        assert(mean == 10);
    }
}
