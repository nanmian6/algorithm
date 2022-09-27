package search;

import java.util.Arrays;

/**
 * @author nanmian
 * 二分查找
 */
public class BinarySearch {

    // arr保证有序
    public static boolean find(int[] sortedArr, int num) {

        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }

        int l = 0;
        int r = sortedArr.length - 1;
        while (l <= r) {

            int mid = (l + r) / 2;
            if (sortedArr[mid] == num) {
                return true;
            }else if (sortedArr[mid] < num) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }

        return false;
    }

    // 验证方法
    public static boolean check(int[] sortedArr, int num) {
        for (int cur : sortedArr) {
            if (cur == num) {
                return true;
            }
        }

        return false;
    }

    // 生成测试用的随机数组
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    public static void main(String[] args) {
        int testTime = 50000;
        int maxSize = 10;
        int maxValue = 100;
        boolean succeed = true;

        for (int i = 0; i < testTime; i++) {
            int[] array = generateRandomArray(maxSize, maxValue);
            Arrays.sort(array);
            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
            if (check(array, value) != find(array, value)) {
                System.out.println("出错了！");
                succeed = false;
                break;
            }
        }

        System.out.println(succeed ? "Nice！" : "Fucking fucked!");
    }

}
