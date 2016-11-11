#include <iostream>
#include <algorithm>
#include <vector>

using std::vector;
using std::pair;

void dfs(vector<vector<int> > &adj, vector<int> &used, vector<int> &order, int x) {
	//write your code here
	used[x] = used[x] + 1;
	size_t t = adj.size();

	for (size_t j = 0; j < adj[x].size(); ++j)
	{
		if (used[adj[x][j]] == 0)
		{
			dfs(adj, used, order, t);
		}
	}
	--t;
	order[t] = x;
	return;
}

vector<int> toposort(vector<vector<int>> adj) {
	vector<int> used(adj.size(), 0);
	vector<int> order;
	//write your code here
	for (size_t i = 0; i < adj.size(); ++i)
	{
		if (used[i] > 0)
		{
			dfs(adj, used, order, i);
		}
	}
	return order;
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
	vector<int> order = toposort(adj);
	for (size_t i = 0; i < order.size(); i++) {
		std::cout << order[i] + 1 << " ";
	}
}
