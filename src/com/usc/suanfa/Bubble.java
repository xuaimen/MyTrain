package com.usc.suanfa;

/**
 * Created by xuqiang on 2017/12/11.
 * <p>
 * 冒泡排序：就是把数组中比较大的数不断的冒在前面。
 */
public class Bubble {
    public void bubble_sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    swap(arr, i, j);
                }
            }
        }
        snp(arr);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void snp(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(arrays[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Bubble b = new Bubble();
        int[] a = {4, 5, 1, 7, 9, 6};
        b.bubble_sort(a);
    }
}
