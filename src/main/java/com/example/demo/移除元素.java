package com.example.demo;

/**
 *  https://leetcode-cn.com/problems/remove-element/
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2019/9/25 16:50
 **/
public class 移除元素 {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        System.out.println(removeElement(nums, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int mun = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[mun]=nums[i];
                mun++;
            }
        }
        return mun;
    }
}
