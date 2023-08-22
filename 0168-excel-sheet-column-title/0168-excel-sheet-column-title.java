// A->1 se start ho ra 0 se nahi iss wajah se saara kaam complex ho ra
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