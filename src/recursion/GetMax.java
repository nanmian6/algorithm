package recursion;

/**
 * @author nanmian
 * 用递归方法求数组中的最大值
 */
public class GetMax {

    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int l, int r) {
        if (l == r) {
            return arr[l];
        }

        int mid = l + ((r - l) >> 1);
        int leftMax = process(arr, l, mid);
        int rightMax = process(arr, mid + 1, r);
        return Math.max(leftMax, rightMax);
    }

}
