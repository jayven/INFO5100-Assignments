package AssignmentSix;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class Q2to5 {

    /*
    Q2. Write two differences between ArrayList and LinkedList.
        The main diff between ArrayList and LinkedList is ArrayList using dynamic array to store the elements(can be resized)
        and ListedList using doubly linked list to store the elements. LinkedList use less time(no need to resize)
        but need more space(data & address) than ArrayList.
        ArrayList is better for storing and accessing data, LinkedList is better for manipulating data.
     */

    /*
    Q3. Given two strings s and t , write a function to determine if t is an anagram of s.

        Example 1:
        Input: s = "anagram", t = "nagaram"
        Output: true

        Example 2:
        Input: s = "rat", t = "car"
        Output: false

        Note:
        You may assume the string contains only lowercase alphabets.
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0)
                return false;
        }
        return true;

        //sorting
        //char[] s_ = s.toCharArray();
        //char[] t_ = t.toCharArray();
        //return Array.equals(Arrays.sort(s_),Arrays.sort(t_));
    }


    /*
    Q4.Given an array of integers arr, write a function that returns true if and only if the number of occurrences of
    each value in the array is unique.

    Example 1:

    Input: arr = [1,2,2,1,1,3]
    Output: true
    Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1.
    No two values have the same number of occurrences.

    Example 2:

    Input: arr = [1,2]
    Output: false
    Example 3:

    Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
    Output: true

    Constraints:

    1 <= arr.length <= 1000
    -1000 <= arr[i] <= 1000
     */
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.size() == new HashSet<>(map.values()).size();
    }


    /*
    Q5. Design a HashMap without using any built-in hash table libraries. (LC #706)
     */
    class MyHashMap {
        int[] data;

        public MyHashMap() {
            data = new int[1000001];
            Arrays.fill(data, -1);
        }

        public void put(int key, int value) {
            data[key] = value;
        }

        public int get(int key) {
            return data[key];
        }

        public void remove(int key) {
            data[key] = -1;
        }
    }
}
