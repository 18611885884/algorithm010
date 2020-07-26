/**
 * 208. 实现 Trie (前缀树)
 * @ClassName Trie
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-22 01:26
 * @Version 1.0
 **/
public class Trie {

    private Trie[] tries;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        tries = new Trie[26];
    }

    public Trie get(char ch){
        return tries[ch - 'a'];
    }

    public void put(char ch, Trie trie){
        tries[ch - 'a'] = trie;
    }

    public boolean isEnd() {
        return isEnd;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || word.length() == 0) return;
        Trie trie = this;
        for(char ch : word.toCharArray()){
            if(trie.get(ch) == null){
                Trie trieNext = new Trie();
                trie.put(ch, trieNext);
                trie = trieNext;
            }else{
                trie = trie.get(ch);
            }
        }
        trie.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = searchPrefix(prefix);
        return trie != null;
    }

    private Trie searchPrefix(String word) {
        Trie trie = this;
        for(char ch : word.toCharArray()){
            trie = trie.get(ch);
            if(trie == null){
                return null;
            }
        }
        return trie;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true

    }
}
