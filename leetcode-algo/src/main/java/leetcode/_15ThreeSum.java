package leetcode;


import com.alibaba.fastjson.JSON;

import org.apache.commons.collections.list.TreeList;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 */
public class _15ThreeSum {


    public static void main(String[] args) {

        int[] nums=new int[]{-1, 0, 1, 2, -1, -4};
      // int[] nums=new int[]{0,0,0};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(JSON.toJSONString(lists));
    }

    public static  List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        Map<String,String> checkMap=new HashMap<>();
        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                int compar=0-nums[i]-nums[j];
                //根据二个数求和得到思路
                if (map.containsKey(compar)&&(map.get(compar)!=i&&map.get(compar)!=j)&&j<map.get(compar)){
                    List<Integer> list=new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(compar);
                  //  Collections.sort(list);
                    //去重,展示是按照数据展示的
                    String checkResult = checkMap.get(list.get(0) + "_" + list.get(1) + "_" + list.get(2));
                    if (checkResult==null){
                        result.add(list);
                        checkMap.put(list.get(0) + "_" + list.get(1) + "_" + list.get(2),"1");
                    }
                }
            }
        }


        return result;
    }

    /**
     * 该方法返回的结果有重复的数据
     * @param nums
     * @return
     */
    public static  List<List<Integer>> threeSum2(int[] nums) {

        List<List<Integer>> result= new ArrayList<>();
        Map<Integer,Integer> map=new HashMap<>();
        for (int i=0;i<nums.length;i++){
                map.put(nums[i],i);
        }

        for (int i=0;i<nums.length;i++){
            for (int j=i+1;j<nums.length;j++){
                int compar=0-nums[i]-nums[j];
                if (map.containsKey(compar)&&(map.get(compar)!=i&&map.get(compar)!=j)&&j>map.get(compar)){
                    List<Integer> list=new ArrayList();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(compar);

                    result.add(list);
                }
            }
        }

        return result;
    }
}
