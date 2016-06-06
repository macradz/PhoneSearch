
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Let's create an application to manage people phone numbers and addresses.

The exercise can be worth 1-5 points. To receive one point, you should implement the following functionality:

    1 adding a phone number to the relative person
    2 phone number search by person

to receive two points we also require

    3 name search by phone number

to receive three points also

    4 adding an address to the relative person
    5 personal information search (search for a person's address and phone number)

if you want to receive four points, also implement

    6 removing a person's information

and to receive all the points:

    7 filtered search by keyword (retrieving a list which must be sorted by name in alphabetic order), the keyword can appear in the name or address

*/

public class Main {

    public static void main(String[] args) {

        welcomeMessage();

        Scanner reader = new Scanner(System.in);
        CB contactBook = new CB();

        while (true) {

            String userInput;

            System.out.print("" + "\n" + "command: ");

            userInput = reader.nextLine();

            if (userInput.equalsIgnoreCase("x")) {
                break;
            } else if (userInput.equalsIgnoreCase("1")) {
                addNumber(reader, contactBook);
            } else if (userInput.equalsIgnoreCase("2")) {
                System.out.print("whose number: ");
                String inputName = reader.nextLine();
                searchNumber(inputName, contactBook);
            } else if (userInput.equalsIgnoreCase("3")) {
                System.out.print("number: ");
                String inputNumber = reader.nextLine();
                searchName(inputNumber, contactBook);
            } else if (userInput.equalsIgnoreCase("4")) {
                addAddress(reader, contactBook);
            } else if (userInput.equalsIgnoreCase("5")) {
                System.out.print("whose information: ");
                String inputName = reader.nextLine();
                searchNumberAndAddress(inputName, contactBook);
            } else if (userInput.equalsIgnoreCase("6")) {
                System.out.print("whose information: ");
                String inputName = reader.nextLine();
                deleteNumberAndAddress(inputName, contactBook);
            } else if (userInput.equals("7")) {
                System.out.print("keyword (if empty, all listed): ");
                String inputName = reader.nextLine();
                filter(inputName, contactBook);
            }
        }
    }

    private static void welcomeMessage() {
        System.out.println("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit");
    }

    private static void addNumber(Scanner reader, CB contactBook) {
        System.out.print("whose number: ");
        String inputName = reader.nextLine();

        contactBook.addContact(inputName);

        System.out.print("number: ");
        String inputNumber = reader.nextLine();

        for (Contact c : contactBook.getContacts()) {
            if (c.getName().equalsIgnoreCase(inputName)) {
                c.addNumber(inputNumber);
                return;
            }
        }
    }

    private static void filter(String name, CB cB){
        ArrayList<Contact> toPrint = new ArrayList<Contact>();
        for (Contact c : cB.getContacts()){
            System.out.println(cB.getContacts().size() +"!!!");
            List<String> strings = c.getAddress();
            String address = "";
            for (String string : strings){
                address += string;
            }
            List<String> numbs = c.getNumber();
            String numbers = "";
            for (String string : strings){
                numbers += string + " ";
            }
            if (c.getName().contains(name) || address.contains(name)
                    || numbers.contains(name)){
            toPrint.add(c);
            }
        }
        System.out.println(toPrint.size());
        if (toPrint.isEmpty()){
            System.out.println(" keyword not found");
            return;
        }
        Collections.sort(toPrint);
        
        for (Contact c : toPrint) {
                System.out.println(" "+ c.getName());
                if (c.getAddress().isEmpty()) {
                    System.out.println("  address unknown");
                } else {
                    System.out.print("  address: ");
                    for (int i = 0; i < c.getAddress().size(); i++) {
                        System.out.println(c.getAddress().get(i));
                    }
                }
                
                
                if (c.getNumber().isEmpty()) {
                    System.out.println("  phone number not found");
                } else {
                    System.out.println("  phone numbers:");
                    for (int i = 0; i < c.getNumber().size(); i++) {
                        System.out.println(c.getNumber().get(i));
                    }
                }
                }return;
           
            
    }
    
    private static void searchNumber(String name, CB contactBook) {
        for (Contact c : contactBook.getContacts()) {
            if (c.getName().equalsIgnoreCase(name)) {
                if (c.getNumber().isEmpty()){
                    System.out.println("  not found");
                    return;
                }
                for (int i = 0; i < c.getNumber().size(); i++) {
                    System.out.println(" " + c.getNumber().get(i));
                }
                return;
            }
        }
        System.out.println("  not found");
    }

    private static void searchName(String number, CB contactBook) {
        for (Contact c : contactBook.getContacts()) {
            if (c.getNumber().contains(number)) {
                System.out.println(c.getName());
                return;
            }
        }
        System.out.println("  not found");
    }

    private static void addAddress(Scanner reader, CB contactBook) {
        System.out.print("whose address: ");
        String inputName = reader.nextLine();

        contactBook.addContact(inputName);

        System.out.print("street: ");
        String inputStreet = reader.nextLine();

        System.out.print("city: ");
        String inputCity = reader.nextLine();

        String address = inputStreet + " " + inputCity;

        for (Contact c : contactBook.getContacts()) {
            if (c.getName().equalsIgnoreCase(inputName)) {
                c.addAdress(address);
                return;
            }
        }
    }

    private static void searchNumberAndAddress(String name, CB contactBook) {

            for (Contact c : contactBook.getContacts()) {

                if (c.getName().equalsIgnoreCase(name)){
                if (c.getAddress().isEmpty()) {
                    System.out.println("  address unknown");
                } else {
                    System.out.print("  address: ");
                    for (int i = 0; i < c.getAddress().size(); i++) {
                        System.out.println(c.getAddress().get(i));
                    }
                }
                
                
                if (c.getNumber().isEmpty()) {
                    System.out.println("  phone number not found");
                } else {
                    System.out.println("  phone numbers:");
                    for (int i = 0; i < c.getNumber().size(); i++) {
                        System.out.println(c.getNumber().get(i));
                    }
                }return;
                }
            }
            System.out.println("  not found");

        }

    private static void deleteNumberAndAddress(String name, CB contactBook) {
        for (Contact c : contactBook.getContacts()) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.getNumber().clear();
                c.getAddress().clear();
                return;
            }
        }
    }
}
