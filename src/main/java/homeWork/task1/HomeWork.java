package homeWork.task1;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork {

    public static void main(String[] args) {
//        task#1
        helloUser();
//        task#2
        reverseArray(args);
//        task#3
        task3(args);
//        task#4
        checkPassword();
//        task#5
        task5(args);
//        task#6
        task6();
        luckyNumbers();
    }

    private static void helloUser() {
        System.out.println("========TASK_1=========");
        System.out.println("Please, enter your name: ");
        Scanner in = new Scanner(System.in);
        String s = in.next();
        System.out.println("Hello, " + s);
    }

    public static void checkPassword() {
        System.out.println("========TASK_4=========");
        System.out.println("Enter your password: ");
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String validPassword = "test123";
        if (s.equals(validPassword)) {
            System.out.println("You entered valid password");
        } else {
            System.out.println("Your password not valid, please try again");
        }
    }

    public static void reverseArray(String[] arguments) {
        System.out.println("========TASK_2=========");
        System.out.println("Arguments line -> " + Arrays.toString(arguments));
        String[] reverse = new String[arguments.length];
        for (int i = arguments.length - 1; i >= 0; i--) {
            reverse[arguments.length - 1 - i] = arguments[i];
        }
        System.out.println("Updated arguments line -> " + Arrays.toString(reverse));
    }

    public static void task3(String[] arguments) {
        System.out.println("========TASK_3=========");
        System.out.print("Output in one line : ");
        for (int i = 0; i < arguments.length; i++) {
            System.out.print(arguments[i] + " ");
        }
        System.out.println("\n Output in separate line : ");
        for (int i = 0; i < arguments.length; i++) {
            System.out.println(arguments[i]);
        }
    }

    public static void task5(String[] arguments) {
        System.out.println("========TASK_5=========");
        int sum = 0;
        int mult = 1;
        for (int i = 0; i < arguments.length; i++) {
            sum = Integer.parseInt(arguments[i]);
            mult *= Integer.parseInt(arguments[i]);
        }
        System.out.println("Sum = " + sum);
        System.out.println("Multiplication = " + mult);
    }

    public static void task6() {
        System.out.println("========TASK_6.1-6.4=========");
        System.out.println("Enter list of numbers divided by space");
        Scanner in = new Scanner(System.in);
        String scanner = in.nextLine();
        String[] str = scanner.split(" ");
        int[] num = new int[str.length];
        String evenNum = "";
        String oddNum = "";
        String task6_3 = "";
        String task6_4 = "";

        for (int i = 0; i < str.length; i++) {
            num[i] = Integer.parseInt(str[i]);
            if (num[i] % 2 == 0) {
                evenNum += num[i] + " ";
            } else {
                oddNum += num[i] + " ";
            }
            if (num[i] % 3 == 0 || num[i] % 9 == 0) {
                task6_3 += num[i] + " ";
            }
            if (num[i] % 5 == 0 && num[i] % 7 == 0) {
                task6_4 += num[i] + " ";
            }
        }

        System.out.println("Even numbers: " + evenNum);
        System.out.println("Odd number:  " + oddNum);
        System.out.println("List of numbers which divided by 3 or 9:  " + task6_3);
        System.out.println("List of numbers which divided by 5 and 7: " + task6_4);

        for (int i = num.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (num[j] > num[j + 1]) {
                    int tmp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = tmp;
                }
            }
        }
        System.out.println("Min number = " + num[0]);
        System.out.println("Max number = " + num[num.length - 1]);
    }

    public static void luckyNumbers() {
        System.out.println("========TASK_6.6=========");
        System.out.println("Enter list of four-digit numbers divided by space");
        Scanner in = new Scanner(System.in);
        String scanner = in.nextLine();
        String[] str = scanner.split(" ");
        for (int i = 0; i < str.length; i++) {
            String[] tmpStr = str[i].split("");
            int[] tmp = new int[tmpStr.length];
            for (int j = 0; j < tmpStr.length; j++){
                tmp[j] = Integer.parseInt(tmpStr[j]);
            }
            if ((tmp[0]+ tmp[1]) == (tmp[2] + tmp[3])){
                System.out.println("Lucky number: " + str[i]);
            }
        }
    }

}
