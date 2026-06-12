/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int peak = peakIndex(mountainArr);

        // Search in ascending part
        int ans = binarySearchAsc(target, mountainArr, 0, peak);
        if (ans != -1) {
            return ans;
        }

        // Search in descending part
        return binarySearchDesc(target, mountainArr, peak + 1, n - 1);
    }

    private int peakIndex(MountainArray mountainArr) {
        int s = 0;
        int e = mountainArr.length() - 1;

        while (s < e) {
            int m = s + (e - s) / 2;

            if (mountainArr.get(m) < mountainArr.get(m + 1)) {
                s = m + 1;
            } else {
                e = m;
            }
        }

        return s;
    }

    private int binarySearchAsc(int target, MountainArray mountainArr, int s, int e) {
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (mountainArr.get(m) == target) {
                return m;
            } else if (mountainArr.get(m) < target) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return -1;
    }

    private int binarySearchDesc(int target, MountainArray mountainArr, int s, int e) {
        while (s <= e) {
            int m = s + (e - s) / 2;

            if (mountainArr.get(m) == target) {
                return m;
            } else if (mountainArr.get(m) < target) {
                e = m - 1; // reversed because descending order
            } else {
                s = m + 1;
            }
        }

        return -1;
    }
}