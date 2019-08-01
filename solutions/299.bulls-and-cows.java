class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        
        Set<Integer> seen = new HashSet<>();
        
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                if (!seen.contains(i)) {
                    bulls++;
                    seen.add(i);
                }
            }
        }
        
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                for (int j = 0; j < secret.length(); j++) {
                    if (j != i) {
                        if (secret.charAt(j) == guess.charAt(i)) {
                            if (!seen.contains(j)) {
                                cows++;
                                seen.add(j);
                                break;
                            }
                        }
                    }
                }    
            }
        }
        
        return bulls + "A" + cows + "B";
    }
}
