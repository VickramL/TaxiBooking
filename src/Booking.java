import java.util.List;

public class Booking {
    private static int bookingCount = 0;
    private int bookingId;
    private String passengerName;
    private char from;
    private char to;
    private int dropTime;
    public Booking(String passengerName, char from, char to,int time){
        bookingCount += 1;
        this.bookingId = bookingCount;
        this.passengerName = passengerName;
        this.from = from;
        this.to = to;
        this.dropTime = time;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public char getFrom() {
        return from;
    }

    public void setFrom(char from) {
        this.from = from;
    }

    public char getTo() {
        return to;
    }

    public void setTo(char to) {
        this.to = to;
    }

    public int getDropTime() {
        return dropTime;
    }

    public void setDropTime(int dropTime) {
        this.dropTime = dropTime;
    }
}
