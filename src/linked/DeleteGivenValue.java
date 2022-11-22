package linked;

/**
 * @author nanmian
 * 删除链表中给定的值
 */
public class DeleteGivenValue {

    public static class Node{
        public int value;
        public Node next;
        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {

    }

    public static Node removeValue(Node head, int value) {
        // head来到第一个不需要删除的位置，作为最后链表的头结点
        while (head != null) {
            if (head.value != value) {
                break;
            }
            head = head.next;
        }
        Node pre = head;
        Node cur = head;
        while (cur != null) {
            if (cur.value == value) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }

}
