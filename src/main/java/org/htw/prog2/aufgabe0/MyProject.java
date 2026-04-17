package org.htw.prog2.aufgabe0;

import java.util.ArrayList;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.SwingWrapper;



public class MyProject {

    /**
     * Calculate root X of a value S according to babylonian algorithm, starting with
     * an initial estimate X(0):
     * <ol>
     *     <li>Estimate the error e(n): e(n)=(S-X(n-1)²)/(2*X(n-1))</li>
     *     <li>Calculate X(n): X(n)=X(n-1)+e(n)</li>
     * </ol>
     * Continue until the estimated error reaches the desired maximum error
     * @param value The value to calculate the root of
     * Continue until the estimated error reaches the desired maximum error
     * @param initial The initial value to start the calculation with
     * @param maxError The maximum allowed error
     * @return An array containing the values of all iterations. The last value in the array is the final estimate.
     */
    public static double[] calculateBabylonianRoot(double value, double initial, double maxError) {

        ArrayList<Double> arrayListOfIterations = new ArrayList<>();
        maxError = Math.abs(maxError);
        double iterationValue = initial;
        double oldIterationvalue;

        if(value<=0){
            return new double[]{0};
        }

            do {
                oldIterationvalue = iterationValue;
                iterationValue = (iterationValue + (value / iterationValue)) / 2.0;
                arrayListOfIterations.add(iterationValue);
                double x = Math.abs(oldIterationvalue-iterationValue);

            } while (oldIterationvalue - iterationValue > maxError || iterationValue-oldIterationvalue>maxError);


        double[] finalArray = arrayListOfIterations.stream().mapToDouble(x -> x.doubleValue()).toArray();



        return finalArray;
    }

    public static void plotData(double[] values) {
        XYChart chart = new XYChart(500, 500);
        chart.addSeries("Data", values);
        new SwingWrapper(chart).displayChart();
    }

    public static void main(String[] args) {
        plotData(calculateBabylonianRoot(74821, 5, 0.1));
    }
}
