package sorts;

/**
 * 冒泡排序、插入排序、选择排序、向下冒泡排序、希尔排序
 *
 * @author Lowry
 */
public class Sorts {
    //插入排序
    public static void insertionSort(int[] a) {
        if (a.length < 1) return;
        for (int i = 1; i < a.length; i++) {
            int value = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (a[j] > value) {
                    a[j + 1] = a[j];    //会覆盖a[i]，需要先维护一个value=a[i]
                } else {
                    break;      //提前推出循环，节省时间
                }
            }
            a[j + 1] = value;   //注意：赋值在索引j+1的位置，而不是索引i的位置，j在循环中一直在变
        }
    }

    //冒泡排序
    public static void bubbleSort(int[] a) {
        if (a.length < 1) return;
        for (int i = 0; i < a.length; i++) {
            //提前推出标志位
            boolean flag = false;
            for (int j = 0; j < a.length - i - 1; j++){
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    //此次冒泡有数据交换
                    flag = true;
                }
            }
            //没有数据交换，提前退出排序
            if (!flag) break;
        }
    }

    //选择排序
    public static void selectionSort(int[] a) {
        if (a.length <= 1) return;
        for (int i = 0; i < a.length; i++) {
            //查找最小值
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;       //获取最小值的索引
                }
            }
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    //向下冒泡排序/选择排序
    public static void bubbleDownSort(int[] a) {
        if (a.length <= 1) return;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                }
            }
        }
    }

    //希尔排序
    public static void shellSort(int[] a) {
        if (a.length <= 1) return;
    }

    public static void main(String[] args) {
        int[] arrs = new int[] {5,8,3,6,1,8,9,2};
//        bubbleSort(arrs);
//        insertionSort(arrs);
//        selectionSort(arrs);
        bubbleDownSort(arrs);
        for (int i : arrs) {
            System.out.println(i);
        }
    }
}














