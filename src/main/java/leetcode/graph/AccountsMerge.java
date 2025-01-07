package leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

class UnionFind{
    int[] parent;
    int[] rank;

    UnionFind(int length){
        parent = new int[length+1];
        rank = new int[length+1]; //length + 1 so that 0 base and 1 base indexing all is taken care of

        for(int i=0; i<=length; i++){
            parent[i] = i;
            rank[i] = 0;
        }
    }

    void union(int nodeA, int nodeB){
        int nodeAParent = find(nodeA);
        int nodeBParent = find(nodeB);

        if(nodeAParent == nodeBParent){
            return;
        }

        if(rank[nodeAParent] < rank[nodeBParent]){
            parent[nodeAParent] = nodeBParent;
        } else if (rank[nodeBParent] < rank[nodeAParent]) {
            parent[nodeBParent] = nodeAParent;
        }else {
            parent[nodeBParent] = nodeAParent;
            rank[nodeAParent] = rank[nodeBParent] + 1;
        }
    }

    int find(int node){

        if(parent[node] == node){
            return node;
        }
        parent[node] = find(parent[node]);
        return  parent[node];
    }
}
public class AccountsMerge {

    public static void main(String[] args) {

        String[][] array = new String[][] {{"John","johnsmith@mail.com","john_newyork@mail.com"},{"John","johnsmith@mail.com","john00@mail.com"},{"Mary","mary@mail.com"},{"John","johnnybravo@mail.com"}};
        List<List<String>> accounts = Arrays.stream(array).map(Arrays::asList).collect(Collectors.toList());

        AccountsMerge am = new AccountsMerge();
        List<List<String>> lists = am.accountsMerge(accounts);
        System.out.println("\n" + lists);

    }

    public List<List<String>> accountsMerge(List<List<String>> accounts){

        UnionFind unionFind = new UnionFind(accounts.size());

        //first map all the emails to its index
        Map<String, Integer> mailToIndexMap = new HashMap<>();

        for(int i=0; i<accounts.size(); i++){
            for(int j=1; j<accounts.get(i).size(); j++){
                String email = accounts.get(i).get(j);
                if(mailToIndexMap.containsKey(email)){
                    //union previous index and current index so current index ultimate parent will be previous index
                    int previousIndex = mailToIndexMap.get(email);
                    unionFind.union(previousIndex, i);
                }else {
                    //add new email in map
                    mailToIndexMap.put(email, i);
                }
            }
        }

        //take the indexes and collect their mails as per parent index of given index
        Map<Integer, List<String>> indexToEmailsMap = new HashMap<>();
        for (Map.Entry<String, Integer> entry : mailToIndexMap.entrySet()) {
            String mail = entry.getKey();
            int parentIndex = unionFind.find(entry.getValue());
            indexToEmailsMap.putIfAbsent(parentIndex, new ArrayList<>());
            indexToEmailsMap.get(parentIndex).add(mail);
        }

        //Prepare the dataset to return
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : indexToEmailsMap.entrySet()) {
            Integer index = entry.getKey();
            List<String> emails = entry.getValue().stream().sorted().collect(Collectors.toList());
            String name = accounts.get(index).get(0);
            emails.add(0, name);
            mergedAccounts.add(emails);
        }

        return mergedAccounts;
    }
}
