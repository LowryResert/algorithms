package queue;

/**
 * 队列的链表实现
 *
 * @author Lowry
 */
public class LinkedListQueue {
    private Node head = null;   //队头
    private Node tail = null;   //队尾

    public void enqueue(String value) {
        if (tail == null) {
            Node newNode = new Node(value, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(value, null);
            tail = tail.next;
        }
    }

    public String dequeue() {
        if (head == null) return null;
        String value = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //定义静态内部类Node
    private static class Node {
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();
        queue.enqueue("l");
        queue.enqueue("o");
        queue.enqueue("w");
        queue.enqueue("r");
        queue.enqueue("y");
        queue.enqueue("qing");
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.printAll();
    }
}
