import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AssignmentThree {
    /* Note:
            1.Complete All Questions
            2.Deadline : 30th September 2019, 12:00pm*/

    /*Q5.
    The count-and-say sequence is a sequence of integers with the first five terms as following:
            1.     1
            2.     11
            3.     21
            4.     1211
            5.     111221

            1 is read off as "one 1" or 11.
            11 is read off as "two 1s" or 21.
            21 is read off as "one 2, then one 1" or 1211.
    Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
    Note: Each term of the sequence of integers will be represented as a string.

            Example 1:
    Input: 1
    Output: "1"

    Example 2:
    Input: 4
    Output: "1211" */

    public static String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder result = new StringBuilder();
        String str = countAndSay(n - 1) + "0";
        for (int i = 0, c = 1; i < str.length() - 1; i++, c++) {
            if (str.charAt(i + 1) != str.charAt(i)) {
                result.append(c).append(str.charAt(i));
                c = 0;
            }
        }
        return result.toString();
    }


    /*Q6. Given an input string , reverse the string word by word.
            Example:
    Input : “the sky is blue”
    Output : “blue is sky the”
    Assumptions:
    A word is defined as a sequence of non-space characters.
    The input string does not contain leading or trailing spaces.
    The words are always separated by a single space.*/
    public static String[] reverse(String[] a, int n) {
        String[] b = new String[n];
        int j = n;
        for (int i = 0; i < n; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }
        return b;
    }

    public static String convert(String input) {
        String[] words = input.trim().split(" ");
        String[] output = reverse(words, words.length);
        return String.join(" ", output);
    }


    /*Q7.
    Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
    Example 1:
    Input:
            [
            [ 1, 2, 3 ],
            [ 4, 5, 6 ],
            [ 7, 8, 9 ]
            ]
    Output: [1,2,3,6,9,8,7,4,5]

    Example 2:
    Input:
            [
            [1, 2, 3, 4],
            [5, 6, 7, 8],
            [9,10,11,12]
            ]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]*/

    public Integer[] spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return null;

        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (true) {
            for (int i = left; i <= right; i++)
                result.add(matrix[top][i]);
            top++;

            if (left > right || top > bottom)
                break;

            for (int i = top; i <= bottom; i++)
                result.add(matrix[i][right]);
            right--;

            if (left > right || top > bottom) break;

            for (int i = right; i >= left; i--)
                result.add(matrix[bottom][i]);
            bottom--;

            if (left > right || top > bottom)
                break;

            for (int i = bottom; i >= top; i--)
                result.add(matrix[i][left]);
            left++;

            if (left > right || top > bottom)
                break;
        }
        Integer[] arr = result.toArray(new Integer[result.size()]);
        return arr;
    }


    /*Q8.
    The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this
    P   A   H   N
    A P L S I I G
    Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    Write the code that will take a string and make this conversion given a number of rows:
    String convert(string s, int numRows);
    Example 1:
    Input: s = "PAYPALISHIRING", numRows = 3
    Output: "PAHNAPLSIIGYIR"

    Example 2:
    Input: s = "PAYPALISHIRING", numRows = 4
    Output: "PINALSIGYAHRPI"
    Explanation:

    P     I    N
    A   L S  I G
    Y A   H R
    P     I

     */
    public String zigzag(String s, int r) {

        StringBuilder result = new StringBuilder();
        if (s.length() <= r || r == 1)
            return s;
        for (int i = 0; i < r; i++) {
            int gap = 2 * r - 2 * i - 2;
            int j = i;
            while (j < s.length()) {
                result.append(s.substring(j, j + 1));
                j = j + gap;
                if (j < s.length() && i != r - 1)
                    result.append(s.substring(j, j + 1));
                if (i != 0)
                    j = j + 2 * i;
                else
                    j = j + gap;
            }
        }
        return result.toString();
    }




    /*Q9. Explain Encapsulation with an example. (Write at least 30-40 words).

      In the oop method, encapsulation means a method of partially packaging and hiding the interface.
    Encapsulation can be thought of as a protective barrier that prevents code and data of the class
    from being randomly accessed by the code of externally defined classes.
      Just like a computer, which is composed of CPU, motherboard, graphics card, memory, hard disk, power supply and other components.
    It is very danger if these parts are scattered outside, anyone can modify it or even destroy it.
    So we use the case to put these parts inside, and leave some sockets and switches outside to access the internal details.


    /*Q10. What is the difference between Encapsulation and Abstraction

      Encapsulation means hiding code and data into a single unit. On the other hand, abstraction refers to hiding unwanted
    details but showing the necessary details. In Java, abstraction is implemented by using interface and abstract class,
    but encapsulation is implemented using private classes.

     */

    public static void main(String[] args) {
        //String input = "the sky is blue";
        //String output = convert(input);
        //System.out.println(output);

        String result = countAndSay(5);
        System.out.println(result);

    }
}


