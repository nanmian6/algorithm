package linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanmian
 * 双链表反转
 */
public class ReverseDoubleList {

    public static class DoubleNode {
        public int value;
        public DoubleNode pre;
        public DoubleNode next;

        public DoubleNode(int data) {
            value = data;
        }
    }

    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            DoubleNode node1 = generateRandomDoubleList(len, value);
            List<Integer> list1 = getDoubleListOriginOrder(node1);
            node1 = reverseDoubleList(node1);
//            printArr(list1);
//            System.out.println("-----反转后-----");
//            printDoubleList(node1);
//            System.out.println();
            if (checkDoubleListReverse(list1, node1)) {
                System.out.println("Oops1!");
            }

            DoubleNode node2 = generateRandomDoubleList(len, value);
            List<Integer> list2 = getDoubleListOriginOrder(node2);
            node2 = reverseDoubleList(node2);
            if (checkDoubleListReverse(list2, node2)) {
                System.out.println("Oops2!");
            }
        }
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArr(List<Integer> arr) {
        System.out.print("原始数据：");
        for (Integer num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void printDoubleList(DoubleNode head) {

        System.out.print("正方向：");
        while (head != null) {
            System.out.print(head.value + " ");
            if (head.next == null) {
                break;
            }
            head = head.next;
        }

        System.out.println();
        System.out.print("反方向：");
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.pre;
        }
        System.out.println();

    }

    /**
     * 反转双端链表
     *
     * @param head
     * @return
     */
    public static DoubleNode reverseDoubleList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.pre = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    /**
     * 暴力反转双链表
     *
     * @param head
     * @return
     */
    public static DoubleNode testReverseDoubleList(DoubleNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<DoubleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        DoubleNode pre = list.get(0);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            DoubleNode cur = list.get(i);
            cur.pre = null;
            cur.next = pre;
            pre.next = cur;
            pre = cur;
        }
        return list.get(size - 1);
    }

    /**
     * 生成双端链表
     *
     * @param len
     * @param value
     * @return
     */
    public static DoubleNode generateRandomDoubleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        DoubleNode head = new DoubleNode((int) (Math.random() * (value + 1)));
        DoubleNode pre = head;
        while (size != 0) {
            DoubleNode cur = new DoubleNode((int) (Math.random() * (value +1)));
            pre.next = cur;
            cur.pre = pre;
            pre = cur;
            size--;
        }
        return head;
    }

    /**
     * 获取初始数据
     *
     * @param head
     * @return
     */
    public static List<Integer> getDoubleListOriginOrder(DoubleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    /**
     * 检测反转是否正确
     *
     * @param origin
     * @param head
     * @return
     */
    public static boolean checkDoubleListReverse(List<Integer> origin, DoubleNode head) {
        DoubleNode end = null;
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return true;
            }
            end = head;
            head = head.next;
        }
        for (Integer integer : origin) {
            if (!integer.equals(end.value)) {
                return true;
            }
            end = end.pre;
        }
        return false;
    }

}
