import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Creating a simple CLI todo lists
        ArrayList<String> todos = new ArrayList<>();

        int userChoice;
        displayMenu();
        // Take user's input via the Scanner
        userChoice = scanner.nextInt();
        // Now we need to consume the new line character from the buffer
        scanner.nextLine();
        // Repeat this until the user explicitly exits the programme.
        while(userChoice != 4) {
            switch (userChoice) {
                case 1:
                    addTodo(todos);
                    break;
                case 2:
                    removeTodo(todos);
                    break;
                case 3:
                    viewTodos(todos);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Incorrect choice. Please try again!");
                    break;
            }
            userChoice = scanner.nextInt();
            scanner.nextLine();
        }
    }

    public static void displayMenu() {
        System.out.println("---------------------");
        System.out.println("ToDo List V1");
        System.out.println("---------------------");
        System.out.println("Select Option Below: ");
        System.out.println("1. Add a ToDo ");
        System.out.println("2. Remove a ToDo ");
        System.out.println("3. View All ToDos ");
        System.out.println("4. Exit! ");
    }

    public static void addTodo(ArrayList<String> todos) {
        System.out.println("Please enter a todo: ");
        String todo = scanner.nextLine();
        todos.add(todo);
        promptUser();
    }

    public static void removeTodo(ArrayList<String> todos) {
        // TODO: Add the function for removing a todo by the user
        // Loop through the existing array List to search through all tasks
        // flag to track if a task has been found
        boolean taskFound = false;
        String taskToRemove;
        System.out.println("Which task would you like to remove? : ");
        taskToRemove = scanner.nextLine();
        for(int i = 0; i < todos.size(); i++) {
            if(todos.get(i).equals(taskToRemove)){
                todos.remove(i);
                taskFound = true;
                i--;
            }
        }
        // If task was not found, notify the user
        if (!taskFound) {
            System.out.println("Task was not found. Try again!");
        }
        promptUser();
    }

    // Function to view all todos by looping through the ArrayList
    public static void viewTodos(ArrayList<String> todos) {
        // Display a message to the user if there are no tasks
        if(todos.isEmpty()) {
            System.out.println("There are no tasks in the list.");
        } else {
            System.out.println("All Todos: ");
            for(String todo : todos) {
                System.out.println("- " + todo);
            }
        }
        promptUser();
    }

    public static void promptUser() {
        System.out.println("Would you like to return back to the main menu? ");
        System.out.println("1. Yes");
        System.out.println("4. No");
        int userAnswer = scanner.nextInt();
        // Clear the buffer of the next line to take the input
        scanner.nextLine();
        if (userAnswer == 1) {
            displayMenu();
        } else if(userAnswer == 4) {
            System.out.println("Thank you for using ToDo App");
        }
    }
}