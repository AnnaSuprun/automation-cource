package homeWorkOOP.main;

import homeWorkOOP.human.Human;
import homeWorkOOP.human.Men;
import homeWorkOOP.human.Women;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Men men = null;
        Women women = null;
        Scanner in = new Scanner(System.in);
        String gender = "true";
        int i = 1;
        System.out.println("------------------------");
        System.out.println("USE GAP AS A DELIMITER");
        System.out.println("------------------------");
        do {
            System.out.println("///////////////////////");
            System.out.printf("Create %d Human\n", i);
            System.out.println("Please, enter: name, lastName, height, weight and gender (true -> men; false -> women)");
            String s = in.nextLine();
            String[] input = s.split(" ");
            if (input[4].equals(gender)) {
                men = new Men(input[0], input[1], Float.parseFloat(input[2]), Float.parseFloat(input[3]));
            } else {
                women = new Women(input[0], input[1], Float.parseFloat(input[2]), Float.parseFloat(input[3]));
            }
            i++;
        } while (i == 2);

        Human human = compatibilityTest(men, women);
        if(human == null){
            System.out.println("ничего не вышло... разбежались");
        }else {
            System.out.println(" Приветсвуем нового человека!!!!");
            System.out.println(" name -> " + human.getName());
            System.out.println(" last name -> " + human.getLastName());
            System.out.println(" height -> " + human.getHeight());
            System.out.println(" weight -> " + human.getWeight());
        }
    }

    public static Human compatibilityTest(Human men, Human women) {
        return men.beInRelationship(women);
    }
}
