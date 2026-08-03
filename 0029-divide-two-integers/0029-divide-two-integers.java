class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor== -1 ){
            return Integer.MAX_VALUE;
        }
        boolean isnegative = dividend < 0 ^ divisor < 0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int quotient = 0;
        while(dividend - divisor >= 0){
            int currdivisor = divisor;
            int currquotient = 1;
            while(dividend - (currdivisor << 1) >= 0){
                currdivisor = currdivisor<< 1;
                currquotient = currquotient<< 1;
            }
            quotient += currquotient;
            dividend -= currdivisor;
        }
        return isnegative? -quotient : quotient;
    }
}