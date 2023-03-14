//Chloe Cho
/*Linked Web: A Dynamically sized container class that can store any 
type of object, and know what other objects is has as neighbors. */
import java.util.List;
import java.util.ArrayList;
/** a Linked-Web. */
public class LinkedWeb<anyType> implements Webable<anyType>
{
/** Data field: collection of Territories of which some share borders. */
   private ArrayList<WebNode<anyType>> board;

   public LinkedWeb(){
      board = new ArrayList<WebNode<anyType>>();
   }
   
   public boolean add(String n, List<String> nei, anyType v){
      if(get(n) != null){
         return false;
      }
      board.add(new WebNode<anyType>(n,nei,v));
      for(int i = 0; i<nei.size(); i++){
         for(int j = 0; j<board.size(); j++){
            if(nei.get(i).equals(board.get(j).getName())){
               if(!board.get(j).isBordering(nei.get(i))){
                  board.get(j).addNeighbor(nei.get(i));
               }
            }
         }
      }
      return true;
   }
   public boolean addNeighbors(String n, List<String> nei){
      WebNode wn = get(n);
      if(wn == null){
         return false;
      }
      else{
         for( int i = 0; i<nei.size(); i++){
            if(!wn.isBordering(nei.get(i))) 
               wn.addNeighbor(nei.get(i));
            for(int j = 0; j<board.size(); j++){
               if(nei.get(i).equals(board.get(j).getName())){
                  if(!board.get(j).isBordering(nei.get(i))){
                     board.get(j).addNeighbor(nei.get(i));
                  }
               }
            }
         }
         return true;
      }
      
   }
   public boolean areNeighbors(String n, String b){
      WebNode webNode1 = get(n);
      WebNode webNode2 = get(b);
      if(webNode1 == null || webNode2 == null){
         return false;
      }
      else{
         return webNode1.isBordering(b);
      }
   }
   public void clear(){
      board.clear();
   }
   public boolean containsName(String n){
      return get(n) != null;
   }
   public WebNode<anyType> get(String n){
      for(int i = 0; i<board.size(); i++){
         if(board.get(i).getName().equals(n)){
            return board.get(i);
         }
      }
      return null;
   }
   public WebNode<anyType> remove(String n){
      WebNode wn = get(n);
      if(wn == null){
         return null;
      }
      else{
         board.remove(wn);
         for(int i =0; i <board.size(); i++){
            if(board.get(i).isBordering(wn.getName())){
               board.get(i).removeNeighbor(wn.getName());
            }
         }
      
      }
      return wn;
   }
   public WebNode<anyType> set(String n, List<String> nei, anyType v){
      WebNode wn = get(n);
      if(wn == null){
         return null;
      }
      else{
         remove(n);
         add(n,nei,v);
         return wn;
      }  
   }
   public String showUnlinked(){
      String temp = "";
      for(int i =0; i<board.size(); i++){
         String start = "[";
         for(int j = 0; j<board.get(i).getNeighbors().size(); j++){
            if(!containsName(board.get(i).getNeighbors().get(j))){
               start += "*"+ board.get(i).getNeighbors().get(j)+"*";              
            }
            else{
               start += board.get(i).getNeighbors().get(j);
            }
            if(j+1 <board.get(i).getNeighbors().size()){
             
               start +=  ", ";
            
            }
         }
         start += "]";
         temp += "NAME: " + board.get(i).getName() + ", Borders:" + start + "\n";
         if(i+1 <board.size()){
            start += "\n";
         }
      }
      return temp;
   }
   public int size(){
      return board.size();
   }
   public Object[] toArray(){
      Object[] temp = new Object[size()];
      for(int i = 0; i<size(); i++){
         temp[i] = board.get(i);
      }
      return temp;
   }

}