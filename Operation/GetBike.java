package Operation;

import BikeRentalBaseClasses.Bike;
import BikeRentalBaseClasses.ElectricBike;
import BikeRentalBaseClasses.User;

import java.util.Scanner;

/* Method to get the number of bikes available*/
public class GetBike implements BikeRentalInterface {
    @Override
    public void BikeRental() {
        Scanner sc = new Scanner(System.in);
        System.out.println("View the bike currently rented by a customer");
        System.out.println("Please input the customer number");
        String customerNumber = sc.nextLine();
        /*Determine if the user's name is "null". If it is, an error message pops up that the user does not exist*/
        if (!User.getInstance(customerNumber).getFirstName().equals("null")) {
            /*Determine if the customer rents a bike.
             * If not, a message pops up that the user has not yet rented a bike.*/
            if (!User.getInstance(customerNumber).getRentedBike().equals("null")) {
                /*Gets the first letter of the BID of the bike rented by the user*/
                String determineType = User.getInstance(customerNumber).getRentedBike().substring(0, 1);
                /*If the initial letter of BID is "n", the bike is a normal bike*/
                if (determineType.equals("n")) {
                    System.out.println(Bike.getInstance(User.getInstance(customerNumber).getRentedBike()));
                    return;
                }
                /*If the initial letter of BID is not "n", the bike is an e-bike*/
                System.out.println(ElectricBike.getInstance(User.getInstance(customerNumber).getRentedBike()));
                return;
            }
            System.out.println("This customer has not rented any bikes.");
            return;
        }
        System.out.println("This customer is not existed!");
        return;
    }
}
