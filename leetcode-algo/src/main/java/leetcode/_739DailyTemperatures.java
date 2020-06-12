package leetcode;

/**
 * 每日温度
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 找到比当前值最大的后一位数
 */
public class _739DailyTemperatures {


    public static void main(String[] args) {
        int[] temperatures=new int[]{73,74,75,71,69,72,76,73};
        //int[] temperatures=new int[]{73,74};
        int[] ints = dailyTemperatures(temperatures);
        for (int i=0;i<ints.length;i++){
            System.out.println(ints[i]);
        }
    }

    public static int[] dailyTemperatures(int[] temperatures){
        int[] result=new int[temperatures.length];
        result[temperatures.length-1]=0;
        //  由于最后一天的结果肯定是0
        for (int i=temperatures.length-2; i>=0;i--){//获取的是需要比较的数
           for (int j=i+1;j<temperatures.length;j++) {
                if (temperatures[i]<temperatures[j]){
                    result[i]=j-i;
                    break;
                }else{
                    result[i]=0;
                }
           }
        }
        return result;
    }



}
