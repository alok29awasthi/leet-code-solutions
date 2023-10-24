/* Word Search II */

class Solution {
    class Trie {
        Trie[] child = new Trie[26];
        String word;
    }

    private Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for(String word: words) {
            Trie node = root;
            for(char c: word.toCharArray()) {
                int idx = c - 'a';
                if(node.child[idx] == null) {
                    node.child[idx] = new Trie();
                }
                node = node.child[idx];
            }
            node.word = word;
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, Trie node, List<String> result) {
        char c = board[i][j];
        if(c == '-' || node.child[c-'a'] == null) {
            return;
        }

        node = node.child[c-'a'];

        if(node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[i][j] = '-';
        if(i>0) dfs(board, i-1, j, node, result);
        if(j>0) dfs(board, i, j-1, node, result);
        if(i<board.length-1) dfs(board, i+1, j, node, result);
        if(j<board[0].length-1) dfs(board, i, j+1, node, result);
        board[i][j] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = buildTrie(words);
        List<String> result = new ArrayList<>();

        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
}

/*
Building the Trie (buildTrie function):

A Trie is constructed to store the dictionary of valid words from the words list.
For each word in the words list, you start at the root of the Trie.
For each character in the word, you traverse the Trie. If the corresponding child node does not exist, you create it.
Once you've added all characters of a word to the Trie, you mark the node at the end of the word with the actual word as node.word. This is used to identify valid words found on the board.
DFS on the Board (dfs function):

The Depth-First Search (DFS) function starts at each cell of the board, exploring horizontally and vertically neighboring cells.
For each cell on the board, you check if the corresponding character is in the Trie and traverse the Trie to the matching node.
If the node contains a valid word, you add that word to the result list and mark it as used by setting node.word to null.
You temporarily replace the board character with a placeholder (e.g., '-') to prevent revisiting the same cell during the DFS.
The DFS continues in four directions (up, down, left, right) from the current cell. If it finds a valid word or reaches the end of the word in the Trie, it backtracks and restores the original character.
Traversing the Entire Board (findWords function):

The findWords function initiates the DFS for each cell in the board. For each cell, it explores possible word paths and accumulates valid words in the result list.
Returning the Result:

After the DFS process is complete, the result list contains all the words found on the board.
*/
