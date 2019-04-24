/**
 Maxim Saffarini masa8974
 Har samarbetat med  Emil Alic emal8232 och Sabina Cardell saca7387
 */
public class Bid {

    private User bidder;
    private int value;

    public Bid(User bidder,int value) {
        this.bidder = bidder;
        this.value = value;
    }

    public User getBidder() {
        return bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public int getValue() {
        return value;
    }


    @Override
    public String toString() {
        return "Value: " + value+" Bidder: "+ bidder.getUserName();
    }
}