// Extremely brute force approach, optimize it 

// in my approach, I thought about going ahead with outdegree approach

// class Solution {
//     public List<Integer> eventualSafeNodes(int[][] graph) {
//         int outdegree[]=new int[graph.length];
//         Queue<Integer> q=new LinkedList<>();
//         HashMap<Integer,List<Integer>> map=new HashMap<>();
//         for(int i=0;i<graph.length;i++)
//         {
//             outdegree[i]=graph[i].length;
//             for(int j=0;j<graph[i].length;j++)
//             {
//                 List<Integer> temp=null;
//                 if(!map.containsKey(graph[i][j]))
//                 {
//                     temp=new ArrayList<>();
//                 }
//                 else
//                 {
//                     temp=map.get(graph[i][j]);
//                 }
//                 temp.add(i);
//                 map.put(graph[i][j],temp);
//             }
//             if(outdegree[i]==0)
//             {
//                 q.add(i);
//             }
//         }
//         List<Integer> ans=new ArrayList<>();
//         while(!q.isEmpty())
//         {
//             int temp=q.remove();
//             ans.add(temp);
//             if(map.containsKey(temp))
//             {
//                 for(int i=0;i<map.get(temp).size();i++)
//                 {
//                     outdegree[map.get(temp).get(i)]--;
//                     if(outdegree[map.get(temp).get(i)]==0)
//                     {
//                         q.add(map.get(temp).get(i));
//                     }
//                 }
//             }
//         }
//         Collections.sort(ans);
//         return ans;
//     }
// }


// in striver's approach he has used the method of reversing the direction of all edges in the graph and then following the regular concept of topological sort using indegree

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            list.add(new ArrayList<>());
        }
        int indegree[]=new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                list.get(graph[i][j]).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            if(indegree[i]==0)
            {
                q.add(i);
            }
        }
        while(!q.isEmpty())
        {
            int temp=q.remove();
            ans.add(temp);
            for(int i=0;i<list.get(temp).size();i++)
            {
                indegree[list.get(temp).get(i)]--;
                if(indegree[list.get(temp).get(i)]==0)
                {
                    q.add(list.get(temp).get(i));
                }
            }
        }        
        Collections.sort(ans);
        return ans;
    }
}