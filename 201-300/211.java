/* Design Add and Search Words Data Structure */

class WordDictionary {
    class Trie {
        Trie[] children;
        boolean isEndOfWord;

        public Trie() {
            children = new Trie[26];
            isEndOfWord = false;
        }
    }

    public boolean find(String word, int idx, Trie node) {
        if(idx == word.length()) {
            return node.isEndOfWord;
        }

        char c = word.charAt(idx);

        if(c == '.') {
            for(Trie child: node.children) {
                if(child != null && find(word, idx+1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            Trie child = node.children[c - 'a'];
            if(child == null) {
                return false;
            }
            return find(word, idx+1, child);
        }
    }

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie temp = root;
        for(char c: word.toCharArray()) {
            int idx = c - 'a';
            if(temp.children[idx] == null) {
                temp.children[idx] = new Trie();
            }
            temp = temp.children[idx];
        }
        temp.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return find(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

/*
Suppose we add the words "bad", "dad", and "mad" to the WordDictionary and then search for words using dot placeholders, like "b.d".

Explanation of the Code:

The WordDictionary uses a Trie data structure to efficiently store and search for words. Each Trie node contains an array of children (Trie[] children) and a boolean flag isEndOfWord to mark the end of a word.

The find function is a recursive function used to search for words within the Trie. It takes three arguments: the current word being searched (word), the current index within the word (idx), and the current Trie node (node).

If we've reached the end of the word (i.e., idx equals the word length), we return true if the current node marks the end of a word (isEndOfWord).

If the current character at the given index is a dot ('.'), we iterate through all the children of the current node. For each non-null child, we recursively call the find function with the next index and that child. If any of these recursive calls return true, we return true.

If the current character is not a dot, we check if there is a corresponding child node in the Trie. If not, we return false. Otherwise, we continue searching with the next character.

The root of the Trie is the starting point for adding words and searching for words.

In the addWord function, we iterate through each character of the word, creating new child nodes as needed to represent the word.

In the search function, we call the find function with the given word, starting from the root of the Trie.

In the example, when we search for "b.d", it matches words "bad" and "bed" in the Trie, so the search function returns true. This is because the dot ('.') acts as a wildcard, matching any character.

This WordDictionary provides a flexible way to store and search for words with wildcards, making it useful for tasks like pattern matching and word searches with placeholders.
*/
