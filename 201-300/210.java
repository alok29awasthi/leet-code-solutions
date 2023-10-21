/* Course Schedule II */

class Solution {
    List<Integer>[] adj;
    boolean[] visited;
    boolean[] marked;

    public int[] findOrder(int numCourses, int[][] pre) {
        adj = new ArrayList[numCourses];
        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<pre.length; i++) {
            adj[pre[i][0]].add(pre[i][1]);
        }

        visited = new boolean[numCourses];
        marked = new boolean[numCourses];
        List<Integer> res = new ArrayList<>();

        for(int i=0; i<numCourses; i++) {
            if(!visited[i]) {
                if(isCyclic(i, res)) {
                    return new int[0];
                }
            }
        }

        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    boolean isCyclic(int i, List<Integer> res) {
        visited[i] = true;
        for(Integer j: adj[i]) {
            if(!visited[j]) {
                if(isCyclic(j, res)) {
                    return true;
                }
            } else if(!marked[j]) {
                return true;
            }
        }

        res.add(i);
        marked[i] = true;
        return false;
    }
}

/*
Suppose we have numCourses = 4 and prerequisites = [[1, 0], [2, 0], [3, 1], [3, 2]]. This means course 0 has no prerequisites, course 1 and 2 depend on course 0, and course 3 depends on courses 1 and 2.

Explanation of the Code:

We create an adjacency list representation of the courses, where each course i has a list of courses that depend on it (adj).

We initialize two boolean arrays: visited to track visited nodes and marked to track nodes on the current path being explored.

We create an empty list res to store the course order as we explore the graph.

We iterate through all the courses (0 to numCourses-1) and for each unvisited course, we call the isCyclic function.

The isCyclic function performs a depth-first search (DFS) from the current course i to explore its prerequisites and mark the visited courses.

During the DFS, if we encounter a node that is already marked as visited (visited[j]), it means we've found a cycle, and we return true.

If a cycle is not found, we add the course to the res list and mark it as visited and marked.

If there is no cycle in the entire graph, we return the res list as the valid course order. Otherwise, we return an empty array.

In the given example, the code will produce a valid course order as [0, 1, 2, 3] because the prerequisites [1, 0], [2, 0], [3, 1], and [3, 2] allow us to take courses in this order without violating any prerequisites.

This solution leverages topological sorting and cycle detection in a directed graph to find a valid course order, returning an empty array if it's impossible to finish all courses.
*/
