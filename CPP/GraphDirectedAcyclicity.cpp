#include <iostream>
#include <vector>

using std::vector;
using std::pair;

bool isCyclic(vector<vector<int>> &adj, int v, vector<bool> &visited)
{
	if (visited[v])
	{
		return true;
	}
	else
	{
		visited[v] = true;

		for (size_t i = 0; i < adj[v].size(); ++i)
		{
			if (visited[adj[v][i]])
			{
				return true;
			}
			else
			{
				return isCyclic(adj, adj[v][i], visited);
			}
		}
	}
	return false;
}

int acyclic(vector<vector<int>> &adj) {
	//write your code here
	if (adj.empty())
		return 0;

	std::vector<bool> visited(adj.size(), false);

	for (size_t i = 0; i < adj.size(); ++i)
	{
		if (isCyclic(adj, i, visited))
			return 1;
	}
	return 0;
}

int main() {
	size_t n, m;
	std::cin >> n >> m;
	vector<vector<int> > adj(n, vector<int>());
	for (size_t i = 0; i < m; i++) {
		int x, y;
		std::cin >> x >> y;
		adj[x - 1].push_back(y - 1);
	}
	std::cout << acyclic(adj);
}
