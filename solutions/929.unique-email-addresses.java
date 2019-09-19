class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> unique = new HashSet<>();
        for (String email : emails) {
            int atIndex = email.indexOf('@');
            String local = email.substring(0, atIndex);
            
            // Filter out periods
            String filtered = local.replaceAll(".", "");
            // Remove everything past the first plus sign
            int plus = filtered.indexOf('+');
            if (plus >= 0)
                filtered = filtered.substring(0, plus);
            filtered = filtered + email.substring(atIndex, email.length());
            unique.add(filtered);
        }
        
        return unique.size();
    }
}