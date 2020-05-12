package JavaPractice;

import java.util.LinkedHashMap;
import java.util.Map;

public class Occurance {

	public static void main(String[] args) {
		
		String S = "You have no choice other than following me!" ;
		
		char[] Ch = S.toCharArray();
		
		char Ch1 = 'o' ;
		
		int count = 0;
		
		Map<Character,Integer> map = new LinkedHashMap<Character,Integer>();
		
		for (char c : Ch) {
			
			if (c==Ch1)
				
			{
				
				
				count++ ;
			}
			
		}
			
			map.put(Ch1, count);
			
			System.out.println(map);
		}
		
	}



// 2nd apprOCH 

/*
 * if (Ch[i]=='o')
 * 
 * { count = count+1;
 * 
 * }
 */
//3rd approach

/* replaceAll("[^o]" ,""); */
//store that in variable and print that length of that nothing but Occuarnce//