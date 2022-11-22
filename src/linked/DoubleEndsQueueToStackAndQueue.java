package linked;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author nanmian
 * 双端队列实现栈和队列
 */
public class DoubleEndsQueueToStackAndQueue {

    /**
     * 双向链表
     * @param <T>
     */
    public static class Node<T> {
        public T value;
        public Node<T> pre;
        public Node<T> next;

        public Node (T data) {
            this.value = data;
        }
    }

    /**
     * 双端队列
     * @param <T>
     */
    public static class DoubleEndsQueue<T> {
        public Node<T> head;
        public Node<T> tail;

        public void addFromHead(T data) {
            Node<T> cur = new Node<>(data);
            if (head == null) {
                head = cur;
                tail = cur;
            } else {
                cur.next = head;
                head.pre = cur;
                head = cur;
            }
        }

        public void addFromTail(T data) {
            Node<T> cur = new Node<>(data);
            if (tail == null) {
                head = cur;
                tail = cur;
            }else {
                cur.pre = tail;
                tail.next = cur;
                tail = cur;
            }
        }

        public T popFromHead() {
            if (head == null) {
                return null;
            }
            Node<T> cur = head;
            if (head == tail) {
                head = null;
                tail = null;
            }else {
                head = head.next;
                cur.next = null;
                head.pre = null;
            }
            return cur.value;
        }

        public T popFromTail() {
            if (tail == null) {
                return null;
            }
            Node<T> cur = tail;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                tail = tail.pre;
                cur.pre = null;
                tail.next = null;
            }
            return cur.value;
        }

        public boolean isEmpty() {
            return head == null;
        }

    }

    /**
     * 双端队列实现栈
     *
     * @param <T>
     */
    public static class MyStack<T> {
        private final DoubleEndsQueue<T> queue;

        public MyStack() {
            queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromHead();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    /**
     * 双端队列实现队列
     * @param <T>
     */
    public static class MyQueue<T> {
        private final DoubleEndsQueue<T> queue;

        public MyQueue() {
            queue = new DoubleEndsQueue<>();
        }

        public void push(T value) {
            queue.addFromHead(value);
        }

        public T pop() {
            return queue.popFromTail();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    public static boolean isEqual(Integer o1, Integer o2) {
        if (o1 == null && o2 != null) {
            return true;
        }
        if (o1 != null && o2 == null) {
            return true;
        }
        if (o1 == null && o2 == null) {
            return false;
        }
        return !o1.equals(o2);
    }

    public static void main(String[] args) {
        int oneTestDataNum = 100;
        int value = 10000;
        int testTimes = 100000;

        for (int i = 0; i < testTimes; i++) {
            MyStack<Integer> myStack = new MyStack<>();
            MyQueue<Integer> myQueue = new MyQueue<>();
            Stack<Integer> stack = new Stack<>();
            Queue<Integer> queue = new LinkedList<>();
            for (int j = 0; j < oneTestDataNum; j++) {
                int nums = (int) (Math.random() * value);
                if (stack.isEmpty()) {
                    myStack.push(nums);
                    stack.push(nums);
                } else {
                    if (Math.random() < 0.5) {
                        myStack.push(nums);
                        stack.push(nums);
                    } else {
                        if (isEqual(myStack.pop(), stack.pop())) {
                            System.out.println("oops!");
                        }
                    }
                }
                int numq = (int) (Math.random() * value);
                if (queue.isEmpty()) {
                    myQueue.push(numq);
                    queue.offer(numq);
                } else {
                    if (Math.random() < 0.5) {
                        myQueue.push(numq);
                        queue.offer(numq);
                    } else {
                        if (isEqual(myQueue.pop(), queue.poll())) {
                            System.out.println("oops!");
                        };
                    }
                }
            }
        }
        System.out.println("Finish");
    }


}
