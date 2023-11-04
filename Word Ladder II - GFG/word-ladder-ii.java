//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java



//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        String beginWord=startWord;
        String endWord=targetWord;
        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> list=new ArrayList<>();
        ArrayList<ArrayList<String>> ans=new ArrayList<>();
        list.add(beginWord);
        int prevLevel=0;
        int min=Integer.MAX_VALUE;
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordList.length;i++)
        {
            set.add(wordList[i]);
        }
        set.remove(beginWord);
        q.add(list);
        ArrayList<String> delete=new ArrayList<>();
        while(!q.isEmpty())
        {
            ArrayList<String> temp=q.remove();
            // System.out.println(temp+" "+prevLevel+" "+temp.size());
            ArrayList<String> newList=null;
            String stringData=temp.get(temp.size()-1);
            
            
            if(temp.size()>prevLevel)
            {
                for(int i=0;i<delete.size();i++)
                {
                    set.remove(delete.get(i));
                }
                prevLevel++;
            }
            
            // not so special code snippet
            
            // if (temp.size() > prevLevel) {
            //     prevLevel++;
            //     for (String it: delete) {
            //         set.remove(it);
            //     }
            // }
            
            // System.out.println(set);
            
            
            if(endWord.equals(stringData))
            {
                if(temp.size()<=min)
                {
                    ans.add(temp);
                    min=temp.size();
                }
            }
            
            // not so special code snippet
            
            // if(stringData.equals(targetWord)) {
            //     // the first sequence where we reached the end.
            //     if (ans.size() == 0) {
            //         ans.add(temp);
            //     } else if (ans.get(0).size() == temp.size()) {
            //         ans.add(temp);
            //     }
            // }
            
            // for(int i=0;i<stringData.length();i++)
            // {
            //     for(char j='a';j<='z';j++)
            //     {
            //         String str=stringData.substring(0,i)+j+stringData.substring(i+1);
            //         if(set.contains(str))
            //         {
            //             delete.add(str);
            //             newList=new ArrayList<>(temp);
            //             newList.add(str);
            //             q.add(newList);
            //         }
            //     }
            // }
            
            for (int i = 0; i < stringData.length(); i++) {

                // Now, replace each character of ‘word’ with char
                // from a-z then check if ‘word’ exists in wordList.
                for (char j = 'a'; j <= 'z'; j++) {
                    char replacedCharArray[] = stringData.toCharArray();
                    replacedCharArray[i] = j;
                    String replacedWord = new String(replacedCharArray);
                    if (set.contains(replacedWord) == true) {
                        temp.add(replacedWord);
                        // Java works by reference, so enter the copy of vec
                        // otherwise if you remove word from vec in next lines, it will 
                        // remove from everywhere 
                        newList = new ArrayList < > (temp);
                        q.add(newList);
                        // mark as visited on the level 
                        delete.add(replacedWord);
                        temp.remove(temp.size() - 1);
                    }
                }

            }
        }
        return ans;
    }
}