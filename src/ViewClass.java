import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ViewClass {
//    List<Taxi> bookedTaxi = new ArrayList<>();
    List<String> bookingDetails = new ArrayList<>();
    public void mainMenu(){
        Scanner input = new Scanner(System.in);
        List<Taxi> taxiList = initiateTaxis(4);
        while(true) {
            System.out.println("\n\t1. Booking\n\t2. BookingDetails\n\t3. Taxi Details\n\t4. Exit\n");

            switch (Validation.validInt("Option")){
                case 1 :{
                    booking(taxiList);
                    break;
                }
                case 2 : {
                    bookingDetails();
                    break;
                }
                case 3 : {
                    taxiDetails(taxiList);
                    break;
                }
                case 4 :{
                    System.out.println("Thank you !");
                    System.exit(0);
                }
                default:
                    System.out.println("Invalid Option !!!");
            }
        }

    }



    public List<Taxi> initiateTaxis(int n){
        List<Taxi> taxiList = new ArrayList<>();
        for(int i = 1;i<=n;i++){
            Taxi taxi = new Taxi();
            taxiList.add(taxi);
        }
        return taxiList;
    }

    public void booking(List<Taxi> taxiList){
        Scanner input = new Scanner(System.in);
        char from;
        char to;
        int pickupTime;
        while (true) {
            System.out.println("a  b  c  d  e  f\n");
            System.out.print("From : ");
            from = input.next().charAt(0);
            System.out.print("To : ");
            to = input.next().charAt(0);
//            System.out.print("Pickup Time : ");
            if(from == to)
                System.out.println("Pickup and Destination shouldn't same");
            else if(from < 'a' || from > 'f' || to < 'a' || to > 'f')
                System.out.println("Invalid Pickup or Destination");
            else
                break;
        }
        pickupTime = 0;
        while(pickupTime<6 || pickupTime>24){
            pickupTime = Validation.validInt("Pickup Time");
            if(pickupTime<6 || pickupTime>24)
                System.out.println("Available Time 6.00 - 24.00\n");
        }

        List<Taxi> availableTaxis = getAvailableTaxis(from,to,pickupTime,taxiList);
        if(availableTaxis.size() == 0){
            System.out.println("No Taxis Available for this time ");
            return;
        }
        Collections.sort(availableTaxis,(a,b)->a.getEarnings()-b.getEarnings());
        bookTaxi(availableTaxis,from,to,pickupTime);
    }
    public List<Taxi> getAvailableTaxis(char from, char to, int pickupTime,List<Taxi> taxiList){
        List<Taxi> taxis = new ArrayList<>();
        for(Taxi taxi:taxiList){
            if(taxi.getAvailableTIme() <= pickupTime &&
                    taxi.getAvailableTIme()+Math.abs((taxi.getCurrentSpot()-96)-(from-96))<=pickupTime)
                taxis.add(taxi);
        }
        return taxis;
    }

    public void bookTaxi(List<Taxi> availableTaxi,char from, char to, int pickupTime){
        Scanner input = new Scanner(System.in);
        int min = Integer.MAX_VALUE;
//        int difference = 0;
        Taxi selectedTaxi = null;
        for(Taxi taxi:availableTaxi){
            int difference = Math.abs((taxi.getCurrentSpot()-96)-(from-96));
            if(difference<min) {
                selectedTaxi = taxi;
                min = difference;
            }
        }
        System.out.print("Enter Name : ");
        String passengerName = input.next();
        int dropTime = pickupTime + Math.abs(from - to);
        int earnings = ((Math.abs(from - to)*15)-5)*10+100;
//        String trip = String.format("%-10s%-15s%-5s%-5%-10%-10",selectedTaxi.getTaxiId(),""+from,to,earnings,dropTime);
        String bookingDetail = String.format("%-10s%-15s%-5s%-5s%-10d%-10d",selectedTaxi.getTaxiId(),passengerName,""+from,""+to,earnings,dropTime);
//        String trip = ""+selectedTaxi.getTaxiId()+"         "+from+"        "+to+"      "+earnings+"        "+dropTime;
//        String bookingDetail = ""+selectedTaxi.getTaxiId()+"        "+passengerName+
//                "         "+from+"        "+to+"      "+earnings+"        "+dropTime;
        bookingDetails.add(bookingDetail);
        selectedTaxi.setTaxiDetails(true,to,selectedTaxi.getEarnings()+earnings,dropTime);
        Booking booking = new Booking(passengerName,from,to,dropTime);
        System.out.println("\n\t****** Your booking is Successful ******\n");
        System.out.println("Booking Id : "+booking.getBookingId());
        System.out.println("Taxi No.   : "+selectedTaxi.getTaxiId());
//        System.out.println("Name       : "+booking.getPassengerName());
//        System.out.println("From       : "+from);
//        System.out.println("To         : "+to);
        System.out.println("Fare       : "+earnings);
    }

    private void bookingDetails() {
        if(bookingDetails.size()==0) {
            System.out.println("\nNo bookings Yet ");
            return;
        }
        System.out.printf("%-10s%-15s%-5s%-5s%-10s%-10s\n","Taxi No","Passenger","From","To","Fare","dropTime");

        for(String string:bookingDetails)
            System.out.println(string);
    }

    public void taxiDetails(List<Taxi> taxiList){

        System.out.printf("%-10s%-15s%-10s%-15s\n","Taxi No.","CurrentSpot","Earnings","AvailableTime");
        for(Taxi taxi:taxiList){
            System.out.printf("%-10d%-15s%-10d%-15s\n",taxi.getTaxiId(),""+taxi.getCurrentSpot(),taxi.getEarnings(),""+taxi.getAvailableTIme()+"'o clock");
        }
    }
}
