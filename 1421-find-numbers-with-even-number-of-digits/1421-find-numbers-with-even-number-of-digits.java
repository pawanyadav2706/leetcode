class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (even(num)) {  
                count++;
            }
        }
        return count;
    }

    // check karta hai ki number ke digits even hain ya nahi
    private boolean even(int num) {
        int numberOfDigits = digits(num);  
        return numberOfDigits % 2 == 0;
    }

    // optimized digit count using log10
    private int digits(int num) {
        if (num < 0) {
            num = num * -1;   
        }
        if (num == 0) {
            return 1;        // special case: log10(0) undefined hota hai
        }
        return (int)(Math.log10(num)) + 1;
    }
}
