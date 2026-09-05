class TimeMap {

    Map<String, List<Integer>> timeMap;
    Map<String, Map<Integer, String>> valMap;

    public TimeMap() {
        timeMap = new HashMap<>();
        valMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timeMap
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(timestamp);
        valMap
            .computeIfAbsent(key, k -> new HashMap<>())
            .put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        String res = "";
        Map<Integer, String> inner = valMap.get(key);

        if(inner == null) return res;
        else if(inner.get(timestamp) != null) return inner.get(timestamp);

        List<Integer> ts = timeMap.get(key);

        int l = 0, r = ts.size() - 1;

        int curMax = -1;

        while(l <= r) {
            int mid = l + (r-l)/2;
            int midVal = ts.get(mid);

            if(midVal < timestamp) {
                if(midVal > curMax) curMax = midVal;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            
        }

        return curMax == -1 ? res : inner.get(curMax);
    }
}
