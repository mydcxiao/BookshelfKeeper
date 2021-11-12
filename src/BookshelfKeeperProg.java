
import java.util.Scanner;
import java.lang.String;
import java.util.ArrayList;

public class BookshelfKeeperProg {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter initial arrangement of books followed by newline:");
        Scanner books = new Scanner(in.nextLine()); // read the string of books, construct a new scanner only containing the string
        ArrayList<Integer> bookArray = readArrayList(books); // convert string to arraylist
        // do error checking for the arraylist of books
        if (!errorcheck1(bookArray)) {
            return;
        }
        if (!errorcheck2(bookArray)) {
            return;
        }

        Bookshelf bookshelf = new Bookshelf(bookArray);
        BookshelfKeeper bookshelfKeeper = new BookshelfKeeper(bookshelf);
        System.out.println(bookshelfKeeper.toString());
        System.out.println("Type pick <index> or put <height> followed by newline. Type end to exit.");
        // do input operations until meet "end" or meet EOF
        while (in.hasNext()) {
            if (!doOperation(in.next(), in, bookshelfKeeper)) {
                return;
            }
        }

    }
    /** Return the converted arraylist of the scanned string of books
     */
    private static ArrayList<Integer> readArrayList(Scanner books) {
        ArrayList<Integer> bookarray = new ArrayList<Integer>();
        while (books.hasNextInt()) {
            bookarray.add(books.nextInt());
        }
        return bookarray;
    }
    /** Do the input operation according to the command type
     * Also do error checking
     */
    private static boolean doOperation(String operation, Scanner in, BookshelfKeeper bookshelfKeeper) {
        if (!errorcheck3(operation)) {
            return false;
        }
        else if (operation.equals("put")) {
            int height = in.nextInt();
            if (!errorcheck5(height)) {
                return false;
            }
            bookshelfKeeper.putHeight(height);
            System.out.println(bookshelfKeeper.toString());
        }
        else if (operation.equals("pick")) {
            int index = in.nextInt();
            int size = bookshelfKeeper.getNumBooks();
            if (!errorcheck4(index, size)) {
                return false;
            }
            bookshelfKeeper.pickPos(index);
            System.out.println(bookshelfKeeper.toString());
        }
        else if (operation.equals("end")) {
            System.out.println("Exiting Program.");
            return false;
        }
        return true;
    }
    /** Check if the input books are all positive
     *
     */
    private static boolean errorcheck1(ArrayList<Integer> bookArray) {
        for (int i = 0; i < bookArray.size(); i++) {
            if (bookArray.get(i) <= 0) {
                System.out.println("ERROR: Height of a book must be positive.");
                System.out.println("Exiting Program.");
                return false;
            }
        }
        return true;
    }
    /** Check if the input books are in non-decreasing order
     *
     */
    private static boolean errorcheck2(ArrayList<Integer> bookArray) {
        for (int i = 0; i < bookArray.size() - 1; i++) {
            if (bookArray.get(i) > bookArray.get(i + 1)) {
                System.out.println("ERROR: Heights must be specified in non-decreasing order.");
                System.out.println("Exiting Program.");
                return false;
            }
        }
        return true;
    }
    /** Check if the input command is valid
     *
     */
    private static boolean errorcheck3(String operation) {
        if (!operation.equals("put") && !operation.equals("pick") && !operation.equals("end")) {
            System.out.println("ERROR: Invalid command. Valid commands are pick, put, or end.");
            System.out.println("Exiting Program.");
            return false;
        }
        return true;
    }
    /** Check if the operand of "pick" is valid
     *
     */
    private static boolean errorcheck4(int index, int size) {
        if (index < 0 || index >= size) {
            System.out.println("ERROR: Entered pick operation is invalid on this shelf.");
            System.out.println("Exiting Program.");
            return false;
        }
        return true;
    }
    /** Check if the operand of "put" is valid
     *
     */
    private static boolean errorcheck5(int height) {
        if (height <= 0) {
            System.out.println("ERROR: Height of a book must be positive.");
            System.out.println("Exiting Program.");
            return false;
        }
        return true;
    }
}
