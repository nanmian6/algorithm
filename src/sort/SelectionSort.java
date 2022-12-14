package sort;

/**
 * @author nanmian
 * 选择排序：外层循环从0开始，内层循环从1开始，每次都找出最小的一个值进行交换
 */
public class SelectionSort {

	public static void sort(int[] arr) {
		
		if (arr == null || arr.length < 2) {
			return;
		}
		
		int n = arr.length;
		for (int pre = 0; pre < n - 1; pre++) {
			int min = pre;
			for (int next = pre + 1; next < n; next++) {
				if (arr[next] < arr[min]) {
					min = next;
				}
			}
			
			swap(arr, pre, min);
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
