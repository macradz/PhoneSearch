
import java.util.ArrayList;
import java.util.List;

public class Contact implements Comparable<Contact> {

    private String contactName;
    private List<String> contactNumber;
    private List<String> contactAddress;

    public Contact(String name) {
        this.contactName = name;
        this.contactNumber = new ArrayList<String>();
        this.contactAddress = new ArrayList<String>();
    }

    public void addNumber(String number) {
        this.contactNumber.add(number);
    }

    public void addAdress(String address) {
        this.contactAddress.add(address);
    }

    public String getName() {
        return this.contactName;
    }

    public List<String> getNumber() {
        return this.contactNumber;
    }

    public List<String> getAddress() {
        return this.contactAddress;
    }

    public void deleteContact() {
        this.contactNumber = null;
        this.contactAddress = null;
    }

    @Override
    public int compareTo(Contact c) {
        return this.contactName.compareTo(c.getName());
    }
    
     @Override
    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }

        if (getClass() != object.getClass()) {
            return false;
        }

        Contact compared = (Contact) object;

        return this.getName().equals(compared.getName());
    }
}
