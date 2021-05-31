package com.company.leetcode;

public class _953 {
  public static boolean isAlienSorted(String[] words, String order) {
    for (int i = 0, j = i + 1; i < words.length && j < words.length; i++) {

      int k = 0, l = 0;
      while (k < words[i].length() && l < words[j].length()) {


        if (order.indexOf(words[i].charAt(k)) > order.indexOf(words[j].charAt(l))) {
//            System.out.println(words[i].charAt(k) + "," + words[j].charAt(j));
          return false;
        } else if (order.indexOf(words[i].charAt(k)) < order.indexOf(words[j].charAt(l))) {
          break;
        }
        k++;
        l++;
      }

      if (k < words[i].length() && l >= words[j].length()) {
        return false;
      }

    }

    return true;
  }

  public static void main(String[] args) {
    System.out.println(isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
    System.out.println(isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    System.out.println(isAlienSorted(new String[]{"dthkre","vvjrym","zvrzapstvm","dcjkqyrr","ditmpogp","gpzzmilb","dymhwov","bytjqyqupf","vjeaumrdy","lwvozpyx"}, "tngjwhflzomueqkisxcpybdavr"));
  }
}
