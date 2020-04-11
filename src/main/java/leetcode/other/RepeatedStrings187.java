class Solution {
public List<String> findRepeatedDnaSequences(String s) {
    Set seen = new HashSet(), repeated = new HashSet();
    for (int i = 0; i + 9 < s.length(); i++) {
        String ten = s.substring(i, i + 10);
        if (!seen.add(ten))
            repeated.add(ten);
    }
    return new ArrayList(repeated);
}
}
/*
class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        seen = set()
        repeated = set()
        n = len(s)
        for i in range(n-9):
            ten = s[i:i+10]
            if ten in seen:
                repeated.add(ten)
            seen.add(ten)
        return repeated
*/