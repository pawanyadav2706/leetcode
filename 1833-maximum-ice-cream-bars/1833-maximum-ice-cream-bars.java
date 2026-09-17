class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for(int i = 0; i<costs.length; i++){
            max = Math.max(max,costs[i]);
        }
        int [] count = new int [max + 1];
        for(int i =0; i<costs.length; i++){
            count[costs[i]]++;
        }
        int total = 0;
        for(int price = 1; price<= max; price++){
            while(count[price] > 0 && coins>= price){
                coins = coins - price;
                total++;
                count[price]--;
            }
            if(coins < price){
                break;
            }
        }
        return total;
    }
}