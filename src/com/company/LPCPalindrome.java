package com.company;

// https://www.geeksforgeeks.org/longest-possible-chunked-palindrome/
public class LPCPalindrome {
    public static int longestChunkedPalindrome(String s) {
        int count = 0;
        int k = s.length();
        System.out.println("len: " + k);
        for (int i = 0, j = 0; i < s.length() && j < s.length();) {
            String left = s.substring(i, j);
            String right = s.substring(s.length()-j, k);
            if (left.length() !=0 && left.equals(right)) {
                if(i == (s.length()-j)) {
                    count+=1;
                    break;
                }
                count+=2;
                k = s.length()-j;
                i = j;
                j = i;
            } else {
                j++;
            }
        }

        return count!=0?count:1;
    }
    public static void main(String[] args) {
        String s = "ghiabcdefhelloadamhelloabcdefghi";
        System.out.println(longestChunkedPalindrome(s));
        s = "merchant";
        System.out.println(longestChunkedPalindrome(s));
        s = "antaprezatepzapreanta";
        System.out.println(longestChunkedPalindrome(s));
        s = "geeksforgeeks";
        System.out.println(longestChunkedPalindrome(s));
    }
}
