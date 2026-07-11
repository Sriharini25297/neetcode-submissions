class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0)
            return false;
        Map<Integer,Integer> mp = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for(int num:hand)
        {
            min = Math.min(num,min);
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        int count = 0;
        Arrays.sort(hand);
        for(int i=0;i<hand.length;i++)
        {
            int start = hand[i];
            int group = 0;
            if(!mp.containsKey(start))
                continue;
            while(mp.containsKey(start)){
                group++;
                int freq = mp.get(start)-1;
                if(freq == 0)
                    mp.remove(start);
                else
                    mp.put(start,freq);
                if(group == groupSize){
                    count++;
                    break;
                }
                start++;
            } 
            if(group != groupSize)
                return false;
        }
        return count == hand.length/groupSize;
    }
}
