import java.util.ArrayList;
import java.util.Arrays;

/**
 * 实现 Trie
 * @ClassName TrieNode
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-22 01:31
 * @Version 1.0
 **/
public class TrieNode {
    // 下个26个字母分别指向那个结点  此处表示路径 --  思维转变
    private TrieNode[] trieNodes;
    // 26个字母
    private int R = 26;
    // 当前结点结束是否代表一个单词
    private boolean isEnd;

    public TrieNode(){
        trieNodes = new TrieNode[R];
    }

    public boolean containsKey(char ch){
        return get(ch) != null;
    }

    public TrieNode get(char ch){
        return trieNodes[ch - 'a'];
    }

    public void put(char ch, TrieNode trieNode){
        trieNodes[ch - 'a'] = trieNode;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}
