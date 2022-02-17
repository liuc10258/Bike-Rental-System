package Operation;

import BikeRentalBaseClasses.Bike;
import BikeRentalBaseClasses.ElectricBike;
import BikeRentalBaseClasses.User;

import java.util.Scanner;

/* Method for returning bikes*/
public class TerminateRental implements BikeRentalInterface {
    @Override
    public void BikeRental() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Start returning the bike");
        System.out.println("Please input the customer number");
        String customerNumber = sc.nextLine();
        /*Determine if the user's name is "null". If it is, an error message pops up that the user does not exist*/
            if (!User.getInstance(customerNumber).getFirstName().equals("null")){
                /*Determine if the customer rents a bike.
                * If not, a message pops up that the user has not yet rented a bike.*/
                if (!User.getInstance(customerNumber).getRentedBike().equals("null")){
                    /*Gets the first letter of the BID of the bike rented by the user*/
                    String determineType = User.getInstance(customerNumber).getRentedBike().substring(0,1);
                    /*If the initial letter of BID is "n", we start walking through the list of normal bikes*/
                    if(determineType.equals("n")){
                        /*Set the bike's rental status to Not Rented*/
                        Bike.getInstance(User.getInstance(customerNumber).getRentedBike()).setIsRented("not rented");
                        /*Clear the customer number from the bike record*/
                        Bike.getInstance(User.getInstance(customerNumber).getRentedBike()).setWhoRented("null");
                        System.out.println(Bike.getInstance(User.getInstance(customerNumber).getRentedBike()));
                        /*Clear the BID from the customer record*/
                        User.getInstance(customerNumber).setRentedBike("null");
                        System.out.println(User.getInstance(customerNumber));
                        return;
                        /*If the initial letter of BID is not "n", we start walking through the list of electric bikes*/
                    }else {
                        /*Set the e-bike's rental status to Not Rented*/
                        ElectricBike.getInstance(User.getInstance(customerNumber).getRentedBike()).setIsRented("not rented");
                        /*Clear the customer number from the e-bike record*/
                        ElectricBike.getInstance(User.getInstance(customerNumber).getRentedBike()).setWhoRented("null");
                        /*Set the charging state of the e-bike to uncharged, which is false*/
                        ElectricBike.getInstance(User.getInstance(customerNumber).getRentedBike()).setCharged(false);
                        System.out.println(ElectricBike.getInstance(User.getInstance(customerNumber).getRentedBike()));
                        /*Clear the BID from the customer record*/
                        User.getInstance(customerNumber).setRentedBike("null");
                        System.out.println(User.getInstance(customerNumber));
                        return;
                    }
                }
                System.out.println("This customer has not rented any bikes!");
                return;
            }
            System.out.println("This customer is not existed!");
            return;
        }

}
