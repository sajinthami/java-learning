import java.util.ArrayList;
import java.util.Scanner;

// Represents a single task in the todo list.
class Task {
    private String description;
    private boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public void markComplete() {
        this.completed = true;
    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        String status = completed ? "[X]" : "[ ]";
        return status + " " + description;
    }
}

// Manages the collection of tasks and the operations on them.
class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Added: " + description);
    }

    public void completeTask(int index) {
        if (isValidIndex(index)) {
            tasks.get(index).markComplete();
            System.out.println("Marked complete: " + tasks.get(index));
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void deleteTask(int index) {
        if (isValidIndex(index)) {
            Task removed = tasks.remove(index);
            System.out.println("Deleted: " + removed);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void printAll() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks yet.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ". " + tasks.get(i));
        }
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < tasks.size();
    }
}

// Entry point: handles user interaction via the console.
public class Main {
    public static void main(String[] args) {
        TodoList todoList = new TodoList();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Todo List Menu ---");
            System.out.println("1. Add task");
            System.out.println("2. View tasks");
            System.out.println("3. Mark task complete");
            System.out.println("4. Delete task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    todoList.addTask(description);
                    break;
                case "2":
                    todoList.printAll();
                    break;
                case "3":
                    System.out.print("Enter task number to complete: ");
                    int completeIndex = Integer.parseInt(scanner.nextLine());
                    todoList.completeTask(completeIndex);
                    break;
                case "4":
                    System.out.print("Enter task number to delete: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    todoList.deleteTask(deleteIndex);
                    break;
                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
        scanner.close();
    }
}