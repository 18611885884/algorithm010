import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 127. 单词接龙
 *
 * @ClassName LadderLength
 * @Description
 * @Author luozhengqi
 * @Date 2020-07-03 00:15
 * @Version 1.0
 **/
public class LadderLength {

    private int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> beginWordSet = new HashSet<>(), endWordSet = new HashSet<>();

        HashSet<String> visited = new HashSet<>();
        int res = 1;
        beginWordSet.add(beginWord);
        endWordSet.add(endWord);
        while (!beginWordSet.isEmpty() && !endWordSet.isEmpty()){
            if(beginWordSet.size() < beginWordSet.size()){
                HashSet<String> ls = beginWordSet;
                beginWordSet = endWordSet;
                endWordSet = ls;
            }
            HashSet<String> temp = new HashSet<>();

            for(String word:beginWordSet){
                char[] ch = word.toCharArray();
                for(int i = 0; i < ch.length; i++){
                    for(char j = 'a'; j <= 'z'; j++){
                        char old = ch[i];
                        ch[i] = j;
                        String st = String.valueOf(ch);
                        if(endWordSet.contains(st)){
                            return res + 1;
                        }
                        if(!visited.contains(st) && wordList.contains(st)){
                            visited.add(st);
                            temp.add(st);
                        }
                        ch[i] = old;
                    }
                }
            }
            beginWordSet = temp;
            res++;
        }
        return 0;
    }
}
