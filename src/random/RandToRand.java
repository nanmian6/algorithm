package random;

/**
 * @author nanmian
 *
 *  给定一个等概率随机返回1到5的函数，不能使用其他第三方函数，如何利用这个函数等概率随机返回1到7？
 */
public class RandToRand {

    /**
     * 给定的函数
     *
     */
    public static int rand() {
        return (int) (Math.random() * 5) + 1;
    }


    /**
     * 将1到5从中间拆分 1到2返回0,4到5返回1,3重来
     *
     * @return
     */
    public static int castRand() {
        int answer;
        do {
            answer = rand();
        }while (answer == 3);

        return answer < 3 ? 0 : 1;
    }

    /**
     * 利用二进制得到结果，也就是做到000到111等概率,也就是0到7
     *
     * @return
     */
    public static int binary() {
        return (castRand() << 2) + (castRand() << 1) + (castRand());
    }

    /**
     * 利用上面的函数得到1到7
     *
     * @return
     */
    public static int result() {
        int answer;
        do {
            answer = binary();
        }while (answer == 0);

        return answer;
    }

    public static void main(String[] args) {
        int testTimes = 100000;
        int[] arr = new int[8];
        for (int i = 0; i < testTimes; i++) {
            arr[result()]++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + "出现了" + arr[i] + "次");
        }
    }


    /* 拓展：如何的等概率随机到17到56范围之间的数？
     * 也就是0到39的随机再加上17
     * 6个二进制位可以得到0到64之间的数
     * 套上面的就行了，大于39就从来
     */

}
