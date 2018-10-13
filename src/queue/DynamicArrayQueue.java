package queue;

/**
 * 数组实现动态队列：在队列满的时候，会自动进行数据搬移，将head搬移至head=0的位置
 *
 * @author Lowry
 */
public class DynamicArrayQueue {
    private String[] items; //数组
    private int n = 0;  //数组大小n
    private int head = 0;   //队头下标
    private int tail = 0;   //队尾下标

    //申请一个大小为capacity的数组
    public DynamicArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    //入队
    public boolean enqueue(String item) {
        if (tail == n ) {
            //如果 tail==n 并且 head == 0 表示队列已经满了
            if (head == 0) return false;
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            //搬移完成后，更新head和tail
            tail -= head;
            head = 0;
        }
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
        DynamicArrayQueue queue = new DynamicArrayQueue(5);
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
