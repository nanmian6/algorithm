package xor;

import java.util.Arrays;

/**
 * @author nanmian
 * 一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两种数
 */
public class FindOddTimesTwoNums {

    public static void main(String[] args) {

        int[] nums = {1,1,1,2,2,2,3,3,4,4,5,5,6,6};
        System.out.println(Arrays.toString(printOddTimesNum2(nums)));
    }

    public static int[] printOddTimesNum2(int[] nums) {
        // 把这两种数a b的^结果求出来
        int eor = 0;
        for (int num : nums) {
            eor ^= num;
        }

        // 既然a和b是两种数，eor一定不等于0
        // 提取出a ^ b的最右侧的1（其实提取出哪一位上的1都行）
        int rightOne = eor & (-eor);

        // 这就说明a和b的rightOne位上一定是不等的
        // 数组中出现过偶数次的数也是可以分成两类的，一类为rightOne位上为0的数，一类为rightOne位上为1的数
        // 我们只挑其中一类进行^运算,这样就能把a,b其中一个拽出来
        int onlyOne = 0;
        for (int num : nums) {
            // rightOne上为1的才进行^
            if ((num & rightOne) != 0) {
                onlyOne ^= num;
            }
        }

        return new int[]{onlyOne, eor ^ onlyOne};
    }


}

