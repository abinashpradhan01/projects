import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class MyToDoList {
    ArrayList<String> listOfTask = new ArrayList<>();
    ArrayList<String> res = new ArrayList<>();

    void run() {
        Scanner sh = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an option from the options mentioned below :");
            System.out.println("\t\t1 - for adding a new task");
            System.out.println("\t\t2 - for removing a task");
            System.out.println("\t\t3 - for displaying the list of tasks");
            System.out.println("\t\t4 - for marking a task DONE");
            System.out.println("\t\t5 - for marking a task UNDONE");
            System.out.println("\t\t6 - to RESET the task list");
            System.out.println("\t\t7 - to EXIT");
            System.out.print("Enter the number representing your choice : ");

            int choice = -1;
            try {
                choice = sh.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Choose a valid integer please:");
                sh.next();
                continue;
            }

            sh.nextLine();

            switch (choice) {
                case 1:
                    addTask(sh);
                    break;
                case 2:
                    removeTask(sh);
                    break;
                case 3:
                    displayTaskList();
                    break;
                case 4:
                    markTaskDone(sh);
                    break;
                case 5:
                    markTaskUndone(sh);
                    break;
                case 6:
                    clearTaskList();
                    break;
                case 7:
                    System.out.println("Thank you for visiting.");
                    sh.close();
                    return;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    void clearTaskList() {
        listOfTask.clear();
        res.clear();
        System.out.println("To-do list is empty now.");
    }

    void addTask(Scanner sh) {
        System.out.print("Enter the task you want to add: ");
        String task = sh.nextLine().toUpperCase();
        listOfTask.add(task);
        res.add("UNDONE");
        System.out.println(task + " has been added successfully.");
    }

    void removeTask(Scanner sh) {
        displayTaskList();
        System.out.print("Enter the index of the task you want to remove from list: ");
        int i = sh.nextInt();
        sh.nextLine();

        if (i > 0 && i <= listOfTask.size()) {
            listOfTask.remove(i - 1);
            res.remove(i - 1);
            System.out.println("Task on index " + i + " has been removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    void displayTaskList() {
        System.out.println("***** List of tasks *****");
        if (listOfTask.isEmpty()) {
            System.out.println("Task list is currently empty.");
            return;
        }

        for (int i = 0; i < listOfTask.size(); i++) {
            System.out.println((i + 1) + ". " + listOfTask.get(i) + " - " + res.get(i));
        }
    }

    void markTaskDone(Scanner sh) {
        displayTaskList();
        System.out.print("Enter the index no of the task you want to mark as done: ");
        int i = sh.nextInt();
        sh.nextLine();

        if (i > 0 && i <= listOfTask.size()) {
            res.set(i - 1, "DONE");
            System.out.println("Task on index no. " + i + " has been marked DONE.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    void markTaskUndone(Scanner sh) {
        displayTaskList();
        System.out.print("Enter the index no of the task you want to mark as undone: ");
        int i = sh.nextInt();
        sh.nextLine();

        if (i > 0 && i <= listOfTask.size()) {
            res.set(i - 1, "UNDONE");
            System.out.println("Task on index no. " + i + " has been marked UNDONE.");
        } else {
            System.out.println("Invalid index.");
        }
    }
}

public class To_do_list {
    public static void main(String[] args) {
        MyToDoList l = new MyToDoList();
        l.run();
    }
}
