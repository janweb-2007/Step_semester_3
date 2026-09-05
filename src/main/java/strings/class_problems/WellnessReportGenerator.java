package strings.class_problems;

public class WellnessReportGenerator {

    public String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("Person | Height (m) | Weight (kg) | BMI | Status");
        for (int i = 0; i < heights.length; i++) {
            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);
            System.out.printf("Person %d | %.2f | %.2f | %.2f | %s%n",
                    (i + 1), heights[i], weights[i], bmi, status);
        }
    }

    public static void main(String[] args) {
        WellnessReportGenerator wrg = new WellnessReportGenerator();
        double[] heights = {1.75, 1.60, 1.68, 1.80, 1.55, 1.72, 1.65, 1.90, 1.58, 1.77};
        double[] weights = {70, 90, 55, 85, 48, 78, 60, 95, 50, 72};

        wrg.printWellnessReport(heights, weights);
    }
}