package BikeRentalBaseClasses;

import java.util.HashMap;
import java.util.Map;

public class ElectricBike extends Bike{
    public boolean isCharged;

    public ElectricBike(String BID, String typeOfBike, String isRented, String whoRented,boolean isCharged) {
        super(BID, typeOfBike,isRented, whoRented);
        this.isCharged = isCharged;
    }

    public boolean getIsCharged() { return isCharged; }

    public void setCharged(Boolean charged) { this.isCharged = charged; }


    public static final Map<String,ElectricBike> ELECTRIC_BIKE = new HashMap<>();
    public static ElectricBike getInstance(String BID) {
        ElectricBike eb = ELECTRIC_BIKE.get(BID);
        if(eb==null){
            eb = new ElectricBike(BID,"electric","not rented","null",true);
            ELECTRIC_BIKE.put(BID,eb);
        }
        return eb;
    }
    @Override
    public String toString() {
        return BID + " | "+typeOfBike+ " | "+ isRented + " | " + whoRented + " | " + isCharged;
    }
}
