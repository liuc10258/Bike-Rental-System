package BikeRentalBaseClasses;

import java.util.HashMap;
import java.util.Map;

public class Bike {
    public final String BID;
    public final String typeOfBike;
    public String isRented;
    public String whoRented;

    public Bike(String BID, String typeOfBike, String isRented, String whoRented) {
        this.BID = BID;
        this.typeOfBike = typeOfBike;
        this.isRented = isRented;
        this.whoRented = whoRented;
    }

    public String getBID() {
        return BID;
    }

    public String getTypeOfBike() {
        return typeOfBike;
    }

    public String getIsRented() {
        return isRented;
    }

    public void setIsRented(String isRented) {
        this.isRented = isRented;
    }

    public String getWhoRented() { return whoRented;}

    public void setWhoRented (String whoRented){
        this.whoRented = whoRented;
    }

    public static final Map<String,Bike> BIKES = new HashMap<>();

    public static Bike getInstance(String BID) {
        Bike b = BIKES.get(BID);
        if(b==null){
            b = new Bike(BID,"normal","not rented","null");
            BIKES.put(BID,b);
        }
        return b;
    }

        @Override
        public String toString () {
            return BID + " | " + typeOfBike + " | " + isRented + " | " + whoRented ;
        }
    }


