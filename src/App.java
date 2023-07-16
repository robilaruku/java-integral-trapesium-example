import java.util.function.Function;

public class App {

    /**
     * Menghitung integral numerik menggunakan metode trapesium.
     *
     * @param function   Fungsi yang akan diintegralkan.
     * @param lowerLimit Batas bawah integral.
     * @param upperLimit Batas atas integral.
     * @param h          Lebar trapesium.
     * @return Nilai integral hasil perhitungan.
     */
    public static double calculateIntegral(Function<Double, Double> function, double lowerLimit, double upperLimit,
            double h) {

        System.out.println("---------------------------------------");

        System.out.println("Langkah-langkah penyelesaian:");

        System.out.print("h = " + h + "  ");
        System.out.print("a = " + lowerLimit + "  ");
        System.out.print("b = " + upperLimit + "  ");

        int numIntervals = (int) ((upperLimit - lowerLimit) / h);
        double sum = 0.0;

        System.out.println();
        System.out.println("h = ((b-a) / n) ");
        System.out.println(h + " = (" + upperLimit + "-" + lowerLimit + ") / n) ");
        System.out.println("n = " + numIntervals);
        System.out.println();

        System.out.println("Maka banyak intevalnya adalah " + numIntervals);
        // Menampilkan langkah-langkah penyelesaian
        for (int i = 0; i <= numIntervals; i++) {
            double x = lowerLimit + i * h;
            double fx = function.apply(x);

            sum += fx; // Jumlahkan nilai fungsi

            System.out.println("F(" + i + ") : f(" + x + ") = 2(" + x + ")^4 + 4(" + x + ")^2 = " + fx);
        }

        StringBuilder formulaBuilder = new StringBuilder("(h/2) * (f0");
        for (int i = 1; i <= numIntervals - 1; i++) {
            formulaBuilder.append(" + 2(f").append(i).append(")");
        }
        formulaBuilder.append(" + f").append(numIntervals).append(")");
        String formula = formulaBuilder.toString();
        System.out.println();
        System.out.println("Rumus = " + formula);

        double integralValue = (h / 2.0) * (function.apply(lowerLimit)
                + 2 * (sum - function.apply(lowerLimit) - function.apply(upperLimit)) + function.apply(upperLimit));

        return integralValue;
    }

    public static void main(String[] args) {

        System.out.println("Integrasi Numerik Metode Trapesium");

        // Definisikan fungsi yang ingin diintegralkan

        Function<Double, Double> function = x -> 2 * Math.pow(x, 4) + 4 * Math.pow(x, 2);

        // Batas bawah dan batas atas integral
        double lowerLimit = 1.0;
        double upperLimit = 3.0;

        System.out.println("---------------------------------------");
        System.out.println("Diketahui");
        System.out.println("Integral Atas = " + upperLimit);
        System.out.println("Integral Bawah = " + lowerLimit);

        System.out.println("F(x) = 2x^4 + 4x^2dx");

        // Input nilai h
        double h = 0.5;

        System.out.println("h = " + h);

        // Hitung nilai integral
        double integralValue = calculateIntegral(function, lowerLimit, upperLimit, h);

        System.out.println("\nNilai integral: " + integralValue);
    }
}
