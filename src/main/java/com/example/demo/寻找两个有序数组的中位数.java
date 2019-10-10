package com.example.demo;

import lombok.val;

/**
 *  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/9/25 16:50
 **/
public class 寻找两个有序数组的中位数 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3,4};
        new 寻找两个有序数组的中位数().findMedianSortedArrays(nums1 , nums2);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = new int[nums1.length + nums2.length];
        int[] vallen = new int[]{0 , 0 , nums3.length};
        for (int i = 0; i < nums3.length; i++) {
            add(nums1 , nums2 , nums3 , i , vallen);
            System.out.println(nums3[i]);
        }

        return 1;
    }

    public void add(int[] nums1, int[] nums2 , int[] nums3 , int i , int[] vallen) {
        int val , val1 , val2;
        val1 = (nums1.length <= i) ? 0 : nums1[vallen[0]];
        val2 = (nums2.length <= i) ? 0 : nums2[vallen[1]];
        if (val1 > val2) {
            val = val2;
            vallen[1] = vallen[1]++;
        }else{
            val = val1;
            vallen[0] = vallen[0]++;
        }
        nums3[i] = val;
    }
}
