package array;

/**
 * @author nanmian
 *
 * 前缀和数组
 */
public class PreSum {

    /*
    * 给定一个数组arr和两个下标left,right，返回两个下标的累加和
    *
    * 一般有两种方案，但都是生成预处理结构，一种是生成一个n*n的矩阵,x代表left，y代表right，将x到y的累加和算好放进去，
    * 但这样会浪费一半的空间，因为x不能大于y。
    * 另一种就是前缀数组，将下标i的值改为0到i的累加和，每次返回arr[right] - arr[left],但这样就每次都需要减一下
    * 所以如果查询次数巨多时，第一种更快，但一般都是选择前缀和数组
    * */

    private int[] preSum;

    public PreSum(int[] array) {

        int n = array.length;
        preSum = new int[n];
        preSum[0] = array[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = array[i] + preSum[i -1];
        }
    }

    public int rangeSum(int left, int right) {
        return left == 0 ? preSum[right - 1] : preSum[right - 1] - preSum[left - 1];
    }

}
