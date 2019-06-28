package JavaProje;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Hesaplama {
	static Connection con = Baglanti.baglantiOlustur();
	public static int kalori, yag, karbon, protein;

	public static void yemekGoster() {

		try {
			PreparedStatement prepareStatement = con.prepareStatement("SELECT * FROM yemekler");
			System.out.println("*ID*--*YEMEK*--*KALORÝ*--Protein*--*Yag*---*Karbonhidrat*\n");

			prepareStatement.executeQuery();
			ResultSet rs = prepareStatement.getResultSet();
			while (rs.next()) {
				String yemek = rs.getString("Yemek");
				int kalori = rs.getInt("Kalori");
				int karbonhidrat = rs.getInt("Karbonhidrat");
				int protein = rs.getInt("Protein");
				int yag = rs.getInt("Yag");
				int id = rs.getInt("ID");

				System.out.println(id + " - - " + yemek + " - - " + kalori + " - - " + protein + " - - " + yag + " - - "
						+ karbonhidrat);

			}
			Scanner tarayici = new Scanner(System.in);
			System.out.println("\nHesaplama Ýþlemine Geçmek Ýster Misiniz? // E");
			String hesapla = tarayici.next().toUpperCase();
			if (hesapla.equals("E")) {
				besinHesapla();
			} else {
				System.out.println("Programdan Çýkýlýyor...");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void besinHesapla() {

		try {
			Scanner tarayici = new Scanner(System.in);

			while (true) {
				System.out.print("Yemek Giriniz: ");
				String yemek = tarayici.next().toLowerCase();

				PreparedStatement prepareStatement = con
						.prepareStatement("select * from yemekler where Yemek='" + yemek + "'");

				prepareStatement.executeQuery();
				ResultSet rs = prepareStatement.getResultSet();

				if (rs.next()) {
					kalori += rs.getInt("Kalori");
					karbon += rs.getInt("Karbonhidrat");
					protein += rs.getInt("Protein");
					yag += rs.getInt("Yag");
					System.out.println("DEVAM ETMEK ISTER MISIN // E - DEVAM");
					String devamMi = tarayici.next().toUpperCase();

					if (!devamMi.equals("E")) {
						System.out.println("Aldýgýnýz Besin Degerleri \nKalori:" + kalori);
						System.out.println("Protein:" + protein);
						System.out.println("Yag:" + yag);
						System.out.println("Karbonhidrat:" + karbon);

						int secim = 0;
						System.out.println("\nVeritabanýna Kaydetmek Ýstiyorsanýz 1 ");
						System.out.println("Bilgisayara Kaydetmek Ýstiyorsanýz Herhangi Bir Tuþa Basýnýz");
						secim = tarayici.nextInt();
						if (secim == 1) {
							try {
								prepareStatement = con.prepareStatement("insert into kayit"
										+ "(Kalori, Protein, Yag, Karbonhidrat) " + " values " + "(?,?,?,?)");
								prepareStatement.setInt(1, kalori);
								prepareStatement.setInt(2, protein);
								prepareStatement.setInt(3, yag);
								prepareStatement.setInt(4, karbon);
								prepareStatement.execute();
								System.out.println("KAYIT EKLENDÝ");
								con.close();
								break;
							} catch (Exception e) {
								System.out.println("HATA: " + e.getMessage());
							}
						}

						else {
							Date simdikiZaman = new Date();
							DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
							File file = new File("E:\\Kaloriler.txt");

							try (FileWriter fileWriter = new FileWriter(file)) {
								fileWriter.append("Sayin " + Main.isim);
								fileWriter.append("\nBugun (" + df.format(simdikiZaman)
										+ ") Aldiginiz Besin Deðerleri \nKalori:" + kalori);
								fileWriter.append("\nProtein:" + protein);
								fileWriter.append("\nKarbonhidrat:" + karbon);
								fileWriter.append("\nYag:" + yag);

							} catch (IOException e) {
								System.out.println("Dosya yazma hatasý");
							}
						}

						break;
					}

				} else {
					System.out.println("Veritabaninda böyle bir yemek yok!!");
					System.out.println("Yemek eklemek ister misiniz: E - EVET");
					String devamMi = tarayici.next().toUpperCase();

					if (devamMi.equals("E")) {
						System.out.print("Yemek gir:");
						String yemekIsmi = tarayici.next().toLowerCase();

						System.out.print("Kalori gir:");
						int kalori = tarayici.nextInt();

						System.out.print("Protein gir:");
						int protein = tarayici.nextInt();

						System.out.print("Yag gir:");
						int yag = tarayici.nextInt();

						System.out.print("Karbonhidrat gir:");
						int karbonhidrat = tarayici.nextInt();

						try {
							prepareStatement = con.prepareStatement("insert into yemekler"
									+ "(Yemek, Kalori, Protein, Yag, Karbonhidrat) " + " values " + "(?,?,?,?,?)");
							prepareStatement.setString(1, yemekIsmi);
							prepareStatement.setInt(2, kalori);
							prepareStatement.setInt(3, protein);
							prepareStatement.setInt(4, yag);
							prepareStatement.setInt(5, karbonhidrat);
							prepareStatement.execute();
							System.out.println("KAYIT EKLENDÝ");
							con.close();
							break;
						} catch (Exception e) {
							System.out.println("HATA: " + e.getMessage());
						}
					} else {
						System.out.println("Programdan Çýkýlýyor...");
						break;
					}

				}
			}

		} catch (Exception e) {
			System.out.println("HATA: " + e.getMessage());
		}

	}
}
