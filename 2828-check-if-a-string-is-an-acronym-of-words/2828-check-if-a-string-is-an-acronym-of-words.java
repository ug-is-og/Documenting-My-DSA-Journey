class Solution {
    public boolean isAcronym(List<String> words, String s) {
        String temp="";
        for(int i=0;i<words.size();i++)
            temp=temp+words.get(i).charAt(0);
        if(temp.equals(s))
            return true;
        return false;
    }
}