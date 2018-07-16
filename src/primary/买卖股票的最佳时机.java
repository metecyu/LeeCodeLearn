package primary;
class Solution {
	
	public int maxProfit(int[] prices) {
        // write your code here
        if(0==prices.length||null==prices) return 0;
         int minPrice  = prices[0];
         int sumProfit = 0;
         for(int i=1;i<prices.length;i++){
              if(minPrice<prices[i]){
                   sumProfit += prices[i] - minPrice;
                   minPrice = prices[i];
              }else{
                   minPrice = prices[i];
              }
         }
         return sumProfit;
	}
	
	/**
	 * 买的规则: 如果之后的数组中有更贵的就买
	 * 卖的规则: 如果之后有更便宜的就卖（不考虑最后元素只能买）
	 * @param prices
	 * @return
	 */
	/*public int maxProfit(int[] prices) {
		int buyType =0;//1:已买 ; 0:未卖
		int stock = 0;
		int profit = 0;
		int index=1;
		for (int i = 0; i < prices.length; i++) {
			for (int j = index; j < prices.length; j++) {
				if(buyType==0){// 当前没股票
					// 买的条件
					if(prices[i]<prices[j] ){
						stock = prices[i];
						buyType = 1;
						index = i;
						break;
					}
				}else{//当前有股票
					if(stock<prices[j] ){
						buyType = 0;
						profit = prices[j]- stock + profit;
						break;
					}
				}
			}
		}
        return profit;
    }*/
	
}
public class 买卖股票的最佳时机 {
	
	public static void main(String args[]){
		int[] prices ={7,1,5,3,6,4}; 
		int ret = new Solution().maxProfit(prices);
		System.out.println("结果:"+ret);
		
		int[] prices2 ={1,2,3,4,5}; 
		ret = new Solution().maxProfit(prices2);
		System.out.println("结果:"+ret);
		
		int[] prices3 ={7,6,4,3,1}; 
		ret = new Solution().maxProfit(prices3);
		System.out.println("结果:"+ret);
		
	}
}
