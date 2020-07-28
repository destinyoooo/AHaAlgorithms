package sorts;

import java.util.Arrays;

public class BubbleSort {
    /**
     * 冒泡排序
     * 循环比较相邻的两个数，将较大的数放在后面
     * @param nums 待排序数值序列
     */
    private static int[] bubbleSort(int[] nums) {
        int len = nums.length;
        if(len == 0 || len == 1) {
            return nums;
        }
        for(int i = 0; i < len; i++) {
            for(int j = 0, subLen = len - 1 - i; j < subLen; j++) {
                if(nums[j + 1] < nums[j]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int arr[] = {2, 400, 71, 6, 8, 45, 19};
        System.out.println("未排序的数组：" + Arrays.toString(arr));
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(arr);
        System.out.println("排序后的数组：" + Arrays.toString(arr));
    }

}
