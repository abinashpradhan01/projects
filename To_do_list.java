import java.util.Scanner;

class MyToDoList {
    void run() {
        try {
            String[] listOfTask = new String[50];
            final String[] res = new String[50];
            Scanner sh = new Scanner(System.in);
            while (true) {
                System.out.print("Choose an option from the options mentioned below :");
                System.out.printf("\n\t\t1-for adding a new task");
                System.out.printf("\n\t\t2-for removing a task");
                System.out.printf("\n\t\t3-for displaying the list of tasks");
                System.out.printf("\n\t\t4-for marking a task DONE");
                System.out.printf("\n\t\t5-for marking a task UNDONE");
                System.out.printf("\n\t\t6-to RESET the task list");
                System.out.printf("\n\t\t7-to EXIT");
                System.out.print("\nEnter the number representing your choice : ");
                int choice = sh.nextInt();
                sh.nextLine();
                try {
                    switch (choice) {
                        case 1:
                            addTask(sh, listOfTask);
                            break;
                        case 2:
                            removeTask(sh, listOfTask, res);
                            break;
                        case 3:
                            displayTaskList(listOfTask, res);
                            break;
                        case 4:
                            marktaskDone(sh, listOfTask, res);
                            break;
                        case 5:
                            markTaskUndone(sh, listOfTask, res);
                            break;
                        case 6:
                            clearTasklist(sh, listOfTask, res);
                            break;
                        case 7:
                            System.out.println("Thank you for visiting. ");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                } catch (Exception e) {
                    System.out.println("Choose an integer please:");
                    break;
                }
            }
            sh.close();
        } catch (Exception e) {
            run();
        }
    }

    void clearTasklist(Scanner sh, String[] listOfTask, String[] res) {
        for (int i = 0; i < listOfTask.length; ++i) {
            listOfTask[i] = res[i] = null;
        }
        System.out.println("To do list is empty now.");
    }

    void addTask(Scanner sh, String[] listOfTask) {
        String task;
        System.out.print("Enter the task you want to add: ");
        task = sh.nextLine();
        try {
            for (int i = 0; i < listOfTask.length; ++i) {
                if (listOfTask[i] == null) {
                    listOfTask[i] = task.toUpperCase();
                    System.out.println(task.toUpperCase() + " has been added successfully.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("An error occurred. Please try again.");
            addTask(sh, listOfTask);
        }
    }

    void removeTask(Scanner sh, String[] listOfTask, String[] res) {
        displayTaskList(listOfTask, res);
        System.out.print("Enter the index of the task you want to remove from list: ");
        int i = sh.nextInt();
        sh.nextLine();
        int ind = i - 1;
        if (ind >= 0 && ind < listOfTask.length && listOfTask[ind] != null) {
            listOfTask[ind] = null;
            res[ind] = null;
            System.out.println("Task on " + i + " index has been removed.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    void displayTaskList(String[] listOfTask, String[] res) {
        System.out.println("*****List of tasks*****");
        int avl = 0;
        for (int k = 0; k < listOfTask.length; ++k) {
            int i = k + 1;
            if (listOfTask[k] != null) {
                avl = 1;
                System.out.print(i + ". " + listOfTask[k] + " - ");
                if ("DONE".equals(res[k])) {
                    System.out.print(res[k]);
                } else {
                    System.out.print("UNDONE");
                }
                System.out.println();
            }
        }
        if (avl == 0) {
            System.out.println("Task list is currently empty now.");
        }
    }

    void marktaskDone(Scanner sh, String[] listOfTask, String[] res) {
        displayTaskList(listOfTask, res);
        System.out.print("Enter the index no of the task you want to mark as done: ");
        int i = sh.nextInt();
        sh.nextLine();
        int ind = i - 1;
        if (ind >= 0 && ind < listOfTask.length && listOfTask[ind] != null) {
            System.out.println("Task on index no. " + i + " has been marked DONE.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    void markTaskUndone(Scanner sh, String[] listOfTask, String[] res) {
        displayTaskList(listOfTask, res);
        System.out.print("Enter the index no of the task you want to mark as undone: ");
        int i = sh.nextInt();
        sh.nextLine();
        int ind = i - 1;
        if (ind >= 0 && ind < listOfTask.length && listOfTask[ind] != null) {
            res[ind] = "UNDONE";
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
