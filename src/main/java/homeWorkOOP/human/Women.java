package homeWorkOOP.human;

import java.util.Random;
import java.util.Scanner;

public class Women extends Human {

    public Women(String name, String lastName, float height, float weight) {
        super(name, lastName, height, weight, false);
        System.out.println("Women instance was created");
    }

    public Human giveBirthTo() {
        System.out.println("тест на совместимость пройден успешно. New human will be created with");
        Scanner in = new Scanner(System.in);
//        if true create Men
        if (new Random().nextBoolean()) {
            System.out.println("Enter name");
            String name = in.nextLine();
            System.out.println("Enter last name");
            String lastName = in.nextLine();
            System.out.println("Enter height");
            float height = Float.parseFloat(in.nextLine());
            System.out.println("Enter weight");
            float weight = Float.parseFloat(in.nextLine());
            return new Men(name, lastName, height, weight);
        } else { // create women
            System.out.println("Enter name");
            String name = in.nextLine();
            System.out.println("Enter last name");
            String lastName = in.nextLine();
            System.out.println("Enter height");
            float height = Float.parseFloat(in.nextLine());
            System.out.println("Enter weight");
            float weight = Float.parseFloat(in.nextLine());
            return new Women(name, lastName, height, weight);
        }

    }
}
