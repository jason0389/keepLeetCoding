package org.jason.lc.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/
 * @author: Jason0389
 * @date: 2022/3/8 11:25
 */
public class LC448 {

    /**
     * 给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * <p>
     * example: 输入：nums = [4,3,2,7,8,2,3,1]  输出：[5,6]
     *
     * @param nums
     * @return 此方法比较笨
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(nums);
        int index = 0;
        for (int i = 1; i <= nums.length; ) {
            if (index < nums.length && i == nums[index]) {
                i++;
            } else if (index < nums.length && i > nums[index]) {
                index++;
            } else {
                result.add(i++);
            }
            while (index < nums.length - 1) {
                if (nums[index + 1] == nums[index]) {
                    index++;
                    if (index == nums.length) {
                        index++;
                    }
                } else {
                    break;
                }
            }
        }

        return result;
    }


    /**
     * 此方法为官方题解法实现
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            nums[(nums[i]-1) % nums.length] += nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=nums.length){
                result.add(i+1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LC448 s = new LC448();
//        List<Integer> result = s.findDisappearedNumbers(new int[]{1,3,4,4});
//        List<Integer> result = s.findDisappearedNumbers(new int[]{1,1,1});
//        List<Integer> result = s.findDisappearedNumbers(new int[]{3, 3, 3});
        List<Integer> result = s.findDisappearedNumbers(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3});
        for (Integer i : result
        ) {
            System.out.println(i);

        }
    }
}
