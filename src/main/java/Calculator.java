import java.util.Scanner;

/**
 * Класс - калькулятор
 * @author SNesterov
 * @version 0.1
 */
public class Calculator implements ISimpleCalculator{

    //Названия доатупных операций калькулятора
    private String[] operations = {"addition", "subtraction", "division", "multiplication"};
    //номер выбранной операции
    private int choosenOperation;

    //отображение всех доступных операций в калькуляторе
    public void showOperations() {
        System.out.println("This calculator can perform the following operations: ");
        for (int i = 0; i < getCountOperation(); i++) {
            System.out.println(i + 1 + " : " + this.operations[i]);
        }
    }

    //выбор операции которая будет производиться на калькуляторе
    public void setOperation(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println(scanner.next() + " isn't integer, try again!");
        }
        while (scanner.hasNextInt()) {
            int numberOperation = scanner.nextInt();
            if ((numberOperation <= getCountOperation()) || numberOperation >= 1) {
                this.choosenOperation = numberOperation;
                System.out.println("You have chosen the " + this.operations[numberOperation - 1] + " operation");
                break;
            } else System.out.println("You have chosen the wrong operation");
        }
    }

    //получение количества доступных в калькуляторе операций
    public int getCountOperation() {
        return operations.length;
    }

    //выполнение расчёта надо введёными числами
    public void calculate(double operandA, double operandB) {
        switch (choosenOperation) {
            case 1:
                System.out.print("The result of addition is ");
                System.out.printf("%.4f", addition(operandA, operandB));
                break;
            case 2:
                System.out.print("The result of subtraction is ");
                System.out.printf("%.4f", subtraction(operandA, operandB));
                break;
            case 3:
                System.out.print("The result of division is ");
                System.out.printf("%.4f", division(operandA, operandB));
                break;
            case 4:
                System.out.print("The result of multiplication is ");
                System.out.printf("%.4f", multiplication(operandA, operandB));
                break;
            default:
                System.out.println("You have chosen the wrong operation");
        }
    }


    // операция вычитания
    @Override
    public double subtraction(double operandA, double operandB) {
        return operandA - operandB;
    }

    // операция сложения
    @Override
    public double addition(double operandA, double operandB) {
        return operandA + operandB;
    }

    // операция деления
    @Override
    public double division(double operandA, double operandB) {
        return operandA / operandB;
    }

    // операция умножения
    @Override
    public double multiplication(double operandA, double operandB) {
        return operandA * operandB;
    }
}
