package linked;

/**
 * @author nanmian
 * 数组实现队列
 */
public class RingArray {

    public static class MyQueue {
        private final int[] arr;
        private int pushI;
        private int pollI;
        private int size;
        private final int limit;

        public MyQueue(int limit) {
            arr = new int[limit];
            pushI = 0;
            pollI = 0;
            size = 0;
            this.limit = limit;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列已满！");
            }
            size++;
            arr[pushI] = value;
            pushI = nextIndex(pushI);
        }

        public int pop() {
            if (size == 0) {
                throw new RuntimeException("队列已空!");
            }
            size--;
            int ans = arr[pollI];
            pollI = nextIndex(pollI);
            return ans;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int nextIndex(int i) {
            return i < limit - 1 ? i + 1 : 0;
        }
    }

}
