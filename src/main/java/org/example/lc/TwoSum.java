package org.example.lc;

/**
 * 思路及算法
 * 最容易想到的方法是枚举数组中的每一个数 x，寻找数组中是否存在 target - x。
 * 当我们使用遍历整个数组的方式寻找 target - x 时，需要注意到每一个位于 x 之前的元素都已经和 x 匹配过，因此不需要再进行匹配。而每一个元素不能被使用两次，所以我们只需要在 x 后面的元素中寻找 target - x。
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/two-sum/solution/liang-shu-zhi-he-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];

    }

    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int[] results = twoSum(nums,9);
        for (int result:results) {
            System.out.println(result);

        }
    }

}