/* Isomorphic Strings */

class Solution {
    public boolean isIsomorphic(String s, String t) {
        int sArr[] = new int[200];
        int tArr[] = new int[200];
        int n = s.length();

        for(int i=0; i<n; i++) {

            if(sArr[(int)(s.charAt(i))] != tArr[(int)(t.charAt(i))]) {
                return false;
            }

            sArr[(int)(s.charAt(i))]=i+1;
            tArr[(int)(t.charAt(i))]=i+1;
        }

        return true;
    }
}

/*
  Suppose we have two strings, s = "egg" and t = "add".
  
  We initialize two integer arrays, sArr and tArr, of size 200 (for ASCII characters).
  
  We start iterating through both strings, character by character:
  
  For the first character, s.charAt(0) is 'e', and t.charAt(0) is 'a'. We check if sArr['e'] (sArr[101]) is equal to tArr['a'] (tArr[97]). Since both are initially 0 (default array values), we proceed to update the mappings:
  
  sArr['e'] is updated to 1.
  tArr['a'] is updated to 1.
  For the second character, s.charAt(1) is 'g', and t.charAt(1) is 'd'. We check if sArr['g'] (sArr[103]) is equal to tArr['d'] (tArr[100]). Both are initially 0, so we proceed to update the mappings:
  
  sArr['g'] is updated to 2.
  tArr['d'] is updated to 2.
  For the third character, s.charAt(2) is 'g', and t.charAt(2) is 'd'. We check if sArr['g'] (sArr[103]) is equal to tArr['d'] (tArr[100]). Both are now 2, so the mappings match.
  
  Since all characters have been checked, and the mappings match for all characters, we conclude that the strings "egg" and "add" are isomorphic.
*/
