package hackerrank.problemsolving;

public class SubSequence {
    public static int renameFile(String newName, String oldName) {
        // Write your code here
        int count = 0;
        if (newName != null && oldName != null) {
            if (newName.equals(oldName)) {
                return 1;
            } else {

                for (int i = 0 ; i <= oldName.length(); i++) {
                    for (int j = i + 1; j <= oldName.length(); j++) {
                        //remove 1 char, then 2 chars, then 3 chars .. etc
                        StringBuilder oldStringBuilder = new StringBuilder(oldName);
                        String subString = oldStringBuilder.delete(i,j).toString();
                        if (subString.equalsIgnoreCase(newName)) {
                            count++;
                        }
                    }
                }
            }

        }
        return count;
    }

  public static void main(String[] args) {
    String newName = "abc";
    String oldName = "aaabbbccc";
    System.out.println(renameFile(newName, oldName));
  }
}
