class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            String[] tokens = domain.split(" ");
            int count = Integer.parseInt(tokens[0]);
            String[] rest = tokens[1].split("\\.");
            String top = "";
            for (int i = rest.length - 1; i >= 0; i--) {
                String period = i != rest.length - 1 ? "." : "";
                top = rest[i] + period + top;
                map.put(top, map.getOrDefault(top, 0) + count);
            }
        }
        
        ArrayList<String> sol = new ArrayList<String>();
        
        for (String domain : map.keySet()) {
            sol.add(map.get(domain) + " " + domain);
        }
        return sol;
    }
}