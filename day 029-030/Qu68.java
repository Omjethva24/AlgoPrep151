//implement k Queues in a single array
//not inpractise section so i copy code from artical but i 
//understan full problem from love babbar bhaiya video

public class KQueues {
 
    int k;
    int n;
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int free;
     
    KQueues(int k, int n){
         
        // Initialize n and k, and allocate memory for all arrays
        this.k = k;
        this.n = n;
        this.arr = new int[n];
        this.front = new int[k];
        this.rear = new int[k];
        this.next = new int[n];
         
        // Initialize all queues as empty
        for(int i= 0; i< k; i++) {
            front[i] = rear[i] = -1;
        }
         
        // Initialize all spaces as free
        free = 0;
        for(int i= 0; i< n-1; i++) {
            next[i] = i+1;
        }
        next[n-1] = -1;
         
         
    }
     
    // To check whether queue number 'i' is empty or not
    private boolean isEmpty(int i) {
        return front[i] == -1;
    }
     
    // To dequeue an from queue number 'i' where i is from 0 to k-1
    private boolean isFull(int i) {
        return free == -1;
    }
 
    // To enqueue an item in queue number 'j' where j is from 0 to k-1
    private void enqueue(int item, int j) {
        if(isFull(j)) {
            System.out.println("queue overflow");
            return;
        }
         
        int nextFree = next[free];
         
        if(isEmpty(j)) {
            rear[j] = front[j] = free;
        }else {
            // Update next of rear and then rear for queue number 'j'
            next[rear[j]] = free;
            rear[j] = free;
        }
        next[free] = -1;
         
        // Put the item in array
        arr[free] = item;
         
        // Update index of free slot to index of next slot in free list
        free = nextFree;
    }
     
    // To dequeue an from queue number 'i' where i is from 0 to k-1
    private int dequeue(int i) {
        // Underflow checkSAS
        if(isEmpty(i)) {
            System.out.println("Stack underflow");
            return Integer.MIN_VALUE;
        }
         
        // Find index of front item in queue number 'i'
        int frontIndex = front[i];
 
        // Change top to store next of previous top
        front[i] = next[frontIndex];
         
        // Attach the previous front to the beginning of free list
        next[frontIndex] = free;
        free = frontIndex;
         
        return arr[frontIndex];
    }
     
}
