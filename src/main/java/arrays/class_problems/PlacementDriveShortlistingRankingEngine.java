package arrays.class_problems;

import java.util.Arrays;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    double compositeScore() {
        return (cgpa * 10) + codingScore;
    }

    @Override
    public int compareTo(Candidate other) {
        return Double.compare(other.compositeScore(), this.compositeScore());
    }
}

public class PlacementDriveShortlistingRankingEngine {

    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;

        for (int i = 0; i < candidates.length; i++) {
            Candidate c = candidates[i];
            if (Candidate.isEligible(c.cgpa) || Candidate.isEligible(c.cgpa, c.codingScore)) {
                shortlisted[count] = c;
                count++;
            }
        }

        Candidate[] finalShortlisted = Arrays.copyOf(shortlisted, count);
        Arrays.sort(finalShortlisted);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalShortlisted.length; i++) {
            Candidate c = finalShortlisted[i];
            result.append(i + 1).append(". ").append(c.name)
                    .append(" (").append(c.compositeScore()).append(")");
            if (i != finalShortlisted.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
                new Candidate("Aisha", 8.2, 40),
                new Candidate("Rohit", 6.8, 65),
                new Candidate("Meena", 6.0, 90),
                new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}
