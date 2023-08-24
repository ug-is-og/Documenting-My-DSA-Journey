// A typical question of dealing with lots of edge cases
// In such questions, don't go into coding part right off the bat, you first need to write down all possible dge cases carefully and how you are going to deal with them in your code
// Completely brute approach

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> finalList=new ArrayList<>();
        int k=0;
        while(k<words.length)
        {
            int tempWidth=maxWidth;
            String temp="";
            while(tempWidth>=words[k].length())
            {
                temp=temp+words[k];
                tempWidth-=words[k].length();
                k++;
                if(k==words.length)
                {
                    while(tempWidth!=0)
                    {
                        temp=temp+" ";
                        tempWidth-=1;
                    }
                    finalList.add(temp);
                    return finalList;
                }
                if(tempWidth>words[k].length())
                {
                    temp=temp+" ";
                    tempWidth--;
                }
                else if(!temp.contains(" "))
                {
                    while(tempWidth!=0)
                    {
                        temp=temp+" ";
                        tempWidth--;
                    }
                }
                else
                break;
            }
            int currIndex=0;
            while(tempWidth!=0)
            {
                int index=temp.indexOf(' ',currIndex);
                if(index!=-1)
                temp=temp.substring(0,index+1)+" "+temp.substring(index+1);
                else
                {
                    currIndex=0;
                    continue;
                }
                tempWidth-=1;
                while(temp.charAt(index)==' ')
                index++;
                currIndex=index;
            }
            finalList.add(temp);
        }  
        return finalList; 
    }
}


