package com.example.demo;

/**
 *  https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/9/25 16:50
 **/
public class 删除排序数组中的重复项 {
    public static void main(String[] args) {
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeElement(nums));
    }

    public static int removeElement(int[] nums) {
        int mun = 0;
        int val = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || val != nums[i]) {
                val = nums[i];
                nums[mun] = nums[i];
                mun++;
            }
        }
        return mun;
    }
}
