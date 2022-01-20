import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Создаём экземпляр калькулятора и отоборажаем доступные операции
        Calculator calculator1 = new Calculator();
        calculator1.showOperations();

        System.out.println("Choose the number of the operation");

        //выбираем операцию для калькулятора
        calculator1.setOperation(scanner);

        //вводим два числа
        System.out.println("Enter first operand:");
        double firstOperand = inputDouble(scanner);

        System.out.println("Enter second operand:");
        double secondOperand = inputDouble(scanner);

        //получаем результат
        calculator1.calculate(firstOperand, secondOperand);
    }

    /**
     * Функция для проверки соответсвия вводимых данных типу double
     * @param scanner указываем scanner для чтения данных из консоли
     * @return double
     */
    private static double inputDouble(Scanner scanner) {
        double entered;
        while (!scanner.hasNextDouble()) {
            System.out.println(scanner.next() + " isn't double, try again!");
        }
        entered = scanner.nextFloat();

        return entered;
    }
}