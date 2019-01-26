import java.util.ArrayList;
import java.util.List;

public class ValidIPAddress {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<String>();
		int len = s.length();
		for(int i = 1; i<4 && i<len-2; i++){
			for(int j = i+1; j<i+4 && j<len-1; j++){
				for(int k = j+1; k<j+4 && k<len; k++){
					String s1 = s.substring(0,i), s2 = s.substring(i,j), s3 = s.substring(j,k), s4 = s.substring(k,len);
					System.out.println(s1+"\t"+s2+"\t"+s3+"\t"+s4);
					if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
						System.out.println("TRUE");
						res.add(s1+"."+s2+"."+s3+"."+s4);
					}
				}
			}
		}
		return res;
	}
	public boolean isValid(String s){
		if(s.length()>3 || s.length()==0 || (s.charAt(0)=='0' && s.length()>1) || Integer.parseInt(s)>255)
			return false;
		return true;
	}
	
	public static void main(String args[])
	{
		ValidIPAddress ip = new ValidIPAddress();
		List<String> res = new ArrayList<String>();
		res = ip.restoreIpAddresses("25525511135");
		for(String s : res)
		{
			System.out.println(s);
		}
	}
}
