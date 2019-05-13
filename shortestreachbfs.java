package fsgraphsandhashing;
import java.util.*;
public class shortestreachbfs {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
while(t-->0)
{
int n=sc.nextInt();
int m=sc.nextInt();
ArrayList<TreeSet<Integer>> adj=new ArrayList<>();
for(int i=0;i<n;i++)
     adj.add(new TreeSet<Integer>());
for(int i=0;i<m;i++)
{
    int u=sc.nextInt()-1;
    int v=sc.nextInt()-1;
    adj.get(u).add(v);
    adj.get(v).add(u);
}
int s=sc.nextInt()-1;
int d[]=new int[n];
Arrays.fill(d,-1);
Queue<Integer> q=new LinkedList<>();
q.add(s);
d[s]=0;
while(!q.isEmpty())
{
    int k=q.poll();
    Iterator<Integer> it=adj.get(k).iterator();
    while(it.hasNext())
    {
        int el=it.next();
        if(d[el]==-1)
        {q.add(el);
            d[el]=d[k]+6;
        }
    }
}
for(int i=0;i<n;i++)
{if(i!=s)
    System.out.print(d[i]+" ");
}
//System.out.println(d);
    System.out.println();
    }

}
}