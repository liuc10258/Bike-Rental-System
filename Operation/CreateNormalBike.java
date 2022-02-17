package Operation;

import BikeRentalBaseClasses.Bike;

/* Method for creating normal bike list*/
public class CreateNormalBike implements BikeRentalInterface {

    @Override
    public void BikeRental() {
        System.out.println("Create Normal bikes Operation");
        /*Create fifty bikes*/
        for (int i = 1; i < 51; i++) {
            String NB = "nb0";
            String str;
            if (i < 10) {
                /*If I is a units digit,  add 0 in front*/
                str = String.format("%02d", i);
                Bike.getInstance(NB + str);
                System.out.println(Bike.getInstance(NB + str));
            } else {
                str = String.valueOf(i);
                Bike.getInstance(NB + str);
                System.out.println(Bike.getInstance(NB + str));
            }
        }
    }
}
