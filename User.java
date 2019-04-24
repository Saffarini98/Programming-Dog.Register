import java.util.Arrays;

/**
 Maxim Saffarini masa8974
 Har samarbetat med  Emil Alic emal8232 och Sabina Cardell saca7387
 */

public class User {
    private String userName;
    private Dog[] ownedDogs;
    private int nrOfDogs = 0;
    private Dog dig = null;


    public User(String userName) { this.userName = userName;
        this.ownedDogs = new Dog[3];
    }

    public void addDog(Dog dog){
        if(nrOfDogs >= ownedDogs.length){
            ownedDogs = Arrays.copyOf(ownedDogs, ownedDogs.length*2);
            /*kopierar over och fordubblar arrayen*/
        }
        ownedDogs[nrOfDogs++] = dog;
    }

    public String getUserName() {
        return userName;
    }

    public void setDog(Dog dig) {
        this.dig = dig;
    }

    public Dog getDog(){
        return dig;
    }

    @Override
    public String toString(){
        String dogsString = "[ ";
        for(Dog d: ownedDogs) {
            //System.out.println(d);
            if (d != null)
                dogsString += d.getName() + " ";
        }
        dogsString += "]";

        return userName + dogsString;
    }

}
