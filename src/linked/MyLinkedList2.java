package linked;

/**
 * Author li.ling
 * Description lc 设计链表 - 双向链表
 * Date 2021/3/18 11:44
 */
public class MyLinkedList2 {

    private class ListNode {

        ListNode prev;

        ListNode next;

        int val;

        ListNode(int val) {
            this.val = val;
        }
    }

    private int size;
    // 虚拟头节点
    private ListNode dummyHead;
    // 虚拟尾节点
    private ListNode dummyTail;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList2() {
        this.size = 0;
        dummyHead = new ListNode(0);
        dummyTail = new ListNode(0);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode prevNode = getPrevNode(index);
        return prevNode.next.val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode prevNode = getPrevNode(index);
        ListNode next = prevNode.next;
        ListNode curr = new ListNode(val);
        // 新增操作
        prevNode.next = curr;
        curr.prev = prevNode;
        curr.next = next;
        next.prev = curr;
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode prevNode = getPrevNode(index);
        prevNode.next = prevNode.next.next;
        prevNode.next.prev = prevNode;
        size--;
    }

    // 获取索引节点的前一个节点
    private ListNode getPrevNode(int index) {
        ListNode preNode = dummyHead;
        // 如果index在链表前半段，则从前往后搜索，否则从后往前搜索
        if (index < size / 2) {
            for (int i = 0; i < index; i++) {
                preNode = preNode.next;
            }
        } else {
            preNode = dummyTail;
            for (int i = 0; i <= size - index; i++) {
                preNode = preNode.prev;
            }
        }
        return preNode;
    }

    public static void main(String[] args) {
        MyLinkedList2 list = new MyLinkedList2();
        list.addAtHead(2);
        list.deleteAtIndex(1);
        list.addAtHead(2);
        list.addAtHead(7);
        list.addAtHead(3);
        list.addAtHead(2);
        list.addAtHead(5);
        list.addAtTail(5);
        list.get(5);
        list.deleteAtIndex(6);
        list.deleteAtIndex(4);
        System.out.println(list);
    }
}
