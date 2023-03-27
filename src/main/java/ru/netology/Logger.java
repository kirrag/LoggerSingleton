package ru.netology;

import java.util.Date;

public class Logger {
	static Date date = new Date();

	protected int num = 1;

	public void log(String msg) {
		System.out.printf("[%1$td.%1$tm.%1$tY %1$tT %2$d] %3$s \n", date, num++, msg);
	}

	// В этом поле храним ссылку на тот
	// единственный объект этого класса
	// который будем отдавать пользователям
	private static Logger logger = null;

	// Запрещаем пользователям пользоваться
	// конструктором нашего класса
	private Logger() {
	}

	// Пользователи которым нужен объект
	// нашего класса получают всегда один
	// и тот же объект, который мы храним
	// в приватном статичном поле, которое
	// мы заполняем в этом методе если оно
	// до того не было заполнено
	public static Logger getInstance() {
		if (logger == null)
			logger = new Logger();
		return logger;
	}
}
