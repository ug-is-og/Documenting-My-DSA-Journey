class data{
    int tweetId;
    int tweetCounter;
    public data(int tweetId,int tweetCounter)
    {
        this.tweetId=tweetId;
        this.tweetCounter=tweetCounter;
    }
}
class ordering implements Comparator<data>{
    public int compare(data d1,data d2){
        return d2.tweetCounter-d1.tweetCounter;
    }
}
class Twitter {
    HashMap<Integer,List<data>> userAndTweets;
    HashMap<Integer,Set<Integer>> followerAndFollowee; // bhot dhyan se dekho yeh set hoga, hamne list use kar li thi pehle and error aa gaya tha 15th test case pe
    int tweetCounter;
    public Twitter() {
        userAndTweets=new HashMap<>();
        followerAndFollowee=new HashMap<>();
        tweetCounter=0;
    }
    
    public void postTweet(int userId, int tweetId) {
        List<data> tweets=null;
        tweetCounter++;
        if(userAndTweets.containsKey(userId))
        {
            tweets=userAndTweets.get(userId);
        }
        else
        {
            tweets=new ArrayList<>();
        }
        tweets.add(new data(tweetId,tweetCounter));
        userAndTweets.put(userId,tweets);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<data> pq=new PriorityQueue<>(new ordering());
        List<Integer> ans=new ArrayList<>();
        if(userAndTweets.containsKey(userId))
        {
            pq.addAll(userAndTweets.get(userId));
        }
        Set<Integer> followees=null;
        if(followerAndFollowee.containsKey(userId))
        {
            followees=followerAndFollowee.get(userId);
            for(int i:followees)
            {
                if(userAndTweets.containsKey(i))
                {
                    pq.addAll(userAndTweets.get(i));
                }
            }
        }
        for(int i=1;i<=10&&!pq.isEmpty();i++)
        {
            ans.add(pq.remove().tweetId);
        }
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followees=null;
        if(followerAndFollowee.containsKey(followerId))
        {
            followees=followerAndFollowee.get(followerId);
        }
        else
        {
            followees=new HashSet<>();
        }
        followees.add(followeeId);
        followerAndFollowee.put(followerId,followees);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees=null;
        if(followerAndFollowee.containsKey(followerId))
        followees=followerAndFollowee.get(followerId);
        else
        return;
        if(followees.contains((Integer)followeeId))
        followees.remove((Integer)followeeId);
        followerAndFollowee.put(followerId,followees);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */