class TimeMap {

    private Map<String, List<Pair>> map;

    private static class Pair {
        String val;
        int time;
        Pair(String v, int t) {
            val = v;
            time = t;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";

        List<Pair> list = map.get(key);
        int l = 0, r = list.size() - 1;
        String res = "";

        while (l <= r) {
            int mid = (l + r) / 2;
            if (list.get(mid).time <= timestamp) {
                res = list.get(mid).val;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return res;
    }
}