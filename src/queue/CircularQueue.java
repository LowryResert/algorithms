package queue;

/**
 * 循环队列的数组实现
 *
 * @author Lowry
 */
public class CircularQueue {
    private String[] items; //数组
    private int n;  //数组大小为n
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        this.n = capacity;
        items = new String[capacity];
    }

    public boolean enqueue(String item) {
        //存疑：为什么此处tail还要加一
        if ((tail + 1) % n == head) return false;
//        if (tail % n == head) return false;
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public void printAll() {
        if (0 == n) return;
        for (int i = head; i % n != tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        queue.enqueue("l");
        queue.enqueue("o");
        queue.enqueue("w");
        queue.enqueue("r");
//        queue.enqueue("y");
        System.out.println(queue.enqueue("qing"));
//        System.out.println(queue.dequeue());
//        System.out.println(queue.dequeue());
        queue.printAll();
        System.exit(0);
    }
}










