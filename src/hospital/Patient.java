package hospital;

public class Patient extends Person implements TriagePriority {

    private String problem;

    // Constructor 1
    public Patient(int id, String name, String problem) {
        super(id, name);
        this.problem = problem;
    }

    // Constructor 2 - Constructor overloading
    public Patient(int id, String name) {
        this(id, name, "Not specified");
    }

    @Override
    public void displayRole() {
        System.out.println("Patient: " + getName()
                + " | Problem: " + problem);
    }

    @Override
    public void showPriority() {
        System.out.println(
                "Triage priority: Needs medical assessment");
    }
}