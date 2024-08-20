import java.util.Scanner;

public class Calculator {
    public static void main(String[] arguments) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter number: ");
        int num2 = scanner.nextInt();

        scanner.nextLine();

        

        System.out.print("Enter operation to use: ");
        String operator = scanner.nextLine();

        switch (operator) {
            case "additoion":
                System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
                break;
            case "subtraction":
                System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
            case "multiplication":
                System.out.printf("%d * %d = %d", num1, num2, num1 * num2);
            case "divison":
                System.out.printf("%d / %d = %d", num1, num2, num1 / num2);
            case "modulo":
                System.out.printf("%d % %d = %d", num1, num2, num1 % num2);
            default:
                break;
        }

        // if(operator.equals("addition")) {
        //     System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
        // } else if(operator.equals("subtraction")) {
        //     System.out.printf("%d + %d = %d", num1, num2, num1 - num2);
        // } else if(operator.equals("multiplication")) {
        //     System.out.printf("%d + %d = %d", num1, num2, num1 * num2);
        // } else if(operator.equals("division")) {
        //     System.out.printf("%d + %d = %d", num1, num2, num1 / num2);
        // } else {
        //     System.out.println("Wrong operator");
        // }

        scanner.close();

    }


}
