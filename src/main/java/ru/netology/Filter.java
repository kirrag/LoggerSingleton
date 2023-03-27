package ru.netology;

import java.util.List;
import java.util.ArrayList;

public class Filter {
	protected int treshold;

	public Filter(int treshold) {
		this.treshold = treshold;
	}

	public List<Integer> filterOut(List<Integer> source) {
		Logger logger = Logger.getInstance();
		List<Integer> result = new ArrayList<>();
		int passed = 0;
		int size = source.size();

		for (int i : source) {
			if (i >= treshold) {
				logger.log("Элемент " + i + " проходит");
				result.add(i);
				passed++;
			} else {
				logger.log("Элемент " + i + " не проходит");
			}
		}
		logger.log("Прошло фильтр " + passed + " элемента из " + size);
		return result;
	}
}
