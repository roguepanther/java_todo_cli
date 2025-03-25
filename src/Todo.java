public class Todo {

    // first, need to set up properties for the class (Attributes)
    String taskDescription;
    boolean isCompleted;
    String dueDate;

    // Constructor to create a new item
    public Todo(String taskDescription, String dueDate) {
        this.taskDescription = taskDescription;
        this.isCompleted = false;
        this.dueDate = dueDate;
    }

    // Need to add a method to mark the todo as completed
    public void markAsCompleted() {
        this.isCompleted = true;
    }

    // Method to display the todo item
    public void displayTodo() {
        String status = isCompleted ? "[Done]" : "[Pending]";
        System.out.println(taskDescription + ": " + status + " (Due: " + dueDate + ")");
    }

    // Method to update the due date.
    public void modifyDueDate(String newDueDate) {
        this.dueDate = newDueDate;
    }
}
