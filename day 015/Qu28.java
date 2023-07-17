// Divide Two Integers


class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0){
            return 0;
        }
        if(dividend == 0){
            return 0;
        }

        boolean isNagetive = (dividend<0) ^ (divisor<0);
        long absDividend = Math.abs((long)dividend);
        long absDivisor = Math.abs((long)divisor);
        long quetiont = 0;

        while(absDividend >= absDivisor){
            long temp=absDivisor;
            long multiple = 1;

            while(absDividend >= (temp<<1)){
                temp<<=1;
                multiple<<=1;
            }

            absDividend-=temp;
            quetiont+=multiple;
        }

        if(isNagetive){
           quetiont = -quetiont;
        }

        if (quetiont >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        
        if (quetiont <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int)quetiont;
    }
}
