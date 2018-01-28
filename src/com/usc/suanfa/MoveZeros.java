package com.usc.suanfa;

import com.google.common.primitives.Ints;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuqiang on 2017/11/26.
 * <p>
 * 问题描述：给定一个数组nums，写一个函数，将数组中所有的0挪到数组的末尾，而维持其他所有非
 * 0元素的相对位置，举例如下：
 * nums = [0,1,0,3,12]，函数运行后结果为[1,3,12,0,0]
 */
public class MoveZeros {

    public static void main(String[] args) {

        int[] nums = {0, 1, 0, 3, 12};

        moveZeroes1(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static void moveZeroes(int[] nums) {

        List<Integer> nonZeroElementList = new ArrayList<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nonZeroElementList.add(nums[i]);
            }
        }

        System.out.println(nonZeroElementList.toString());

        //Guava 的方法
        int[] nonZeroElements = Ints.toArray(nonZeroElementList);

        for (int i = 0; i < nonZeroElements.length; i++) {
            nums[i] = nonZeroElements[i];
        }

        for (int i = nonZeroElements.length; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void moveZeroes1(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                nums[k++] = nums[i];
            }
        }

        for (int i = k; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
