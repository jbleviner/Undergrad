public class CreditCards {


   public static void main(String[] args) {
   
   
      SapphireCardholder sc = new SapphireCardholder("10001", "Smith, Sam"); 
      sc.addPurchases(34.5, 100.0, 63.50, 350.0); 
      sc.setPrevBalance(1200.0);
      sc.setPayment(200);
      System.out.println(sc + "\n");
      
      DiamondCardholder dc = new DiamondCardholder("10002", "Jones, Pat"); 
      dc.addPurchases(34.5, 100.0, 63.50, 300.0); 
      dc.setPrevBalance(1200.0);
      System.out.println(dc + "\n");
      
      BlueDiamondCardholder bdc = new BlueDiamondCardholder("10003", "King, Kelly"); 
      bdc.addPurchases(34.5, 100.0, 63.50, 300.0, 100.0); 
      bdc.setPrevBalance(1200.0);
      System.out.println(bdc + "\n");
      
      BlueDiamondCardholder bdc2 = new BlueDiamondCardholder("10004", "Jenkins, Jordan"); 
      bdc2.addPurchases(5000.0, 1000.0, 4000.0);
      bdc2.setPrevBalance(1200.0);
      System.out.println(bdc2 + "\n");
      
      
      SapphireCardholder s = new SapphireCardholder("10005", "bum, Kevin");
      s.addPurchases(1, 2, 3, 4, 5, 6, 88, 100, 33.5);
      System.out.println(s.getPurchases());
      
   }
}