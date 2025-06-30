package com.ryml.elementary;

import com.alibaba.fastjson2.JSONObject;
import org.junit.Test;

import java.util.*;

/**
 * @Description // TODO: 这里填写类的详细描述
 * @Author 刘一博
 * @Date 2025/6/30 16:13
 * @Version 1.0.0
 */
public class Calculate {

    /**
     * 简单
     * 提示
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案，并且你不能使用两次相同的元素。
     * <p>
     * 你可以按任意顺序返回答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,4], target = 6
     * 输出：[1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [3,3], target = 6
     * 输出：[0,1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 2 <= nums.length <= 104
     * -109 <= nums[i] <= 109
     * -109 <= target <= 109
     * 只会存在一个有效答案
     */
    @Test
    public void theSumOfYwoNumbers() {
        System.out.println(JSONObject.toJSONString(theSumOfYwoNumbers2(new int[]{2, 7, 11, 15}, 9)));
    }

    /**
     * 计算两数之和=target
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] theSumOfYwoNumbers(int[] nums, Integer target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * 计算两数之和=target
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] theSumOfYwoNumbers2(int[] nums, Integer target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }


    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * 解释：
     * 在 strs 中没有字符串可以通过重新排列来形成 "bat"。
     * 字符串 "nat" 和 "tan" 是字母异位词，因为它们可以重新排列以形成彼此。
     * 字符串 "ate" ，"eat" 和 "tea" 是字母异位词，因为它们可以重新排列以形成彼此。
     * 示例 2:
     * 输入: strs = [""]
     * 输出: [[""]]
     * 示例 3:
     * 输入: strs = ["a"]
     * 输出: [["a"]]
     * 提示：
     * 1 <= strs.length <= 104
     * 0 <= strs[i].length <= 100
     * strs[i] 仅包含小写字母
     */
    @Test
    public void group() {
        Collection<List<String>> group = group(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(JSONObject.toJSONString(group));
    }

    /**
     * 按字母排序后数值一直的分组
     *
     * @param strs 字符串列表
     * @return 分组后的数据
     */
    public Collection<List<String>> group(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key, list);
        }
        return map.values();
    }

    /**
     * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
     * <p>
     * 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
     * 示例 1：
     * 输入：nums = [100,4,200,1,3,2]
     * 输出：4
     * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     * 示例 2：
     * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
     * 输出：9
     * 示例 3：
     * 输入：nums = [1,0,1,2]
     * 输出：3
     * 提示：
     * 0 <= nums.length <= 105
     * -109 <= nums[i] <= 109
     */
    @Test
    public void test() {

    }


}
