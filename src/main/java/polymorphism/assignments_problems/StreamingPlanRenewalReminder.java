package polymorphism.assignments_problems;

import java.time.LocalDate;
import java.util.*;

abstract class Plan {
    String name;
    LocalDate startDate;

    Plan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    abstract int getValidityDays();

    LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends Plan {
    BasicPlan(String name, LocalDate startDate) { super(name, startDate); }
    int getValidityDays() { return 30; }
}

class StandardPlan extends Plan {
    StandardPlan(String name, LocalDate startDate) { super(name, startDate); }
    int getValidityDays() { return 90; }
}

class PremiumPlan extends Plan {
    PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }
    int getValidityDays() { return 365; }
}

public class StreamingPlanRenewalReminder {

    public static void main(String[] args) {
        List<Plan> subscribers = new ArrayList<>();
        subscribers.add(new BasicPlan("Asha", LocalDate.of(2024, 1, 15)));
        subscribers.add(new StandardPlan("Ravi", LocalDate.of(2024, 2, 1)));
        subscribers.add(new PremiumPlan("Neha", LocalDate.of(2024, 3, 10)));
        subscribers.add(new BasicPlan("Kiran", LocalDate.of(2024, 12, 20)));

        for (Plan p : subscribers) {
            System.out.println(p.name + ": " + p.getRenewalDate());
        }
    }
}