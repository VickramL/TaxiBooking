import java.util.Scanner;

public class Validation {
    public static int validInt(String str){

        try{
            Scanner input = new Scanner(System.in);
            System.out.print("Enter the "+str+" : ");
            int number = input.nextInt();
            return number;
        }
        catch (Exception e){
            System.out.println("Invalid input !!!");
        }
        return 0;
    }
}
