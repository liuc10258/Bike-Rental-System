package Operation;

import BikeRentalBaseClasses.Bike;
import BikeRentalBaseClasses.ElectricBike;
import BikeRentalBaseClasses.User;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

/* Method for issuing bikes*/
public class IssueBike implements BikeRentalInterface {

    @Override
    public void BikeRental() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Start renting a bike");
        System.out.println("Please input the customer number");
        String customerNumber = sc.nextLine();
        /*Determine if the user's name is "null". If it is, an error message pops up that the user does not exist*/
        if (!User.getInstance(customerNumber).getFirstName().equals("null")) {
            /*Determine if the user has already rented a bike*/
            if (User.getInstance(customerNumber).getRentedBike().equals("null")) {
                System.out.println("Please input the type of the bikes");
                String typeOfBike = sc.nextLine();
                /*If the type of bike entered is normal, it starts walking through the list of normal bikes*/
                if (typeOfBike.equals("normal")) {
                    for (int i = 1; i < 51; i++) {
                        String NB = "nb0";
                        String str;
                        /*The if here is used to tell if I is a units digit*/
                        if (i < 10) {
                            /*If I is a units digit,  add 0 in front*/
                            str = String.format("%02d", i);
                            /*Determine whether the bike has been rented.
                             *If all the bikes have been rented, a message pops up that all of the bikes are rented.
                             * */
                            if (Bike.getInstance(NB + str).getIsRented().equals("not rented")) {
                                /*Assign the rental bike number(BID) to the customer record*/
                                User.getInstance(customerNumber).setRentedBike(NB + str);
                                /*Change the status of the bike to "rented"*/
                                Bike.getInstance(NB + str).setIsRented("rented");
                                /*Assign the customer number to the bicycle record*/
                                Bike.getInstance(NB + str).setWhoRented(User.getInstance(customerNumber).getCustomerNumber());
                                System.out.println(User.getInstance(customerNumber));
                                System.out.println(Bike.getInstance(NB + str));
                                System.out.println("Successfully rented!");
                                return;
                            }
                        } else {
                            str = String.valueOf(i);
                            if (Bike.getInstance(NB + str).getIsRented().equals("not rented")) {
                                User.getInstance(customerNumber).setRentedBike(NB + str);
                                Bike.getInstance(NB + str).setIsRented("rented");
                                Bike.getInstance(NB + str).setWhoRented(User.getInstance(customerNumber).getCustomerNumber());
                                System.out.println(User.getInstance(customerNumber));
                                System.out.println(Bike.getInstance(NB + str));
                                System.out.println("Successfully rented!");
                                return;
                            }
                        }

                    }
                    System.out.println("Sorry, all of the bikes are already rented!");
                    return;
                    /*If the type of bike entered is normal, it starts walking through the list of electric bikes*/
                } else if (typeOfBike.equals("electric")) {
                    /* Determine whether the customer is a gold class customer and whether the customer is over 21 years old*/
                    if (User.getInstance(customerNumber).getGoldClass() == true && (Period.between(User.getInstance(customerNumber).getDateOfBirth(), LocalDate.now()).getYears()) > 20) {
                        for (int i = 1; i < 11; i++) {
                            String EB = "eb0";
                            String str;
                            if (i < 10) {
                                str = String.format("%02d", i);
                                /*Determine whether the e-bike has been rented and whether it is fully charged*/
                                if (ElectricBike.getInstance(EB + str).getIsRented().equals("not rented") && ElectricBike.getInstance(EB + str).getIsCharged() == true) {
                                    /*Assign the rental e-bike number(BID) to the customer record*/
                                    User.getInstance(customerNumber).setRentedBike(EB + str);
                                    /*Change the status of the e-bike to "rented"*/
                                    ElectricBike.getInstance(EB + str).setIsRented("rented");
                                    /*Assign the customer number to the e-bike record*/
                                    ElectricBike.getInstance(EB + str).setWhoRented(User.getInstance(customerNumber).getCustomerNumber());
                                    System.out.println(User.getInstance(customerNumber));
                                    System.out.println(ElectricBike.getInstance(EB + str));
                                    System.out.println("Successfully rented!");
                                    return;
                                }
                            } else {
                                str = String.valueOf(i);
                                if (ElectricBike.getInstance(EB + str).getIsRented().equals("not rented")) {
                                    User.getInstance(customerNumber).setRentedBike(EB + str);
                                    ElectricBike.getInstance(EB + str).setIsRented("rented");
                                    ElectricBike.getInstance(EB + str).setWhoRented(User.getInstance(customerNumber).getCustomerNumber());
                                    System.out.println(User.getInstance(customerNumber));
                                    System.out.println(ElectricBike.getInstance(EB + str));
                                    System.out.println("Successfully rented!");
                                    return;
                                }
                            }
                        }
                        System.out.println("Sorry，all of the electric bikes are already rented or uncharged!");
                        return;
                    }
                    System.out.println("Under 21 or not Gold Class");
                    return;
                } else {
                    System.out.println("Invalid type of bike!");
                    return;
                }
            }
            System.out.println("Failed,the user had borrowed a bike");
            return;
        }
        System.out.println("This customer is not existed");
    }
}

