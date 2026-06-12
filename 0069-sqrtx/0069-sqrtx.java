class Solution {
    public int mySqrt(int x) {
        int s = 0, e = x, ans = 0;

        while (s <= e) {
            int mid = s + (e - s) / 2;

            if ((long)mid * mid == x) {
                return mid;
            }
            else if ((long)mid * mid < x) {
                ans = mid;
                s = mid + 1;
            }
            else {
                e = mid - 1;
            }
        }

        return ans;
    }
}