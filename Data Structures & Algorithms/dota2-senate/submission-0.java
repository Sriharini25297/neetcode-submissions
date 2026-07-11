class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        int n = senate.length();
        for(int i=0;i<senate.length();i++)
        {
            char ch = senate.charAt(i);
            if(ch == 'R')
                r.offer(i);
            else
                d.offer(i);
        }
        while(!r.isEmpty() && !d.isEmpty())
        {
            int radiant = r.peek();
            int dire = d.peek();
            if(radiant < dire)
            {
                d.poll();
                int idx = r.poll();
                r.offer(idx+n);
            }else{
                r.poll();
                int idx = d.poll();
                d.offer(idx+n);
            }
        }
        return r.isEmpty()?"Dire":"Radiant";
    }
}