class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do{
            slow = findsuare(slow);
            fast = findsuare(findsuare(fast));
        }while(slow != fast);

        if(slow == 1){
            return true;
        }
        return false;
    }

    private int findsuare(int number){
        int ans = 0;
        while(number >0){
            int rem = number % 10;
            ans = ans + rem * rem;
            number = number / 10;
        }
        return ans;
    }
}