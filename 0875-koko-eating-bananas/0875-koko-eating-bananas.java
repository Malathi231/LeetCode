class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int max = 0;

        for (int i = 0; i < piles.length; i++) {
            if (piles[i] > max) {
                max = piles[i];
            }
        }

        int s = 1;
        int e = max;

        while (s < e) {

            int mid = s + (e - s) / 2;

            if (isPossible(piles, mid, h)) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }

        return s;
    }

    boolean isPossible(int[] piles, int speed, int h) {

        long hours = 0;

        for (int i = 0; i < piles.length; i++) {

            // ceil(piles[i] / speed)
            hours += (piles[i] + speed - 1) / speed;

            if (hours > h) {
                return false;
            }
        }

        return true;
    }
}