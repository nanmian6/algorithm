package sort;

/**
 * @author nanmian
 * 插入排序：外循环从1开始，内循环往前面排好序的部分插入
 */
public class InsertSort {
	

	public static void sort(int[] arr) {

		if (arr == null || arr.length < 2) {
			return;
		}
		
		int n = arr.length;
		for (int pre = 1; pre < n; pre++) {
			for (int next = pre; next - 1 >= 0 ; next--) {
				if (arr[next] < arr[next - 1]) {
					swap(arr, next, next - 1);
				} else {
					break;
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
