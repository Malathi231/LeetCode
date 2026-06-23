// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         for(int i=0;i<n;i++){
//             nums1[i+m]=nums2[i];
//         }
//         Arrays.sort(nums1);
//     }
// }


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p1 = 0, p2 = 0, k = 0;
        int[] ans = new int[m + n];

        while (p1 < m && p2 < n) {
            if (nums1[p1] <= nums2[p2]) {
                ans[k++] = nums1[p1++];
            } else {
                ans[k++] = nums2[p2++];
            }
        }

        while (p1 < m) {
            ans[k++] = nums1[p1++];
        }

        while (p2 < n) {
            ans[k++] = nums2[p2++];
        }

        for (int i = 0; i < m + n; i++) {
            nums1[i] = ans[i];
        }
    }
}