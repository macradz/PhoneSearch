
import java.util.ArrayList;
import java.util.List;

public class CB {

    private final List<Contact> contactBook;
    private Contact contact;

    public CB() {
        this.contactBook = new ArrayList<Contact>();
    }

    public boolean addContact(String name) {
        contact = new Contact(name);
        for (Contact cont : this.getContacts()) {
            if (cont.equals(contact)) {
                List<String> numbs = contact.getNumber();
                for (String string : numbs) {
                    cont.addNumber(string);
                }
                List<String> ads = contact.getAddress();
                for (String ad : ads) {
                    cont.addNumber(ad);
                }
                return false;
            }
        }
        this.contactBook.add(contact);
        return true;
    }


    public List<Contact> getContacts() {
        return this.contactBook;
    }
}
