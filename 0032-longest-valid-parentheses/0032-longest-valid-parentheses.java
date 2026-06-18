// class Solution {
//     public int longestValidParentheses(String s) {
//         Stack <Character> st=new Stack();
//         int c=0,ans=0;
//         int max=Integer.MIN_VALUE;
//        for(int i=0;i<s.length();i++){
//         char ch=s.charAt(i);
//         if(ch=='[' || ch=='(' ||ch=='{')
//         {
//             st.push(ch);
//         }
//         else{
//             if(st.size()==0)
//                 c=0;

//             else if(ch==')' && st.peek()=='('){
//                 st.pop();
//                 c+=2;
//                 ans=Math.max(ans,c);
//             }else 
//                 return 0;;
//         }
        
//                }
//                return ans;
//     }
// }


import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1); // base index

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            } else {
                st.pop();

                if (st.isEmpty()) {
                    st.push(i);
                } else {
                    ans = Math.max(ans, i - st.peek());
                }
            }
        }

        return ans;
    }
}