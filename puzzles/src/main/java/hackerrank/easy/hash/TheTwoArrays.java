package hackerrank.easy.hash;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

//https://www.hackerrank.com/challenges/two-strings
//Test Cases Passed: All (By brute-force couldn't get all cases to pass due to timeout).
// The Set approach + mid return worked great and reduced the overall search.
public class TheTwoArrays {


	// Complete the twoStrings function below.
	static String twoStrings(String s1, String s2) {

		if (s1.length() > 0 && s2.length() > 0) {
			char [] a1 = s1.toCharArray();
			char [] a2 = s2.toCharArray();

			Set<Character> characterSet = new HashSet<>();
			for (char c : a1){
				characterSet.add(c);
			}

			for (char a: a2) {
				if (characterSet.contains(a)) {
					return "YES";
				}
			}

		}
		return "NO";
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			String s1 = scanner.nextLine();

			String s2 = scanner.nextLine();

			String result = twoStrings(s1, s2);

			bufferedWriter.write(result);
			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}
