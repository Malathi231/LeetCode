class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int count=0;
        for(int start=0;start<n;start++){
            for(int end=start;end<n;end++){
                String sub=s.substring(start,end+1);
            
            if(isPalindrome(sub)){
                count++;
            }
        }
        }
        return count;
    }

     public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}