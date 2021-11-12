
import java.util.ArrayList;
import java.lang.String;
/**
 * Class Bookshelf
 * Implements idea of arranging books into a bookshelf.
 * Books on a bookshelf can only be accessed in a specific way so books don’t fall down;
 * You can add or remove a book only when it’s on one of the ends of the shelf.
 * However, you can look at any book on a shelf by giving its location (starting at 0).
 * Books are identified only by their height; two books of the same height can be
 * thought of as two copies of the same book.
 */

public class Bookshelf {

    /**
     Representation invariant:

     -- the height of books are positive

     -- number of books stored is books.size()

     <put rep. invar. comment here>

     */


    // <add instance variables here>
    private ArrayList<Integer> books;


    /**
     * Creates an empty Bookshelf object i.e. with no books
     */
    public Bookshelf() {

        books = new ArrayList<Integer>();

        assert isValidBookshelf();  // sample assert statement (you will be adding more of these calls)
    }

    /**
     * Creates a Bookshelf with the arrangement specified in pileOfBooks. Example
     * values: [20, 1, 9].
     *
     * PRE: pileOfBooks contains an array list of 0 or more positive numbers
     * representing the height of each book.
     */
    public Bookshelf(ArrayList<Integer> pileOfBooks) {

        //for ( int i = 0; i < pileOfBooks.size(); i++){
        // assert pileOfBooks.get(i) >= 0;
        //}

        books = new ArrayList<Integer>(pileOfBooks);

        assert isValidBookshelf();

    }

    /**
     * Inserts book with specified height at the start of the Bookshelf, i.e., it
     * will end up at position 0.
     *
     * PRE: height > 0 (height of book is always positive)
     */
    public void addFront(int height) {

        //assert height > 0;

        books.add(0, height);

        assert isValidBookshelf();

    }

    /**
     * Inserts book with specified height at the end of the Bookshelf.
     *
     * PRE: height > 0 (height of book is always positive)
     */
    public void addLast(int height) {

        //assert height > 0;

        books.add(books.size(), height);

        assert isValidBookshelf();

    }

    /**
     * Removes book at the start of the Bookshelf and returns the height of the
     * removed book.
     *
     * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
     */
    public int removeFront() {

        //assert books.size() > 0;

        int front = books.remove(0);

        assert isValidBookshelf();

        return front;

    }

    /**
     * Removes book at the end of the Bookshelf and returns the height of the
     * removed book.
     *
     * PRE: this.size() > 0 i.e. can be called only on non-empty BookShelf
     */
    public int removeLast() {

        //assert books.size() > 0;

        int last = books.remove(books.size() - 1);

        assert isValidBookshelf();

        return last;
    }

    /*
     * Gets the height of the book at the given position.
     *
     * PRE: 0 <= position < this.size()
     */
    public int getHeight(int position) {

        // assert position >= 0 && position < books.size();

        int height = books.get(position);

        assert isValidBookshelf();

        return height;

    }

    /**
     * Returns number of books on the this Bookshelf.
     */
    public int size() {

        int size = books.size();

        assert isValidBookshelf();

        return size;

    }

    /**
     * Returns string representation of this Bookshelf. Returns a string with the height of all
     * books on the bookshelf, in the order they are in on the bookshelf, using the format shown
     * by example here:  “[7, 33, 5, 4, 3]”
     */
    public String toString() {

        if (books.size() == 0) {
            String heightOfBooks = "[]";

            assert isValidBookshelf();

            return heightOfBooks;
        }

        String heightOfBooks = "[" + books.get(0);

        for ( int i = 1; i < books.size(); i++){

            heightOfBooks = heightOfBooks + ", " + books.get(i);

        }

        heightOfBooks = heightOfBooks + "]";

        assert isValidBookshelf();


        return heightOfBooks;

    }

    /**
     * Returns true iff the books on this Bookshelf are in non-decreasing order.
     * (Note: this is an accessor; it does not change the bookshelf.)
     */
    public boolean isSorted() {

        for (int i = 0; i < books.size() - 1; i++){
            if (books.get(i) > books.get(i+1)){
                return false;
            }
        }

        assert isValidBookshelf();

        return true;  // dummy code to get stub to compile
    }

    /**
     * Returns true iff the Bookshelf data is in a valid state.
     * (See representation invariant comment for more details.)
     */
    private boolean isValidBookshelf() {

        for (int i = 0; i < books.size(); i++){
            if (books.get(i) <= 0){
                return false;
            }
        }

        return true;

    }

}


