class Solution {
    void getSumCombo(int idx,int sum,int t,int nums[],Set<List<Integer>> st,List<Integer> lst)
    {
        if(sum == t)
        {
            st.add(new ArrayList<>(lst));
            return;
        }
        if(sum > t)
            return;
        if(idx>=nums.length)
            return;
        sum += nums[idx];
        lst.add(nums[idx]);
        getSumCombo(idx,sum,t,nums,st,lst);
        sum -= nums[idx];
        lst.remove(lst.size()-1);
        getSumCombo(idx+1,sum,t,nums,st,lst);

    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        Set<List<Integer>> st = new HashSet<>();
        List<Integer> lst = new ArrayList<>();
        getSumCombo(0,0,target,nums,st,lst);
        return new ArrayList<>(st);
    }
}
