class Solution {
    class Info {
        char val;
        int count;
        Info(char val, int count) {
            this.count = count;
            this.val = val;
        }
    }
    class InfoComparator implements Comparator<Info> {
        public int compare(Info a, Info b) {
            return b.count - a.count;  
        }
    }

    public String reorganizeString(String s) {
        int[] freq = new int[26];
        // Count frequency of all characters
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
        }
        PriorityQueue<Info> pq = new PriorityQueue<>(new InfoComparator());
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new Info((char) (i + 'a'), freq[i]));
            }
        }
        StringBuilder ans = new StringBuilder();
        while (pq.size() > 1) {
            Info first = pq.poll();
            Info second = pq.poll();
            ans.append(first.val);
            first.count--;
            ans.append(second.val);
            second.count--;

            if (first.count > 0) {
                pq.add(first);
            }
            if (second.count > 0) {
                pq.add(second);
            }
        }
        if (pq.size() == 1) {
            Info last = pq.poll();
            if (last.count > 1) {
                return "";  
            }
            ans.append(last.val);
        }

        return ans.toString();
    }
}
