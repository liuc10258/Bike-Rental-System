package Operation;

import BikeRentalBaseClasses.Bike;
import BikeRentalBaseClasses.ElectricBike;

import java.util.Scanner;

/* Method to get the number of bikes available*/
public class AvailableBikes implements BikeRentalInterface {

    @Override
    public void BikeRental() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Count the available bikes");
        System.out.println("Please input the type of the bikes");
        String typeOfBikes = sc.nextLine();
        /*Set Count Available Biks to 0*/
        {
            int countAB = 0;
            /*If the type of bike entered is normal, it starts walking through the list of normal bikes*/
            if (typeOfBikes.equals("normal")) {
                for (int i = 1; i < 51; i++) {
                    String NB = "nb0";
                    String str;
                    if (i < 10) {
                        /*If I is a units digit,  add 0 in front*/
                        str = String.format("%02d", i);
                        /*If the rental status of the bike is not rented, it counts +1*/
                        if (Bike.getInstance(NB + str).getIsRented().equals("not rented")) {
                            countAB++;
                        }
                    } else {
                        str = String.valueOf(i);
                        if (Bike.getInstance(NB + str).getIsRented().equals("not rented")) {
                            countAB++;
                        }
                    }
                }
                /*If the type of bike entered is normal, it starts walking through the list of electric bikes*/
            } else if (typeOfBikes.equals("electric")) {
                for (int i = 1; i < 11; i++) {
                    String EB = "eb0";
                    String str;
                    if (i < 10) {
                        str = String.format("%02d", i);
                        if (ElectricBike.getInstance(EB + str).getIsRented().equals("not rented")) {
                            countAB++;
                        }
                    } else {
                        str = String.valueOf(i);
                        if (ElectricBike.getInstance(EB + str).getIsRented().equals("not rented")) {
                            countAB++;
                        }
                    }
                }
            } else {
                System.out.println("Invalid input");
                return;
            }
            System.out.println(countAB);
        }
    }
}
