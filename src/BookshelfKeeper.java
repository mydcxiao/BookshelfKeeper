
import java.lang.String;

/**
 * Class BookshelfKeeper
 *
 * Enables users to perform efficient putPos or pickHeight operation on a bookshelf of books kept in
 * non-decreasing order by height, with the restriction that single books can only be added
 * or removed from one of the two *ends* of the bookshelf to complete a higher level pick or put
 * operation.  Pick or put operations are performed with minimum number of such adds or removes.
 */
public class BookshelfKeeper {

    /**
     Representation invariant:
     -- the height of books are arranged in non-decreasing order
     <put rep. invar. comment here>

     */

    // <add instance variables here>
   /*@param bookshelf: Object of class Bookshelf
            total: total number of operations
            numOp: number of operations for one call of mutator
   */

    private Bookshelf bookshelf;
    private int total;
    private int numOp;

    /**
     * Creates a BookShelfKeeper object with an empty bookshelf
     */
    public BookshelfKeeper() {

        bookshelf = new Bookshelf();
        total = 0;
        numOp = 0;

        assert isValidBookshelfKeeper();

    }

    /**
     * Creates a BookshelfKeeper object initialized with the given sorted bookshelf.
     * Note: method does not make a defensive copy of the bookshelf.
     *
     * PRE: sortedBookshelf.isSorted() is true.
     */
    public BookshelfKeeper(Bookshelf sortedBookshelf) {

        bookshelf = sortedBookshelf;
        total = 0;
        numOp = 0;

        assert isValidBookshelfKeeper();

    }

    /**
     * Removes a book from the specified position in the bookshelf and keeps bookshelf sorted
     * after picking up the book.
     *
     * Returns the number of calls to mutators on the contained bookshelf used to complete this
     * operation. This must be the minimum number to complete the operation.
     *
     * PRE: 0 <= position < getNumBooks()
     */
    public int pickPos(int position) {

        numOp = 0;
        final int FRONT = 0;
        final int LAST = 1;
        // Rearrange books from the front
        if(position < bookshelf.size() / 2) {
            int direction = FRONT;
            Bookshelf temp = storeRemove(bookshelf, position, direction);
            temp.removeLast();
            addBack(temp, direction);
            total = total + numOp;
            assert isValidBookshelfKeeper();
            return numOp;
        }
        // Rearrange books form the back
        else {
            int direction = LAST;
            int size = bookshelf.size();
            Bookshelf temp = storeRemove(bookshelf, position, direction);
            bookshelf.removeLast();
            numOp++;
            addBack(temp, direction);
            total = total + numOp;
            assert isValidBookshelfKeeper();
            return numOp;
        }

    }

    /**
     * Inserts book with specified height into the shelf.  Keeps the contained bookshelf sorted
     * after the insertion.
     *
     * Returns the number of calls to mutators on the contained bookshelf used to complete this
     * operation. This must be the minimum number to complete the operation.
     *
     * PRE: height > 0
     */
    public int putHeight(int height) {

        numOp = 0;
        final int FRONT = 0;
        final int LAST = 1;
        // Find the insertion position
        int position = findPosition(height);
        // Insert from the front
        if(position < bookshelf.size() / 2) {
            int direction = FRONT;
            Bookshelf temp = storeRemove(bookshelf, position, direction);
            bookshelf.addFront(height);
            numOp++;
            addBack(temp, direction);
            total = total + numOp;
            assert isValidBookshelfKeeper();
            return numOp;
        }
        // Insert from the back
        else {
            int direction = LAST;
            Bookshelf temp = storeRemove(bookshelf, position, direction);
            bookshelf.addLast(height);
            numOp++;
            addBack(temp, direction);
            total = total + numOp;
            assert isValidBookshelfKeeper();
            return numOp;
        }
    }

    /**
     * Returns the total number of calls made to mutators on the contained bookshelf
     * so far, i.e., all the ones done to perform all of the pick and put operations
     * that have been requested up to now.
     */
    public int getTotalOperations() {

        assert isValidBookshelfKeeper();

        return total;   // dummy code to get stub to compile
    }

    /**
     * Returns the number of books on the contained bookshelf.
     */
    public int getNumBooks() {

        assert isValidBookshelfKeeper();

        return bookshelf.size();
    }

    /**
     * Returns string representation of this BookshelfKeeper. Returns a String containing height
     * of all books present in the bookshelf in the order they are on the bookshelf, followed
     * by the number of bookshelf mutator calls made to perform the last pick or put operation,
     * followed by the total number of such calls made since we created this BookshelfKeeper.
     *
     * Example return string showing required format: “[1, 3, 5, 7, 33] 4 10”
     *
     */
    public String toString() {

        String heightOfBooks = bookshelf.toString() + " " + numOp + " " + total;

        assert isValidBookshelfKeeper();


        return heightOfBooks;

    }

    /**
     * Returns true iff the BookshelfKeeper data is in a valid state.
     * (See representation invariant comment for details.)
     */
    private boolean isValidBookshelfKeeper() {

        for (int i = 0; i < bookshelf.size() - 1; i++) {
            if (bookshelf.getHeight(i) > bookshelf.getHeight(i + 1)){
                return false;
            }
        }
        return true;

    }

    // add any other private methods here
    /**
     * Returns the position of the biggest element that is not bigger than height
     */
    private int search1(int height) {
        int hi = bookshelf.size();
        int lo = 0;

        while (hi - lo > 0) {
            int mid = (lo + hi) / 2;
            if (height < bookshelf.getHeight(mid)) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return --lo;
    }
    /**
     * Returns the position of the biggest element that is smaller than height
     */
    private int search2(int height) {
        int hi = bookshelf.size();
        int lo = 0;

        while (hi - lo > 0) {
            int mid = (lo + hi) / 2;
            if (height <= bookshelf.getHeight(mid)) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        return --lo;
    }
    /**
     * Returns the position that will be used for insertion
     */
    private int findPosition(int height) {
        int position1 = search1(height);
        int position2 = search2(height);
        int position;
        if (bookshelf.size() - position1 - 1 <= position2 + 1) {
            position = position1;
        }
        else {
            position = position2;
        }
        return position;
    }
    /**
     * Returns the temporary Bookshelf Object that stores the values removed from original Bookshelf object
     * Count the operations
     */
    private Bookshelf storeRemove(Bookshelf bookshelf, int position, int direction) {
        Bookshelf temp = new Bookshelf();
        if (direction == 0) {
            for(int i = 0; i <= position; i++) {
                temp.addLast(bookshelf.removeFront());
                numOp++;
            }
        }
        if (direction == 1) {
            int size = bookshelf.size();
            for(int i = position + 1; i < size; i++) {
                temp.addLast(bookshelf.removeLast());
                numOp++;
            }
        }
        return temp;
    }
    /**
     * Add the elements of temporary Bookshelf Object back to the original Bookshelf object
     * Count the operations
     */
    private void addBack(Bookshelf temp, int direction) {
        int size = temp.size();
        if (direction == 0) {
            for(int i = 0; i < size; i++) {
                bookshelf.addFront(temp.removeLast());
                numOp++;
            }
        }
        if (direction == 1) {
            for(int i = 0; i < size; i++) {
                bookshelf.addLast(temp.removeLast());
                numOp++;
            }
        }
    }

}


