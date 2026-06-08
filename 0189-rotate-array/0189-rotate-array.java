class Solution {
    public void rotate(int[] nums, int k) {
        int n=nums.length;
        k=k%n;
        //reversein range concept;
        reverseArray(nums,0,n-1);//reverse entire array
        reverseArray(nums,0,k-1);//reverse the first half
        reverseArray(nums,k,n-1);//reverse the second half;
        System.out.println(nums) ;  
         }
    static void reverseArray(int[] nums,int s, int e){
        int temp=0;
        while(s<e){
            temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
}