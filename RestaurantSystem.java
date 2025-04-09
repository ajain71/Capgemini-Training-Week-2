class Person {
    protected String name;
    protected int id;
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}
interface Worker {
    void performDuties();
}
class Chef extends Person implements Worker {
    private String specialty;
    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    @Override
    public void performDuties() {
        System.out.println(name + " is preparing meals. Specialty: " + specialty);
    }
}
class Waiter extends Person implements Worker {
    private int tablesAssigned;
    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }
    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers at " + tablesAssigned + " tables.");
    }
}
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 101, "French Cuisine");
        chef.displayDetails();
        chef.performDuties();
        System.out.println();
        Waiter waiter = new Waiter("John Doe", 202, 5);
        waiter.displayDetails();
        waiter.performDuties();
    }
}