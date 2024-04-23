import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ------ Task 1 ---------
        System.out.println(" ------- Task 1 -------");
        System.out.println("Enter number:");
        int number = scanner.nextInt();
        System.out.println("Enter power of the number:");
        int power = scanner.nextInt();
        int result = getNumberPower(number, power);
        System.out.println(result);

        // --------- Task 2 -------
        System.out.println("-------- Task 2 ---------");
        while (true) {
            int operation = getOperation(scanner);
            double res = makeCalculation(operation, scanner);
            System.out.println("The result is: " + res);

            System.out.println("Do you want to continue? Press Y to continue");
            scanner.nextLine();
            String answer = scanner.nextLine();
            if (!answer.equals("Y")) {
                break;
            }
        }
    }

    public static int getNumberPower(int number, int power) {
        int result = 1;

        if (power == 1) {
            return number;
        } else if (power > 1) {
            for (int i = 0; i < power; i++) {
                result *= number;
            }
        }

        return result;
    }

    public static int getOperation(Scanner scanner) {
        System.out.println("Enter 1 to perform Add");
        System.out.println("Enter 2 to perform Subtract");
        System.out.println("Enter 3 to perform Multiply");
        System.out.println("Enter 4 to perform Divide");

        int operation = scanner.nextInt();
        boolean isRightOperation = operation == 1 || operation == 2 || operation == 3 || operation == 4;
        while (!isRightOperation) {
            System.out.println("Enter 1 to perform Add");
            System.out.println("Enter 2 to perform Subtract");
            System.out.println("Enter 3 to perform Multiply");
            System.out.println("Enter 4 to perform Divide");

            operation = scanner.nextInt();
            isRightOperation = operation == 1 || operation == 2 || operation == 3 || operation == 4;
        }

        return operation;
    }

    public static double getNumberAsInput(Scanner scanner) {
        System.out.println("Enter number:");
        return scanner.nextDouble();
    }

    public static double calcAdd (double num, double secondNum) {
        return num + secondNum;
    }

    public static double calcSubtract (double num, double secondNum) {
        return num - secondNum;
    }

    public static double calcMultiply (double num, double secondNum) {
        return num * secondNum;
    }

    public static double calcDivide (double num, double secondNum) {
        return num / secondNum;
    }

    public static double makeCalculation(int operation, Scanner scanner) {
        double firstNumber = getNumberAsInput(scanner);
        double secondNumber = getNumberAsInput(scanner);
        double result = 0;

        while (operation == 4 && secondNumber == 0) {
            secondNumber = getNumberAsInput(scanner);
        }

        result = switch (operation) {
            case 1 -> calcAdd(firstNumber, secondNumber);
            case 2 -> calcSubtract(firstNumber, secondNumber);
            case 3 -> calcMultiply(firstNumber, secondNumber);
            case 4 -> calcDivide(firstNumber, secondNumber);
            default -> result;
        };

        return result;
    }
}