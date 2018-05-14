/*
Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

Note:
The length of A and B will be between 1 and 10000.
*/

class Solution {
    public int repeatedStringMatch(String A, String B) {
        // validate that the number of keys is not greater in B
        Set<Character> a_set = new HashSet<>();
        Set<Character> b_set = new HashSet<>();
        for (int i = 0; i < A.length(); ++i) {
            a_set.add(A.charAt(i));
        }
        for (int i = 0; i < B.length(); ++i) {
            b_set.add(B.charAt(i));
        }
        if (b_set.size() > a_set.size()) {
            return -1;
        }
        // at this point, A has >= characters than B
        // iterate through each character in A to see if is substring
        for (int i = 0; i < A.length(); ++i) {
            // check for substring
            if (A.charAt(i) == B.charAt(0)) {
                int count = countSubstring(A, B, i);
                if (count != -1) {
                    return count;
                }
            }
        }
        return -1;
    } 
    
    // helper class to see if a substring exists
    private int countSubstring(String A, String B, int start_index) {
        StringBuilder a = new StringBuilder(A.substring(start_index));
        int a_index = 0;
        int b_index = 0;
        int num = 1; 
        while (b_index < B.length()) {
            if (a_index == a.length()) {
                a.append(A);
                ++num;
            }
            if (a.charAt(a_index) != B.charAt(b_index)) {
                return -1;
            }
            ++a_index;
            ++b_index;
        }
        
        return num;
    }
}
