package homeWorkOOP.human;

import java.util.Random;

public abstract class Human {
    private String name;
    private String lastName;
    private float height;
    private float weight;
    private boolean gender;

    public Human(String name, String lastName, float height, float weight, boolean gender) {
        this.name = name;
        this.lastName = lastName;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
    }

    public boolean speak(Human human) {
//      true - мужчина
        if (this.gender && human.gender) {
            return new Random().nextBoolean();
        }
        return true;
    }

    // терпеть/выдерживать общество
    public boolean endureSociety(Human human) {
        //  Ж Ж с вероятностью 0.05
        if (!this.gender && !human.gender) {
            if (Math.random() < 0.05) {
                return true;
            } else {
                return false;
            }
            //  М М с вероятностью 0.056
        } else if (this.gender && human.gender) {
            if (Math.random() < 0.056) {
                return true;
            } else {
                return false;
            }
            //  Ж М с вероятностью 0.7
        } else {
            if (Math.random() < 0.7) {
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean spendTimeTogether(Human human) {
//        | (a — b) / [ (a + b) / 2 ] | * 100 %
        if (Math.abs((this.height - human.height) / ((this.height + human.height) / 2)) * 100 > 10) {
            //  метод возвращает true с вероятностью 0.85
            if (Math.random() < 0.85) {
                return true;
            } else {
                return false;
            }
        } else {
            if (Math.random() < 0.95) {
                return true;
            } else {
                return false;
            }
        }
    }

    public Human beInRelationship(Human human) {
        if (speak(human) && endureSociety(human) && spendTimeTogether(human)) {
            if (this.gender == human.gender) {
                return null;
            } else if (human instanceof Women){
                return ((Women) human).giveBirthTo();
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
}
