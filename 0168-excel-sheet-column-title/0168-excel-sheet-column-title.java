// iss question ki approach examples se hi figure out ho payegi
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb=new StringBuilder();
        while(columnNumber!=0)
        {
            int temp=(columnNumber-1)%26;
            sb.append((char)('A'+temp));
            columnNumber=(columnNumber-1)/26; //base 26
        }
        return sb.reverse().toString();
    }
}