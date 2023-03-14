//Chloe Cho
import java.util.*;
public class MyStack<anyType>{
   private ArrayList<anyType> s;
   
   public void push(anyType x){
      s.add(0,x);
   }

 /** removes and returns the element at the top of a non-empty stack.
  * @return the value that was removed; returns null if the stack is empty.
  */
   public anyType pop(){
      anyType temp = s.get(0);
      s.remove(0);
      return temp;
   }
        				                 
 /** returns the element at the top of a non-empty stack.
  * @return the element at the top of the stack; returns null if the stack is empty.
  */                                     
   public anyType peek(){
      return s.remove(0);
   }
                         
 /** lets the client know if the stack has any elements or is empty.
  * @return true if the stack is empty; returns false if the stack has elements stored in it.
  */                                     
   public boolean isEmpty(){
      if(s.get(0) == null){
         return true;
      }
      return false;
   }
   
 /** returns the number of logical elements stored in the stack.
 *   @return the number of elements added into the stack.
 */    
   public int size(){
      return s.size();
   }

   
}