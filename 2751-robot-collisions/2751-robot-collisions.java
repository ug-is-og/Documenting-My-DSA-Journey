// // iss concept ki aatma clear hai ab mujhe
// import java.util.*;

// class statusOrdering implements Comparator<data>{ // Comparable nahi comparator hoga
//      public int compare(data obj1,data obj2)
//     {
//         return Integer.compare(obj1.position,obj2.position);
//     }
// }
// class data{
//     int position,health;
//     char direction;
//     public data(int position,int health,char direction)
//     {
//         this.position=position;
//         this.direction=direction;
//         this.health=health;
//     }
// }
// class Solution {
//     public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
//         ArrayList<data> status=new ArrayList<>();
//         ArrayList<data> positionOrder=new ArrayList<>();
//         for(int i=0;i<positions.length;i++)
//         {
//             status.add(new data(positions[i],healths[i],directions.charAt(i)));
//         }
//         for(int i=0;i<status.size();i++)
//             positionOrder.add(status.get(i)); // yeh step upar iss liye nahi kiya taaki jo objects status mein daale unka same reference positionOrder mein bhi aa jaye
//         Collections.sort(status,new statusOrdering()); // ek cheez aur dhyan dena...sort hamne kewal status ko kiya hai...positionOrder ko apne pas hi rkaha hai taaki baad mein health after operations ko correct order mein bhej paaye ham log
//         Stack<data> fight=new Stack<>();
//         for(int i=0;i<status.size();i++)
//         {
//             if(status.get(i).direction=='L'&&fight.isEmpty())
//                 fight.push(status.get(i));
//             else if(status.get(i).direction=='R')
//                 fight.push(status.get(i));
//             else if(status.get(i).direction=='L'&&!fight.isEmpty())
//             {
//                 fight.push(status.get(i));
//                 operations(fight);
//             }
//         }
//         List<Integer> health=new ArrayList<>();
//         for(int i=0;i<positionOrder.size();i++)
//         {
//             if(positionOrder.get(i).health!=0)
//                 health.add(positionOrder.get(i).health);
//         }
//         return health;
//     }
//     public void operations(Stack<data> fight)
//     {
//         data temp=fight.pop();
//         data delete=null;
//         while(!fight.isEmpty()&&fight.peek().direction!='L')
//         {
//             if(fight.peek().health==temp.health)
//             {
//                 delete=fight.pop();
//                 delete.health=0;
//                 temp.health=0;
//                 return;
//             }
//             else if(fight.peek().health>temp.health)
//             {
//                 fight.peek().health=fight.peek().health-1;
//                 temp.health=0; // taaki function call complete hone ke baad check kar paaye ki agar object mein health ki value zero hai toh usko apne ans mein include mat karo
//                 return;
//             }
//             else
//             {
//                 delete=fight.pop();
//                 delete.health=0;
//                 temp.health=temp.health-1;
//                 continue;
//             }
//         }
//         fight.push(temp);
//     }
// }




import java.util.*;
class robot{
    int position;
    int health;
    char direction;
    public robot(int position,int health,char direction){
        this.position=position;
        this.health=health;
        this.direction=direction;
    }
}
class ordering implements Comparator<robot>
{
    public int compare(robot a,robot b)
    {
        return a.position-b.position;
    }
}
class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        List<robot> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        HashMap<Integer,robot> map=new HashMap<>();
        for(int i=0;i<positions.length;i++)
        {
            robot obj=new robot(positions[i],healths[i],directions.charAt(i));
            map.put(positions[i],obj);
            list.add(obj);
        }
        Collections.sort(list,new ordering());
        Stack<robot> st=new Stack<>();
        ab: for(int i=0;i<list.size();i++)
        {
            robot b=list.get(i);
            while(st.size()>0&&st.peek().direction=='R'&&b.direction=='L') // very very important yeh while loop hoga not if condition , analyze using this test case
            // position {11,44,16} , health {1,20,17} "RLR"
            {
                robot a=st.peek();
                if(a.health>b.health)
                {
                    a.health=a.health-1;
                    b.health=0;
                    continue ab;
                }
                else if(b.health>a.health)
                {
                    b.health=b.health-1;
                    a.health=0;
                    st.pop();
                }
                else
                {
                    b.health=0;
                    a.health=0;
                    st.pop();
                    continue ab;
                }
            }
            st.push(b);
        }    
        for(int i=0;i<positions.length;i++)
        {
            robot temp=map.get(positions[i]);
            if(temp.health!=0)
            {
                ans.add(temp.health);
            }
        }
        return ans;
    }
}



