package dev.puzzles.geek4geeks;

public class Edit1Problem {

  boolean is2StringOneByEdit(String s1, String s2) {

    boolean finale = false;

    char a[] = s1.toCharArray();
    char b[] = s2.toCharArray();

    if (Math.abs(a.length - b.length) > 1) {
      return false;
    }

    if (a.length >= b.length) {
      finale = evaluate(b, a);
    } else {
      finale = evaluate(a, b);
    }

    return finale;
  }

  private boolean evaluate(char[] a, char[] b) {
    int globalcount = 0;
    int count = 0;

    for (int i = 0; i < a.length; i++) {
      if (globalcount > 1) {
        return false;
      }
      if (a[i] - b[i] != 0) {
        globalcount++;
      } else {
        count++;
      }
    }

    if (Math.abs(a.length - count) > 1 || Math.abs(b.length - count) > 1) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    String s1 = "Gaek";
    String s2 = "Geeks";
    Edit1Problem gg = new Edit1Problem();
    System.out.println(gg.is2StringOneByEdit(s1, s2));

    String s3 = "gfg";
    String s4 = "gf";
    Edit1Problem gg1 = new Edit1Problem();
    System.out.println(gg1.is2StringOneByEdit(s3, s4));
  }
}
