package ss10.bt.linkedlist;

public class Test {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(0,1);
        list.add(1,2);
        list.add(2,3);
        System.out.println("first");
        list.remove(1);
        list.printList();
    }
}
