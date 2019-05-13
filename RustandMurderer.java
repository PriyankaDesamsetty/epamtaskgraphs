
import java.util.*;

public class RustandMurderer {
	static int v;
	static int dist[];

	RustandMurderer(int v) {
		this.v = v;
		dist = new int[v];
	}

	public static void find(int source, HashMap<Integer, HashSet<Integer>> h) {
		HashSet<Integer> notvisited = new HashSet<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int i = 1; i <= v; i++)
			notvisited.add(i);
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(source);
		notvisited.remove(source);
		// System.out.println(source-1+" "+dist[source-1]);
		dist[source - 1] = 0;
		while (!q.isEmpty()) {
			int u = q.poll();
			for (int vertex : notvisited) {
				if (h.get(u) == null || !h.get(u).contains(vertex)) {
					dist[vertex - 1] = dist[u - 1] + 1;
					visited.add(vertex);
					q.add(vertex);
				}
			}
			notvisited.removeAll(visited);
			visited = new HashSet<Integer>();

		}

		for (int i = 0; i < v; i++) {
			if (i != source - 1) {
				System.out.print(dist[i] + " ");
			}
		}
		System.out.println();

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		while (testcases-- > 0) {

			int cities = sc.nextInt();
			int roads = sc.nextInt();
			HashMap<Integer, HashSet<Integer>> map = new HashMap<Integer, HashSet<Integer>>();
			new RustandMurderer(cities);
			for (int i = 0; i < roads; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				if (map.containsKey(u))
					map.get(u).add(v);
				else {
					HashSet<Integer> connectroads = new HashSet<Integer>();
					connectroads.add(v);
					map.put(u, connectroads);
				}
				if (map.containsKey(v))
					map.get(v).add(u);
				else {
					HashSet<Integer> connectroad = new HashSet<Integer>();
					connectroad.add(u);
					map.put(v, connectroad);
				}

			}
			int source = sc.nextInt();

			find(source, map);
		}
	}
}
