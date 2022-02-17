package Operation;

import BikeRentalBaseClasses.ElectricBike;

/* Method for creating electric bike list*/
public class CreateElectricBike implements BikeRentalInterface {
    @Override
    public void BikeRental() {
        System.out.println("Create electric bikes Operation");
        /*Create ten e-bikes*/
        for (int i = 1; i < 11; i++) {
            String EB = "eb0";
            String str;
            if (i < 10) {
                /*If I is a units digit,  add 0 in front*/
                str = String.format("%02d", i);
                ElectricBike.getInstance(EB + str);
                System.out.println(ElectricBike.getInstance(EB + str));
            } else {
                str = String.valueOf(i);
                ElectricBike.getInstance(EB + str);
                System.out.println(ElectricBike.getInstance(EB + str));
            }
        }
    }
}
