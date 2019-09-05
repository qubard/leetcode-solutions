class Solution {
    public String[] reorderLogFiles(String[] logs) {
        ArrayList<String> sorted = new ArrayList<>();
        ArrayList<String> digits = new ArrayList<>();
        for (String log: logs) {
            sorted.add(log);
        }
        Collections.sort(sorted, (a, b) -> {
            String idA = a.split(" ")[0];
            String idB = b.split(" ")[0];
            int comp = a.substring(idA.length() + 1, a.length()).compareTo(b.substring(idB.length() + 1, b.length()));
            if (comp == 0) {
                return idA.compareTo(idB);
            }
            boolean isDigit1 = Character.isDigit(a.split(" ")[1].charAt(0));
            boolean isDigit2 = Character.isDigit(b.split(" ")[1].charAt(0));
            
            if (!isDigit1 && !isDigit2) {
                return comp;
            }
            
            return isDigit1 ? isDigit2 ? 0 : 1 : -1;
        });
        String[] sol = new String[logs.length];
        int i = 0;
        for (String s : sorted) {
            sol[i] = s;
            i++;
        }
        return sol;
    }
}