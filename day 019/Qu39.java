//Minimum Window Substring


class Solution {
    public String minWindow(String s, String t) {
        if(t.length() == 1){
            char ch = t.charAt(0);
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)== ch)
                return ch+"";
            }
            return "";
        }

        HashMap<Character,Integer> thm = new HashMap<>();
        HashMap<Character,Integer> subhm = new HashMap<>();
        for(char i : t.toCharArray()){
            thm.put(i, thm.getOrDefault(i,0)+1);
        }

        String ans = "";
        int l=-1,r=-1;
        int matchCount=t.length();
        int currcount = 0;

        while(true){
            boolean f1=false;
            boolean f2=false;
            while(currcount<matchCount && r<s.length()-1){
                r++;
                char ch=s.charAt(r);
                subhm.put(ch,subhm.getOrDefault(ch,0)+1);
                if(thm.containsKey(ch) && (subhm.get(ch)<=thm.get(ch))){
                    currcount++;
                }
                f1=true;
            }      

            while(l<r && currcount==matchCount){
                String subs = s.substring(l+1,r+1);
                if(ans.length()==0 || subs.length()<ans.length()){
                    ans=subs;
                }
                l++;
                char ch=s.charAt(l);
                if(subhm.get(ch)==1){
                    subhm.remove(ch);
                }else{
                    subhm.put(ch,subhm.get(ch)-1);
                }
                if(subhm.getOrDefault(ch,0) < thm.getOrDefault(ch,0)){
                        currcount--;
                }
                f2=true;
            }   
            if(f1==false && f2==false){
                break;
            }
        }
            return ans.length()==0?"":ans; 
    }
}                            
