
import java.util.ArrayList;
import java.lang.String;

public class BookshelfTester {

    public static void main(String[] args) {
        // Test the Bookshelf() and toString method
        Bookshelf bookshelf = new Bookshelf();
        System.out.println("Creat an empty Bookshelf [exp: []]: ");
        System.out.println(bookshelf.toString());
        // Test the Bookshelf(ArrayList<integer>) and toString method
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(3);
        arr.add(7);
        arr.add(11);
        bookshelf = new Bookshelf(arr);
        System.out.println("Using an arraylist to creat an Bookshelf [exp: [1, 3, 7, 11]]: ");
        System.out.println(bookshelf.toString());

        // Test the addFront method
        bookshelf = new Bookshelf();
        bookshelf.addFront(5);
        System.out.println("Add 5 to the front of an empty Bookshelf [exp: [5]]: ");
        System.out.println(bookshelf.toString());
        bookshelf = new Bookshelf(arr);
        bookshelf.addFront(5);
        System.out.println("Add 5 to the front of an non-empty Bookshelf [exp: [5, 1, 3, 7, 11]]: ");
        System.out.println(bookshelf.toString());

        // Test the addLast method
        bookshelf = new Bookshelf();
        bookshelf.addLast(5);
        System.out.println("Add 5 to the last of an empty Bookshelf [exp: [5]]: ");
        System.out.println(bookshelf.toString());
        bookshelf = new Bookshelf(arr);
        bookshelf.addLast(5);
        System.out.println("Add 5 to the last of an non-empty Bookshelf [exp: [1, 3, 7, 11, 5]]: ");
        System.out.println(bookshelf.toString());

        //
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(5);

        // Test the removeFront method
        bookshelf = new Bookshelf(arr2);
        bookshelf.removeFront();
        System.out.println("Remove the front to get an empty Bookshelf [exp: []]: ");
        System.out.println(bookshelf.toString());
        bookshelf = new Bookshelf(arr);
        bookshelf.removeFront();
        System.out.println("Remove the front of an non-empty Bookshelf [exp: [3, 7, 11]]: ");
        System.out.println(bookshelf.toString());

        // Test the removeLast method
        bookshelf = new Bookshelf(arr2);
        bookshelf.removeFront();
        System.out.println("Remove the last to get an empty Bookshelf [exp: []]: ");
        System.out.println(bookshelf.toString());
        bookshelf = new Bookshelf(arr);
        bookshelf.removeLast();
        System.out.println("Remove the front of an non-empty Bookshelf [exp: [1, 3, 7]]: ");
        System.out.println(bookshelf.toString());

        //Test the getHeight method
        bookshelf = new Bookshelf(arr);
        System.out.println("Get the height of the first book in a Bookshelf [exp: 1]: ");
        System.out.println(bookshelf.getHeight(0));

        // Test the size method
        System.out.println("Get the size of a Bookshelf [exp: 4]: ");
        System.out.println(bookshelf.size());

        //Test the isSorted method
        ArrayList<Integer> arr3 = new ArrayList<>();
        arr3.add(5);
        arr3.add(6);
        arr3.add(1);

        System.out.println("Is a sorted Bookshelf ? [exp: true]: ");
        System.out.println(bookshelf.isSorted());

        bookshelf = new Bookshelf(arr2);

        System.out.println("Is a sorted Bookshelf ? [exp: true]: ");
        System.out.println(bookshelf.isSorted());

        bookshelf = new Bookshelf(arr3);

        System.out.println("Is a sorted Bookshelf ? [exp: false]: ");
        System.out.println(bookshelf.isSorted());

        //Test the assert statement
        //constructor
        //ArrayList<Integer> arr4 = new ArrayList<>();
        //arr4.add(1);
        //arr4.add(-1);
        //bookshelf = new Bookshelf(arr4);

        //addFront
        //bookshelf = new Bookshelf(arr);
        //bookshelf.addFront(-1);

        //addLast
        //bookshelf.addLast(-1);

        //removeFront
        //bookshelf = new Bookshelf();
        //bookshelf.removeFront();

        //removeLast
        //bookshelf.removeLast();

        //getHeight
        //bookshelf.getHeight(0);
        //bookshelf.getHeight(-1);

        //toString
        //bookshelf.toString();

        //size
        //bookshelf.size();

        //isSorted
        //bookshelf.isSorted();

    }

}

