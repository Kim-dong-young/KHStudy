package test240730.object1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeMap;

public class MemberController {
	private HashMap<String, Member> map = new HashMap<>();
	
	public boolean joinMembership(String id, Member m) {
		if(!map.containsKey(id)) { // map.get(id) != null 도 가능
			map.put(id, m);
			return true;
		}
		return false;
	}
	
	public String logIn(String id, String password) {
		if(map.containsKey(id) && map.get(id).getPassword().equals(password)) {
			return map.get(id).getName();
		}
		return null;
	}
	
	public boolean changePassword(String id, String oldPw, String newPw) {
		if(map.containsKey(id) && map.get(id).getPassword().equals(oldPw)) {
			map.get(id).setPassword(newPw);
			return true;
		}
		return false;
	}
	
	public void changeName(String id, String newName) {
		if(map.containsKey(id))
			map.get(id).setName(newName);
	}
	
	public TreeMap<String, Member> sameName(String name) {
		TreeMap<String, Member> sameName = new TreeMap<String, Member>(new Comparator<String>() {
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		Set<String> keySet =map.keySet();
		
		for(String key : keySet) {
			Member m = map.get(key);
			if(m.getName().equals(name)) {
				sameName.put(key, m);
			}
		}
		
		/*
		   for(Object key : map.keySet()){
			 	Member m = map.get(key);
				if(m.getName().equals(name)) {
					sameName.put(key, m);
				}
		   }
		 */
		
		return sameName;
	}
}
