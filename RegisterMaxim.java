import java.util.Scanner;
import java.util.ArrayList;

/**
 Maxim Saffarini masa8974
 Har samarbetat med  Emil Alic emal8232 och Sabina Cardell saca7387
 */

public class RegisterMaxim {

    private Scanner input = new Scanner(System.in);
    private ArrayList<Dog> allDogs = new ArrayList<>();
    private ArrayList<User> allUsers = new ArrayList<>();
    private int auctionNumber = 1;
    private ArrayList<Auction> auctionList = new ArrayList<>();


    // Infomration om kommandon
    public void readInformation() {
        System.out.println((char) 27 + "[30mTillganliga kommando");
    }


    // Initierar programmet (Matar in hundens information)
    public void initialize() {
        System.out.println((char) 27 + "[32m   -register new dog");
        System.out.println("   -remove dog");
        System.out.println("   -list dogs");
        System.out.println("   -increase age");
        System.out.println((char) 27 + "[33m   ");
        System.out.println("   -register new user");
        System.out.println("   -list users");
        System.out.println("   -remove user");
        System.out.println((char) 27 + "[29m ");
        System.out.println("   -start auction");
        System.out.println("   -iist auctions");
        System.out.println("   -make bid");
        System.out.println("   -close auction");
        System.out.println((char) 27 + " ");
        System.out.println((char) 27 + "[31m   -exit");
    }


    // LOOP
    public void runCommandLoop() {
        boolean done = false;
        do {
            String command = readCommand();
            done = handleCommand(command);
        } while (!done);

    }

    // Lasa kommando
    public String readCommand() {
        System.out.print((char) 27 + "[30mValja kommando> ");
        String command = input.nextLine().trim().toLowerCase();
        return command;
    }

    // Genomfor kommando
    private boolean handleCommand(String command) {
        switch (command) {
            case "register new dog":
                registerNewDog();
                break;
            case "increase age":
                increaseAge();
                break;
            case "list dogs":
                listDogs();
                break;
            case "remove dog":
                removeDog();
                break;
            case "register new user":
                registerNewUser();
                break;
            case "list users":
                listUsers();
                break;
            case "remove user":
                removeUser();
                break;
            case "start auction":
                startAuction();
                break;
            case "list auctions":
                listAuctions();
                break;
            case "list bids":
                listBids();
                break;
            case "make bid":
                makeBid();
                break;
            case "close auction":
                closeAuction();
                break;
            case "exit":
                closeDown();
                return true;
            default:
                System.out.println("Fel");
                break;

        }
        return false;
    }


    /**
     * Kommandon for att hantera HUNDAR
     */


    //Hitta en hund
    private Dog findDog(String name) {
        for (int i = 0; i < allDogs.size(); i++) {
            if (allDogs.get(i).getName().equalsIgnoreCase(name)) {
                return allDogs.get(i);
            }
        }
        return null;
    }


    //Registrera en ny hund
    private void registerNewDog() {
        System.out.print("Hundens namn: ");
        String name = input.nextLine().trim().toLowerCase();
        while (name == null || name.isEmpty()) {
            System.out.println("Fel! Tomma rader accepteras inte ");
            name = input.nextLine().trim().toLowerCase();
        }
        System.out.print("Hundens Ras: ");
        String breed = input.nextLine().trim().toLowerCase();
        while (breed == null || breed.isEmpty()) {
            System.out.println("Fel/Error");
            System.out.print("Hundens ras: ");
            breed = input.nextLine().trim().toLowerCase();
        }
        System.out.print("Hundens alder (ar): ");
        int age = input.nextInt();
        System.out.print("Hundens vikt (kg): ");
        int weight = input.nextInt();
        input.nextLine();
        System.out.println("Hund " + name + " ar registrerad");
        Dog dog = new Dog(name, breed, age, weight);
        allDogs.add(dog);
        sortDogs();
    }


    private void listDogs() {
        System.out.println("Ange den minsta svanslängden> ");
        double tailLength = input.nextDouble();
        input.nextLine();
        System.out.print(allDogs.size());
        for (int i = 0; i < allDogs.size(); i++) {
            System.out.print(allDogs.get(i).getTailLength());
            if (allDogs.get(i).getTailLength() >= tailLength) {
                System.out.println(allDogs.get(i).toString());

            }
        }
    }


    private void sortDogs() { //bubblesort
        int size = allDogs.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (allDogs.get(j).getTailLength() > allDogs.get(j + 1).getTailLength()) {
                    swapDog(j, j + 1);
                } else if (Double.compare(allDogs.get(j).getTailLength(), allDogs.get(j + 1).getTailLength()) == 0) {
                    if (allDogs.get(j).getName().compareTo(allDogs.get(j + 1).getName()) > 0) {
                        swapDog(j, j + 1);

                    }
                }
            }
        }
    }

    private void swapDog(int index1, int index2) {
        Dog temporary = allDogs.get(index2);
        allDogs.set(index2, allDogs.get(index1));
        allDogs.set(index1, temporary);
    }


    private void increaseAge() {
        System.out.print("Hundens namn:");
        String name = input.nextLine().trim().toLowerCase();
        while (name == null || name.isEmpty()) {
            System.out.println("Error");
            System.out.println("Hundens namn: ");
            name = input.nextLine().trim().toLowerCase();
        }
        Dog dog = findDog(name);
        if (dog == null) {
            System.out.println("Error ");

        } else {

            dog.increaseAge();
            System.out.println("increased!");
        }
    }


    private void removeDog() {
        System.out.print("Hundens namn: ");
        String name = input.nextLine().trim().toLowerCase();
        while (name == null || name.isEmpty()) {
            System.out.print("Error: ");
            System.out.println("Hundens namn: ");
            name = input.nextLine().trim().toLowerCase();
        }
        Dog dog = findDog(name);
        if (dog == null) {
            System.out.println("Fel: hund med det namnet fanns ej i registret");
        } else {
            allDogs.remove(dog);
            System.out.println("Hunden har tagits bort");

        }
    }


    /**
     * Kommandon for att hantera ANVANDARE
     */


    private User findUser(String userName) {
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getUserName().equalsIgnoreCase(userName)) {
                return allUsers.get(i);
            }
        }
        return null;
    }


    private void registerNewUser() {
        System.out.print("Anvandarnamn: ");
        String userName = input.nextLine().trim().toLowerCase();
        while (userName == null || userName.isEmpty()) {
            System.out.print("Error: ");
            System.out.print("Anvandarnamn: ");
            userName = input.nextLine().trim().toLowerCase();
        }
        System.out.println("Anvandare " + userName + " ar registrerad");
        User user = new User(userName);
        allUsers.add(user);
    }

    //fa en lista av anvandare
    private void listUsers() {
        for (int i = 0; i < allUsers.size(); i++) {
            System.out.println("- " + allUsers.get(i).toString());
        }
    }


    //Ta bort en anvandare
    private void removeUser() {
        System.out.print("Användarnamn: ");
        String userName = input.nextLine().trim().toLowerCase();
        while (userName == null || userName.isEmpty()) {
            System.out.print("Error: ");
            System.out.println("Användarnamn: ");
            userName = input.nextLine().trim().toLowerCase();
        }
        User user = findUser(userName);
        if (user != null) {

            for (Dog d : allDogs) {
                if (d.getOwner().equals(user)) {
                    d.setOwner(null);
                }
            }

            for (Auction a : auctionList) {
                a.removebidfromUser(user);
            }
        allUsers.remove(user);
        System.out.println("Anvandare har tagits bort");
    } else

    {
        System.out.println("Fel: anvandare med det namnet fanns ej i registret");
    }
        }






    /**
     * Kommandon for att hantera AUKTIONER
     */






    private void startAuction() {
        System.out.print("Hundens namn:");
        String name = input.nextLine().trim().toLowerCase();
        while (name == null || name.isEmpty()) {
            System.out.println("Fel: ");
            System.out.println("Hundens namn: ");
            name = input.nextLine().trim().toLowerCase();
        }
        Dog dog = findDog(name);
        if (dog == null) {
            System.out.println("Fel, finns inte sadan hund");
            return;
        }

        for (Auction auction : auctionList) {
            if (auction.getDog().equals(dog)) {
                System.out.println("Fel: hunden ar redan ute far auktion");
                return;
            }
        }

        if (dog.getOwner() != null) {//OBS SKAPA METOD I DOG
            System.out.println("Fel: hunden har redan en agare");

        } else {
            Auction a = new Auction(dog, auctionNumber++);
            auctionList.add(a);
            {
                System.out.println(name + " har satts fatt auktion i auktion" + " " + "#" +  a.getAuctionNumber());
            }
        }
    }


    private void listAuctions() {
        if (auctionList.isEmpty()) {
            System.out.println("Fel, inga pagaende auktioner ");
            return;
        } else {
            for (Auction a : auctionList) {
                System.out.println(a.toString());
            }
        }

    }


    private void listBids() {
        System.out.print("Hundens namn:");
        String dogName = input.nextLine().trim().toLowerCase();
        while (dogName == null || dogName.isEmpty()) {
            System.out.println("Error: ");
            System.out.println("Hundens namn: ");
            dogName = input.nextLine().trim().toLowerCase();
        }

        Auction a = findAuction(dogName);

        if (a == null) {
            System.out.print("Fel: hunden ar inte ute far en auktion");
            return;
        } else {
            a.listBids();
        }
    }




    private Auction findAuction(String dogName) {
        for (Auction a : auctionList) {
            if (a.getDog().getName().equals(dogName)) {
                return a;
            }
        }
        return null;
    }




    private void makeBid() {
        System.out.print("Anvandarnamn: ");
        String userName = input.nextLine().trim().toLowerCase();
        while (userName == null || userName.isEmpty()) {
            System.out.print("Error: ");
            System.out.print("Anvandarnamn: ");
            userName = input.nextLine().trim().toLowerCase();
        }
        User u = findUser(userName);
        if (u == null) {
            System.out.println("Fel: ingen sadan agare");
            return;
        }

        System.out.println("Hundens namn: ");
        String dogName = input.nextLine().trim().toLowerCase();
        while (dogName == null || dogName.isEmpty()) {
            System.out.print("Error: ");
            System.out.println("Hundens namn: ");
            dogName = input.nextLine().trim().toLowerCase();
        }
        Auction a = findAuction(dogName);
        if (a == null) {
            System.out.println("Fel: hunden ar inte uppe far auktion");
            return;
        }

        int minimum = a.getMinimumBid();
        System.out.print("Belopp att buda (" + minimum + ")> ");
        int value = input.nextInt();
        input.nextLine();

        while (value < minimum) {
            System.out.print("Fel: far lagt bud");
            System.out.print("Belopp att buda (" + minimum + ")> ");
            value = input.nextInt();
            input.nextLine();
        }

        Bid bid = new Bid(u, value);
        a.addBid(bid);
        System.out.println("Bud har gjorts");
    }

    private Auction findAuction(Dog dog) { //skicka in hund?
        for (Auction a : auctionList) {
            if (a.getDog().equals(dog)) {

            }
        }
        return null;
    }

    private void closeAuction() {
        System.out.print("Hundens namn> ");
        String name = input.nextLine().trim().toLowerCase();
        while (name == null || name.isEmpty()) {
            System.out.println("Error");
            System.out.println("Hundens namn: ");
            name = input.nextLine().trim().toLowerCase();
        }
        Auction auction = null;

        for (Auction a : auctionList) {
            if (a.getDog().getName().equalsIgnoreCase(name)) {
                System.out.println(a.getDog().getName());
                auction = a;
                if (a.getBids().isEmpty()) {
                    System.out.println("Auktionen är stängd. Inga bud gjordes för" + a.getDog().getName());
                }else{
                    // temporary
                    a.getDog().setOwner(a.getBids().get(0).getBidder());
                    a.getBids().get(0).getBidder().addDog(a.getDog());
                    System.out.println("Owner fixed!");
                }
            }
        }

        if (auction == null) {
            System.out.println("Fel: denna hund är inte uppe för auktion");
            return;
        }
        else
            auctionList.remove(auction);

    }





    // Avsluta programmet
    public void closeDown() {
        System.out.println("Tack och hej!");
    }


    public static void main(String[] args) {

        RegisterMaxim prog = new RegisterMaxim();
        prog.readInformation();
        prog.initialize();
        prog.runCommandLoop();
        prog.closeDown();
    }

}
