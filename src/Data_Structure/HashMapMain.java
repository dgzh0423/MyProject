package Data_Structure;
import java.util.*;
/**
 * @author 15304
 */

public class HashMapMain {
    public static void main(String[] args){
        CharacterFinder charF = new CharacterFinder();
        charF.findKthNonRepeatedChar("a red apple", 4);
        var ch = charF.findFirstRepeatedChar("a green apple");
        System.out.println(ch);
    }

    public static class CharacterFinder{
        public void findKthNonRepeatedChar(String str, int k){
            Map<Character, Integer> map = new HashMap<>();
            for (var ch: str.toCharArray()){
                var count = map.containsKey(ch) ? map.get(ch) : 0;
                map.put(ch,count+1);
            }

            int c1 = 0;
            int c2 = 0;
            for (var ch: str.toCharArray()) {
                // if (map.get(ch) == 1){return ch;}
                if (map.get(ch) == 1){
                    c1++;
                    c2++;
                    if(c1 == k){
                        System.out.println(ch);
                    }
                }
            }
            if (k > c2){
                throw new IllegalStateException();
            }
        }

        public char findFirstRepeatedChar(String str){
            Set<Character> set = new HashSet<>();
            for (var ch: str.toCharArray()){
                if (set.contains(ch)){
                    return ch;
                }
                set.add(ch);
            }
            return Character.MIN_VALUE;
        }
    }
}
