package sort;

/**
 * @author nanmian
 * 归并排序
 */
public class MergeSort {

    // 递归方法实现
    // 整体是递归，左边排好序+右边排好序+merge让整体有序
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length - 1);
    }

    /**
     * 非递归方法实现
     * 流程在于折腾步长这个概念，每次以步长为步数分组，每次分左右两组
     * 步长从1开始，步长的变化一定是以2为基数
     * 左组一定要满，如果凑不齐就不管。右组有多少算多少
     * 步长一旦超过总长度, 说明搞完了, 停止就行了
     * */
    public static void mergeSortPlus(int[] arr) {

        if (arr == null || arr.length < 2) {
            return;
        }

        int n = arr.length;
        // 步长
        int mergeSize = 1;
        // 1.步长大于n的时候就表示结束了
        while (mergeSize < n) {
            // 2.定义左组的起始位置
            int l = 0;
            // 3.l大于n的时候刚好走完
            while (l < n) {
                // 如果左组凑不齐了直接跳过
                if (mergeSize >= n - l) {
                    break;
                }
                // 中分位置，l从0开始，所以要-1
                int m = l + mergeSize - 1;
                // 右组不够就把剩下的加上就行，从0开始，所以要-1
                int r = m + Math.min(mergeSize, n - m - 1);
                merge(arr, l, m, r);
                //继续往前走
                l = r + 1;
            }
            // 防止溢出整数最大值
            if (mergeSize > n / 2) {
                break;
            }

            // 每次*2
            mergeSize <<= 1;
        }

    }

    // 请把arr[L..R]排有序
    // l...r N
    // T(N) = 2 * T(N / 2) + O(N)
    // O(N * logN)
    private static void process(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        // 就是(l + r) / 2，这样是为了防止溢出
        int mid = l + ((r - l) >> 1);
        process(arr, l, mid);
        process(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int m, int r) {
        // 1.定义一个辅助数组
        int[] help = new int[r - l + 1];
        // 2.定义开始下标
        int i = 0;
        // 3.将左指针指向l(左边的开始)
        int p1 = l;
        // 4.将右指针指向r(右边的开始)
        int p2 = m + 1;
        // 5.如果左指针和右指针都没越界，那么就开始比较
        while (p1 <= m && p2 <= r) {
            // 6.哪边的数小就拷贝哪边的数，等于则拷贝左边
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 7.此时一定会有一边先越界
        // 右边越了直接拷贝左边
        while (p1 <= m) {
            help[i++] = arr[p1++];
        }

        // 左边越了直接拷贝右边
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // 8.最后拷贝回去
        for (i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        mergeSortPlus(arr);

        printArray(arr);

    }

}
