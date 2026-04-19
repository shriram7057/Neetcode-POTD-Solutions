class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        mp = {}
        for s in strs:
            key = tuple(sorted(s))
            if key not in mp:
                mp[key] = []
            mp[key].append(s)
        return list(mp.values())