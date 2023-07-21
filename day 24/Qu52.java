public class Solution {
    public boolean findStudents(ArrayList<Integer> A, int mid, int B) {
        int stu = 1;
        int pages = 0;
        for(int i=0; i<A.size(); i++){
            if (A.get(i) > mid) {
                return false; // Not possible to allocate all students with maxPages
            }
            if(pages+A.get(i)>mid){
                stu+=1;
                pages=A.get(i);
            }else{
                pages+=A.get(i);
            }
        }
        return stu<=B;
    }
    public int books(ArrayList<Integer> A, int B) {
        if (A.size() < B) {
            return -1; // Not enough books to allocate to all students
        }
        int low = Integer.MIN_VALUE;
        int high = 0;
        int res=-1;
        for(int i=0; i<A.size(); i++){
            high+=A.get(i);
            low = Math.max(low, A.get(i));
        }
        
        while(low<=high){
            int mid = (low + high) / 2;
            
            if(findStudents(A, mid, B)){
                res=mid;
                 high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return res;
    }
}

