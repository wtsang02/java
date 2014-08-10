package com.wtsang.java.swing.application.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class MapListUtil {
	
	public static <K, T> Map<K,List<T>> add(Map<K,List<T>> map,K key,T newListItem){
		if(map.containsKey(key)){
			List<T> entry=map.get(key);
			entry.add(newListItem);
			map.put(key, entry);
		}else{
			List<T> list= new ArrayList<T>();
			list.add(newListItem);
			map.put(key,list);
		}
		
		return map;
		
		
	}
	/**
	 * This operation will make map list lose the key.
	 * @param map
	 * @return
	 */
	public static <K,T> Object[] mapListToArray(Map<K,List<T>> map){
		Set<Entry<K, List<T>>> set= map.entrySet();
		Iterator<Entry<K, List<T>>> it=set.iterator();
		List<T> completeList=new ArrayList<T>();
		while(it.hasNext()){
			List<T> list= it.next().getValue();
			if(list!=null){
				
				completeList.addAll(list);
				
			}
		}
		
		return completeList.toArray();
	}

}
