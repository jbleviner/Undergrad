public interface TwoDShape2 {

   public int getNumberSides();
   
   public double getPerimeter();
   
 
   /** 
    * An interface may contain static methods including their bodies,
    * which are inherited by an implementing class. 
    */
   static int myStaticMethod() {
      System.out.println("this is allowed!");
      return 0;
   }

   /** 
    * An interface may contain "default" instance methods including their bodies, 
    * which are inherited by an implementing class. 
    */
   default public double getPerimeterX() {
      return 0; // or something useful;
   }
}