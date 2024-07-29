import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
    }

    public static void main1(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);
        myLinkedList.addLast(1);

        myLinkedList.removeAllKey(1);
        myLinkedList.display();
    }
}
