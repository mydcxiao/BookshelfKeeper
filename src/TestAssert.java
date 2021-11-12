
import java.util.ArrayList;
import java.lang.String;

public class TestAssert {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(3);

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1);
        arr2.add(-1);

        Bookshelf bookshelf = new Bookshelf(arr);
        bookshelf = new Bookshelf(arr2);
        bookshelf.addFront(-2);
      /*ArrayList<Integer> arr = new ArrayList<>();
      arr.add(1);
      arr.add(3);
      arr.add(4);
      arr.add(5);
      Bookshelf book = new Bookshelf(arr);
      BookshelfKeeper keeper = new BookshelfKeeper(book);
      keeper.pickPos(2);
      System.out.println(keeper.toString());
      keeper.putHeight(4);
      System.out.println(keeper.toString());*/

    }
}