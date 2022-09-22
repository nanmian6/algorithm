package sort;

/**
 * @author nanmian
 * 冒泡排序：每次都从头到尾选出最大的一个数
 */
public class BubbleSort {
	
	public static void sort(int[] arr) {
		
		if (arr == null || arr.length < 2) {
			return;
		}
		
		int n = arr.length;
		for (int pre = 0; pre < n -1; pre++) {
			for (int next = 0; next < n - pre - 1; next++) {
				if (arr[next] > arr[next + 1]) {
					swap(arr, next, next + 1);
				}
			}
		}
		
	}
	
	public static void swap(int[] arr, int pre, int next) {
		
		if (pre == next) {
            return;
        }
		
		int temp = arr[pre];
		arr[pre] = arr[next];
		arr[next] = temp;
	}
	
	
	
	public static void print(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = new int[]{9,8,7,6,5,4,3,2,1};
		
		print(arr);
		sort(arr);
		print(arr);
		
	}
	
}
