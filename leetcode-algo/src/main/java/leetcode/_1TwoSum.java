package leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 *
 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。



 示例:

 给定 nums = [2, 7, 11, 15], target = 9

 因为 nums[0] + nums[1] = 2 + 7 = 9
 所以返回 [0, 1]
 */
public class _1TwoSum {

    public static void main(String[] args) {
       int[] ints = twoSum2(new int[]{0,2,5, 5, 3, 6}, 10);



       // Map<Integer,Integer> map=new HashMap<>();
      //  map.put(1,1);
       // map.put(1,2);
      //∂  System.out.println(JSON.toJSONString(map));
    }

    public static int[] twoSum(int[] nums, int target) {

        for (int i=0;i<nums.length;i++){
          for (int j=i+1;i<nums.length;j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
          }
        }

        throw new IllegalArgumentException("无匹配的两数相加");
    }

    /***
     * 看了题解，可以使用map进行存储。和数据库查询进行匹配是一样的
     */

    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for (int i=0;i<nums.length;i++){
            int complement=target-nums[i];
          if (map.containsKey(complement)&&map.get(complement)!=i){
                return new int[]{i,map.get(complement)};
          }
        }
        throw new IllegalArgumentException("无匹配的两数相加");
    }



}
