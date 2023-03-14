//Chloe Cho
import java.util.*;

public class WebNode<anyType>{
   private String name;
   private List<String> neighbors;
   private anyType value;
   
   public WebNode(String n, List<String> nei, anyType v){
      name = n;
      neighbors = nei;
      value = v;
   }
   
   public boolean addNeighbor(String n){
      neighbors.add(n);
      return true;
   }
   
   public boolean addNeighbors(List<String> nei){
      for(int i = 0 ; i< nei.size(); i++){
         neighbors.add(nei.get(i));
      }
      return true;
   }
   
   public String getName(){
      return name;
   }
   public List<String> getNeighbors(){
      return neighbors;
   }
   
   public anyType getValue(){
      return value;
   }
   
   public boolean isBordering(String n){
      for(int i = 0; i<neighbors.size(); i++){
         if(neighbors.get(i).equals(n)){
            return true;
         }
      }
      return false;
   }
   
   public int numNeighbors(){
      return getNeighbors().size();
   }
   
   public boolean removeNeighbor(String n){
      for(int i = 0; i<neighbors.size(); i++){
         if(neighbors.get(i).equals(n)){
            neighbors.remove(i);
            return true;
         }
      }
      return false;
   
   }
   public void setName(String n){
      name = n;
   }
   
   public void setNeighbors(List<String> nei){
      neighbors = nei;
   }
   
   public void setValue(anyType v){
      value = v;
   }
   public String toString(){
      String print = "";
      for(int i = 0; i<neighbors.size(); i++){
         if(i == neighbors.size()-1){
            print += neighbors.get(i);
         }
         else{
            print += neighbors.get(i) + ", ";
         } 
      }
      return print;
   }
}