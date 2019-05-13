package fsgraphsandhashing;
import java.util.*;

public class primsspecialsubtree {
static class pair implements Comparable<pair>
{
	int node;
	int val;
	pair(int n,int v)
	{
		node=n;
		val=v;
	}
	public int compareTo(pair p)
	{
		return val<p.val?-1:1;
	}
	public String toString()
	{
		return node+" "+val;
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
ArrayList<ArrayList<pair>> adj=new ArrayList<>();
int n=sc.nextInt();
int m=sc.nextInt();
for(int i=0;i<n;i++)
	adj.add(new ArrayList<pair>());
for(int i=0;i<m;i++)
{
	int u=sc.nextInt()-1;
	int v=sc.nextInt()-1;
	int w=sc.nextInt();
adj.get(u).add(new pair(v,w));
adj.get(v).add(new pair(u,w));
}

int S=sc.nextInt()-1;
int tot=0;
boolean visited[]=new boolean[n];

PriorityQueue<pair> p=new PriorityQueue<pair>();
p.add(new pair(S,0));
//visited[S]=true;

while(p.size()>0)
{
	pair el=p.poll();
//visited[el.node]=true;
if(!visited[el.node])
{
	for(int i=0;i<adj.get(el.node).size();i++)
{
	pair e=adj.get(el.node).get(i);
	if(!visited[e.node])
	{
		p.add(e);
	}
}
	visited[el.node]=true;

	tot+=el.val;
}
}
System.out.println(tot);
	}

}
