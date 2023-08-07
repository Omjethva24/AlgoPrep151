//Fractional knapsack

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int w, Item arr[], int n) 
    {
        // Your code here
        double ratio[][] = new double[arr.length][3];
        for(int i=0; i < n; i++){
            ratio[i][0] = arr[i].weight;
            ratio[i][1] = arr[i].value;
            ratio[i][2] = ratio[i][1]/(double)ratio[i][0];
        }
        
        double ans =0; 
        
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[2]));
        
        for(int i=ratio.length-1; i >= 0; i--){
            if(ratio[i][0] <= w){
                ans+= ratio[i][1];
                w-=ratio[i][0];
            }else{
                ans+= ratio[i][2] * w;
                w=0;
                break;
            }
        }
        return ans;
        
    }
}