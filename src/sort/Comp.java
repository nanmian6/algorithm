package sort;

/**
 * @author nanmian
 * 对数器
 */
public class Comp {

    /**
     * 返回随机长度随机值数组
     *
     * @param maxLen
     * @param maxValue
     * @return
     */
    public static int[] randomArray(int maxLen, int maxValue) {

        int len = (int) (Math.random() * maxLen);
        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            ans[i] = (int) (Math.random() * maxValue);
        }
        return ans;
    }

    /**
     * 复制数组方法
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {

        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }

        return ans;
    }

    /**
     * 验证数组是否排序正确
     *
     * @param
     */
    public static boolean isSorted(int[] arr) {

        if (arr.length < 2) {
            return true;
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < max) {
                return false;
            }
            max = arr[i];
        }

        return true;
    }


    public static void main(String[] args) {

        int maxlength = 500;
        int maxValue = 1000;
        int testTimes = 10000;

        for (int i = 0; i < testTimes; i++) {

            int[] array = randomArray(maxlength, maxValue);
            int[] copyArray = copyArray(array);
            SelectionSort.sort(array);

            if (!isSorted(array)) {
                // 打印错误例子
                SelectionSort.print(copyArray);
                System.out.println("选择排序错了");
                break;
            }
        }

    }


}
