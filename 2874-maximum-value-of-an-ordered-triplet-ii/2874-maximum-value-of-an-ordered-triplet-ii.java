// Solution by Lee215 "[Java/C++/Python] One Pass, O(n)"
// hame basically (nums[i]-nums[j])*nums[k] se deal karna tha 

// toh tum jab apni approach build kar re the tab tumne socha ki nums[i] ko maximize karunga, nums[j] ko minimize karunga and nums[k] ko maximize karunga, jab itni saari cheezein leke chala toh confuse ho gaya ki manage kaise karun

// Lee bhaiya ne bhot smoothly handle kiya, unhone bola ki mein kewal nums[i]-nums[j] pe focus karunga and nums[k] ko multiply karke dekhta jaunga , jo maximum aaya woh store karta rahunga ,

//ab bhai baat ko samjho agar mujhe normally nikalna hota ki nums[i]-nums[j] ki max value kya hai toh mujhe O(n^2) lagta (agar bina sort kare karu, kyunki iss question mein sort nahi kar sakte) par lee bhaiya ne smartness dikhayi ki bhai nums[i] ko maximum rakho at all times, iss ek optimization se tum maximum value of nums[i]-nums[j] nikal loge ek hi pass mein

class Solution {
    public long maximumTripletValue(int[] nums) {
        int maxab=0,maxa=0; // maxab is maximum value of nums[i]-nums[j] and maxa is max value of nums[i]
        long res=0;
        for(int a:nums)
        {
            res=Math.max(res,1L*a*maxab);
            maxab=Math.max(maxab,maxa-a);
            maxa=Math.max(maxa,a);
        }
        return res;
    }
}