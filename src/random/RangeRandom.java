package random;

/**
 * @author nanmian
 *
 * 给一个不等概率返回0和1的函数，如何等概率返回0和1？
 */
public class RangeRandom {

    /**
     *
     * 不等概率赶回0和1
     */
    public static int range() {
        return Math.random() < 0.84 ? 0 : 1;
    }

    /**
     *
     * 调用两次，00和11就重来，01就返回0,10就返回1，这样就等概率了
     */
    public static int equal() {
        int answer;
        do {
            answer = range();
        }while (answer == range());

        return answer;
    }


    public static void main(String[] args) {
        int testTimes = 100000;
        int[] arr = new int[2];
        for (int i = 0; i < testTimes; i++) {
            arr[equal()]++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "出现了" + arr[i] + "次");
        }
    }

}
