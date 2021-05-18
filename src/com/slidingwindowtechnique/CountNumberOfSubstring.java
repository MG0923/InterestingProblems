package com.slidingwindowtechnique;
/*Count number of substrings having at least K distinct characters*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountNumberOfSubstring {

    // Function to find all distinct substrings containing exactly `k` distinct
    // characters
    public static Set<String> findDistinctSubstrings(String str, int k)
    {
        // create a set to store substrings containing exactly `k` distinct characters
        Set<String> result = new HashSet<>();

        // in each iteration of the loop, consider substring starting with `str[i]`
        for (int i = 0; i < str.length() - k + 1; i++)
        {
            // create a set to store distinct characters in the current substring
            Set<Character> chars = new HashSet<>();

            // process substring starting with `str[i]`
            for (int j = i; j < str.length() && chars.size() <= k; j++)
            {
                // insert current character `str[j]` into the hash set
                chars.add(str.charAt(j));

                // if the count of distinct characters becomes `k`
                if (chars.size() == k)
                {
                    // add the current substring to the result
                    result.add(str.substring(i, j + 1));
                }
            }
        }

        return result;
    }

    // Function to find all distinct substrings containing exactly `k` distinct
    // characters
    public static Set<String> findDistinctSubstringsWithAtleastK(String str, int k)
    {
        // create a set to store substrings containing exactly `k` distinct characters
        Set<String> result = new HashSet<>();

        // in each iteration of the loop, consider substring starting with `str[i]`
        for (int i = 0; i < str.length() - k + 1; i++)
        {
            // create a set to store distinct characters in the current substring
            Set<Character> chars = new HashSet<>();

            // process substring starting with `str[i]`
            for (int j = i; j < str.length(); j++)
            {
                // insert current character `str[j]` into the hash set
                chars.add(str.charAt(j));

                /*
                    If current character `str[j]` is seen before in the
                    substring `str[i…j-1]`, the count remains the same since
                    the hash set only allows unique values
                */

                // if the count of distinct characters becomes `k`
                if (chars.size() >= k)
                {
                    // add the current substring to the result
                    result.add(str.substring(i, j + 1));
                }
            }
        }

        return result;
    }

    // Function to count number of substrings
    // having atleast k distinct characters
    static void atleastKDistinctChars(String s, int k) {

        // Stores the size of the string
        int n = s.length();

        // Initialize a HashMap
        Map<Character, Integer> mp = new HashMap<>();

        // Stores the start and end
        // indices of sliding window
        int begin = 0, end = 0;

        // Stores the required result
        int ans = 0;

        // Iterate while the end
        // pointer is less than n
        while (end < n) {

            // Include the character at
            // the end of the window
            char c = s.charAt(end);
            mp.put(c, mp.getOrDefault(c, 0) + 1);

            // Increment end pointer by 1
            end++;

            // Iterate until count of distinct
            // characters becomes less than K
            while (mp.size() >= k) {

                // Remove the character from
                // the beginning of window
                char pre = s.charAt(begin);
                mp.put(pre, mp.getOrDefault(pre, 0) - 1);

                // If its frequency is 0,
                // remove it from the map
                if (mp.get(pre) == 0) {
                    mp.remove(pre);
                }

                // Update the answer
                ans += s.length() - end + 1;
                begin++;
            }
        }

        // Print the result
        System.out.println(ans);
    }

    // Driver code
    public static void main(String[] args) {

        // Given inputs
        String s = "abcadce";
        int k = 4;

        System.out.println(findDistinctSubstrings(s, k));
        System.out.println(findDistinctSubstringsWithAtleastK(s, k));
        atleastKDistinctChars(s, k);
    }
}
