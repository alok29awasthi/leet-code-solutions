/* Course Schedule */

class Solution {
    List<Integer>[] adj;
    boolean[] visited;
    boolean[] marked;
    public boolean canFinish(int numCourses, int[][] pre) {
        adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        visited = new boolean[numCourses];
        marked = new boolean[numCourses];

        for(int i=0; i<pre.length; i++) {
            adj[pre[i][0]].add(pre[i][1]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(isCyclic(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean isCyclic(int i) {
        visited[i] = true;
        for(Integer j: adj[i]) {
            if(!visited[j]) {
                if(isCyclic(j)) {
                    return true;
                }
            } else if(!marked[j]) {
                return true;
            }
        }
        marked[i] = true;
        return false;
    }
}

/*
Let's illustrate how this code works with an example:

Suppose you have the following course prerequisites:

numCourses = 4
prerequisites = [[1, 0], [2, 1], [3, 2]]
We initialize the adjacency list based on the prerequisites:

adj[0] = []  // No prerequisites for course 0
adj[1] = [0] // Course 1 depends on course 0
adj[2] = [1] // Course 2 depends on course 1
adj[3] = [2] // Course 3 depends on course 2
We start with course 0 and perform a DFS to check for cycles. We mark nodes as "visited" when we visit them.

We visit course 0, mark it as visited, and see that it has no prerequisites.
We visit course 1, mark it as visited, and see that it depends on course 0. So, we visit course 0 and find that it's already visited. We mark course 0 as "marked" and return to course 1.
We visit course 2, mark it as visited, and see that it depends on course 1. We visit course 1, which is already marked. We detect a cycle, so we return false.
Since we detected a cycle when checking course 2, we return false. This means it's not possible to finish all courses given the prerequisites.

The code efficiently uses DFS to detect cycles in the course dependency graph. If a cycle is found, it returns false, indicating that it's impossible to finish all the courses. Otherwise, it returns true, meaning all courses can be completed.
*/
