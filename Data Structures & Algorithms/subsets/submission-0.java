class Solution {
    void generateSubsets(int idx,int nums[],List<Integer> ans,Set<List<Integer>> lst)
    {
        if(idx == nums.length)
        {
            lst.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[idx]);
        generateSubsets(idx+1,nums,ans,lst);
        ans.remove(ans.size()-1);
        generateSubsets(idx+1,nums,ans,lst);
    }
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> lst = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        generateSubsets(0,nums,ans,lst);
        return new ArrayList<>(lst);
    }
}
