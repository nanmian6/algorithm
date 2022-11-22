package xor;

/**
 * @author nanmian
 * 一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这种数
 */
public class FindOddTimesNums {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3,3,4,4,5,5,6,6};
        System.out.println(printOddTimesNum(nums));
    }


    public static int printOddTimesNum(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }


}
