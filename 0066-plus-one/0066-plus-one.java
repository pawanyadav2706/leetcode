class Solution {
    public int[] plusOne(int[] digits) {
        	int n= digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;  // agar 9 se chhota hai to +1 karo
                return digits; // aur return kar do
            }
            digits[i] = 0; // agar 9 hai to usko 0 bana do aur carry aage le jao
        }

        // agar sab 9 the to naya array banana padega
        int[] newNumber = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
    }
