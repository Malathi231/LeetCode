class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int ans=Integer.MIN_VALUE;
        int s=0,e=n-1;
        while(s<e){
            int area=Math.min(height[s],height[e])*(e-s);
            ans=Math.max(ans,area);
            if(height[s]<height[e]){
                s++;
            }
            else{
                e--;
            }
        }
        return ans;
    }
}