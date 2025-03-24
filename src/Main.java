import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creating a simple CLI todo lists
        ArrayList<String> todos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int userChoice;
        displayMenu();
        // Take user's input via the Scanner
        userChoice = scanner.nextInt();
        // Repeat this until the user explicitly exits the programme.
        while(userChoice != 4){ // Flawed logic
            switch (userChoice) {
                case 1:
                    addTodo(todos);
                    promptUser();
                    continue;
                case 2:
                    removeTodo();
                    promptUser();
                    continue;
                case 3:
                    viewTodos(todos);
                    promptUser();
                    continue;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Incorrect choice. Please try again!");
                    userChoice = scanner.nextInt(); // We can add a request in the event user makes incorrect choice
            }
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
        // TODO: Add the function for adding a todo by the user
        // Need to add a todo into the general array (array list?) of todos
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a todo: ");
        String todo = scanner.nextLine();
        // Do we want to sanitize the user input? Probably not
        todos.add(todo);
    }

    public static void removeTodo() {
        // TODO: Add the function for removing a todo by the user
    }

    public static void viewTodos(ArrayList<String> todos) {
        // TODO: Add the function for viewing all todos by the user
        System.out.println("All Todos: ");
        for(String todo : todos) {
            System.out.println("- " + todo);
        }
    }

    public static void promptUser() {
        // TODO: Add functionality to trigger the user prompt or not
        Scanner reprompt = new Scanner(System.in);
        System.out.println("Would you like to return back to the main menu? ");
        System.out.println("5. Yes");
        System.out.println("2. No");
        int userAnswer = reprompt.nextInt();
        if(userAnswer == 5) {
            displayMenu();
        } else {
            System.out.println("Thank you for using ToDo App");
            System.exit(0);
        }
    }
}