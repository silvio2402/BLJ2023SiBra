import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Set;

public class PeopleStore {
    Set<Person> people;

    String filename;

    public PeopleStore(String filename) throws IOException {
        this.filename = filename;

        this.people = new HashSet<Person>();
    }

    @SuppressWarnings("unchecked")
    public void load() {
        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            this.people = (Set<Person>) in.readObject();
            in.close();
            System.out.println("Loaded " + this.people.size() + " people.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void save() {
        try {
            FileOutputStream file = new FileOutputStream(this.filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(this.people);
            out.close();
            System.out.println("Saved " + this.people.size() + " people.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
