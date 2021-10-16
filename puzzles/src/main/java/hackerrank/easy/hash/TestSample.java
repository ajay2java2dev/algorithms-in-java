package hackerrank.easy.hash;

public class TestSample {

  public static void main(String[] args) {
    String ab = "ab";
    String bc = "ba";

    System.out.println("TestSample.main --> ab - bc = " + (ab.hashCode() - bc.hashCode()));
    System.out.println("TestSample.main --> ab - bc = " + (bc.hashCode() - ab.hashCode()));

    if (Math.abs(ab.hashCode()) == Math.abs(bc.hashCode())) {
      System.out.println("ab is equals bc");
    }

    String bca = "bca";
    String acb = "acb";

    System.out.println("TestSample.main --> bca - acb = " + (bca.hashCode() - acb.hashCode()));
    System.out.println("TestSample.main --> acb - bca = " + (acb.hashCode() - bca.hashCode()));

    if (Math.abs(bca.hashCode()) == Math.abs(acb.hashCode())) {
      System.out.println("ab is equals bc");
    }
  }
}
