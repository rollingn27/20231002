public class MainClass {

    public static void main(String[] args) {
        MyCircularDeque myCircularDeque = new MyCircularDeque(3);
        myCircularDeque.insertLast(1);  // return True
        myCircularDeque.insertLast(2);  // return True
        myCircularDeque.insertFront(3); // return True
        myCircularDeque.insertFront(4); // return False, the queue is full.
        myCircularDeque.getRear();      // return 2
        myCircularDeque.isFull();       // return True
        myCircularDeque.deleteLast();   // return True
        myCircularDeque.insertFront(4); // return True
        myCircularDeque.getFront();
    }
}
