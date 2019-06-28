package JavaProje;

import java.sql.Connection;
import java.sql.DriverManager;

public class Baglanti {
	public static Connection baglantiOlustur() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/fatih?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Turkey", 
					"root", 
					"root");
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
}
}
