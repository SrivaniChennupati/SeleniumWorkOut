package JavaPractice;

public class Palindrome {

	public static void main(String[] args) {
		
		
		String s = "malayalam" ;
		
		int length = s.length();
		
		String Rev = "" ;
		
		
		for (int i= s.length()-1;i>=0;i--)
			
		{
			
			   Rev= Rev+s.charAt(i);
			
			
		}
	 
		 if (s.equals(Rev))
			 
		 {
			 
			 System.out.println(s + "  is a Palindrome");
		 }
		 
		 else
		 {
			 System.out.println(s + "  is not a Palindrome");
			 
		 }
		 

	}

}
