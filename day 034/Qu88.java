//Implement Trie (Prefix Tree)


class Trie {
class Node{
    Node[] children = new Node[26];
    int freq;
    boolean eow;
    Node(){
        freq=0;
        eow=false;
        Arrays.fill(children, null);
    }
}

    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node curr = root;

        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            curr=curr.children[idx];
        }
        curr.eow = true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        
        for(int level=0; level<word.length(); level++){
            int idx = word.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return curr.eow==true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        
        for(int level=0; level<prefix.length(); level++){
            int idx = prefix.charAt(level)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
}