package SlidingWindow;

import java.util.List;

/**

PROBLEM: Substring with Concatenation of All Words (LeetCode #30)
https://leetcode.com/problems/substring-with-concatenation-of-all-words/
Given string s and array words (all same length), return all start indices where a concatenation
of all words in any order appears as a substring in s.
Example: s = "barfoothefoobarman", words = ["foo","bar"] → [0, 9]

------------------------------------------------------------------------------------------------------------------------

Approach:
1) All words share the same length (wordLen); total window size = words.length × wordLen
2) For each starting offset (0 to wordLen-1), slide a word-level window over s
3) Use a frequency map of words; extract one chunk of wordLen chars at a time from the current position
4) If chunk not in map or used too many times → reset window from current position
5) When matched word count == words.length → record start index and slide by one word

------------------------------------------------------------------------------------------------------------------------

Time : O(n × m) — n = s.length(), m = wordLen; inner loop runs n/m iterations per offset
Space: O(total words) — frequency maps for the word list and current window

------------------------------------------------------------------------------------------------------------------------

*/
public class _8_SubstringWithConcatenationOfAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        return null;
    }

}
