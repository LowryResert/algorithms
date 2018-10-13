package array;

/**
 * 1) 数组中的插入、删除、按照下标随机访问操作；
 * 2） 数组中的数据是int类型的;
 *
 * @author Lowry
 */
public class Array {
    private int[] data;
    private int n;      //定义数组大小
    private int count;  //实际大小

    public Array(int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0; //初始实际大小为0
    }

    //根据索引查找元素
    public int find(int index) {
        if (index < 0 || index >= count) return -1;
        return data[index];
    }

    //根据索引删除元素
    public boolean delete(int index) {
        if (index < 0 || index >= count) return false;
        //从删除位置开始，将后面的元素向前移动一位
        for (int i = index + 1; i < count; i++) {
            data[i - 1] = data[i];
        }
        count--;
        return true;
    }

    //向数组中插入元素
    public boolean insert(int index, int value) {
        if (index < 0 || index >= count) return false;
        if (count == n) return false;
        for (int i = index; i < count; i++ ) {
            data[i + 1] = data[i];
        }
        data[index] = value;
        count++;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}

















