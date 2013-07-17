package expression.arithmetic;

import java.util.Stack;

public class EvaluateArithmetic {

	public static Double evalute(String exp) {
		char[] tokens = exp.toCharArray();

		Stack<Double> nums = new Stack<Double>();
		Stack<Character> opts = new Stack<Character>();

		boolean flag = true;
		
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == ' ')
				continue;
			if (tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.') {
				StringBuffer bf = new StringBuffer();
				while (i < tokens.length && tokens[i] >= '0'
						&& tokens[i] <= '9' || i < tokens.length
						&& tokens[i] == '.') {
					bf.append(tokens[i++]);
				}
				nums.push(Double.parseDouble(bf.toString()));
				//System.out.print(nums.peek() + "  ");
			} else if (tokens[i] == '(') {
				opts.push(tokens[i]);
			} else if (tokens[i] == ')') {
				while (opts.peek() != '(') {
					nums.push(baseOpt(opts.pop(), nums.pop(), nums.pop()));
				}
				opts.pop();
			} else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*'
					|| tokens[i] == '/') {
				while (!opts.empty() && hasPre(tokens[i], opts.peek())) {
					nums.push(baseOpt(opts.pop(), nums.pop(), nums.pop()));
				}
				opts.push(tokens[i]);
			} else {
				flag = false;
				break;
			}
		}
		
		if(flag == false){
			System.out.println("illegal input");
			System.exit(0);
		}

		while (!opts.empty()) {
			nums.push(baseOpt(opts.pop(), nums.pop(), nums.pop()));
		}

		return nums.pop();
	}

	public static boolean hasPre(char opt1, char opt2) {
		if (opt2 == '(' || opt2 == ')')
			return false;
		if ((opt1 == '*' || opt1 == '/') && (opt2 == '+' || opt2 == '-'))
			return false;
		else
			return true;
	}

	public static double baseOpt(char opt, double a, double b) {
		switch (opt) {
		case '+':
			return b + a;
		case '-':
			return b - a;
		case '*':
			return b * a;
		case '/':
			if (a == 0)
				throw new UnsupportedOperationException("Cannot divide by zero");
			return b / a;
		}
		return 0;
	}

}
