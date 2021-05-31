package com.company;

import java.util.Map;

public class NumberToHexaDecimal {

    static void convertToHex(int num) {
        String res = "";
        var map = Map.of(10,'a',11,'b',12,'c',13,'d',14,'e',15,'f');

        if (num < 0) {
            {
//                num = -num;
//                String binaryString = Integer.toBinaryString(~num);
//                System.out.println(binaryString);
//                StringBuilder sb = new StringBuilder(binaryString.substring(24)).reverse();
//                char curr = '1';
//                for (int i = 0; i < sb.length(); i++) {
//                    if (sb.charAt(i) == '1') {
//                        if (curr == '1') {
//                            sb.setCharAt(i, '0');
//                            curr = '1';
//                        } else {
//                            curr = '0';
//                        }
//                    } else {
//                        sb.setCharAt(i, curr);
//                        curr = '0';
//                    }
//                }
//                System.out.println("sb : " + sb.reverse().toString());
//                num = Integer.parseInt(sb.toString(), 2);
//                System.out.println("neg num " + num + ", " +  Integer.toHexString(num));
                StringBuilder sb = new StringBuilder();
                int bitNum = 8;
                num = -num - 1;
                while (bitNum > 0) {  // num is negative
                    int rest = num % 16;
                    if (rest < 6) {
                        sb.append((char)('f' - rest));
                    }
                    else {
                        sb.append(15 - rest);
                    }
                    num /= 16;
                    bitNum--;
                }

                System.out.println(sb.reverse().toString());
            }
        }

        if (num > 0) {
            while (num > 0) {
                int r = num % 16;
                res = (map.get(r)!=null ? map.get(r)+"" : r) + res;
                num/=16;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        convertToHex(-10);
        convertToHex(-1);
        convertToHex(6);
        convertToHex(60);
        convertToHex(26);
    }
}
