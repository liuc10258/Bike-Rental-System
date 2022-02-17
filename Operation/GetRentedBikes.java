package Operation;

import BikeRentalBaseClasses.Bike;
import BikeRentalBaseClasses.ElectricBike;

/*This method returns a collection of all the bikes currently rented out
(if any)*/
public class GetRentedBikes implements BikeRentalInterface {
    @Override
    public void BikeRental() {
        System.out.println("View all currently rented bikes");
        /*Walk through the list of normal bikes*/
        for (int i = 1; i < 51; i++) {
            String NB = "nb0";
            String str;
            /*The if here is used to tell if I is a units digit*/
            if (i < 10) {
                /*If I is a units digit,  add 0 in front*/
                str = String.format("%02d", i);
                /* Determine whether the bike has been rented*/
                if (Bike.getInstance(NB + str).getIsRented().equals("rented")) {
                    /*If so, print the bike record*/
                    System.out.println(Bike.getInstance(NB + str));
                }
            } else {
                str = String.valueOf(i);
                if (Bike.getInstance(NB + str).getIsRented().equals("rented")) {
                    Bike.getInstance(NB + str);
                    System.out.println(Bike.getInstance(NB + str));
                }
            }
        }
        /*Then walk through the list of electric bikes*/
        for (int i = 1; i < 11; i++) {
            String EB = "eb0";
            String str;
            if (i < 10) {
                str = String.format("%02d", i);
                /* Determine whether the e-bike has been rented*/
                if (ElectricBike.getInstance(EB + str).getIsRented().equals("rented")) {
                    /*If so, print the e-bike record*/
                    ElectricBike.getInstance(EB + str);
                    System.out.println(ElectricBike.getInstance(EB + str));
                }
            } else {
                str = String.valueOf(i);
                if (ElectricBike.getInstance(EB + str).getIsRented().equals("rented")) {
                    ElectricBike.getInstance(EB + str);
                    System.out.println(ElectricBike.getInstance(EB + str));
                }
            }
        }
    }
}
