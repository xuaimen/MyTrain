package com.usc.suanfa;

/**
 * Created by xuqiang on 2017/11/18.
 * <p>
 * 二分查找法--前提必须是有序的数据，有序是前提
 * <p>
 * 复杂度O(logn)
 */
public class BinarySearch {
    public int binarySearch(int arr[], int n, int target) {
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 复杂度 O(T*depth)
     * @param arr
     * @param l
     * @param r
     * @param target
     * @return
     */
    public int binarySearch(int arr[], int l, int r, int target) {
        if (l > r) {
            return -1;
        }

        int mid = l + (r - l) / 2;
        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] > target) {
            return binarySearch(arr, l, mid - 1, target);
        } else {
            return binarySearch(arr, mid + 1, r, target);
        }
    }
}
