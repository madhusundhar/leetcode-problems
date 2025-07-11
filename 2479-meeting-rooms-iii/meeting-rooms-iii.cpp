class Solution {
public:
    int mostBooked(int n, vector<vector<int>>& meetings) {
        sort(meetings.begin(), meetings.end());
        
        priority_queue<int, vector<int>, greater<int>> free;
        for (int i = 0; i < n; i++) free.push(i);
        
        priority_queue<pair<long long, int>, vector<pair<long long, int>>, greater<>> occupied;
        
        vector<int> count(n, 0);

        for (auto& meet : meetings) {
            long long start = meet[0], end = meet[1];
            while (!occupied.empty() && occupied.top().first <= start) {
                free.push(occupied.top().second);
                occupied.pop();
            }

            if (!free.empty()) {
                int room = free.top(); free.pop();
                count[room]++;
                occupied.push({end, room});
            } else {
                auto [freeAt, room] = occupied.top(); occupied.pop();
                count[room]++;
                occupied.push({freeAt + (end - start), room});
            }
        }
        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) maxRoom = i;
        }

        return maxRoom;
    }
};