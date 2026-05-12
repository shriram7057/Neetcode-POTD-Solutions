class LFUCache {
    /**
     * @param {number} capacity
     */
    constructor(capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyMap = new Map();   // key -> {value, freq}
        this.freqMap = new Map();  // freq -> ordered Map of keys
    }

    updateFreq(key) {
        let node = this.keyMap.get(key);
        let freq = node.freq;

        this.freqMap.get(freq).delete(key);

        if (this.freqMap.get(freq).size === 0) {
            this.freqMap.delete(freq);

            if (this.minFreq === freq) {
                this.minFreq++;
            }
        }

        node.freq++;

        if (!this.freqMap.has(node.freq)) {
            this.freqMap.set(node.freq, new Map());
        }

        this.freqMap.get(node.freq).set(key, true);
    }

    /**
     * @param {number} key
     * @return {number}
     */
    get(key) {
        if (!this.keyMap.has(key)) {
            return -1;
        }

        let node = this.keyMap.get(key);

        this.updateFreq(key);

        return node.value;
    }

    /**
     * @param {number} key
     * @param {number} value
     * @return {void}
     */
    put(key, value) {
        if (this.capacity === 0) return;

        if (this.keyMap.has(key)) {
            this.keyMap.get(key).value = value;
            this.updateFreq(key);
            return;
        }

        if (this.keyMap.size === this.capacity) {
            let lfuKeys = this.freqMap.get(this.minFreq);

            let evictKey = lfuKeys.keys().next().value;

            lfuKeys.delete(evictKey);

            if (lfuKeys.size === 0) {
                this.freqMap.delete(this.minFreq);
            }

            this.keyMap.delete(evictKey);
        }

        this.keyMap.set(key, { value: value, freq: 1 });

        if (!this.freqMap.has(1)) {
            this.freqMap.set(1, new Map());
        }

        this.freqMap.get(1).set(key, true);

        this.minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * var obj = new LFUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */