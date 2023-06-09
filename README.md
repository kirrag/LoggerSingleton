# LoggerSingleton
Задача «Логгер»
Описание

В этом задании попрактикуемся с шаблоном Singleton (Одиночка). Мы пишем программу, которая будет каждый свой шаг обильно логгировать в консоль, но не напрямую через System.out.println, а через объект-логгер нашего собственного класса-синглтона.
Функционал программы

    Программа здоровается с пользователем, просит ввести два числа: размер списка N и верхнюю границу значений элементов в списке M.
    Программа создаёт список ArrayList из N элементов и заполняет их случайными числами от 0 до M.
    Программа просит пользователя ввести число f для фильтрации списка.
    Программа создаёт объект filter вашего класса Filter, передав в конструктор значение f
    Программа вызывает у filter метод List<Integer> filterOut(List<Integer> list), передавая созданный случайный список в качестве параметра и принимая в качестве ответа список, который идентичен исходному, если пропустить элементы меньше f
    Программа выводит итоговый список на экран и завершает свою работу

Логгер

Каждое действие программы, будь то некорректный ввод пользователем входных данных или решение не добавлять элемент в результирующий список в методе filterOut, должно быть залоггировано. Для этого надо создать синглтон-класс Logger у которого будет метод void log(String msg) для вывода на экран сообщения. Сообщение должно выводиться в формате: [<дата и номер сообщения>] <текст сообщения>, где <номер сообщения> это порядковый номер выводимого логгером сообщения, а <текст сообщения> это значение параметра msg.
Пример запуска

Жирным шрифтом в примере это ввод пользователем данных

    [31.12.2019 15:38:22 1] Запускаем программу
    [31.12.2019 15:38:22 2] Просим пользователя ввести входные данные для списка
    Введите размер списка: 7
    Введите верхнюю границу для значений: 10
    [31.12.2019 15:38:23 3] Создаём и наполняем список
    Вот случайный список: 3 5 5 1 0 3 6
    [31.12.2019 15:38:23 4] Просим пользователя ввести входные данные для фильтрации
    Введите порог для фильтра: 4
    [31.12.2019 15:38:23 5] Запускаем фильтрацию
    [31.12.2019 15:38:23 6] Элемент "3" не проходит
    [31.12.2019 15:38:23 7] Элемент "5" проходит
    [31.12.2019 15:38:23 8] Элемент "5" проходит
    [31.12.2019 15:38:23 9] Элемент "1" не проходит
    [31.12.2019 15:38:23 10] Элемент "0" не проходит
    [31.12.2019 15:38:24 11] Элемент "3" не проходит
    [31.12.2019 15:38:24 12] Элемент "6" проходит
    [31.12.2019 15:38:24 13] Прошло фильтр 3 элемента из 7
    [31.12.2019 15:38:24 14] Выводим результат на экран
    Отфильтрованный список: 5 5 6
    [31.12.2019 15:38:24 15] Завершаем программу

Реализация

    Создайте класс Logger с методом void log(String msg) для логгирования сообщения в консоль описанным выше форматом (для поддержки счётчика сообщений заведите у логгера и инкрементируйте при логгировании числовое поле int num).

public class Logger {
  protected int num = 1;

  public void log(String msg) {
    System.out.println("[" + num++ + "] " + msg);
  }
}

    Примените шаблон Singleton (Одиночка) к классу Logger чтобы во всей программе у этого класса был только один объект, для чего подобно примеру из лекции сделайте конструктор приватным и создайте статичный метод Logger getInstance() для получения одного и того же объекта класса Logger при любом повторном вызове (сам же этот объект храните в статичном приватном поле private static Logger instance).

public class Logger {
  //...

  // В этом поле храним ссылку на тот
  // единственный объект этого класса
  // который будем отдавать пользователям
  private static Logger logger;

  // Запрещаем пользователям пользоваться
  // конструктором нашего класса
  private Logger() {}

  // Пользователи которым нужен объект
  // нашего класса получают всегда один
  // и тот же объект, который мы храним
  // в приватном статичном поле, которое
  // мы заполняем в этом методе если оно
  // до того не было заполнено
  public static Logger getInstance() {
    //...
  }
}

    Создайте класс Filter с конструктором, принимающим параметр f, и методом List<Integer> filterOut(List<Integer> list) для фильтрации списка. Используйте внутри него логгирование (можно как в примере вывода выше), но не передавайте логгер объекту фильтра через параметры, а сделайте Logger logger = Logger.getInstance() прямо там в коде, где он нужен.

public class Filter {
  protected int treshold;

  public Filter(int treshold) {
    this.treshold = treshold;
  }

  public List<Integer> filterOut(List<Integer> source) {
    Logger logger = Logger.getInstance();
    List<Integer> result = new ArrayList<>();
    //..
    return result;
  }
}

    Создайте класс Main, в котором вы будете коммуницировать с пользователем и реализовывать функционал программы, не забывая обильно логгировать свои шаги через написанный вами логгер.

public class Main {
  public static void main(String[] args) {
    Logger logger = Logger.getInstance();
    //...
  }
}

    Для заполнения списка ArrayList случайными числами используйте генератор случайных чисел Random random = new Random() и его метод random.nextInt(maxValue).
    Протестируйте работу программы. Не забывайте про правила форматирования кода (для автоформата можете выделить код в идее и нажать Ctrl+Alt+L).

