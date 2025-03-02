package Trie;

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
        System.out.println("The Trie has been created.");
    }

    public void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("Inserted successfully " + word + " in Trie");
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);
            if (node == null) {
                System.out.println("Word: " + word + " does not exist in Trie.");
                return false;
            }
            currentNode = node;
        }
        if (currentNode.endOfString) {
            System.out.println("Word: " + word + " exist in Trie");
            return true;
        } else {
            System.out.println("Word: " + word + " does not exist in Trie. But it is a prefix of another string");
        }
        return false;
    }

    public void delete(String word) {
        if (search(word)) {
            delete(root, word, 0);
        }
    }


    // Helper Method
    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canThisNodeBeDeleted;

        if (currentNode.children.size() > 1) {
            delete(currentNode, word, index+1);
            return false;
        }
        if (index == word.length() - 1) {
            if (!currentNode.children.isEmpty()) {
                currentNode.endOfString = false;
                return false;
            } else {
                parentNode.children.remove(ch);
                return true;
            }
        }
        if (currentNode.endOfString) {
            delete(currentNode, word, index+1);
            return false;
        }
        canThisNodeBeDeleted = delete(currentNode, word, index+1);
        if (canThisNodeBeDeleted) {
            parentNode.children.remove(ch);
            return true;
        } else {
            return false;
        }
    }
}
