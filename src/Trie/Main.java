package Trie;

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("API");
        trie.insert("APIS");
        trie.delete("API");
        trie.delete("AP");
        trie.search("API");
        trie.search("APIS");

    }
}
