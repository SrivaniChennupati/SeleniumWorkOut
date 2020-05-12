package JavaPractice;


import java.util.LinkedHashMap;
import java.util.Map;

public class OccuranceOfChar {

	public static void main(String[] args) {
		
		String S = "You have no choice other than following me!" ;
		
		char[] ch = S.toCharArray();
		
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		
		for (char c : ch) {
			
			
			if (map.containsKey(c))
				
			{
				Integer integer = map.get(c);
				
				map.put(c, integer+1);
				
			}
			
			else
				
			{
				
				map.put(c, 1);
			}
			
			
			
		}
		
		
		System.out.println(map);
		

	}

}
