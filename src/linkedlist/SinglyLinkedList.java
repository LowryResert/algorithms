package linkedlist;

/**
 * 1) 单链表的实现；
 * 2） 单链表的插入、删除、查找操作；
 *
 * @author Lowry
 */
public class SinglyLinkedList {
    private Node head = null;

    public Node findByValue(int value) {
        Node p = head;
        while (p != null && p.data != value) p = p.next;
        return p;
    }

    public Node findByIndex(int index) {
        Node p = head;
        int pos = 0;
        while (p != null && pos != index) {
            p = p.next;
            pos++;
        }
        return p;
    }

    public void insertToHead(int value) {
        Node newNode = new Node(value,null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertAfter(Node p, int value) {
        Node newNode = new Node(value,null);
        insertAfter(p,newNode);
    }

    public void insertAfter(Node p,Node newNode) {
        if (p == null) return;
        p.next = newNode.next;
        p.next = newNode;
    }

    public void insertBefore(Node p,int value) {
        Node newNode = new Node(value,null);
        insertBefore(p,newNode);
    }

    public void insertBefore(Node p,Node newNode) {
        if (p == null) return;
        if (head == p) {
            insertToHead(newNode);
            return;
        }

        //维护一个head来查找目标节点的上一节点
        Node q = head;
        //注意此处的判断条件是 q.next != p
        //q维护的是目标节点p的上一节点，这样插入操作的时候就不用重复查找目标节点的上一节点
        while (q != null && q.next != p) {
            q = q.next;
        }
        //一直查找，如果head为空，说明链表中没有目标，直接返回
        if (q == null) return;
        newNode.next = p;
        q.next = newNode;
    }

    public void deleteByNode(Node p) {
        if (p == null || head ==null) return;
        if (p == head) {
            head = head.next;
            return;
        }
        Node q = head;
        while (q != null && q.next != p) {
            q = q.next;
        }
        if (q == null) return;
        q.next = q.next.next;
    }

    public void deleteByValue(int value) {
        if (head == null) return;
        Node p = head;
        //维护一个节点q,保存寻址节点p的上一节点
        Node q = null;
        if (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        if (p == null) return;
        //如果维护的q节点为空，说明尚未被赋值。
        //说明需要删除的节点为head节点，直接删除head节点
        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }

        //可重复删除指定value的代码
        /*if (head != null && head.data == value) {
            head = head.next;
        }
        Node pNode = head;
        while (pNode != null) {
            if (pNode.next.data == data) {
                pNode.next = pNode.next.next;
                continue;
            }
            pNode = pNode.next;
        }*/
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
