/* Happy Numbers */

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> numbersEncountered = new HashSet<>();

        while(!numbersEncountered.contains(n)) {
          numbersEncountered.add(n);
          n = getSumOfDigitsSquared(n);
          if(n == 1) {
            return true;
          }
        }

        return false;
    }

    private int getSumOfDigitsSquared(int n) {
      int sum = 0;
      while (n != 0) {
        sum += (n%10) * (n%10);
        n /= 10; 
      }

      return sum;
    }
}

/*
  Let's say we want to check if n = 19 is a happy number.

  In the first iteration, we calculate the sum of the squares of its digits: 1^2 + 9^2 = 1 + 81 = 82.
  
  In the second iteration, we calculate the sum of the squares of the digits of 82: 8^2 + 2^2 = 64 + 4 = 68.
  
  In the third iteration, we calculate the sum of the squares of the digits of 68: 6^2 + 8^2 = 36 + 64 = 100.
  
  In the fourth iteration, we calculate the sum of the squares of the digits of 100: 1^2 + 0^2 + 0^2 = 1.
  
  At this point, we have reached 1, and the algorithm returns true. Since we reached 1, 19 is considered a happy number.
  
  The algorithm keeps track of encountered numbers using a Set to detect cycles. If it encounters a number that it has seen before, it means it's stuck in a cycle and will never reach 1, so it returns false.
*/
