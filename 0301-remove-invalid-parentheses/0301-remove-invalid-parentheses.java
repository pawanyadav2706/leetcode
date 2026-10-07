class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        int left = 0;
        int right = 0;

        for(char ch: s.toCharArray()){
            if(ch == '('){
                left++;
            }else if(ch == ')'){
                if(left > 0){
                    left--;
                }else {
                    right++;
                }
            }
        }
        backtrack(s, 0, left, right, result);
        return result;
        }
        private void backtrack(String s, int index, int leftremove, int rightremove, List<String> result){
            if(leftremove == 0 && rightremove == 0){
                if(isValid(s)){
                    result.add(s);
                }
                return;
            }
            for(int i = index; i<s.length(); i++){
                if(i > index && s.charAt(i) == s.charAt(i - 1)){
                    continue;
                }
                char ch = s.charAt(i);
                // remove an extra '('
                if(ch == '(' && leftremove > 0){
                    String next = s.substring(0, i) + s.substring(i + 1);
                    backtrack(next, i, leftremove - 1, rightremove, result);
                }
                // remove an extra ')'
                if(ch == ')' && rightremove > 0){
                    String next = s.substring(0, i) + s.substring( i + 1);
                    backtrack(next, i, leftremove, rightremove - 1, result);
                }
            }
        }
        private boolean  isValid(String s){
            int balance = 0;
            for(char ch: s.toCharArray()){
                if(ch == '('){
                    balance++;
                } else if(ch == ')'){
                    balance--;
                    if(balance < 0){
                        return false;
                    }
                }
            }
            return balance == 0;
        }
    }