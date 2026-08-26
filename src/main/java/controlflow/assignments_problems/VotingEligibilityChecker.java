package controlflow.assignments_problems;

public class VotingEligibilityChecker {
    public void checkVotingEligibility(int age) {
        boolean isEligible = age >= 18;
        if (isEligible) {
            System.out.println("Eligible to vote");
        } else {
            System.out.println("Not eligible to vote");
        }
    }

    public static void main(String[] args) {
        VotingEligibilityChecker vec = new VotingEligibilityChecker();
        vec.checkVotingEligibility(20); // Eligible to vote
        vec.checkVotingEligibility(16); // Not eligible to vote
    }
}
