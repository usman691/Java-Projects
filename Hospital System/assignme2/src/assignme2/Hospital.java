package assignme2;
import java.util.*;

// ===== Interfaces =====
interface Schedulable {
    void viewSchedule();
}

interface Billable {
    void generateBill();
}

// ===== Base Class =====
abstract class Person {
    protected String name;

    public Person(String name) {
        if (name == null ) throw new IllegalArgumentException("Name cannot be null or empty.");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// ===== Composition Classes =====
class Schedule {
    private List<String> appointments = new ArrayList<>();

    public void addAppointment(String appointment) {
        appointments.add(appointment);
    }

    public void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointments scheduled.");
        } else {
            for (String appt : appointments) {
                System.out.println(" - " + appt);
            }
        }
    }
}

class MedicalRecord {
    private String condition;
    private List<String> history = new ArrayList<>();

    public MedicalRecord(String condition) {
        this.condition = condition;
    }

    public void addHistory(String entry) {
        history.add(entry);
    }

    public void viewRecord() {
        System.out.println("Condition: " + condition);
        System.out.println("Medical History:");
        if (history.isEmpty()) {
            System.out.println(" - No history yet.");
        } else {
            for (String entry : history) {
                System.out.println(" - " + entry);
            }
        }
    }
}

// ===== Subclasses =====
class Doctor extends Person implements Schedulable {
    private String department;
    private Schedule schedule;

    public Doctor(String name, String department) {
        super(name);
        this.department = department;
        this.schedule = new Schedule();
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public void viewSchedule() {
        System.out.println("Doctor " + name + " (Dept: " + department + ") Schedule:");
        schedule.viewAppointments();
    }

    public Schedule getSchedule() {
        return schedule;
    }
}

class Nurse extends Person {
    private String assignedWard;

    public Nurse(String name, String assignedWard) {
        super(name);
        this.assignedWard = assignedWard;
    }

    public void assistDoctor() {
        System.out.println("Nurse " + name + " is assisting in ward: " + assignedWard);
    }
}

class Receptionist extends Person implements Billable {
    public Receptionist(String name) {
        super(name);
    }

    public void handleAppointment() {
        System.out.println("Receptionist " + name + " is handling appointments.");
    }

    @Override
    public void generateBill() {
        System.out.println("Receptionist " + name + " is generating a bill.");
    }
}

class Patient extends Person {
    private int age;
    private MedicalRecord medicalRecord;

    public Patient(String name, int age, String condition) {
        super(name);
        if (age <= 0) throw new IllegalArgumentException("Age must be positive.");
        this.age = age;
        this.medicalRecord = new MedicalRecord(condition);
    }

    public void viewDetails() {
        System.out.println("Patient: " + name + ", Age: " + age);
        medicalRecord.viewRecord();
    }

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }
}

// ===== Aggregation: Hospital Class =====
class Hospital {
    private List<Doctor> doctors = new ArrayList<>();
    private List<Nurse> nurses = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    private List<Receptionist> receptionists = new ArrayList<>();

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addNurse(Nurse nurse) {
        nurses.add(nurse);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void addReceptionist(Receptionist receptionist) {
        receptionists.add(receptionist);
    }

    public List<Doctor> searchDoctorByDepartment(String department) {
        List<Doctor> result = new ArrayList<>();
        for (Doctor d : doctors) {
            if (d.getDepartment().equalsIgnoreCase(department)) {
                result.add(d);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Hospital hospital = new Hospital();

        // Create Doctors
        Doctor doc1 = new Doctor("Dr. Anum", "Cardiology");
        Doctor doc2 = new Doctor("Dr. Javed", "Neurology");

        doc1.getSchedule().addAppointment("10 AM - Surgery");
        doc2.getSchedule().addAppointment("2 PM - Consultation");

        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);

        // Create Nurse
        Nurse nurse = new Nurse("Kareem", "Ward A");
        hospital.addNurse(nurse);

        // Create Receptionist
        Receptionist receptionist = new Receptionist("Ali");
        hospital.addReceptionist(receptionist);

        // Create Patient
        Patient patient = new Patient("Shahzeb", 45, "Diabetes");
        patient.getMedicalRecord().addHistory("Insulin prescribed on 2023-05-12");
        hospital.addPatient(patient);

        // ===== Use Methods =====
        System.out.println("== Doctor Schedules ==");
        doc1.viewSchedule();
        doc2.viewSchedule();

        System.out.println("\n== Nurse Activity ==");
        nurse.assistDoctor();

        System.out.println("\n== Receptionist Tasks ==");
        receptionist.handleAppointment();
        receptionist.generateBill();

        System.out.println("\n== Patient Details ==");
        patient.viewDetails();

        System.out.println("\n== Search Doctors by Department: Cardiology ==");
        for (Doctor d : hospital.searchDoctorByDepartment("Cardiology")) {
            System.out.println(" - " + d.getName());
        }
    }
}


