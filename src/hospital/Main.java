package hospital;

import java.util.Scanner;
import java.util.ArrayList;

// Abstract class
abstract class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract void displayRole();
}

// Interface
interface TriagePriority {
    void showPriority();
}

// Hospital class
class Hospital {

    private ArrayList<Patient> patients = new ArrayList<>();

    // Method overloading - first method
    public void registerPatient(Patient patient) {
        patients.add(patient);
        System.out.println("Patient registered successfully!");
    }

    // Method overloading - second method
    public void registerPatient(int id, String name) {
        Patient patient = new Patient(id, name);
        patients.add(patient);
        System.out.println("Patient registered successfully!");
    }

    public void assignPatient(Doctor doctor, Patient patient) {
        System.out.println(doctor.getName()
                + " is attending " + patient.getName());
    }

    // Display all registered patients
    public void displayPatients() {

        System.out.println("\n===== ALL REGISTERED PATIENTS =====");

        if (patients.isEmpty()) {
            System.out.println("No patients registered yet.");
        } else {

            for (Patient patient : patients) {
                patient.displayRole();
            }

            System.out.println("Total patients: " + patients.size());
        }
    }

    public void showPatientCount() {
        System.out.println("Total patients: " + patients.size());
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Hospital hospital = new Hospital();

        Doctor doctor = new Doctor(
                201, "Dr. Meera", "Emergency");

        int choice = 0;

        while (choice != 3) {

            System.out.println("\n===== SMART HOSPITAL =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Show All Patients");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {

                System.out.print("Enter patient ID: ");
                int id = input.nextInt();
                input.nextLine();

                System.out.print("Enter patient name: ");
                String name = input.nextLine();

                System.out.print("Enter patient's condition: ");
                String condition = input.nextLine();

                Patient patient = new Patient(
                        id, name, condition);

                patient.displayRole();
                patient.showPriority();

                hospital.registerPatient(patient);

                hospital.assignPatient(doctor, patient);

            } else if (choice == 2) {

                hospital.displayPatients();

            } else if (choice == 3) {

                hospital.showPatientCount();

                System.out.println(
                        "Thank you for using Smart Hospital!");

            } else {

                System.out.println("Invalid choice. Try again.");
            }
        }

        input.close();
    }
}