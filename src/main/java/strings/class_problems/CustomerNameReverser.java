package strings.class_problems;

public class CustomerNameReverser {

    public String reverseCustomerName(String customerName) {
        char[] chars = customerName.toCharArray();
        StringBuilder reversed = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            reversed.append(chars[i]);
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        CustomerNameReverser reverser = new CustomerNameReverser();
        String name = "Sunil";
        String reversedName = reverser.reverseCustomerName(name);

        System.out.println("Original Name: " + name);
        System.out.println("Reversed Name: " + reversedName);
    }
}