package homeWorkOOP.human;

public class Men extends Human {

    public Men(String name, String lastName, float height, float weight) {
        super(name, lastName, height, weight, true);
        System.out.println("Men instance was created");
    }
}
