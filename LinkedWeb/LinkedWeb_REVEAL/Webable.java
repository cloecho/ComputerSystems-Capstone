//Chloe Cho
import java.util.*;
public interface Webable<anyType>{
   public abstract boolean add(String n, List<String> nei, anyType v);
   public abstract boolean addNeighbors(String n, List<String> nei);
   public abstract boolean areNeighbors(String n, String b);
   public abstract void clear();
   public abstract boolean containsName(String n);
   public abstract WebNode get(String n);
   public abstract WebNode remove(String n);
   public abstract WebNode set(String n, List<String> nei, anyType v);
   public abstract String showUnlinked();
   public abstract int size();
   public abstract Object[] toArray();  
}