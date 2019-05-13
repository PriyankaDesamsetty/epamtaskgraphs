
import java.util.*;
public class roadsandlibraries {
    static long totcost=0;
static long find(int n,int m,long cl,long cr,ArrayList<TreeSet<Integer>> adj)
{if(cl<=cr || m==0)
    return cl*n;

    boolean visited[]=new boolean[n];
    for(int i=0;i<n;i++)
    {
        if(!visited[i])
        {totcost+=cl;
            dfs(i,cr,adj,visited);
        }
    }
return totcost;
}
static void dfs(int i,long cr,ArrayList<TreeSet<Integer>> adj,boolean visited[])
{
    visited[i]=true;
    Iterator<Integer> it=adj.get(i).iterator();
while(it.hasNext())
{
 int k=it.next();   
        if(!visited[k])
        {
       //System.out.println(totcost);
            totcost+=cr;
            dfs(k,cr,adj,visited);
        }
}   
}
    public static void main(String[] args) {
        // TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
//int  tot;
while(t-->0)
{
ArrayList<TreeSet<Integer>> adj=new ArrayList<TreeSet<Integer>>();
int n=sc.nextInt();
int m=sc.nextInt();
long cl=sc.nextInt();
long cr=sc.nextInt();
for(int i=0;i<n;i++)
 adj.add(new TreeSet<Integer>());
for(int i=0;i<m;i++)
{int u=sc.nextInt()-1;
int v=sc.nextInt()-1;
    adj.get(u).add(v);
    adj.get(v).add(u);
}
System.out.println(find(n,m,cl,cr,adj));
totcost=0;
}
    }

}
