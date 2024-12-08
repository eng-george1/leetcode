package a_Basics;

public class Fibonacci {

    int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    int fibonacci1(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n <= 2)
            return 1;
        int first = 1, second = 1;
        for (int i = 3; i <= n; i++) {
            int temp = first;
            first += second;
            second = temp;
        }
        return first;
    }
}