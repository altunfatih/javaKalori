package JavaProje;

import java.util.Scanner;

public class Main {

		
	static Baglanti db=new Baglanti();
	static Scanner tarayici = new Scanner(System.in);
	public static String isim= null;
	public static void main(String[] args) {
		try {
			System.out.println("Ýsim Giriniz: ");
			isim=tarayici.next();
			System.out.println("Sayin "+isim+" Saðlýklý Beslenme Programýna Hoþgeldin..."
					+ "\nNe Yapmak Ýstersiniz? "
					+ "\n1)Aldýðýn Besin Deðerlerini Hesapla "
					+ "\n2)Yemek Listesini Göster");
			int secenek = tarayici.nextInt();
			switch (secenek) {
			case 1:
				Hesaplama.besinHesapla();
				break;
			case 2:
				Hesaplama.yemekGoster();
				break;
			default:
				System.out.println("HATALI GIRIS PROGRAM KAPANIYOR");
			}
		}
		catch(Exception e)
		{
			System.out.println("HATA: " + e.getMessage());
		}
		

	}

}
