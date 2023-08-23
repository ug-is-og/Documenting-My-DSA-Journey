// HashMap, LinkedHashMap wagera lagake sab dekh liya iss question mein koi si bhi approach kaam nahi kar ri....but ek cheez seekh gaye ki hashmap ko sort kaise karte hai based on its value 
// meine hashmap mein basically yeh approach lagayi thi ki pehle frequency nikal lo characters ke corresponding, uske baad based on frequency sort karlo using below link
// https://www.digitalocean.com/community/tutorials/sort-hashmap-by-value-java
// uske baad do do baar kaata marte jao aur wapas start se continue karte jao, agar at any point ansstring ka last character matches incoming string toh return "" else banate jao, while(true) wale loop ko tab break karo jab saare characters in hashmap ki frequency 0 ho jaaye

// 56/70 passed

// fffps

// f=3, p=1,s=1 ans=""
// f=2,p=0,s=1 ans=fp
// f=1,p=0,s=0 ans=fpfs
// f=0,p=0,s=0 ans=fpfsf toh sahi ho gaya

// won't work for this test case
// "ogccckcwmbmxtsbmozli"
// before sorting
//{b=2, c=4, g=1, i=1, k=1, l=1, m=3, o=2, s=1, t=1, w=1, x=1, z=1}
// after sorting 
// {c=4, m=3, b=2, o=2, g=1, i=1, k=1, l=1, s=1, t=1, w=1, x=1, z=1}
// expected: "cocgcickmlmsmtbwbxoz"

// dekh tune approach dimaag wali lagaayi hai par yeh hamesha kaam nahi karegi, since ek input ke liye kaafi possible outputs ho re iss liye 56 test cases ke liye chal gaya, baakiyo ke liye nahi chala because there is some loop hole in the approach, wahi figure out karna hai

// chinta mat kar kaafi sahi socha tha tune, but abhi aur practice baaki hai for that perfection level

// Let's look at a new approach

// ab ham jo approach dekhne ja re hai priority queue ke through that is very similar to above approach, bas yahi th ki data structures banaye hi iss liye gaye hai ki zaada maath mat maaro, toh thoda carefully utilize karo DS ko

// Priority Queue Approach
// Pepcoding : https://www.youtube.com/watch?v=D_jE64CJ5UE&t=593s
 
class Solution {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        // to ensure that its a max heap based on values of pairs
        PriorityQueue<Pair<Character,Integer>> pq=new PriorityQueue<>((pair1,pair2)->pair2.getValue()-pair1.getValue());
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        pq.add(new Pair<>(entry.getKey(),entry.getValue()));
        Pair<Character,Integer> block=pq.remove();
        String ans="";
        ans=ans+block.getKey();
        block=new Pair<>(block.getKey(),block.getValue()-1);
        while(pq.size()>0)
        {
            Pair<Character,Integer> temp=pq.poll();
            ans=ans+temp.getKey();
            temp=new Pair<>(temp.getKey(),temp.getValue()-1);
            if(block.getValue()>0)
            pq.add(block);
            block=temp;
        }
        if(block.getValue()>0)
        return "";
        return ans;
    }
}