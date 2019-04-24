/**
 Maxim Saffarini masa8974
 Har samarbetat med  Emil Alic emal8232 och Sabina Cardell saca7387
 */

public class Dog {

    private String name;
    private String breed;
    private User owner = null;
    private int age;
    private int weight;
    //private double tailLength;

    public Dog(String name, String breed, int age, int weight) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.weight = weight;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getWeight() {
        return weight;
    }

    public double getTailLength() {
        if (breed.equalsIgnoreCase("tax") || breed.equalsIgnoreCase("dachshund")) {
            return 3.7;
        } else {
            double getTailLength = (age * weight * 1.0) / 10;
            return getTailLength;
        }
    }
    @Override
    public String toString() {
        String temp;
        if (owner == null)
            temp = name + ", " + breed + ", " + age + " år " + weight + " kg, Svans= " + getTailLength();
        else
            temp = name + ", " + breed + ", " + age + " år " + weight + " kg, Svans= " + getTailLength() +' '+ getOwner().getUserName();
        return temp;
    }
    public void increaseAge() {
        age++;
    }

    public int compareTo(Dog otherDog){
        //OM de är lika, return 0
        if (this.getTailLength()<otherDog.getTailLength()){
            return -1;
        }
        else if(this.getTailLength()>otherDog.getTailLength()){
            return 1;
        }
        else {
            return this.name.compareTo(otherDog.getName());
        }

    }

}
