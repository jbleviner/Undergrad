import java.math.BigInteger;
public class BigNumberExample2 {

   public static void main(String[] args) {
      int i = 0, j = 0;
      BigInteger bi = new BigInteger("1000000");
      //for (i = 0; i < 100; i++) {
      for (j = 0; j < 100; j++) {
         bi = bi.multiply(new BigInteger("123456789"));
         System.out.println(bi);
      }
      
      //System.out.println(i + "   " + j + "   " + bi);
      //}
      
      //System.out.println(i + "   " + j + "   " + bi);
      
      java.text.DecimalFormat df = new java.text.DecimalFormat("0,000");
      String biString = df.format(bi);
      System.out.println("\n" +biString);
   }
}