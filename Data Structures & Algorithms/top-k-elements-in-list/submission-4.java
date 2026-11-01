class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // sort the list
        Arrays.sort(nums);
        
        HashMap<Integer, Integer> countNums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (countNums.containsKey(nums[i])) {
                int count = countNums.get(nums[i]);
                countNums.replace(nums[i], count+1);
            } else {
                countNums.put(nums[i], 1);
            }
        }

        List<Integer> counts = new ArrayList<>(countNums.values());
        Collections.sort(counts);
        counts = counts.subList(counts.size()-k, counts.size());

        int[] ret = new int[k];
        int retIndex = 0;
        for (int num : nums) {
            if (retIndex > 0 && ret[retIndex-1] == num) continue; // skip duplicates
            if (counts.contains(countNums.get(num))) {
                ret[retIndex] = num;
                retIndex++;
            }
        }

        return ret;
    }
}