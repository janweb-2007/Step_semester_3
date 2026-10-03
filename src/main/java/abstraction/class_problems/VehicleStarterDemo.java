package abstraction.class_problems;

public class DiscountInterfaceDemo {

    interface Discountable {
        double applyDiscount(double price);
    }

    static class RegularItem {
        String name;
        double price;
        RegularItem(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    static class SaleItem extends RegularItem implements Discountable {
        SaleItem(String name, double price) { super(name, price); }
        public double applyDiscount(double price) { return price * 0.80; }
    }

    public static void main(String[] args) {
        RegularItem[] items = { new RegularItem("Pen", 10), new SaleItem("Bag", 500) };

        for (RegularItem item : items) {
            double finalPrice = (item instanceof Discountable)
                    ? ((Discountable) item).applyDiscount(item.price)
                    : item.price;
            System.out.printf("%s: %.2f%n", item.name, finalPrice);
        }
    }
}
