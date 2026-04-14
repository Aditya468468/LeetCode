class Solution {

    private boolean isVowel(char x) {
        return x=='a'||x=='e'||x=='i'||x=='o'||x=='u';
    }

     public long beautifulSubstrings(String s, int k) {

        int n = s.length();

        // 🔹 Step 1: Precompute "need"
        int need = 1;
        while ((long)need * need % k != 0) {
            need++;
        }

        int mod = 2 * need;

        // 🔹 Step 2: Map → (state + mod) → count
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", 1);

        int v = 0, c = 0;
        long ans = 0;

        for (int i = 0; i < n; i++) {

            if (isVowel(s.charAt(i))) v++;
            else c++;

            int state = v - c;
            int keyMod = (i + 1) % mod;

            String key = state + "#" + keyMod;

            ans += map.getOrDefault(key, 0);

            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return ans;
    }
}