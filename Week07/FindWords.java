import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. 单词搜索 II
 * @ClassName FindWords
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-22 15:49
 * @Version 1.0
 **/
public class FindWords {
    /**
     * 输入:
     * words = ["oath","pea","eat","rain"] and board =
     * [
     *   ['o','a','a','n'],
     *   ['e','t','a','e'],
     *   ['i','h','k','r'],
     *   ['i','f','l','v']
     * ]
     *
     * 输出: ["eat","oath"]
     *
     * 1、将words 的单词构建在tire 树中
     */
    int[][] fx = new int[][]{{0, -1},{0, 1},{-1, 0},{1, 0}};
    public List<String> findWords(char[][] board, String[] words) {
        if(words.length == 0 || board.length == 0){
            return new ArrayList<>();
        }
        // 初始化 trie树
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        Set<String> res = new HashSet<>();
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(res, board, i, j, trie, "");
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(Set<String> res, char[][] board, int i, int j, Trie trie, String str) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '@'){
            return;
        }
        str += board[i][j];
        if(!trie.startsWith(str)){
            return;
        }
        if(trie.search(str)){
            res.add(str);
        }
        char ans = board[i][j];
        board[i][j] = '@';
        for(int[] f : fx){
            dfs(res, board, i + f[0], j + f[1], trie, str);
        }
        board[i][j] = ans;
    }

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

    }

    public static void main(String[] args) {
        char[][] ch = new char[][]{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        new FindWords().findWords(ch, new String[]{"oath","pea","eat","rain"});
    }
}
