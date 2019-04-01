package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class EvaluateDivison {
	public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

		Map<String, ArrayList<String>> pairs = new HashMap<>();
		Map<String, ArrayList<Double>> valuePair = new HashMap<>();
		for(int i = 0; i < equations.length; i++ )
		{
			if(!pairs.containsKey(equations[i][0]))
			{
				pairs.put(equations[i][0], new ArrayList<String>());
				valuePair.put(equations[i][0], new ArrayList<Double>());
			}

			if(!pairs.containsKey(equations[i][1]))
			{
				pairs.put(equations[i][1], new ArrayList<String>());
				valuePair.put(equations[i][1], new ArrayList<Double>());
			}

			pairs.get(equations[i][0]).add(equations[i][1]);
			pairs.get(equations[i][1]).add(equations[i][0]);

			valuePair.get(equations[i][0]).add(values[i]);
			valuePair.get(equations[i][1]).add(1/values[i]);

		}

		double[] result = new double[queries.length];

		for(int i =0 ; i < queries.length; i++)
		{
			String[] query = queries[i];
			Set<String> set = new HashSet<>();
			result[i] = dfs(query[0],query[1],pairs,valuePair,set,1.0);
			if(result[i] == 0.0)
			{
				result[i] = -1.0;
			}
		}
		return result;

	}

	private double dfs(String start, String end, Map<String, ArrayList<String>> pairs,
			Map<String, ArrayList<Double>> valuePair, Set<String> set, double val) {
		if(set.contains(start))
		{
			return 0.0;
		}
		if(!pairs.containsKey(start))
		{
			return 0.0;
		}
		if(start.equals(end))
		{
			return val;
		}
		set.add(start);

		ArrayList<String> parList = pairs.get(start);
		ArrayList<Double> valueList = valuePair.get(start);
		double res = 0.0;

		for(int i = 0; i < parList.size(); i++)
		{
			res = dfs(parList.get(i),end,pairs,valuePair,set,val * valueList.get(i));
			if(res != 0.0)
			{
				break;
			}
		}	
		set.remove(start);
		return res;
	}

	public static void main(String args[])
	{
		EvaluateDivison ed = new EvaluateDivison();
		String[][] equations = new String[][] {{"a","b"},{"b","c"}};
		double[] values = new double[] {2.0,3.0};
		String[][] queries = new String[][] {{"a","c"},{"b","a"},{"a","e"},{"a","a"},{"x","x"}};
		double[] result = ed.calcEquation(equations, values, queries);
		for(double val : result)
		{
			System.out.println(val);
		}
	}
}
