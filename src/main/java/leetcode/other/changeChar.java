package leetcode.other;

/**
��Сдת��
**/
public class changeChar{
	
	public static void main(String[] args){
		StringBuffer str1 = new StringBuffer();
		String str2 = "sdfhSDFHGgsdroggdlkjSERTGS";
		char c[] str2.toCharArray();
		for(int i=0;i<str2.length();i++){
			char ch = c[i];
			if(Character.isUpperCase(ch)){
				c[i] = Character.toLowerCase(ch);
			}else if(Character.isTitleCase(ch)){
				c[i] = Character.toLowerCase(ch);
			}else if(Character.isLowerCase(ch)){
				c[i] = Character.toUpperCase(ch);
			}
		}
		return new String(c);
		
	}
	
	
	
}