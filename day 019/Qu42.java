//Count Substrings with equal number of 0s, 1s and 2s

class Solution 
{ 
    long getSubstringWithEqual012(String str) 
    { 
        // code here
        int ans = 0;
        
        int c0=0,c1=0,c2=0;
        HashMap<String,Integer> map = new HashMap<>();
        String key = (c1-c0) + "#" + (c2-c1);
        map.put(key,1);
        
        for(char i : str.toCharArray()){
            if(i=='0'){
                c0++;
            }else if(i=='1'){
                c1++;
            }else{
                c2++;
            }
            
            key = (c1-c0) + "#" + (c2-c1);
            
            if(map.containsKey(key)){
                ans+=map.get(key);
                map.put(key,map.get(key)+1);
            }else{
                map.put(key,1);
            }
            
        }
        return ans;
    }
} 
