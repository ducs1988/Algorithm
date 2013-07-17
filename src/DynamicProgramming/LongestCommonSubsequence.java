package DynamicProgramming;

/*
 * 
 * Given two sequences, find the length of longest subsequence present in both of them.
 * 
 * LCS(m,n) = LCS(m-1,n-1) + 1;
 * LCS(m,n) = Max(LCS(m-1,n),LCS(m,n-1));
 * 
 * base case: LCS(m,n) = 0;
 * 
 * */

public class LongestCommonSubsequence {

	/**
	 * @param args
	 */
	
	public static int LCS(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (X[m-1] == Y[n-1]) {
			return 1 + LCS(X, Y, m-1, n-1);
		} else {
			return Math.max(LCS(X, Y, m-1, n), LCS(X, Y, m, n-1));
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x = "SUNDAYX";
		String y = "SATURDAY";
		
		char[] X = x.toCharArray();
		char[] Y = y.toCharArray();
		
		int result = LCS(X, Y, X.length, Y.length);
		System.out.println("Length of Longest Common Subsequence is " + result);
	}

}
