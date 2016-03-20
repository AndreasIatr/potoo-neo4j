package potoo.utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DataStructureUtils {
	
	public static <T> Set<T> toSet(Iterable<T> iterable) {
		Set<T> set = new HashSet<>();
		iterable.forEach(set::add);
		return set;
	}
	
	public static <T> Map<String, Set<T>> toMap(String collectionName, Iterable<T> iterable) {
		Map<String, Set<T>> theMap = new HashMap<>();
		theMap.put(collectionName, toSet(iterable));
		return theMap;
	}
}