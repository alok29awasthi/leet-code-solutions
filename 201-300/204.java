/* Count Primes */

class Solution {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int count = 0;
        for(long i=2; i<n; i++) {
            if(!isPrime[(int)i]) {
                count++;
                for(long j=i*i; j<(long)n; j+=i) {
                    isPrime[(int)j] = true;
                }
            }
        }

        return count;
    }
}

/*
  Let's illustrate this with an example:
  
  Suppose we want to find the number of prime numbers less than n = 10.
  
  We create a boolean array isPrime of size n and initialize it with all false values.
  
  We start iterating through numbers from 2 to n-1, which is from 2 to 9.
  
  For each number i in this range, if isPrime[i] is false, it means it's a prime number. We increment the count.
  
  For i = 2, we increment count to 1 because 2 is a prime number.
  
  We then mark all multiples of 2 as true (not prime) starting from i*i, which is 4, and incrementing by i. So, we mark 4, 6, and 8 as true.
  
  Next, we move to i = 3. Since isPrime[3] is false, we increment count to 2 because 3 is a prime number.
  
  We then mark all multiples of 3 as true (not prime) starting from i*i, which is 9. So, we mark 9 as true.
  We continue this process until we have checked all numbers from 2 to 9.
  
  Finally, we return the count, which is 4. There are 4 prime numbers less than 10, which are 2, 3, 5, and 7.
*/
