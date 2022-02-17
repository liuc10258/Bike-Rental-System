package BikeRentalBaseClasses;

import Operation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestWindow {
    /*  create some users for testing easily */
    public void createTestCustomers(String customerNumber, String firstName, String surname, String dateOfBirth, Boolean isGoldClass) {
        User.getInstance(customerNumber);
        User.getInstance(customerNumber).setFirstName(firstName);
        User.getInstance(customerNumber).setSurname(surname);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dob = LocalDate.parse(dateOfBirth, dtf);
        User.getInstance(customerNumber).setDateOfBirth(dob);
        User.getInstance(customerNumber).setGoldClass(isGoldClass);
    }

    public static void main(String[] args) {
        TestWindow tw = new TestWindow();
        tw.createTestCustomers("AS-2021-01", "Anna", "Smith", "30/08/1995", true);
        tw.createTestCustomers("ZB-2021-02", "Zoe", "Brown", "18/11/1993", false);
        tw.createTestCustomers("JW-2021-03", "John", "Williams", "06/06/1987", false);
        tw.createTestCustomers("JS-2021-04", "John", "White", "04/12/2001", true);
        System.out.println("Registered Customers:");
        System.out.println(User.getInstance("AS-2021-01"));
        System.out.println(User.getInstance("ZB-2021-02"));
        System.out.println(User.getInstance("JW-2021-03"));
        System.out.println(User.getInstance("JS-2021-04"));
        BikeRentalInterface createNB = new CreateNormalBike();
        System.out.println("Normal Bikes:");
        createNB.BikeRental();
        BikeRentalInterface createEB = new CreateElectricBike();
        System.out.println("Electric Bikes:");
        createEB.BikeRental();

        BikeRentalInterface au = new AddUser();
        au.BikeRental();
        BikeRentalInterface issueB = new IssueBike();
        issueB.BikeRental();
        BikeRentalInterface getRB = new GetRentedBikes();
        getRB.BikeRental();
        BikeRentalInterface ab = new AvailableBikes();
        ab.BikeRental();
        BikeRentalInterface getB = new GetBike();
        getB.BikeRental();
        BikeRentalInterface tr = new TerminateRental();
        tr.BikeRental();
        BikeRentalInterface cb = new ChargeBike();
        cb.BikeRental();

    }
}
