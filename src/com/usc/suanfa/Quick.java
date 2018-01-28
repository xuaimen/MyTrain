package com.usc.suanfa;

/**
 * Created by xuqiang on 2017/12/11.
 *
 * 快速排序
 */
public class Quick {
    public static void main(String[] args) {
        Quick q = new Quick();
        int[] a = {49, 38, 65, 12, 45, 5};
        q._quick_sort(a, 0, 5);
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void _quick_sort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int i = start;
        int j = end;
        int value = arr[i];
        boolean flag = true;

        while (i != j) {
            if (flag) {
                if (value > arr[j]) {
                    swap(arr, i, j);
                    flag = false;
                } else {
                    j--;
                }
            } else {
                if (value < arr[i]) {
                    swap(arr, i, j);
                    flag = true;
                } else {
                    i++;
                }
            }
        }
        snp(arr);
        _quick_sort(arr, start, j - 1);
        _quick_sort(arr, i + 1, end);
    }

    public void snp(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println();
    }
}
