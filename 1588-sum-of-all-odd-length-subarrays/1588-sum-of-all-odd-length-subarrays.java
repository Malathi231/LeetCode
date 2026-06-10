class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n=arr.length;
        int s=0,e=0;
        int contribution=0, occ=0,totalSum=0;
        for(int i=0;i<n;i++){
            occ=(((i+1)*(n-i))+1)/2;
            contribution=(occ)*arr[i];
            totalSum+=contribution;
        }
        return totalSum;
    }
}