package com.snow.leetcode;

/**
 * @author lurui
 * @Package com.snow.leetcode
 * @ClassName Lesson2
 * @Description Lesson2
 * @Date 2020/2/7 3:04 下午
 */
public class Lesson2 {
//    定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//
//    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
//
//    示例 1:
//
//    给定数组 nums = [1,1,2],
//
//    函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
//
//    你不需要考虑数组中超出新长度后面的元素。
//    示例 2:
//
//    给定 nums = [0,0,1,1,1,2,2,3,3,4],
//
//    函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
//
//    你不需要考虑数组中超出新长度后面的元素。

    public int removeDuplicates(int[] nums) {
        if (null == nums || nums.length == 0) {
            throw new IllegalArgumentException("入参异常");
        }
        int p = 0;
        int q = 1;
        for (; q < nums.length; q++) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println("数组第" + (i + 1) + "位：" + nums[i]);
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int nums[] = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Lesson2 lesson2 = new Lesson2();
        int result = lesson2.removeDuplicates(nums);
        System.out.println(result);
    }

}
