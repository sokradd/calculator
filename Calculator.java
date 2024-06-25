
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        char operator; // указывает операцию которую нужно выполнить.
        Double firstnumber, secondnumber, result; // назначаем переменные.
        Scanner scan = new Scanner(System.in); // выделяем память.
        
        System.out.println("Welcome to Calculator!\n");
        while (true) {  // создаем луп 
            System.out.println("Choose operation: + , - , * , / , or %");
            operator = scan.next().charAt(0);
        
        if (operator == '+' || operator == '-' || operator == '*' || operator == '/' || operator == '%' ) { // если выбираем правильный оператор - оно переходит к вводу номера.
            break;
        } else { // если выбираем инвалидный , то выдает ошибку.
            System.out.println("Invalid operator. Please try again!");
        }
    }
        System.out.println("Enter first number: ");
        firstnumber = scan.nextDouble();
        System.out.println("Enter second number: ");
        secondnumber = scan.nextDouble();        

        switch(operator) {
            case '+':
            result = firstnumber + secondnumber;
            System.out.println(firstnumber + "+" + secondnumber + "=" + result);
            break;

            case '-':
            result = firstnumber - secondnumber;
            System.out.println(firstnumber + "-" + secondnumber + "=" + result);
            break;

            case '*':
            result = firstnumber * secondnumber;
            System.out.println(firstnumber + "*" + secondnumber + "=" + result);
            break;

            case '/':
                if (secondnumber != 0) { // попытка разделить на ноль 
            result = firstnumber / secondnumber;
            System.out.println(firstnumber + "/" + secondnumber + "=" + result);
                } else { // если все таки делим на ноль - выдает ошибку.
                    System.out.println("Error! Division by zero.");
                }
            break;

            case '%':
                result = firstnumber % secondnumber;
                System.out.println(firstnumber + "%" + secondnumber + "=" + result);
                break;
            
            }
        }
    }

