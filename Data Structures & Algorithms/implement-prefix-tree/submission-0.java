class TrieNode{
    boolean isEnd;
    Map<Character,TrieNode> mp;
    TrieNode(){
        this.isEnd = false;
        mp = new HashMap<>();
    }
}
class PrefixTree {
    TrieNode root;
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char ch:word.toCharArray())
        {
            if(!curr.mp.containsKey(ch))
                curr.mp.put(ch,new TrieNode());
            curr = curr.mp.get(ch);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch:word.toCharArray())
        {
            if(!curr.mp.containsKey(ch))
                return false;
            curr = curr.mp.get(ch);
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char ch:prefix.toCharArray())
        {
            if(!curr.mp.containsKey(ch))
                return false;
            curr = curr.mp.get(ch);
        }
        return true;
    }
}
