
import java.util.List;
import java.util.Scanner;

public class Calculator {

    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';
    private static final char REMAINDER = '%';
    private static final char EQUALS = '=';
    private static final List<Character> ALLOWS_OPERATORS = List.of(ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION, REMAINDER);

    public static void run() {
        char operator; // указывает операцию которую нужно выполнить.
        Double firstnumber;
        Double secondnumber; // назначаем переменные.
        Scanner scan = new Scanner(System.in); // выделяем память.
        
        System.out.println("Welcome to Calculator!\n");
        while (true) {  // создаем луп 
            System.out.println("Choose operation: + , - , * , / , or %");
            operator = scan.next().charAt(0);
        
            if (!ALLOWS_OPERATORS.contains(operator)) { // если выбираем правильный оператор - оно переходит к вводу номера.
                System.out.println("Invalid operator. Please try again!");
                break;
            }

            System.out.println("Enter first number: ");
            firstnumber = scan.nextDouble();
            System.out.println("Enter second number: ");
            secondnumber = scan.nextDouble();

            // TODO: я бы добавил сюда еще проверку что это реально число, а не буква или еще что-то (так как вылетит ошибка InputMismatchException)

            switch(operator) {
                case ADDITION -> add(firstnumber, secondnumber);
                case SUBTRACTION -> substract(firstnumber, secondnumber);
                case MULTIPLICATION -> multipliply(firstnumber, secondnumber);
                case DIVISION -> divide(firstnumber, secondnumber);
                case REMAINDER -> takeRemainder(firstnumber, secondnumber);
                default -> System.out.println("Something went wrong!");
            }
        }
    }

    private static void divide(Double firstnumber, Double secondnumber) {

        // Если у тебя было бы result не double, а int - то 2/0 -> выскочит exception ArithmeticException
        // и можно было бы сделать типо такого:
        // try {
        //    Double result = firstnumber / secondnumber;
        //    System.out.println(firstnumber + Character.toString(DIVISION) + secondnumber + EQUALS + result);
        // } catch (ArithmeticException e) {
        //    System.out.println(format("Error! Division by zero! {0}", e.getMessage()));
        // }

        // но так как ты используешь Double - то результат Infinity.
        if (secondnumber != 0) { // попытка разделить на ноль
            double result = firstnumber / secondnumber;
            System.out.println(firstnumber + Character.toString(DIVISION) + secondnumber + EQUALS + result);
        } else { // если все таки делим на ноль - выдает ошибку.
            System.out.println("Error! Division by zero.");
        }
    }

    private static void add(Double firstnumber, Double secondnumber) {
        double result = firstnumber + secondnumber;
        System.out.println(firstnumber + Character.toString(ADDITION) + secondnumber + EQUALS + result);
    }

    private static void substract(Double firstnumber, Double secondnumber) {
        double result = firstnumber - secondnumber;
        System.out.println(firstnumber + Character.toString(SUBTRACTION) + secondnumber + EQUALS + result);
    }

    private static void multipliply(Double firstnumber, Double secondnumber) {
        double result = firstnumber * secondnumber;
        System.out.println(firstnumber + Character.toString(MULTIPLICATION) + secondnumber + EQUALS + result);
    }

    private static void takeRemainder(Double firstnumber, Double secondnumber) {
        double result = firstnumber % secondnumber;
        System.out.println(firstnumber + Character.toString(REMAINDER) + secondnumber + EQUALS + result);
    }
}