package linked;

import java.util.Stack;

/**
 * @author nanmian
 *  如何用栈结构实现队列结构
 *  利用两个栈 一个进栈 一个出栈
 *  将进栈的数据存入出栈
 */
public class TwoStacksImplementQueue {

    public static class TwoStacksQueue {
        private final Stack<Integer> stackPush;
        private final Stack<Integer> stackPop;

        public TwoStacksQueue() {
            this.stackPush = new Stack<>();
            this.stackPop = new Stack<>();
        }

        // 核心就是push栈向pop栈导入数据
        private void pushToPop() {
            if (stackPop.empty()) {
                while (!stackPush.empty()) {
                    stackPop.push(stackPush.pop());
                }
            }
        }

        public void add(int pushInt) {
            stackPush.push(pushInt);
            pushToPop();
        }

        public int poll() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.pop();
        }

        public int peek() {
            if (stackPop.empty() && stackPush.empty()) {
                throw new RuntimeException("Queue is empty!");
            }
            pushToPop();
            return stackPop.peek();
        }

    }

    public static void main(String[] args) {
        TwoStacksQueue test = new TwoStacksQueue();
        test.add(1);
        test.add(2);
        test.add(3);

        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
        System.out.println(test.peek());
        System.out.println(test.poll());
    }

}
