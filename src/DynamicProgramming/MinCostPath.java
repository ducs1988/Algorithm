package DynamicProgramming;

/*
 * 
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], 
 * write a function that returns cost of minimum cost path 
 * to reach (m, n) from (0, 0).
 * 
 * C(m,n)=cost(m,n)+min(C(m-1,n), C(m-1,n-1), C(m,n-1));
 * C(0,0)=cost(0,0);
 * base case: m<0 or n<0, C(m,n)=MAX;
 * 
 * */

public class MinCostPath {
	public static int Cost(int[][] cost, int m, int n) {
		if (m < 0 || n < 0) {
			return Integer.MAX_VALUE;
		}
		if (m == 0 && n == 0) {
			return cost[0][0];
		} else {
			return cost[m][n] + Math.min(Cost(cost, m-1, n), Math.min(Cost(cost, m-1, n-1), Cost(cost, m, n-1)));
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] cost = {{1,2,3},
						{4,8,2},
						{1,5,3}};
		
		System.out.println(Cost(cost, 2, 2));
	}

}
