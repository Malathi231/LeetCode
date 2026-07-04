class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {

        HashMap<String, Integer> map = new HashMap<>();

        // Store list1 with indices
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        ArrayList<String> result = new ArrayList<>();
        int minSum = Integer.MAX_VALUE;

        // Traverse list2
        for (int i = 0; i < list2.length; i++) {

            if (map.containsKey(list2[i])) {

                int sum = i + map.get(list2[i]);

                if (sum < minSum) {
                    minSum = sum;
                    result.clear();
                    result.add(list2[i]);
                }
                else if (sum == minSum) {
                    result.add(list2[i]);
                }
            }
        }

        return result.toArray(new String[0]);
    }
}