package BikeRentalBaseClasses;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    public String firstName;
    public String surname;
    public LocalDate dateOfBirth;
    public String customerNumber;
    public int issueDateYear;
    public boolean isGoldClass;
    public String rentedBike;


    public User(String firstName, String surname, LocalDate dateOfBirth, String customerNumber, int issueDateYear, boolean isGoldClass, String rentedBike) {
        this.firstName = firstName;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.customerNumber = customerNumber;
        this.issueDateYear = issueDateYear;
        this.isGoldClass = isGoldClass;
        this.rentedBike = rentedBike;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRentedBike(String rentedBike) {
        this.rentedBike = rentedBike;
    }

    public String getFirstName() {
        return firstName;
    }


    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public int getIssueDate() {
        return issueDateYear;
    }

    public boolean getGoldClass() {
        return isGoldClass;
    }

    public String getRentedBike() {
        return rentedBike;
    }

    public void setGoldClass(boolean goldClass) {
        isGoldClass = goldClass;
    }



    public static final Map<String, User> USERS = new HashMap<>();
    //public static final Map<String, CustomerNumber> CUSTOMER_NUMBER = new HashMap<>();
    public static User getInstance(String customerNumber) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        User u = USERS.get(customerNumber);
        if (u == null) {
            u = new User("null", "null", null,customerNumber, year, false, "null");
            USERS.put(customerNumber, u);
        }
            return u;
        }

    @Override
    public String toString() {
        return firstName + ' ' + surname + " | " + dateOfBirth+ " | " + customerNumber+ " | " +issueDateYear+ " | " +isGoldClass+ " | " + rentedBike;
    }

}


