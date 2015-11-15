package Model;
import java.security.*;
import java.math.*;

public class MD5 
{
	MessageDigest m;
	public MD5()
	{
		try
		{
			m= MessageDigest.getInstance("MD5");
		}
		catch(Exception e)
		{
			
		}
	}
	
	public String MD5Encode(String s)
	{
		m.update(s.getBytes(),0,s.length());
		return new BigInteger(1,m.digest()).toString(16);
	}
}