import java.util.Scanner;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.println("Введите выражение [2+2] или два римских числа от I до X:[V+V] + Enter ");
        String input = scn.nextLine();
        String output = calc(input);
        System.out.println(output);

    }

    public static String calc(String input) {
        Converter converter = new Converter();
        String[] actions = {"+", "-", "/", "*"};
        String[] regexActions = {"\\+", "-", "/", "\\*"};
        int actionIndex = -1;
        int actionSumm = 0;
        for (int i = 0; i < actions.length; i++) {
            if (input.contains(actions[i])) {
                actionIndex = i;
                break;
            }
        }
        int index =0; int i =0;
        while(true)
        {
            index = input.indexOf(actions[0], index);
            if (index != -1)
            {
                actionSumm ++;
                index += 1;

            }else {
                break;
            }

        }
        while(true)
        {
            index = input.indexOf(actions[1], index);
            if (index != -1)
            {
                actionSumm ++;
                index += 1;

            }else {
                break;
            }

        }
        while(true)
        {
            index = input.indexOf(actions[2], index);
            if (index != -1)
            {
                actionSumm ++;
                index += 1;

            }else {
                break;
            }

        }
        while(true)
        {
            index = input.indexOf(actions[3], index);
            if (index != -1)
            {
                actionSumm ++;
                index += 1;

            }else {
                break;
            }

        }
        if (actionSumm > 1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Некорректное выражение");
                return "ошибка";
            }
        }
        if (actionIndex == -1) {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("Отсутствует знак действия");
                return "ошибка";
            }
        }

        String[] data = input.split(regexActions[actionIndex]);
        int result = 0;
        if (converter.isRoman(data[0]) == converter.isRoman(data[1])) {
            int a, b;
            boolean isRoman = converter.isRoman(data[0]);
            if (isRoman) {
                a = converter.romanToInt(data[0]);
                b = converter.romanToInt(data[1]);
                if (b > a ) {
                    try {
                        throw new IOException();
                    } catch (IOException e) {
                        System.out.println("Некорректное выражение");
                        return "ошибка";
                    }
                }
            } else {
                a = Integer.parseInt(data[0]);
                b = Integer.parseInt(data[1]);
            }
            if ( a<=0 || b<=0 || a>10 || b>10) {
                try {
                    throw new IOException();
                } catch (IOException e) {
                    System.out.println("Некорректное выражение");
                    return "ошибка";
                }
            }
            switch (actions[actionIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }

            if (isRoman) {
               return converter.intToRoman(result);
            }else return String.valueOf(result);

        }

        return input = "Вычислено";
    }
}
