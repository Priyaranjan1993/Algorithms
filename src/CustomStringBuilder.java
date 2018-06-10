
public class CustomStringBuilder {

	char c[];
	char c1[];
	int track = 0;

	CustomStringBuilder()
	{
		c = new char[2];
	}

	CustomStringBuilder(String s)
	{
		c = new char[s.length()];
		append(s);
	}

	public void append(String s)
	{
		int stringLength = s.length();
		char temp[] = null;
		if(c1 != null)
		{
			temp = new char[c1.length];
			System.arraycopy(c1, 0, temp, 0, c1.length);
		}
		if(c1 != null)
		{
			c1 = new char[temp.length];
		}
		else {
			c1 = new char[c.length];
		}

		while (c1.length - track <= stringLength)
		{
			c1 = new char[stringLength + c1.length];

		}
		if(temp != null)
		{
			System.arraycopy(temp, 0, c1, 0 ,temp.length);
		}
		else {
			System.arraycopy(c, 0, c1, 0 ,c.length);
		}

		int counter = track;
		int m = 0;
		for(int i= counter; i<= ((counter+stringLength) - 1);i++)
		{
			c1[i] = s.charAt(m);
			m++;
			track ++;
		}
		c = new char[c1.length];
	}

	public String toString() {
		String str = new String(c1);
		return str;

	}
}

class child{

	public static void main(String args[])
	{
		CustomStringBuilder csb = new CustomStringBuilder("My ");
		String str1 = "Hello ";
		String str2 = "Java";
		csb.append(str1);
		csb.append(str2);
		System.out.println(csb);
	}

}
