package strings.assignments_problems;

public class MovieReviewWordLengthProfiler {

    public void classifyWordLengths(String review) {
        String[] words = review.split("\\s+");
        int shortCount = 0, mediumCount = 0, longCount = 0;

        for (String word : words) {
            int length = word.length();
            if (length <= 4) {
                shortCount++;
            } else if (length <= 8) {
                mediumCount++;
            } else {
                longCount++;
            }
        }

        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        MovieReviewWordLengthProfiler profiler = new MovieReviewWordLengthProfiler();
        profiler.classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}