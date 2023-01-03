package MaHoa;

import java.security.MessageDigest;

public class MaHoa {
	public static String maHoaMD5(String str) {
		byte[] defaultBytes=str.getBytes();
		try {
			MessageDigest algorithm=MessageDigest.getInstance("MDS");
			algorithm.reset();
			algorithm.update(defaultBytes);
			byte messageDigest[]=algorithm.digest();
			StringBuffer hexString= new StringBuffer();
			for(int i=0; i<messageDigest.length; i++) {
				String hex = Integer.toHexString(messageDigest[i] & 0xFF);
				if (hex.length()==1) {
					hexString.append('0');
				}
				hexString.append(hex);
				
			}
			str= hexString + "";
			
			}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return str;
	}

}
