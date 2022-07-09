import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        double pay = doubleAmount * Math.pow((1 + doubleYearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double doubleAmount, double doubleYearRate, int depositPeriod) {
        return round(doubleAmount + doubleAmount * doubleYearRate * depositPeriod, 2);
    }

    double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }

    void printDepositWithInterest() {
        int period;
        int action;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double depositWithInterest = 0;
        if (action == 1) {
            depositWithInterest = calculateSimplePercent(amount, 0.06, period);
        } else if (action == 2) {
            depositWithInterest = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + depositWithInterest);
    }

    public static void main(String[] args) {
        new DepositCalculator().printDepositWithInterest();
    }

}
