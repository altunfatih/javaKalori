package JavaProje;

import java.util.Scanner;

public class Main {

		
	static Baglanti db=new Baglanti();
	static Scanner tarayici = new Scanner(System.in);
	public static String isim= null;
	public static void main(String[] args) {
		try {
			System.out.println("�sim Giriniz: ");
			isim=tarayici.next();
			System.out.println("Sayin "+isim+" Sa�l�kl� Beslenme Program�na Ho�geldin..."
					+ "\nNe Yapmak �stersiniz? "
					+ "\n1)Ald���n Besin De�erlerini Hesapla "
					+ "\n2)Yemek Listesini G�ster");
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
