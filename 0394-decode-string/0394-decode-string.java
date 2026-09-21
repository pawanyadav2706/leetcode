class Solution {
    public String decodeString(String s) {
        Stack<Integer> numberstack = new Stack<>();
        Stack<String> mainstack = new Stack<>();

        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch >= '0' && ch<='9'){
                int num = 0;
                while(i<s.length() && s.charAt(i) >='0' && s.charAt(i) <='9'){
                    num = num * 10 + (int)(s.charAt(i)-'0');
                    i++;
                }
                i--;
                numberstack.push(num);
            }else if(ch != ']'){
                mainstack.push(ch + "");
            }else{
                String str = "";
                while(!mainstack.peek().equals("[")){
                    str = mainstack.pop() + str;
                }
                mainstack.pop();
                int repeatationNum = numberstack.pop();

                StringBuilder sb = new StringBuilder("");

                while(repeatationNum > 0){
                    sb.append(str);
                    repeatationNum--;
                }
                mainstack.push(sb.toString());
            }
        }
        StringBuilder ans = new StringBuilder("");
        while(mainstack.size() > 0){
            ans.insert(0, mainstack.pop());
        }
        return ans.toString();
    }
}