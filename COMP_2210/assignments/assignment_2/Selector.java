import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Kevin Bumgarner (kgb0022@auburn.edu)
 * @author  Dean Hendrix (dh@auburn.edu)
 * @version February 7th, 2020
 *
 */
public final class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
   private Selector() { }


   /**
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      } else if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      Iterator<T> itr = coll.iterator();
      T min = itr.next();
      for (T elm : coll) {
         if (comp.compare(elm, min) < 0) {
            min = elm;
         }
      }
      return min;
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      } else if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      Iterator<T> itr = coll.iterator();
      T max = itr.next();
      for (T elm : coll) {
         if (comp.compare(elm, max) > 0) {
            max = elm;
         }
      }
      return max;
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
   
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      } else if (coll.isEmpty() || k < 1) {
         throw new NoSuchElementException();
      }
   
      List<T> myList = new ArrayList<T>(coll);
      java.util.Collections.sort(myList, comp);
      T kMin = myList.get(0);
      int count = 1; 
      for (T elm : myList) {
         if (comp.compare(elm, kMin) != 0) {
            kMin = elm;
            count++;
         }
         if (count == k) {
            return kMin;
         }
      } 
     // Will run if k > distinct elements or k > number of elements
      throw new NoSuchElementException();
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      } else if (coll.isEmpty() || k < 1) {
         throw new NoSuchElementException();
      }
      List<T> myList = new ArrayList<T>(coll);
      java.util.Collections.sort(myList, comp);
      T kMax = myList.get(myList.size() - 1);
      int count = 1; 
      for (int i = myList.size() - 1; i >= 0; i--) {
         if (comp.compare(myList.get(i), kMax) != 0) {
            kMax = myList.get(i);
            count++;
         }
         if (count == k) {
            return kMax;
         }
      }   
     // Will run if k > distinct elements or k > number of elements
      throw new NoSuchElementException();
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                         Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      } else if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      List<T> myList = new ArrayList<T>();
      for (T elm : coll) {
         if ((comp.compare(elm,low) >= 0) && (comp.compare(elm,high) <= 0)) {
            myList.add(elm);
         }
      }
      if (myList.isEmpty()) {
         throw new NoSuchElementException();
      }    
      return myList;
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      } else if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }        
      T ceiling = max(coll, comp);
      boolean qualified = false;
      for(T elm : coll) {
         if (comp.compare(elm, key) >= 0 && comp.compare(elm, ceiling) <= 0) {
            ceiling = elm;
            qualified = true;
         }
      }             
      if (!qualified) {
         throw new NoSuchElementException();
      }      
      return ceiling;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      if (coll == null || comp == null) {
         throw new IllegalArgumentException();
      } else if (coll.isEmpty()) {
         throw new NoSuchElementException();
      }
      
      T floor = min(coll, comp);
      boolean qualified = false;
      for(T elm : coll) {
         if (comp.compare(elm, key) <= 0 && comp.compare(elm, floor) >= 0) {
            floor = elm;
            qualified = true;
         }
      }      
      if (!qualified) {
         throw new NoSuchElementException();
      }       
      return floor;
   }

}
