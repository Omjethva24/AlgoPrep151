//k stacks in a single array

public class GFG
{
    // A Java class to represent k stacks in a single array of size n
    static class KStack
    {
        int arr[];   // Array of size n to store actual content to be stored in stacks
        int top[];   // Array of size k to store indexes of top elements of stacks
        int next[];  // Array of size n to store next entry in all stacks
                     // and free list
        int n, k;
        int free; // To store beginning index of free list
 
        //constructor to create k stacks in an array of size n
        KStack(int k1, int n1)
        {
            // Initialize n and k, and allocate memory for all arrays
            k = k1;
            n = n1;
            arr = new int[n];
            top = new int[k];
            next = new int[n];
 
            // Initialize all stacks as empty
            for (int i = 0; i < k; i++)
                top[i] = -1;
 
            // Initialize all spaces as free
            free = 0;
            for (int i = 0; i < n - 1; i++)
                next[i] = i + 1;
            next[n - 1] = -1; // -1 is used to indicate end of free list
        }
 
        // A utility function to check if there is space available
        boolean isFull()
        {
            return (free == -1);
        }
 
        // To push an item in stack number 'sn' where sn is from 0 to k-1
        void push(int item, int sn)
        {
            // Overflow check
            if (isFull())
            {
                System.out.println("Stack Overflow");
                return;
            }
 
            int i = free; // Store index of first free slot
 
            // Update index of free slot to index of next slot in free list
            free = next[i];
 
            // Update next of top and then top for stack number 'sn'
            next[i] = top[sn];
            top[sn] = i;
 
            // Put the item in array
            arr[i] = item;
        }
 
        // To pop an element from stack number 'sn' where sn is from 0 to k-1
        int pop(int sn)
        {
            // Underflow check
            if (isEmpty(sn))
            {
                System.out.println("Stack Underflow");
                return Integer.MAX_VALUE;
            }
 
            // Find index of top item in stack number 'sn'
            int i = top[sn];
 
            top[sn] = next[i]; // Change top to store next of previous top
 
            // Attach the previous top to the beginning of free list
            next[i] = free;
            free = i;
 
            // Return the previous top item
            return arr[i];
        }
 
        // To check whether stack number 'sn' is empty or not
        boolean isEmpty(int sn)
        {
            return (top[sn] == -1);
        }
 
    }
}