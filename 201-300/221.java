/* Maximal Square */

class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;

        int[][] mat = new int[n][m];
        int size=0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                mat[i][j] = matrix[i][j] - '0';
                if((i==0 || j==0) && mat[i][j]==1) {
                    size = 1;
                }
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=1; j<m; j++) {
                if(mat[i][j]==1) {
                    mat[i][j] = Math.min(mat[i-1][j], Math.min(mat[i][j-1], mat[i-1][j-1])) + 1;
                    if(size < mat[i][j]) {
                        size = mat[i][j];
                    }
                }
            }
        }

        return size*size;
    }
}

/*
Consider the binary matrix:

1 0 1 0 1
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

**Step 1: Initialization**

The solution initializes a new matrix `mat` and a variable `size`. The `mat` matrix is initialized based on the input binary matrix:

1 0 1 0 1
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

If there is a '1' in the first row or first column, `size` is set to 1.

**Step 2: DP Update**

Now, it iterates through the matrix, starting from the second row and second column. For each '1' in the matrix, it updates the corresponding entry in the `mat` matrix based on the minimum of its left, above, and diagonally left above neighbors.

1 0 1 0 1
1 0 1 1 1
1 1 1 2 2
1 0 0 1 0

The `mat` matrix is efficiently updated, representing the size of the largest square ending at each position.

**Step 3: Return Result**

The solution returns the area of the largest square by squaring the `size`. In this example, the largest square has a side length of 2, so the result is `2 * 2 = 4`.

**Explanation:**

The dynamic programming approach efficiently builds up the information about the size of squares ending at each position, allowing the algorithm to find the maximum square size without redundant computations. The final result is the area of the largest square in the binary matrix.
*/
