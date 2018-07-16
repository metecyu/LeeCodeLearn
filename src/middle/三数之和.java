package middle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
class Solution {
    /*
     * 
     * 未能过审批 - 超出时间限制
     * */
	public List<List<Integer>> threeSum_me(int[] nums) {
    	List<List<Integer>> outList = new ArrayList<List<Integer>>() ;   
    	ArrayList<Integer> yu_chu_li = new ArrayList<Integer>();
    
        for(int i=0;i<nums.length;++i)
            yu_chu_li.add(nums[i]);
        Collections.sort(yu_chu_li);
        for(int i=0;i<nums.length;++i)
            nums[i]=yu_chu_li.get(i);
        TreeMap<String,Boolean> map = new TreeMap<String,Boolean>();
        for (int i = 0; i < nums.length; i++) {
        	for (int j = i+1; j < nums.length; j++) {
    			for (int k = j+1; k < nums.length; k++) {        			
        			if(nums[i]+nums[j]+nums[k]==0){
        				String key = ""+nums[i]+"_"+nums[j]+"_"+nums[k];
                        if(map.get(key)==null){
	        				ArrayList<Integer> wow = new ArrayList<Integer>();
	                        wow.add(nums[i]);
	                        wow.add(nums[j]);
	                        wow.add(nums[k]);
	                        outList.add(wow);
	                        map.put(key,Boolean.valueOf(true));
	                        System.out.println(nums[i]+","+nums[j]+","+nums[k]);
	                        break;// 后续业不需要做了
        				}
        			}        			
        		}
    			if(nums[i]+nums[j]>0){
    				break;
    			}    			
    		}
        	if(nums[i]>0){
				break;
			}
		}
        return outList;
    }
    
    /**
     * 网上找的答案
     * 原理：
     * 1 先对数字从小到大排序
     * 2 使用两个循环匹配三数和为0的组合
     * 3 三数如果小于0，mid加1，
     * 4 三数如果大于0，max减1，
     * 5 三数等于0，记录这个组合，mid 和 max相应变动（因为如果只单独移动mid ，max 那就肯定不等于0 ）
     * 高明之处：首位相加 等于0的概率高很多
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> yu_chu_li = new ArrayList<Integer>();
        Map<String,Boolean> map = new HashMap<String,Boolean>();
        for(int i=0;i<nums.length;++i)
            yu_chu_li.add(nums[i]);
        Collections.sort(yu_chu_li);
        for(int i=0;i<nums.length;++i)
            nums[i]=yu_chu_li.get(i);
        for(int min=0;min<nums.length;++min)
        {
            int mid=min+1;
            int max=nums.length-1;
            while(mid<max)
            {
                if(nums[mid]+nums[max]==-nums[min])
                {
                    ArrayList<Integer> wow = new ArrayList<Integer>();
                    wow.add(nums[min]);
                    wow.add(nums[mid]);
                    wow.add(nums[max]);
                    String key = ""+nums[min]+"_"+nums[mid]+"_"+nums[max];
                    if(map.get(key)==null)
                    {
                        result.add(wow);
                        map.put(key,Boolean.valueOf(true));
                        System.out.println(key);
                    }
                    ++mid;
                    --max;
                }
                else if(nums[mid]+nums[max]<-nums[min])
                    ++mid;
                else
                    --max;
            }
        }
        return result;
    }
}
public class 三数之和 {
	
	public static void main(String args[]){
		/*int[] prices ={7,1,5,3,6,4}; 
		int ret = new Solution().threeSum(prices);
		System.out.println("结果:"+ret);
		
		int[] prices2 ={1,2,3,4,5}; 
		ret = new Solution().threeSum(prices2);
		System.out.println("结果:"+ret);
		
		int[] prices3 ={7,6,4,3,1}; 
		ret = new Solution().threeSum(prices3);
		System.out.println("结果:"+ret);
		*/
		int[] prices ={-1, 0, 1, 2, -1, -4}; 
		List<List<Integer>> outList =  new Solution().threeSum_me(prices);
		System.out.println(outList);
	}
}
