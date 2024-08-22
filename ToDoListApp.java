import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String name, priority, deadline;

    Task(String name, String priority, String deadline) {
        this.name = name;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String toString() {
        return name + " | Priority: " + priority + " | Deadline: " + deadline;
    }
}

public class ToDoListApp {
    private static ArrayList<Task> tasks = new ArrayList<>();
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            System.out.println("To-do list");
            System.out.println("1. Add to do");
            System.out.println("2. Edit to do");
            System.out.println("3. Remove to do");
            System.out.println("4. Display List");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addTask(scanner);
                    break;
                case 2:
                    editTask(scanner);
                    break;
                case 3:
                    deleteTask(scanner);
                    break;
                case 4:
                    viewTasks();
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }
        scanner.close();
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Task Name: ");
        String name = scanner.nextLine();
        System.out.print("Priority (High/Medium/Low): ");
        String priority = scanner.nextLine();
        System.out.print("Deadline (mm/dd/yyyy): ");
        String deadline = scanner.nextLine();
        tasks.add(new Task(name, priority, deadline));
        scanner.nextLine();
    }

    private static void editTask(Scanner scanner) {
        viewTasks();
        System.out.print("Enter task number to edit: ");
        int taskIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            System.out.print("New Task Name: ");
            String name = scanner.nextLine();
            System.out.print("New Priority (High/Medium/Low): ");
            String priority = scanner.nextLine();
            System.out.print("New Deadline (mm/dd/yyyy): ");
            String deadline = scanner.nextLine();
            tasks.set(taskIndex, new Task(name, priority, deadline));
            scanner.nextLine();
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private static void deleteTask(Scanner scanner) {
        viewTasks();
        System.out.print("Enter task number to delete: ");
        int taskIndex = scanner.nextInt() - 1;

        if (taskIndex >= 0 && taskIndex < tasks.size()) {
            tasks.remove(taskIndex);
        } else {
            System.out.println("Invalid task number.");
        }
        scanner.nextLine();
    }

    private static void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks.");
        } else {
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
        scanner.nextLine();
    }
}
