package linked;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanmian
 * 单链表反转(迭代法)
 */
public class ReverseSingleList {

    public static class SingleNode {
        public int value;
        public SingleNode next;
        public SingleNode(int data) {
            value = data;
        }
    }

    public static void main(String[] args) {
        int len = 50;
        int value = 100;
        int testTime = 100000;
        System.out.println("test begin!");
        for (int i = 0; i < testTime; i++) {
            SingleNode node1 = generateRandomSingleList(len, value);
            List<Integer> list1 = getSingleListOriginOrder(node1);
            node1 = reverseSingleList(node1);
            if (checkSingleListReverse(list1, node1)) {
                System.out.println("Oops1!");
            }

            SingleNode node2 = generateRandomSingleList(len, value);
            List<Integer> list2 = getSingleListOriginOrder(node2);
            node2 = testReverseSingleList(node2);
            if (checkSingleListReverse(list2, node2)) {
                System.out.println("Oops2!");
            }
        }
    }

    /**
     * 迭代模式反正单链表
     * a    ->   b    ->  c  ->  null
     * c    ->   b    ->  a  ->  null
     *
     * @param head
     * @return
     */
    public static SingleNode reverseSingleList(SingleNode head) {
        // 代表上一个节点
        SingleNode pre = null;
        // 代表下一个节点
        SingleNode next = null;

        while (head != null) {
            // 把下一个要操作的节点记录下来
            next = head.next;
            // 改变头节点的指向
            head.next = pre;
            // 记录上一个节点
            pre = head;
            // 进行下一节点
            head = next;
        }
        return pre;
    }

    /**
     * 暴力模式反转单链表
     *
     * @return
     */
    public static SingleNode testReverseSingleList(SingleNode head) {
        if (head == null) {
            return null;
        }
        ArrayList<SingleNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        list.get(0).next = null;
        int size = list.size();
        for (int i = 1; i < size; i++) {
            list.get(i).next = list.get(i - 1);
        }
        return list.get(size - 1);
    }

    /**
     * 单链表生成器
     *
     * @param len
     * @param value
     * @return
     */
    public static SingleNode generateRandomSingleList(int len, int value) {
        int size = (int) (Math.random() * (len + 1));
        if (size == 0) {
            return null;
        }
        size--;
        SingleNode head = new SingleNode((int) (Math.random() * (value + 1)));
        SingleNode pre = head;
        while (size != 0) {
            SingleNode cur = new SingleNode((int) (Math.random() * (value + 1)));
            pre.next = cur;
            pre = cur;
            size--;
        }
        return head;
    }

    /**
     * 获取单链表原始数据
     *
     * @param head
     * @return
     */
    public static List<Integer> getSingleListOriginOrder(SingleNode head) {
        List<Integer> ans = new ArrayList<>();
        while (head != null) {
            ans.add(head.value);
            head = head.next;
        }
        return ans;
    }

    /**
     * 检测结果
     *
     * @param origin
     * @param head
     * @return
     */
    public static boolean checkSingleListReverse(List<Integer> origin, SingleNode head) {
        for (int i = origin.size() - 1; i >= 0; i--) {
            if (!origin.get(i).equals(head.value)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }


}
