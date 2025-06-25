import java.util.*;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public String toString() {
        return "id : " + id + " Name : " + name + " Marks : " + marks;
    }
}
public class StudentManagementSystem {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.println("Enter Id :");
        int id  = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name :");
        String name = sc.nextLine();
        System.out.println("Enter Marks :");
        double marks = sc.nextDouble();

        Student student = new Student(id, name, marks);
        studentList.add(student);
        System.out.println("Studnet added successfully.");
    }

    static void viewStudent() {
        if (studentList.isEmpty()) {
            System.out.println("No studnet record found.");
        } else {
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    static void upadateStudent() {
        System.out.println("Enter Id of student to update");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.id == id) {
                sc.nextLine();
                System.out.println("Enter Name :");
                s.name = sc.nextLine();
                System.out.println("Enter Marks :");
                s.marks = sc.nextDouble();
                System.out.println("Student updated successfully.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Id" + id + "not found.") ;
        }
    }

    static void deleteStudent() {
        System.out.println("Enter Id of student to update");
        int id = sc.nextInt();
        boolean removed = studentList.removeIf(s -> s.id == id);

        if (removed) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with id " + id + "not found.");
        }
    }

    public static void main(String args[]) {
        System.out.println("Wlcome to the Student MAnagement System");
        boolean exit = true;

        while(exit){
            System.out.println("Choose an operation");
            System.out.println("1. Add Student");
            System.out.println("2. View Student");
            System.out.println("3. Upadte Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            int choose = sc.nextInt();

            if(choose == 5){
                exit = false;
                System.out.println("You are exit from System.");
                break; 
            }

            switch(choose){
                case 1 :
                    addStudent();
                    break;
                case 2 :
                    viewStudent();
                    break;
                case 3 :
                    upadateStudent();
                    break;
                case 4 :
                    deleteStudent();
                    break;
                default :
                System.out.println("Invalid choice");
                continue;
            }
        }
    }
}
