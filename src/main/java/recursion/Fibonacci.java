package recursion;

public class Fibonacci {

    public static void main(String[] args) {
        int nthFact = getNthFactorial(10, new int[10]);
        System.out.println("Nth Factorial: " + nthFact);
    }

    private static int getNthFactorial(int num, int[] memoization) {
        if(num <= 1){
            return num;
        }
        if(memoization[num-1] != 0){
            return memoization[num-1];
        }
        memoization[num-1] = getNthFactorial(num-1, memoization) + getNthFactorial(num-2, memoization);
        return memoization[num-1];
    }
}
