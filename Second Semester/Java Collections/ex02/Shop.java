package ex02;

import java.util.Comparator;

public class Shop {

	public static void main(String[] args) {
		// Shop erzeugen und mit Items füllen
		ShopItem first = new ShopItem("PowerBank", 10.0), second = new ShopItem("HDD", 50.0),
				third = new ShopItem("LED", 25.0), fourth = new ShopItem("Battery", 6.5);

		// --- Hier Code einfügen um Items aufsteigend nach Namen zu sortieren ---
		Comparator<String> sComparator = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		};
		PriorityDeque<String> pdq = new PriorityDeque<>(sComparator);
		pdq.offer(first.getName());
		pdq.offer(second.getName());
		pdq.offer(third.getName());
		pdq.offer(fourth.getName());

		// ----------------------------
		System.out.println("Erwarteter output:");
		System.out.println(fourth.toString());
		System.out.println(second.toString());
		System.out.println(third.toString());
		System.out.println(first.toString());

		// --- Hier code einfügen um Items absteigend nach Preis zu sortieren ---
		Comparator<Double> iComparator = new Comparator<Double>() {

			@Override
			public int compare(Double o1, Double o2) {
				return o1.compareTo(o2);
			}
		};
		PriorityDeque<Double> pq = new PriorityDeque<>(iComparator);

		pq.offer(first.getPrice());
		pq.offer(second.getPrice());
		pq.offer(third.getPrice());
		pq.offer(fourth.getPrice());

		// ----------------------------
		System.out.println("------------------------");
		System.out.println("Erwarteter output:");
		System.out.println(second.toString());
		System.out.println(third.toString());
		System.out.println(first.toString());
		System.out.println(fourth.toString());

	}

}
