package org.jason.lc.easy;

/**
 * @description: https://leetcode-cn.com/problems/hamming-distance/
 * 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
 * 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。
 * @author: Administrator
 * @date: 2022/3/8 14:58
 */
public class LC461 {

    public static void main(String[] args) {
        LC461 lc = new LC461();
        System.out.println(lc.hammingDistance(1, 4));
    }

    /**
     * @description: 方法一： 位运算，击败100%
     * @date: 2022/3/8 15:06
     */
    public int hammingDistance(int x, int y) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((x >> i & 1) != (y >> i & 1)) {
                result++;
            }
        }
        return result;
    }


}
