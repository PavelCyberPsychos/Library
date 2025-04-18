import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        library.addBook(new Book("Volya k vlasty", "Nicshe", "1214314", 1718, "Philosophy"));
        library.addBook(new Book("Так говорил Заратустра", "Фридрих Ницше", "978-5-02-026966-7", 1883, "Философия"));
        library.addBook(new Book("Преступление и наказание", "Фёдор Достоевский", "978-5-699-71190-5", 1866, "Классическая литература"));
        library.addBook(new Book("Мастер и Маргарита", "Михаил Булгаков", "978-5-699-12434-5", 1967, "Роман"));
        library.addBook(new Book("1984", "Джордж Оруэлл", "978-5-267-00632-9", 1949, "Антиутопия"));
        library.addBook(new Book("Автостопом по галактике", "Дуглас Адамс", "978-5-17-085432-2", 1979, "Научная фантастика"));
        library.addBook(new Book("Гарри Поттер и философский камень", "Джоан Роулинг", "978-5-353-06143-5", 1997, "Фэнтези"));
        library.addBook(new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0618002257", 1954, "Fantasy"));
        library.addBook(new Book("Pride and Prejudice", "Jane Austen", "978-0141439518", 1813, "Classic Literature"));
        library.addBook(new Book("One Hundred Years of Solitude", "Gabriel García Márquez", "978-0061120091", 1967, "Magical Realism"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee", "978-0446310789", 1960, "Classic Literature"));
        System.out.println("нажмите любую кнопку");
        String s = "";
        boolean isAlive = true;
        while (isAlive) {
            System.out.println("Добро пожаловать в систему управления библиотекой!\n" +
                    "\n" +
                    "1.  Добавить книгу\n" +
                    "2.  Удалить книгу\n" +
                    "3.  Найти книгу по ISBN\n" +
                    "4.  Найти книги по автору\n" +
                    "5.  Найти книги по жанру\n" +
                    "6.  Показать все книги\n" +
                    "7.  Взять книгу\n" +
                    "8.  Вернуть книгу\n" +
                    "9.  Выйти\n" +
                    "\n" +
                    "Выберите действие:");
            switch (scanner.nextLine()) {
                case "6":
                    library.displayAllBooks();
                    break;
                case "7":
                    System.out.println("напишите уникальный номер книги:");
                    String ISBN = scanner.nextLine();
                    library.borrowBook(ISBN);
                    break;
                case "9":
                    isAlive = false;
                    break;
                case "8":
                    System.out.println("напишите уникальный номер книги:");
                    String ISBN2 = scanner.nextLine();
                    library.returnBook(ISBN2);
                    break;
                case "2":
                    System.out.println("напишите уникальный номер книги:");
                    library.removeBook(scanner.nextLine());
                    break;
                case "3":
                    System.out.println("напишите уникальный номер книги:");
                    library.findBookByISBN(scanner.nextLine());
            }
        }
    }

}

