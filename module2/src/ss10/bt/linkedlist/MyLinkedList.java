package ss10.bt.linkedlist;

public class MyLinkedList<E> {
    public class Node {
        private Node next;
        private final Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData(Object data) {
            return this.data;
        }
    }

    private Node head;
    private Node tail;
    private int numNodes = 0;

    public MyLinkedList() {
    }

    public void add(int index, E element) {
       if (index==0){
           addFirst(element);
       }else if (index>=numNodes){
           addLast(element);
       }else {
           Node current = head;
           for (int i = 0; i < index; i++) {
               current=current.next;
               Node temp = current.next;
               current.next=new Node(element);
               (current.next).next=temp;
               numNodes++;
           }
       }
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        if (tail == null) {
            tail = head;
        }
        numNodes++;
    }

    public void addLast(E e) {
        Node newNode = new Node(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        numNodes++;
    }

    public E removeFirst() {
        if (numNodes == 0) {
            return null;
        } else {
            Node temp = head;
            head = head.next;
            numNodes--;
            if (head == null) {
                tail = null;
            }
            return (E) temp.data;
        }
    }

    public E removeLast() {
        if (numNodes == 0) {
            return null;
        } else if (numNodes == 1) {
            Node temp = head;
            head = tail = null;
            numNodes = 0;
            return (E) temp.data;
        } else {
            Node current = head;

            for (int i = 0; i < numNodes - 2; i++)
                current = current.next;

            Node temp = tail;
            tail = current;
            tail.next = null;
            numNodes--;
            return (E) temp.data;
        }
    }

    public E remove(int index) {
        if (index < 0 || index>=numNodes ){
            return null;
        }else if (index==0){
            return removeFirst();
        }else if (index==numNodes-1){
            return removeLast();
        }else {
            Node previous = head;
            for (int i = 0; i < index; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next= current.next;
            numNodes--;
            return (E) current.data;
        }//s
    }
    public int size(){
        return this.numNodes;
    }
    public E get (int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return (E)temp;
    }
    public void printList(){
        Node temp = head;
        while (temp!= null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
//    public Object clone()
    public boolean contains(E o){
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if ((E) temp.data == o) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public int indexOf(E o){
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if ((E) temp.data == o) return i;
            temp = temp.next;
        }
        return -1;
    }
}
