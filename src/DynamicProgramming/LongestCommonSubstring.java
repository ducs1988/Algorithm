package DynamicProgramming;
/*
 * 
 * Given two string 'X' and 'Y', 
 * find the length of the longest common substring.
 * 
 * LCS(m,n) = LCS(m-1, n-1) + 1; if m-1 & n-1 is match
 * or LCS(m,n) = LCS(m-1, n-1);
 * 
 * */
public class LongestCommonSubstring {
	public static int r = -1;
	
	public static int LCStr(char[] X, char[] Y, int idx_x, int idx_y) {
		int[][] LCS = new int[X.length+1][Y.length+1];
		int result = 0;
		
		for (int i=0; i<=X.length; i++) {
			for (int j=0; j<=Y.length; j++) {
				if (i == 0 || j == 0) {
					LCS[i][j] = 0;
				} else if (X[i-1] == Y[j-1]) {
					LCS[i][j] = LCS[i-1][j-1] + 1;
					result = Math.max(result, LCS[i][j]);
				} else {
					LCS[i][j] = 0;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		String x = "SUNDAYX";
		String y = "SATURDAY";
		
		char[] X = x.toCharArray();
		char[] Y = y.toCharArray();
		
		int result = LCStr(X, Y, X.length, Y.length);
		
		System.out.println("Length of Longest Common Substring is " + result);
	}
}
