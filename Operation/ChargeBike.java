package Operation;

import BikeRentalBaseClasses.ElectricBike;

/* Method for the rented electric bikes*/
public class ChargeBike implements BikeRentalInterface {
    @Override
    public void BikeRental() {
        System.out.println("Start charging e-bikes");
        /*Walk through the list of electric bikes*/
        for (int i = 1; i < 11; i++) {
            String EB = "eb0";
            String str;
            if (i < 10) {
                str = String.format("%02d", i);
                /* Determine if power is "false" */
                if (ElectricBike.getInstance(EB + str).getIsCharged() == false) {
                    ElectricBike.getInstance(EB + str).setCharged(true);
                    System.out.println(ElectricBike.getInstance(EB + str));
                }
            } else {
                str = String.valueOf(i);
                /* Determine if power is "false" */
                if (ElectricBike.getInstance(EB + str).getIsCharged() == false) {
                    ElectricBike.getInstance(EB + str).setCharged(true);
                    System.out.println(ElectricBike.getInstance(EB + str));
                }
            }
        }
        System.out.println("Charging completed!");
    }
}
