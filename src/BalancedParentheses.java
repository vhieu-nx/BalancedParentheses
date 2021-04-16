import java.util.Scanner;
import java.util.Stack;

public class BalancedParentheses {
    Stack s = new Stack();
    String paraOpened[] = { "[", "(", "{" };
    String paraClosed[] = { "]", ")", "}" };

    boolean pairWith(String x) {

        if (s.pop().equals("[") && x.equals("]")) {
            return true;
        } else if (s.pop().equals("{") && x.equals("}")) {
            return true;
        } else if (s.pop().equals("(") && x.equals(")")) {
            return true;
        }
        return false;
    }

    boolean isCounterPart(String x) {
        for (int i = 0; i < 3; i++) {
            if (paraOpened[i].equals(x)) {
                return true;
            }
            if (paraClosed[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkBalancedParentheses(String array[]) {

        for (int i = 0; i < array.length; i++) {
            String x = array[i];

            if (array[i].equals(paraOpened[0]) || array[i].equals(paraOpened[1]) || array[i].equals(paraOpened[2])) {

                s.push(array[i]);

            } else if (isCounterPart(x)) {

                if (s.isEmpty() || !pairWith(x)) {

                    return false;

                } else {

                    s.pop();

                }
            }
        }

        return s.isEmpty() ? true : false;
    }

    public static void main(String args[]) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the string:");
        String x = s.nextLine();

        System.out.println(x);

        String array[] = new String[x.length()];

        for (int i = 0; i < array.length; i++) {

            array[i] = x.substring(i, i + 1);

        }

        BalancedParentheses b = new BalancedParentheses();

        boolean value = b.checkBalancedParentheses(array);

        if (value) {
            System.out.println("BalancedParentheses");
        } else {
            System.out.println("UnBalancedParentheses");
        }

        s.close();
    }
}
