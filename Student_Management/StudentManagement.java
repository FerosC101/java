import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
        System.out.println("Student deleted successfully.");
    }

    public void updateStudent(int id, String name, int age, String course) {
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(name);
                student.setAge(age);
                student.setCourse(course);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public Student searchStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public List<Student> searchStudentsByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }
        return result;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentManagement sms = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Search Student by ID");
            System.out.println("5. Search Students by Name");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Course: ");
                    String course = scanner.nextLine();
                    Student student = new Student(id, name, age, course);
                    sms.addStudent(student);
                    break;
                case 2:
                    System.out.print("Enter Student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    sms.deleteStudent(deleteId);
                    break;
                case 3:
                    System.out.print("Enter Student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter New Age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter New Course: ");
                    String newCourse = scanner.nextLine();
                    sms.updateStudent(updateId, newName, newAge, newCourse);
                    break;
                case 4:
                    System.out.print("Enter Student ID to search: ");
                    int searchId = scanner.nextInt();
                    Student foundStudent = sms.searchStudentById(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student Found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Student Name to search: ");
                    String searchName = scanner.nextLine();
                    List<Student> foundStudents = sms.searchStudentsByName(searchName);
                    if (!foundStudents.isEmpty()) {
                        for (Student s : foundStudents) {
                            System.out.println("Student Found: " + s);
                        }
                    } else {
                        System.out.println("No students found with that name.");
                    }
                    break;
                case 6:
                    sms.displayAllStudents();
                    break;
                case 7:
                    System.out.println("Exiting system.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
