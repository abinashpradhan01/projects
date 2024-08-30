import java.util.Scanner;

public class LibraryManagementSystem {

    void run() {
        Scanner s = new Scanner(System.in);
        String[] booklist = new String[50];

        while (true) {
            System.out.println(
                "Choose 1 for adding books, 2 for issuing books, 3 for displaying available book list, " +
                "4 for returning books, 5 to search for a book in the booklist, 6 for exit"
            );
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    addBooks(s, booklist);
                    break;
                case 2:
                    issueBooks(s, booklist);
                    break;
                case 3:
                    displayBookList(s, booklist);
                    break;
                case 4:
                    returnBooks(s, booklist);
                    break;
                case 5:
                    searchBook(s, booklist);
                    break;
                case 6:
                    System.out.println("Thank you, visit again.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Input");
            }
        }
    }

    void searchBook(Scanner s, String[] booklist) {
        System.out.println("Enter the name of the book you want to search in the book list: ");
        String name = s.nextLine();
        int avl = 0;

        for (int k = 0; k < booklist.length; ++k) {
            if (booklist[k] != null && booklist[k].equalsIgnoreCase(name)) {
                avl = 1;
                break;
            }
        }

        if (avl == 1) {
            System.out.println(name.toUpperCase() + " does exist in the book list");
        } else {
            System.out.println(name + " does not exist in the book list.");
        }
    }

    void issueBooks(Scanner s, String[] booklist) {
        System.out.println("Enter the name of the book you want to issue: ");
        String name = s.nextLine();
        String NAME = name.toUpperCase();
        int avl = 0;

        for (String element : booklist) {
            if (element != null && element.equalsIgnoreCase(NAME)) {
                avl = 1;
                break;
            }
        }

        if (avl == 1) {
            for (int k = 0; k < booklist.length; ++k) {
                if (NAME.equalsIgnoreCase(booklist[k])) {
                    booklist[k] = null;
                    System.out.println(NAME + " book has been issued.");
                    break;
                }
            }
        } else {
            System.out.println("The requested book is not available, sorry.");
        }
    }

    void returnBooks(Scanner s, String[] booklist) {
        System.out.println("Enter the name of the book you want to return: ");
        String name = s.nextLine();
        String NAME = name.toUpperCase();
        int avl = 0;

        for (String element : booklist) {
            if (element != null && element.equalsIgnoreCase(NAME)) {
                avl = 1;
                break;
            }
        }

        if (avl == 0) {
            for (int k = 0; k < booklist.length; ++k) {
                if (booklist[k] == null) {
                    booklist[k] = NAME;
                    System.out.println(NAME + " book has been returned.");
                    break;
                }
            }
        } else {
            System.out.println("Book already in the library.");
        }
    }

    void addBooks(Scanner s, String[] booklist) {
        System.out.println("Enter the name of the book you want to add: ");
        String name = s.nextLine();
        String NAME = name.toUpperCase();
        int avl = 0;

        for (String element : booklist) {
            if (element != null && element.equalsIgnoreCase(NAME)) {
                avl = 1;
                break;
            }
        }

        if (avl == 0) {
            for (int k = 0; k < booklist.length; ++k) {
                if (booklist[k] == null) {
                    booklist[k] = NAME;
                    System.out.println(NAME + " book has been added.");
                    break;
                }
            }
        } else {
            System.out.println("Book already exists in the library.");
        }
    }

    void displayBookList(Scanner s, String[] booklist) {
        System.out.println("Available books in the library:");

        for (int k = 0; k < booklist.length; ++k) {
            int i = k + 1;
            if (booklist[k] != null) {
                System.out.println(i + " " + booklist[k]);
            }
        }

        if (booklist[0] == null) {
            System.out.printf("Book list is empty.\n\n\n");
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.run();
    }
}