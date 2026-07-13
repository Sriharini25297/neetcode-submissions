class Pair{
    String ans;
    int time;
    Pair(String s,int t)
    {
        this.ans = s;
        this.time = t;
    }
}
class TimeMap {
    Map<String,List<Pair>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!mp.containsKey(key))
        {
            mp.put(key,new ArrayList<>());
        }
        mp.get(key).add(new Pair(value,timestamp));
    }
    String bs(List<Pair> lst,int t)
    {
        int low = 0;
        int high = lst.size()-1;
        StringBuilder sb = new StringBuilder();
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if(lst.get(mid).time == t)
                return lst.get(mid).ans;
            else if(lst.get(mid).time < t)
            {
                sb.setLength(0);
                sb.append(lst.get(mid).ans);
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return sb.length() == 0 ?"":sb.toString();
    }
    public String get(String key, int timestamp) {
        if(!mp.containsKey(key))
            return "";
        return bs(mp.get(key),timestamp);

    }
}
