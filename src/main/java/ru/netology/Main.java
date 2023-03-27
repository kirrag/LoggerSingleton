package ru.netology;

import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Main {
	static Scanner in = new Scanner(System.in);
	static Random rnd = new Random();

	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		List<Integer> result = new ArrayList<>();
		logger.log("Запускаем программу");
		logger.log("Просим пользователя ввести входные данные для списка");
		System.out.print("Введите размер списка: ");
		int n = in.nextInt();
		System.out.print("Введите верхнюю границу для значений: ");
		int m = in.nextInt();
		logger.log("Создаём и наполняем список");
		List<Integer> rndlist = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			rndlist.add(rnd.nextInt(m));
		}
		System.out.print("Вот сулчайный список: ");
		for (int i = 0; i < n; i++) {
			System.out.print(rndlist.get(i) + " ");
		}
		System.out.println();
		logger.log("Просим пользователя ввести входные данные для фильтрации");
		System.out.print("Введите порог для фильтра: ");
		int f = in.nextInt();
		logger.log("Запускаем фильтрацию ");
		Filter filter = new Filter(f);
		result = filter.filterOut(rndlist);
		logger.log("Выводим результат на экран");
		System.out.print("Отфильтрованный список: ");
		for (int i : result) {
			System.out.print(i + " ");
		}
		System.out.println();
		logger.log("Завершаем программу");
	}
}
