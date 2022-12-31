import java.util.ArrayList;
import java.util.List;

public class Taxi {
    private static int taxiCount = 0;
    private int taxiId;
    private boolean available;
    private char currentSpot;
    private int earnings;
    private int availableTIme;
//    private List<String> trips;

    public Taxi(){
        taxiCount += 1;
        this.taxiId = taxiCount;
        this.available = false;
        this.currentSpot = 'a';
        this.earnings = 0;
        this.availableTIme = 6;
//        this.trips = new ArrayList<>();
    }

    public void setTaxiDetails(boolean available,char currentSpot, int earnings, int availableTIme){
        this.available = available;
        this.currentSpot = currentSpot;
        this.earnings = earnings;
        this.availableTIme = availableTIme;
//        this.trips.add(trip);
    }

    public int getTaxiId() {
        return taxiId;
    }

//    public void setTaxiId(int taxiId) {
//        this.taxiId = taxiId;
//    }

//    public boolean isAvailable() {
//        return available;
//    }

//    public void setAvailable(boolean available) {
//        this.available = available;
//    }

    public char getCurrentSpot() {
        return currentSpot;
    }

//    public void setCurrentSpot(char currentSpot) {
//        this.currentSpot = currentSpot;
//    }

    public int getEarnings() {
        return earnings;
    }

//    public void setEarnings(int earnings) {
//        this.earnings = earnings;
//    }

    public int getAvailableTIme() {
        return availableTIme;
    }

//    public void setAvailableTIme(int availableTIme) {
//        this.availableTIme = availableTIme;
//    }

//    public List<String> getTrips() {
//        return trips;
//    }
//
//    public void setTrips(List<String> trips) {
//        this.trips = trips;
//    }
}
