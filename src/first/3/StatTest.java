import java.util.Arrays;

/**
    Implements a few simple tests. Each test creates a new instance of 'Stat'
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

         // an array of two numbers is used to test the two methods.
        {
            double[] data = {10.32, 11.32};
            assert(new Stat().mean(10.32, 11.32) == new Stat().mean(data));
            
            mean = new Stat().mean(data);
            assert(mean== Arrays.stream(data).sum()/data.length);   
        }

        /** Stream API - from the package java.util.stream
         * Streams are sequences of elements supporting sequential and 
         * parallel aggregate operations.
         */
        {
            double[] data = {1.01, 2.02, 3.03, 4.04, 5.05, 6.06};
            mean = new Stat().mean(data);
            assert(mean== Arrays.stream(data).sum()/data.length);
        }
    }
}
