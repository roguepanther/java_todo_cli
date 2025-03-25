import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Creating a simple CLI todo lists
        ArrayList<Todo> todos = new ArrayList<>();

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
//                    removeTodo(todos);
                    break;
                case 3:
                    viewTodos(todos);
                    break;
                case 4:
                    modifyDueDate(todos);
                    break;
                case 5:
                    markAsCompleted(todos);
                    break;
                case 6:
                    saveTodosToFile(todos);
                    break;
                case 7:
                    System.out.println("Goodbye!");
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
        // TODO: Restructure the menu to follow a numerical flow
        System.out.println("---------------------");
        System.out.println("ToDo List V1");
        System.out.println("---------------------");
        System.out.println("Select Option Below: ");
        System.out.println("1. Add a ToDo ");
        System.out.println("2. Remove a ToDo ");
        System.out.println("3. View All ToDos ");
        System.out.println("4. Modify a Todo ");
        System.out.println("5. Mark ToDo as Completed ");
        System.out.println("6. Save Existing Todos");
        System.out.println("7. Exit! ");
    }

    public static void addTodo(ArrayList<Todo> todos) {
        System.out.println("Please enter a todo: ");
        String todo = scanner.nextLine();
        //TODO: Add the ability to add a due date
        System.out.println("Please enter Due Date: ");
        System.out.println("Format: dd/MM/yyyy");
        String dueDate = scanner.nextLine();
        // Create a new todo object and add it
        Todo newTodo = new Todo(todo, dueDate);
        todos.add(newTodo);
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
    public static void viewTodos(ArrayList<Todo> todos) {
        // Display a message to the user if there are no tasks
        if(todos.isEmpty()) {
            System.out.println("There are no tasks in the list.");
        } else {
            System.out.println("All Todos: ");
            for(Todo todo : todos) {
                todo.displayTodo();
            }
        }
        promptUser();
    }

    public static void modifyDueDate(ArrayList<Todo> todos) {
        // First need to ask the user which todo they want to modify
        System.out.println("Which todo would you like to modify due date for: ");
        String selectTodo = scanner.nextLine();
        // Select the task and print out the existing due date
        Todo todoToModify = null;
        for (Todo todo : todos) {
            if(selectTodo.equals(todo.taskDescription)) {
                todoToModify = todo;
                System.out.println("Current Due Date for task: " + todo.dueDate);
                break;
            }
        }
        // Check if we found the todo
        if(todoToModify == null) {
            System.out.println("Task not found!");
            return;
        }

        System.out.println("Enter new due date: (dd/MM/yyyy)");

        // update to the new date
        todoToModify.dueDate = scanner.nextLine();
        System.out.println("New due date has been added!");
        promptUser();
    }

    public static void markAsCompleted(ArrayList<Todo> todos) {
        System.out.println("Which todo would you like to mark as completed: ");
        String selectTodo = scanner.nextLine();
        Todo todoToMark = null;

        for(Todo todo : todos) {
            if(selectTodo.equals(todo.taskDescription)) {
                todoToMark = todo;
                break;
            }
        }

        if(todoToMark == null) {
            System.out.println("Task has not been found");
            return;
        }

        todoToMark.markAsCompleted();
        promptUser();
    }

    public static void saveTodosToFile(ArrayList<Todo> todos) {
        try (
                FileWriter writer = new FileWriter("tasks.txt"); // Overwrites by default
                BufferedWriter bufferedWriter = new BufferedWriter(writer))
        {
            // Write each todo to a file
            for (Todo todo : todos) {
                // format: task description, dueDate, completed
                String todoLine = todo.taskDescription + "," + todo.dueDate + "," + todo.isCompleted;
                System.out.println(todo.taskDescription + "," + todo.dueDate + "," + todo.isCompleted);
                bufferedWriter.write(todoLine);
                bufferedWriter.newLine(); // add a new line after each todo

            }

            System.out.println("Todos successfully saved to tasks.txt");
        } catch (IOException e) {
            System.out.println("Error saving todos: " + e.getMessage());
        }
        promptUser();
    }


    public static void promptUser() {
        System.out.println("Would you like to return back to the main menu? ");
        System.out.println("1. Yes");
        System.out.println("7. No");
        int userAnswer = scanner.nextInt();
        // Clear the buffer of the next line to take the input
        scanner.nextLine();
        if (userAnswer == 1) {
            displayMenu();
        } else if(userAnswer == 7) {
            System.out.println("Thank you for using ToDo App");
            System.exit(0);
        }
    }
}