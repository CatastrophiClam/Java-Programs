package dataStructures;
import java.util.*;

class Holder<T>{
	
}

public class Vault <T>{
	private HashMap<Integer, ArrayList<HashSet<Object>>> keys;
	private HashMap<HashSet<Object>, T> storage;
	
	{
		keys = new HashMap<Integer, ArrayList<HashSet<Object>>>();
		storage = new HashMap<HashSet<Object>, T>();
	}
	
	public Vault(){
		
	}
	
	public boolean put(T object, Object... keys){
		int combKey = 0;
		HashSet<Object> key = new HashSet<Object>();
		for (Object i:keys){
			combKey += i.hashCode();
			key.add(i);
		}
		if (!this.keys.containsKey(combKey)){
			this.keys.put(combKey, new ArrayList<HashSet<Object>>());
		}
		this.keys.get(combKey).add(key);
		storage.put(key, object);
		return true;
	}
	
	public boolean contains(Object...keys){
		int combKey = 0;
		for (Object i:keys){
			combKey+=i.hashCode();
		}
		if (this.keys.containsKey(combKey)){
			outer:
			for (HashSet<Object>i:this.keys.get(combKey)){
				if (keys.length==i.size()){
					for (Object j:keys){
						if (!i.contains(j)){
							continue outer;
						}
					}
					return true;
				}
			}
		}
		return false;
	}
	
	public T get(Object...keys){
		int combKey = 0;
		for (Object i:keys){
			combKey+=i.hashCode();
		}
		if (this.keys.containsKey(combKey)){
			outer:
			for (HashSet<Object>i:this.keys.get(combKey)){
				if (keys.length==i.size()){
					for (Object j:keys){
						if (!i.contains(j)){
							continue outer;
						}
					}
					return storage.get(i);
				}
			}
		}
		return null;
	}
}
