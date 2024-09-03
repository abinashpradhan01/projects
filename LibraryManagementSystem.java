import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    void run() {
        Scanner s = new Scanner(System.in);
        ArrayList<String> booklist = new ArrayList<>();

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
                    displayBookList(booklist);
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

    void searchBook(Scanner s, ArrayList<String> booklist) {
        System.out.println("Enter the name of the book you want to search in the book list: ");
        String name = s.nextLine();
        boolean found = false;

        for (String book : booklist) {
            if (book.equalsIgnoreCase(name)) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(name.toUpperCase() + " does exist in the book list");
        } else {
            System.out.println(name + " does not exist in the book list.");
        }
    }

    void issueBooks(Scanner s, ArrayList<String> booklist) {
        System.out.println("Enter the name of the book you want to issue: ");
        String name = s.nextLine();
        String NAME = name.toUpperCase();

        if (booklist.removeIf(book -> book.equalsIgnoreCase(NAME))) {
            System.out.println(NAME + " book has been issued.");
        } else {
            System.out.println("The requested book is not available, sorry.");
        }
    }

    void returnBooks(Scanner s, ArrayList<String> booklist) {
        System.out.println("Enter the name of the book you want to return: ");
        String name = s.nextLine();
        String NAME = name.toUpperCase();

        if (!booklist.contains(NAME)) {
            booklist.add(NAME);
            System.out.println(NAME + " book has been returned.");
        } else {
            System.out.println("Book already in the library.");
        }
    }

    void addBooks(Scanner s, ArrayList<String> booklist) {
        System.out.println("Enter the name of the book you want to add: ");
        String name = s.nextLine();
        String NAME = name.toUpperCase();

        if (!booklist.contains(NAME)) {
            booklist.add(NAME);
            System.out.println(NAME + " book has been added.");
        } else {
            System.out.println("Book already exists in the library.");
        }
    }

    void displayBookList(ArrayList<String> booklist) {
        System.out.println("Available books in the library:");
        
        if (booklist.isEmpty()) {
            System.out.printf("Book list is empty.\n\n\n");
        } else {
            for (int i = 0; i < booklist.size(); i++) {
                System.out.println((i + 1) + " " + booklist.get(i));
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem lms = new LibraryManagementSystem();
        lms.run();
    }
}
