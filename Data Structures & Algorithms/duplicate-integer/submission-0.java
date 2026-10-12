class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> dup = new HashSet<>();
        for (int num : nums) {
            if (dup.contains(num)) {
                return true;
            } 
            dup.add(num);
        }
        return false;
    }
}