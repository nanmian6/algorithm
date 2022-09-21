package random;

/**
 * @author nanmian
 *
 * 验证Math.random()-------返回0到1 左闭右开
 */
public class VerifyRandom {

    public static void main(String[] args) {

        int testTimes = 100000;
        int count = 0;
        for(int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.3) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println("======================");


        count = 0;
        for(int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 4) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        System.out.println("======================");


        count = 0;
        double x = 0.17;
        for(int i = 0; i < testTimes; i++) {
            if (powerTwo() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        // x的平方
        System.out.println(Math.pow(x, 2));
        System.out.println("======================");


        count = 0;
        for(int i = 0; i < testTimes; i++) {
            if (powerThree() < x) {
                count++;
            }
        }
        System.out.println((double) count / (double) testTimes);
        // x的平方
        System.out.println(Math.pow(x, 3));
        System.out.println("======================");


    }



    /**
     * 返回[0,1)的一个小数，并且出现概率由原来的x调整成x平方
     *
     * @return
     */
    public static double powerTwo() {
        return Math.max(Math.random(), Math.random());
    }

    /**
     * 返回[0,1)的一个小数，并且出现概率由原来的x调整成x3次方
     *
     * @return
     */
    public static double powerThree() {
        return Math.max(Math.random(), Math.max(Math.random(), Math.random()));
    }




}
