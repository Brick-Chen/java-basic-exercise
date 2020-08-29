import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GrammarExercise {
    public static void main(String[] args) {
        //需要从命令行读入
        String firstWordList = "apple,juice,mother,people,beautiful,apple,dog";
        String secondWordList = "cat,baby,smile,good,apple,beautiful,Dog,nice";

        List<String> result = findCommonWordsWithSpace(firstWordList,secondWordList);
        //按要求输出到命令行

    }

    public static List<String> findCommonWordsWithSpace(String firstWordList, String secondWordList) {
        //在这编写实现代码
        if(!valid(firstWordList) || !valid(secondWordList)) {
            throw new RuntimeException("input not valid");
        }

        Set<String> m1 = Arrays.stream(firstWordList.split(",")).
                map(String::toLowerCase).collect(Collectors.toSet());

        Set<String> m2 = Arrays.stream(secondWordList.split(",")).
                map(String::toLowerCase).collect(Collectors.toSet());

        return m1.stream().filter(m2::contains).sorted().collect(Collectors.toList());
    }

    private static boolean valid(String s) {
        String[] div = s.split(",");
        return div.length == (int) Arrays.stream(div).filter(GrammarExercise::isWord).count();
    }

    private static boolean isWord(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }
        for(int i = 0; i < s.length(); ++i) {
            if(!Character.isLetter(s.charAt(i))){
                return false;
            }
        }
        return true;
    }


}
