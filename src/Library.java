import java.util.ArrayList;

public class Library {
    private static ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        if (books.isEmpty()) {
            books.add(book);
            return;
        }
        for (Book b : books) {
            if (b.getISBN().equals(book.getISBN())) {
                System.out.println("Книга с ISBN " + book.getISBN() + " уже существует в библиотеке.");
                throw new RuntimeException();
            }
            books.add(book);
            System.out.println("Книга успешно добавлена в библиотеку");
        }
    }

    public void removeBook(String ISBN) {
        for (Book b : books) {
            if (ISBN.equals(b.getISBN())) {
                books.remove(b);
                System.out.println("Книга удалена");
            }
        }
    }

    public Book findBookByISBN(String ISBN) {
        for (Book b : books) {
            if (ISBN.equals(b.getISBN())) {
                return b;
            }
        }
        return null;
    }

    public ArrayList<Book> findBooksByAuthor(String author) {
        ArrayList<Book> allBooks = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().equalsIgnoreCase(author)) {
                allBooks.add(b);
            }
        }
        return allBooks;
    }

    public ArrayList<Book> findBooksByGenre(String genre) {
        ArrayList<Book> allBooks = new ArrayList<>();
        for (Book b : books) {
            if (b.getGenre().equalsIgnoreCase(genre)) {
                allBooks.add(b);
            }
        }
        return allBooks;
    }

    public void displayAllBooks() {
        books.forEach(b -> System.out.println(b.toString()));
    }

    public boolean borrowBook(String ISBN) {
        for (Book b : books) {
            if (b.getISBN().equals(ISBN)) {
                if (b.isAvailable() == true) {
                    b.setAvailable(false);
                    System.out.println("Книга успешно взята");
                    return true;
                } else {
                    System.out.println("Книга занята!");
                    return false;
                }
            }
            System.out.println("Книга не найдена!");
        }
        return false;
    }

    public boolean returnBook(String ISBN) {
        for (Book b : books) {
            if (b.getISBN().equals(ISBN)) {
                if (b.isAvailable() == false) {
                    b.setAvailable(true);
                    System.out.println("книга успешна возвращена");
                    return true;
                }
                System.out.println("Книга не доступна");
                return false;
            }
        }
        System.out.println("Книга не найдена!");
        return false;
    }

}
