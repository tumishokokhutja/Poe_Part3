/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe_part3;

import javax.swing.JOptionPane;

/**
 *
 * @author RC_Student_lab
 */
public class Poe_Part3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package poe_part3;

/**
 *
 * @author RC_Student_lab
 */
/*import javax.swing.JOptionPane;*/

/*public class KhanbanTasks {*/
/* private static boolean loggedIn = false;*/

    // Arrays to hold task data
    private static String[] developers;
    private static String[] taskNames;
    private static int[] taskIDs;
    private static int[] taskDurations;
    private static String[] taskStatuses;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

        // Login
        login();

        // Populate arrays
        populateArrays();

        // Main menu
        int choice;
        do {
            String choiceStr = JOptionPane.showInputDialog(
                    "\nMain Menu:\n" +
                            "1. Add tasks\n" +
                            "2. Show report\n" +
                            "3. Display tasks with status 'done'\n" +
                            "4. Display longest task\n" +
                            "5. Search task by name\n" +
                            "6. Search tasks by developer\n" +
                            "7. Delete a task\n" +
                            "8. Quit\n" +
                            "Enter your choice:");

            choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1:
                    if (loggedIn) {
                        addTasks();
                    } else {
                        JOptionPane.showMessageDialog(null, "Please login first.");
                    }
                    break;
                case 2:
                    displayReport();
                    break;
                case 3:
                    displayTasksByStatus("done");
                    break;
                case 4:
                    displayLongestTask();
                    break;
                case 5:
                    String taskName = JOptionPane.showInputDialog("Enter task name to search:");
                    searchTaskByName(taskName);
                    break;
                case 6:
                    String developerName = JOptionPane.showInputDialog("Enter developer name to search:");
                    searchTasksByDeveloper(developerName);
                    break;
                case 7:
                    String taskToDelete = JOptionPane.showInputDialog("Enter task name to delete:");
                    deleteTaskByName(taskToDelete);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Exiting...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }

    private static void login() {
        JOptionPane.showMessageDialog(null, "Please login to continue.");

        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        // Dummy validation
        if (username.equals("admin") && password.equals("admin123")) {
            loggedIn = true;
            JOptionPane.showMessageDialog(null, "Login successful.");
        } else {
            JOptionPane.showMessageDialog(null, "Invalid credentials. Please try again.");
            login();
        }
    }

    private static void populateArrays() {
        // Populate arrays with test data
        developers = new String[]{"Mike Smith", "Edward Harrison", "Samantha Paulson", "Glenda Oberholzer"};
        taskNames = new String[]{"Create Login", "Create Add Features", "Create Reports", "Add Arrays"};
        taskIDs = new int[]{1, 2, 3, 4};
        taskDurations = new int[]{5, 8, 2, 11};
        taskStatuses = new String[]{"To Do", "Doing", "Done", "To Do"};
    }

    private static void addTasks() {
        String numTasksStr = JOptionPane.showInputDialog("Enter the number of tasks you wish to enter:");
        int numTasks = Integer.parseInt(numTasksStr);

        // Logic to add tasks to arrays
        // Example: prompt user for input and populate arrays accordingly
    }

    private static void displayTasksByStatus(String status) {
        StringBuilder tasks = new StringBuilder("Tasks with status '" + status + "':\n");
        for (int i = 0; i < taskStatuses.length; i++) {
            if (taskStatuses[i].equalsIgnoreCase(status)) {
                tasks.append("Developer: ").append(developers[i]).append(", Task Name: ").append(taskNames[i]).append(", Task Duration: ").append(taskDurations[i]).append("\n");
            }
        }
        JOptionPane.showMessageDialog(null, tasks.toString());
    }

    private static void displayLongestTask() {
        int longestDuration = -1;
        int index = -1;

        for (int i = 0; i < taskDurations.length; i++) {
            if (taskDurations[i] > longestDuration) {
                longestDuration = taskDurations[i];
                index = i;
            }
        }

        if (index != -1) {
            JOptionPane.showMessageDialog(null, "Developer: " + developers[index] + ", Task Duration: " + taskDurations[index]);
        }
    }

    private static void searchTaskByName(String name) {
        boolean found = false;

        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equalsIgnoreCase(name)) {
                JOptionPane.showMessageDialog(null, "Task Name: " + taskNames[i] + ", Developer: " + developers[i] + ", Task Status: " + taskStatuses[i]);
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }

    private static void searchTasksByDeveloper(String developer) {
        boolean found = false;

        StringBuilder tasks = new StringBuilder();
        for (int i = 0; i < developers.length; i++) {
            if (developers[i].equalsIgnoreCase(developer)) {
                tasks.append("Task Name: ").append(taskNames[i]).append(", Task Status: ").append(taskStatuses[i]).append("\n");
                found = true;
            }
        }

        if (found) {
            JOptionPane.showMessageDialog(null, tasks.toString());
        } else {
            JOptionPane.showMessageDialog(null, "No tasks found for developer " + developer);
        }
    }

    private static void deleteTaskByName(String name) {
        boolean found = false;

        for (int i = 0; i < taskNames.length; i++) {
            if (taskNames[i].equalsIgnoreCase(name)) {
                // Delete task from arrays
                taskNames[i] = null;  // Assuming deletion logic for simplicity
                taskIDs[i] = 0;
                taskDurations[i] = 0;
                taskStatuses[i] = null;
                found = true;
                JOptionPane.showMessageDialog(null, "Entry '" + name + "' successfully deleted.");
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(null, "Task not found.");
        }
    }

    private static void displayReport() {
        StringBuilder report = new StringBuilder("Task Report:\n");
        for (int i = 0; i < taskNames.length; i++) {
            report.append("Task ID: ").append(taskIDs[i]).append(", Task Name: ").append(taskNames[i])
                    .append(", Developer: ").append(developers[i]).append(", Duration: ").append(taskDurations[i])
                    .append(", Status: ").append(taskStatuses[i]).append("\n");
        }
        JOptionPane.showMessageDialog(null, report.toString());
    }
}
    }
    

