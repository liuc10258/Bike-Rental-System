package Operation;

import BikeRentalBaseClasses.User;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/* Method for adding new customers*/
public class AddUser implements BikeRentalInterface {
    @Override
    public void BikeRental() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Start adding a new customer");
        System.out.println("Please input the customer number");
        String customerNumber = sc.nextLine();
        User.getInstance(customerNumber);
        /*If the customer's first name is not "null", it is already registered*/
        if (User.getInstance(customerNumber).getFirstName().equals("null")) {
            System.out.println("Please input the first name");
            String firstName = sc.nextLine();
            /*Determine if the first letter of the first name entered is the same as the first letter of the customer number*/
            while (!firstName.substring(0, 1).equals(customerNumber.substring(0, 1))) {
                System.out.println("wrong first name");
                System.out.println("Please input the first name");
                firstName = sc.nextLine();
            }
            System.out.println("Please input the surname");
            String surname = sc.nextLine();
            /*Determine if the first letter of the surname entered is the same as the second letter of the customer number*/
            while (!surname.substring(0, 1).equals(customerNumber.substring(1, 2))) {
                System.out.println("wrong surname");
                System.out.println("Please input the first name");
                surname = sc.nextLine();
            }
            System.out.println("Please input the date of birth(dd/MM/yyyy)");
            /*Determine whether the date entered is a past date*/
            while (true) {
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                String dateOfBirth = sc.nextLine();
                LocalDate dob = LocalDate.parse(dateOfBirth, fmt);
                String[] date = dateOfBirth.split("/");
                if (!LocalDate.now().isAfter(LocalDate.of(Integer.parseInt(date[2]),
                        Integer.parseInt(date[1]),
                        Integer.parseInt(date[0])))) {
                    System.out.println("That's not a valid date of an birthday!");
                    System.out.println("Please input the date of birth(dd/MM/yyyy)");
                } else {
                    System.out.println("Please input  the Gold Class(true / false)");
                    Boolean isGoldClass = sc.nextBoolean();
                    User.getInstance(customerNumber).setFirstName(firstName);
                    User.getInstance(customerNumber).setSurname(surname);
                    User.getInstance(customerNumber).setDateOfBirth(dob);
                    User.getInstance(customerNumber).setGoldClass(isGoldClass);
                    System.out.println(User.getInstance(customerNumber));
                    return;
                }
            }

        /*    System.out.println("Please input  the Gold Class(true / false)");
            Boolean isGoldClass = sc.nextBoolean();
            User.getInstance(customerNumber).setFirstName(firstName);
            User.getInstance(customerNumber).setSurname(surname);
            User.getInstance(customerNumber).setDateOfBirth(dob);
            User.getInstance(customerNumber).setGoldClass(isGoldClass);
            System.out.println(User.getInstance(customerNumber));
            return;*/
        }
        System.out.println("This customer is already existed");
    }
}
