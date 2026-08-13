class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        //Frequency required from t
        for(char ch : t.toCharArray()){
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        int required = need.size();
        int formed = 0;
        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int start = 0;

        for(int right = 0; right < s.length(); right++){
            char ch = s.charAt(right);
            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Character has reached the required frequency
            if(need.containsKey(ch) && window.get(ch).intValue() == need.get(ch).intValue()){
                formed++;
            }
            // Try to shrink while window is valid
            while(left <= right && formed == required){

                //updated minimum window
                if(right - left +1 < minLength){
                    minLength = right - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar, window.get(leftChar) - 1);

                // We have lost a required character
                if(need.containsKey(leftChar) && window.get(leftChar) < need.get(leftChar)){
                    formed--;
                }
                left++;
            }

        }
        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLength);
    }
}