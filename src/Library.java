import java.util.ArrayList;

public class Library {
    private static ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        for (Book b : books) {
            if (book.getISBN().equals(b.getISBN())) {
                System.out.println("такая книга уже есть!");
                throw new RuntimeException();
            }
        }
        System.out.println("Книга добавлена!");
        books.add(book);
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
                System.out.println("Книга нашлась: " + "\n" + b.toString());

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
                if (b.isAvailable()) {
                    System.out.println("книга взята");
                    b.setAvailable(false);
                    return true;
                } else {
                    System.out.println("Книга сейчас занята");
                    return false;
                }
            }
        }
        System.out.println("такой книги не существует");
        return false;
    }

    public boolean returnBook(String ISBN) {
        for (Book b : books) {
            if (b.getISBN().equals(ISBN)) {
                if (!(b.isAvailable())) {
                    b.setAvailable(true);
                    System.out.println("книга успешна возвращена");
                    return true;
                } else {
                    System.out.println("Вы не можите вернуть книгу,так как она сейчас в библиотеке");
                    return false;
                }
            }
        }
        System.out.println("Книга не найдена!");
        return false;
    }

}
