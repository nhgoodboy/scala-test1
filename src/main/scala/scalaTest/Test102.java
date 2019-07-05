package scalaTest;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test102 {
    /**
     * 虚词过滤
     */
    static Set<String> NON_WORDS = new HashSet<String>() {
        {
            add("the");
            add("and");
            add("of");
            add("to");
            add("a");
            add("i");
            add("it");
            add("in");
            add("or");
            add("is");
            add("d");
            add("s");
            add("as");
            add("so");
            add("but");
            add("be");
        }
    };

    /**
     * 命令式方式过滤实现      * @param words     * @return
     */
    public static Map wordFreq1(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        Matcher m = Pattern.compile("\\w+").matcher(words);
        while (m.find()) {
            String word = m.group().toLowerCase();
            if (!NON_WORDS.contains(word)) {
                if (wordMap.get(word) == null) {
                    wordMap.put(word, 1);
                } else {
                    wordMap.put(word, wordMap.get(word) + 1);
                }
            }
        }
        return wordMap;
    }

    /**
     * 将待处理对象转为列表集合     * @param words     * @param regex     * @return
     */
    private static List<String> regexToList(String words, String regex) {
        List wordList = new ArrayList<>();
        Matcher m = Pattern.compile(regex).matcher(words);
        while (m.find()) wordList.add(m.group());
        return wordList;
    }

    /**
     * 对集合统一处理     * @param words     * @return
     */
    public static Map wordFreq2(String words) {
        TreeMap<String, Integer> wordMap = new TreeMap<>();
        regexToList(words, "\\w+").stream().map(w -> w.toLowerCase()).filter(w -> !NON_WORDS.contains(w)).forEach(w -> wordMap.put(w, wordMap.getOrDefault(w, 0) + 1));
        return wordMap;
    }

    public static void main(String[] args) {
        String test = "Before the popularity of network communicative tools, such as Weibo and WeChat, people get used " +
                "to know a person by face and face talk, but now the situation has changed, the young generation tend to" +
                " know a person by network social communicative tools. If they are interested in making friends, then they " +
                "will be friends online first and then keep trace with the former information on the record. It seems that we" +
                " can learn a person so fast and convenient. There is a short video about a girl dated a guy, but the guy did " +
                "not have any account on the Internet, then the girl felt not comfortable and started to question if the guy " +
                "was a criminal. The video satirizes people to rely on the Internet too much. They rather to communicate with a" +
                " person by the Internet instead of face and face talk, while the latter is much trustworthy";
        System.out.println(wordFreq1(test).toString());
        System.out.println(wordFreq2(test).toString());
    }
}


