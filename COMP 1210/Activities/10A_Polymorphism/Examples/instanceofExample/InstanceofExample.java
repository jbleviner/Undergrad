public class InstanceofExample {

   public static void main(String[] args) {
   
      A a = new A();
      B b = new B();
      B2 b2 = new B2();
      C c = new C();
      A aa = new C();
   
      
      if (a instanceof A) {
         System.out.println("a is-an A");
      }
      
      if (a instanceof B) {
         System.out.println("a is-an B");
      }
      
      if (b instanceof B) {
         System.out.println("b is-a B");
      }
      
      if (b instanceof A) {
         System.out.println("b is-an A");
      }
   
      if (b2 instanceof A) {
         System.out.println("b2 is-an A");
      }
      
      if (c instanceof C) {
         System.out.println("c is-a C");
      }
      
      if (c instanceof B) {
         System.out.println("c is-a B");
      }
      
      if (c instanceof A) {
         System.out.println("c is-an A");
      }
      
      if (aa instanceof C) {
         System.out.println("aa is-a C");
      }
      
      if (aa instanceof B) {
         System.out.println("aa is-a B");
      }
      
      if (aa instanceof A) {
         System.out.println("aa is-an A");
      }
   
      // if (b2 instanceof B) {
         // System.out.println("b2 is-an B");
      // }
   }
}

class A {
   double x = 10;
   public A() {
   
   }
}

class B extends A {
   double y = 20;
   public B() {
      super();
   }
}

class B2 extends A {
   double y2 = 22;
   public B2() {
      super();
   }
}

class C extends B {
   double z = 30;
   public C() {
      super();
   }
}
