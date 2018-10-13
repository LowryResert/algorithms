package queue;

/**
 * 队列的数组实现
 *
 * @author Lowry
 */
public class ArrayQueue {
    private String[] items; //数组
    private int n = 0;  //数组大小n
    private int head = 0;   //队头下标
    private int tail = 0;   //队尾下标

    //申请一个大小为capacity的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        //如果 tail==n 表示队列已经满了
        if (tail == n ) return false;
        items[tail] = item;
        ++tail;
        return true;
    }

    //出队
    public String dequeue() {
        //如果 head==tail 表示队列为空
        if (head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (int i = head; i < tail; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);
        queue.enqueue("l");
        queue.enqueue("o");
        queue.enqueue("w");
        queue.enqueue("r");
        System.out.println(queue.enqueue("y"));
        System.out.println(queue.enqueue("qing"));
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        queue.printAll();
    }
}














