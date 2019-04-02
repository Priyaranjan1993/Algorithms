package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] courseMatrix = new int[numCourses][numCourses];
		int[] inDegree = new int[numCourses];

		for(int i = 0; i< prerequisites.length; i++)
		{
			int course = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if(courseMatrix[pre][course] == 0)
			{
				inDegree[course]++;
			}
			courseMatrix[pre][course] = 1;
		}

		Queue<Integer> queue = new LinkedList<>();

		for(int j = 0; j < numCourses; j++)
		{
			if(inDegree[j] == 0)
			{
				queue.offer(j);
			}
		}
		int count = 0;
		while(!queue.isEmpty())
		{
			int preReq =queue.poll();
			count++;
			for(int k = 0; k < numCourses; k++)
			{
				if(courseMatrix[preReq][k] != 0)
				{
					if(--inDegree[k] == 0)
					{
						queue.offer(k);
					}
				}
			}

		}
		return count == numCourses;
	}

	public static void main(String args[])
	{
		CourseSchedule c = new CourseSchedule();
		int numCourses = 3;
		int[][] prerequisites = new int[][] {{2,0},{2,1}};
		System.out.println(c.canFinish(numCourses, prerequisites));
	}
}
