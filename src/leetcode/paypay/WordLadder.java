package leetcode.paypay;

import java.util.*;

/*
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
 */
public class WordLadder {

    public static void main(String[] args) {
        WordLadder wordLadder = new WordLadder();
        List<String> wordList = Arrays.asList("a", "b", "c");
        System.out.println("outPut: " + wordLadder.ladderLength("a", "c", wordList));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        q.add(null);
        HashSet<String> vis = new HashSet<>();
        vis.add(beginWord);
        int lvl = 1;
        while (!q.isEmpty()) {
            String pop = q.poll();
            if (pop == null) {
                lvl++;
                if (!q.isEmpty()) q.add(null);
            } else {
                char[] str = pop.toCharArray();
                for (int i = 0; i < str.length; str[i] = pop.charAt(i), i++) {
                    for (char a = 'a'; a <= 'z'; a++) {
                        str[i] = a;
                        String neigh = new String(str);
                        if (set.contains(neigh) && !vis.contains(neigh)) {
                            if (neigh.equals(endWord)) return lvl + 1;
                            vis.add(neigh);
                            q.add(neigh);
                        }
                    }
                }
            }
        }
        return 0;
    }


//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        int ladderLength = 1;
//        if(!wordList.contains(endWord)){
//            ladderLength = 0;
//            System.out.println("The endWord '" + endWord + "' is not in wordList, therefore there is no valid transformation sequence.");
//            return ladderLength;
//        }
//
//        String ladderWord = beginWord;
//        System.out.println(ladderWord);
//        List<String> matchingWords;
//
//        for (int i=0;i<wordList.size();i++){
//            matchingWords = new ArrayList<>();
//            boolean flag = false;
//            for (int k=0;k<ladderWord.length();k++) {
//
//                for (int j=i;j<wordList.size();j++) {
//                    if (ladderWord.charAt(k) == wordList.get(j).charAt(k)) {
//                        if(!flag)
//                            matchingWords.add(wordList.get(j));
//                    } else if (flag && matchingWords.contains(wordList.get(j))){
//                        matchingWords.remove(wordList.get(j));
//                    }
//                }
//
//                if (matchingWords.size()>0){
//                    if (matchingWords.size()==1){
//                        ladderWord = matchingWords.get(0);
//                        System.out.println(ladderWord);
//                        ladderLength++;
//                        break;
//                    }
//                    flag = true;
//                }
//            }
//            if (matchingWords.size()==0){
//                break;
//            } else if (matchingWords.size()>1){
//                Collections.sort(matchingWords);
//                ladderWord = matchingWords.get(0);
//                ladderLength++;
//            }
//            if (ladderWord.equals(endWord)){
//                break;
//            }
//        }
//
//        return ladderLength;
//    }
}
