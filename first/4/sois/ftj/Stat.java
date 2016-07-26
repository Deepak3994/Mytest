package sois.ftj;

public class Stat {
    public double mean(double x, double y) {
        return (x + y)/2;
    }

    public double mean(final double[] data) {
        double total = 0;
        int size = data.length;

        for (int i = 0; i < size; i++) {
            total = total + data[i];
        }
        return total/size;
    }

}
