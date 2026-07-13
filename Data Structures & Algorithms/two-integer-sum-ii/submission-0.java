class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<numbers.length;i++)
        {
            int num = numbers[i];
            if(mp.containsKey(target-num))
            {
                return new int[]{mp.get(target-num),i+1};
            }
            mp.put(num,i+1);
        }
        return new int[]{-1,-1};
    }
}
