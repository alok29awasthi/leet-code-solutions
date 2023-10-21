/* Implement Trie (Prefix Tree) */

class Trie {

    class Node {
        Node[] children = new Node[26];
        boolean isEndOfWord = false;
    }

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node temp = root;
        for(char c: word.toCharArray()) {
            int idx = c - 'a';
            if(temp.children[idx]==null) {
                temp.children[idx] = new Node();
            }
            temp = temp.children[idx];
        }
        temp.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        Node temp = root;
        for(char c: word.toCharArray()) {
            int idx = c - 'a';
            if(temp.children[idx] == null) {
                return false;
            }
            temp = temp.children[idx];
        }

        return temp.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        Node temp = root;
        for(char c: prefix.toCharArray()) {
            int idx = c - 'a';
            if(temp.children[idx] == null) {
                return false;
            }
            temp = temp.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

/*
The Trie class uses a nested class Node to represent the nodes in the Trie. Each node has an array of children to represent the next characters, and a boolean isEndOfWord to indicate whether a word ends at this node.

The Trie class has a root node that serves as the starting point of the Trie.

The insert method is used to insert a word into the Trie. It iterates through the characters of the word, creating nodes as needed to represent the characters.

The search method is used to check if a complete word is present in the Trie. It iterates through the characters and returns true if it reaches the end of a valid word.

The startsWith method checks if there are words in the Trie with the given prefix. It returns true if the Trie has words that start with the provided prefix.


*/
