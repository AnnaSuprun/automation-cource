package homeWork.task2;

import java.util.Scanner;

public class HomeWorkArrays {

    public static void main(String[] args) {
        String[] values = getNumbers();
        task1(values);
        task2(values);

        System.out.println("=======TASK 3 ========");
        System.out.println("Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.");
        task3(getNumbersWithLength(values));


        System.out.println("=======TASK 4 ========");
        System.out.println("Найти число, в котором число различных цифр минимально." +
                " Если таких чисел несколько, найти первое из них");
        task4(values);
    }

    public static String[] getNumbers() {
        System.out.println("Enter list of numbers divided by space: ");
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] numbers = s.split(" ");
        return numbers;
    }

    public static int[][] getNumbersWithLength(String[] numbers) {
        int[][] numbLength = new int[numbers.length][2];
        for (int i = 0; i < numbers.length; i++) {
            numbLength[i][0] = numbers[i].split("").length;
            numbLength[i][1] = Integer.parseInt(numbers[i]);
        }
        for (int i = numbLength.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbLength[j][0] > numbLength[j + 1][0]) {
                    int tmpSize = numbLength[j][0];
                    int tmpValue = numbLength[j][1];
                    numbLength[j][0] = numbLength[j + 1][0];
                    numbLength[j][1] = numbLength[j + 1][1];
                    numbLength[j + 1][0] = tmpSize;
                    numbLength[j + 1][1] = tmpValue;
                }
            }
        }
        return numbLength;
    }

    public static void shortLongNumbers(int[][] numbLength) {
        int i = 0;
        do {
            System.out.println("The number " + numbLength[i][1] + " with shortest length is " + numbLength[i][1]);
            i++;
        } while (numbLength[0][0] == numbLength[i][0] && i < numbLength.length - 1);

        if (numbLength[0][0] != numbLength[numbLength.length - 1][0]) {
            int j = numbLength.length - 1;
            do {
                System.out.println("The number " + numbLength[j][1] + " with longest length is " + numbLength[j][1]);
                j--;
            } while (numbLength[numbLength.length - 1][0] == numbLength[j][0] && j >= 0);
        }
    }

    public static void task1(String[] numbers) {
        int[][] numbLength = getNumbersWithLength(numbers);
        shortLongNumbers(numbLength);
    }

    public static void task2(String[] numbers) {
        int[][] numbLength = getNumbersWithLength(numbers);

        System.out.println("List of numbers from numbers with longest to shortest length ");
        for (int i = numbLength.length - 1; i >= 0; i--) {
            System.out.print(numbLength[i][1] + " ");
        }

    }

    public static void task3(int[][] numbersWithLength) {
        int averageLength = numbersWithLength[numbersWithLength.length-1][0] / 2;
        System.out.println("Average length = " + averageLength);
        System.out.println("Numbers with length less than average length. [numbers][length]");
        for (int i = 0; i < numbersWithLength.length; i++) {
            if (numbersWithLength[i][0] < averageLength) {
                System.out.print("number -> " + numbersWithLength[i][1] + " length -> " + numbersWithLength[i][0]);
            }
        }
    }

    public static void task4(String[] values){
        int[][] countArray = new int[values.length][2];
        for (int i = 0; i < values.length; i++) {
            String[] tmp = values[i].split("");
            int count = 0;
            for (int j = 0; j < tmp.length; j++){
                for (int k = j+1; k < tmp.length; k++){
                    if(tmp[j].equals(tmp[k])){
                        count++;
                    }
                }
            }
            countArray[i][0] = Integer.parseInt(values[i]);
            countArray[i][1] = count;
        }
        bubbleSortBySecondValue(countArray);
        System.out.println("число, в котором число различных цифр минимально -> " + countArray[0][0] + "\n");
    }

    public static void bubbleSortBySecondValue(int[][] arrayForSorting){
        for (int i = arrayForSorting.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arrayForSorting[j][1] > arrayForSorting[j + 1][1]) {
                    int tmpSecondValue = arrayForSorting[j][1];
                    int tmpFirstValue = arrayForSorting[j][0];
                    arrayForSorting[j][0] = arrayForSorting[j + 1][0];
                    arrayForSorting[j][1] = arrayForSorting[j + 1][1];
                    arrayForSorting[j + 1][0] = tmpSecondValue;
                    arrayForSorting[j + 1][1] = tmpFirstValue;
                }
            }
        }
    }

}
