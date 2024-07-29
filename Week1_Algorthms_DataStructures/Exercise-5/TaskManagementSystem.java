public class TaskManagementSystem {

    // Inner class representing a Task
    public static class Task {
        private int taskId;
        private String taskName;
        private String status;

        // Constructor
        public Task(int taskId, String taskName, String status) {
            this.taskId = taskId;
            this.taskName = taskName;
            this.status = status;
        }

        // Getters and Setters
        public int getTaskId() { return taskId; }
        public void setTaskId(int taskId) { this.taskId = taskId; }
        public String getTaskName() { return taskName; }
        public void setTaskName(String taskName) { this.taskName = taskName; }
        public String getStatus() { return status; }
        public void setStatus(String status) { this.status = status; }

        // Override toString for better representation
        @Override
        public String toString() {
            return "Task ID: " + taskId + ", Name: " + taskName + ", Status: " + status;
        }
    }

    // Inner class representing a Node in the singly linked list
    private static class Node {
        Task task;
        Node next;

        Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Head node of the singly linked list
    private Node head;

    // Constructor
    public TaskManagementSystem() {
        this.head = null;
    }

    // Add a task to the list
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Search for a task by ID
    public Task searchTaskById(int taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null; // Task not found
    }

    // Traverse and display all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by ID
    public boolean deleteTaskById(int taskId) {
        if (head == null) {
            return false; // List is empty
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.task.getTaskId() != taskId) {
            current = current.next;
        }
        if (current.next == null) {
            return false; // Task not found
        }
        current.next = current.next.next;
        return true; // Task successfully deleted
    }

    // Main method to demonstrate functionality
    public static void main(String[] args) {
        TaskManagementSystem tms = new TaskManagementSystem();

        // Add tasks
        tms.addTask(new Task(1, "Complete Project Report", "In Progress"));
        tms.addTask(new Task(2, "Prepare Presentation", "Not Started"));
        tms.addTask(new Task(3, "Send Email Updates", "Completed"));

        // Traverse tasks
        System.out.println("All Tasks:");
        tms.traverseTasks();

        // Search for a task
        System.out.println("\nSearching for Task with ID 2:");
        Task task = tms.searchTaskById(2);
        System.out.println(task != null ? task : "Task not found");

        // Delete a task
        System.out.println("\nDeleting Task with ID 2:");
        boolean deleted = tms.deleteTaskById(2);
        System.out.println(deleted ? "Task deleted successfully" : "Task not found");

        // Traverse tasks after deletion
        System.out.println("\nTasks after deletion:");
        tms.traverseTasks();
    }
}
