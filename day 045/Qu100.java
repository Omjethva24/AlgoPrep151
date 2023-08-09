//No. of balanced parentheses sequence
//in this problem bhaiya forget to attach link
//i found article in gfg and problem in pepcoding
//it is same logic like catalan's number
//so i write code below of function

public class Qu100 {
    static int findCatalan(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] catalan = new int[n + 1];
        catalan[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        return catalan[n];
    }

    public static void main(String[] args) {
        int n = 4; 
        int result = findCatalan(n);
        System.out.println("No. of Balanced Parentheses Sequences: " + result); 
    }
}