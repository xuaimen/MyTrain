package com.usc.suanfa;

/**
 * Created by xuqiang on 2017/12/3.
 * <p>
 * 0,1,2 数组中只是包含这3个元素，进行排序
 */
public class SortColors {
    // 时间复杂度O(n)
    // 空间复杂度O(1)
    // 遍历两遍
    public static void sortColors(int[] nums) {
        int[] count = {0, 0, 0};
        for (int i = 0; i < nums.length; i++) {
            assert (nums[i] >= 0 && nums[i] <= 2);
            count[nums[i]]++;
        }

        int index = 0;

        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }

        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }

        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }

    }

    // 时间复杂度O(n)
    // 空间复杂度O(1)
    // 遍历一遍
    public static void sortColors1(int[] nums) {
        int zero = -1;
        int two = nums.length;
        for (int i = 0; i < two; i++) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums[i], nums[--two]);
            } else {
                assert (nums[i] == 0);
                swap(nums[i], nums[++zero]);
            }
        }
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

    }

    public static void swap(char[] arr ,int a ,int b){
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /*
    * 给定一个有序整型数组和一个整数target，在其中寻找两个元素，使其和为target。返回这两个数
    * 的索引
    * 例如：numbers=[2,7,11,15]，target=9，那么应该返回数字2,7的索引
    *
    * 对撞指针
    * */

    public static int[] towSum(int numbers[], int target) throws Exception {
        assert (numbers.length >= 2);
        int l = 0, r = numbers.length;
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                int res[] = {l, r};
                return res;
            } else if (numbers[l] + numbers[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        throw new Exception("The input has no solution");
    }

    /**
     * 字符串翻转
     */
    public static void reverseString(String str) {
        assert (str != null && str.length() != 0);
        char[] arr = str.toCharArray();
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            swap(arr,l++,r--);
        }

        String reverseStr = String.copyValueOf(arr);

        System.out.println(reverseStr);
    }

    public static void main(String[] args) {
        reverseString("hello");
    }

    /*
    * 给定一个整型数组和一个数字s，找到数组中最短的连续子数组，使得连续子数组的数字和sum>=s，返回这个最短的连续子数组的长度返回值。
    *
    * 如：给定数组[2,3,1,2,4,3]，s=7       答案为[4,3]，返回2
    * */

    public static int minSubArrayLen(int s, int[] nums){
        int l = 0,r = -1;
        int sum = 0;
        int res = nums.length+1;
        while (l<nums.length){
            if(r+1<nums.length && sum<s){
                sum +=nums[++r];
            }else{
                sum -=nums[l++];
            }

            if(sum > s){
                res = Math.min(res,r-l+1);
            }
        }

        if(res == nums.length+1){
            return 0;
        }

        return res;
    }
}
