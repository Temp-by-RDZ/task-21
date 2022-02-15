package TRDZ.tasks;

public class Initialization {

	public static void main(String[] args) {
		My_Hash<Product, Integer> hashTable = new My_Hash<>(5);
	//region Проверка добавления
		hashTable.put(new Product(11, "Апельсин"), 150); //1
		hashTable.put(new Product(77, "Банан"), 100); //7
		hashTable.put(new Product(67, "Морковь"), 228); //7
		hashTable.put(new Product(60, "Лимон"), 250); //0
		hashTable.put(new Product(51, "Молоко"), 120); //1
		hashTable.put(new Product(21, "Картошка"), 67); //1
		System.out.println("Занято ячеек - " + hashTable.size());
		hashTable.display();
	//endregion
	//region Проверка вывода и удаления
		System.out.println("Цена картошки =  " + hashTable.get(new Product(21, "Картошка")));
		System.out.println("Цена банана   = " + hashTable.get(new Product(77, "Банан")));
		System.out.println("Цена моркови  = " + hashTable.get(new Product(67, "Морковь")));
		System.out.println(" ");
		System.out.println("Удаление картошки ее цена была "+hashTable.remove(new Product(21, "Картошка")));
		System.out.println("Удаление банана его  цена была "+hashTable.remove(new Product(77, "Банан")));
		System.out.println("Удаление лимона его цена была "+hashTable.remove(new Product(60, "Лимон")));
		System.out.println(" ");
		System.out.println("Занято ячеек - " + hashTable.size());
		hashTable.display();
	//endregion
	//region Проверка вывода и добавления после удаления
		System.out.println("Цена лимона   = " + hashTable.get(new Product(60, "Лимон")));
		System.out.println("Цена банана   = " + hashTable.get(new Product(77, "Банан")));
		System.out.println("Цена моркови  = " + hashTable.get(new Product(67, "Морковь")));
		System.out.println(" ");
		System.out.println("Добавление Лимона и ананаса");
		hashTable.put(new Product(60, "Лимон"), 250);
		hashTable.put(new Product(47, "Ананас"), 69);
		System.out.println(" ");
		System.out.println("Занято ячеек - " + hashTable.size());
		hashTable.display();
	//endregion
		}

	}
