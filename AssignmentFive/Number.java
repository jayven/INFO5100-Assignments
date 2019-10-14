package AssignmentFive;

/*Create a class called Number. Write a method called count() which can calculate quotient
of two integers and use try...catch to deal with all possible exception. */

public class Number {
    public static int count(int a, int b) {
        return a / b;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 0;
        try {
            int quotient = count(a, b);
            System.out.println("the quotient is " + quotient);
        } catch (ArithmeticException e) {
            System.out.println("Exception occurred");
        }
    }
}
