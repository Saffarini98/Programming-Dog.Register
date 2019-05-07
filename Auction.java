import java.util.ArrayList;

public class Auction {

    private ArrayList<Bid> bidList = new ArrayList<Bid>();
    private int auctionNumber;
    private static int numberOfAuctions = 1;
    private Dog dog;

    public Auction(Dog name, int auction) {
        this.dog = name;
        this.auctionNumber = auction;
        numberOfAuctions++;
    }

    public int getAuctionNumber() {
        return auctionNumber;

    }

    public Dog getDog() {
        return dog;
    }

    public ArrayList<Bid> topBids(){
        ArrayList<Bid> topList = new ArrayList<>();
        int index = Math.min(3, bidList.size());
        for(int i = 0 ; i<index ; i++){
            topList.add(bidList.get(i));
        }
        return topList;
    }


    public ArrayList<Bid> getBids() {
        return new ArrayList<Bid>(bidList);
    }

    public void addBid(Bid bid) {
        for (int i = 0 ; i<bidList.size();i++) {
            if (bidList.get(i).getBidder().equals(bid.getBidder())) {
                bidList.remove(i);
                break;
            }
        }
        bidList.add(0, bid);
    }

    public Bid getHighestBid() {
        if (bidList.isEmpty()) {
            return null;
        } else {
            return bidList.get(0);
        }
    }

    public int getMinimumBid() {
        Bid highestBid = getHighestBid();
        if (highestBid == null) {
            return 1;
        }
        return highestBid.getValue() + 1;
    }

    public void removebidfromUser(User usertoRemove) {
        for (int i = 0; i < bidList.size(); i++) {
            if (bidList.get(i).getBidder() == usertoRemove) {
                bidList.remove(i);
                break;
            }
        }
    }

    public void setValue(Bid value) {
        bidList.add(value);
    }

    public String toString() {
        return String.format(this.auctionNumber + ": " + dog + ". " + "Top bids: " + topBids());
    }

    public void listBids() {
        if (!bidList.isEmpty()) {
            System.out.println("Here are the bids for this auction");
            for (Bid bid : bidList) {
                System.out.println(bid.getBidder().getUserName() + " " + bid.getValue() + "kr");

            }
        }

        else {
            System.out.println("Error: No bids registred yet for this auction");
        }




    }
}


