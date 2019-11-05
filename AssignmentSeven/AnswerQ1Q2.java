package AssignmentSeven;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AnswerQ1Q2 {
    /*  Q1. Write a program that read sentences from a file and reverse sentences word by word. After reverse,
    create a new file to save sentences. (Extreme corner case is not mandatory.)

    Example:
    Input file: the sky is blue.
    Output file: blue is sky the.*/

    public static String reverse(String s) {
        if (s.length() == 0)
            return s;
        String str[] = s.split(" ");
        String ans = "";
        for (int i = str.length - 1; i >= 0; i--) {
            ans += str[i] + " ";
        }
        return ans.substring(0, ans.length() - 1);

    }
    /* Q2. Write a program that decode a file. Given an encoded file, create its decoded file.
    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
    Note that k is guaranteed to be a positive integer.

    Assume that the string from input file is always valid; No extra white spaces, square brackets are well-formed, etc.

    Furthermore, assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
    For example, there won't be input like 3a or 2[4].

    Examples:
    Input file: "3[a]2[bc]", output file: "aaabcbc".
    Input file: "3[a2[c]]", output file: "accaccacc".
    Input file: "2[abc]3[cd]ef", output file: "abcabccdcdcdef".*/

    public String decode(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        String res = "";
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int c = 0;
                while (Character.isDigit(s.charAt(i))) {
                    //in case it is to digit*10
                    c = 10 * c + (s.charAt(i) - '0');
                    i++;
                }
                count.push(c);
            } else if (s.charAt(i) == '[') {
                result.push(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder temp = new StringBuilder(result.pop());
                int repeat = count.pop();
                for (int j = 0; j < repeat; j++) {
                    temp.append(res);
                }
                res = temp.toString();
                i++;
            } else {
                res += s.charAt(i++);
            }
        }
        return res;
    }

}
