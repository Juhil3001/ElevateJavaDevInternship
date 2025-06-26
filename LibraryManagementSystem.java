import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author =author;
        this.isIssued = false;
    }

    public int getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        this.isIssued = true;
    }
    public void returnBook() {
        this.isIssued = false;
    }

    public void displayBook() {
        System.out.println("ID :" + id + ", Title :" + title + ", Author :" + author + ", Issued :" +isIssued);
    }
}

class User {
    private int userid;
    private String name;

    public User(int userid, String name) {
        this.userid = userid;
        this.name = name;
    }

    public int getUserId() {
        return userid;
    }
    public String getName() {
        return name;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book Added.");
    }

    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books.");
        } else {
            for (Book book : books) {
                book.displayBook();
            }
        }
    }

    public Book findBookById(int id) {
        for (Book book : books) {
            if (book.getId() == id) return book;
        }
        return null;
    }

    public void issueBook(int bookId, User user) {
        Book book = findBookById(bookId);
        if (book == null) {
            System.out.println("Book not found.");
        } else if (book.isIssued()) {
            System.out.println("Book already issued.");
        } else {
            book.issueBook();
            System.out.println("Book issue to " + user.getName());
        }
    }

    public void returnBook(int bookId) {
        Book book = findBookById(bookId);
        if (book != null && book.isIssued()) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not issued or not found.");
        }
    }
}
public class LibraryManagementSystem {
    public static void main(String args[]) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        System.out.println("Wlcome to the Library MAnagement System");
        boolean exit = true;

        System.out.print("Enter your User ID :");
        int uid = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your name :");
        String uname = sc.nextLine();
        User user = new User(uid, uname);

        while(exit){
            System.out.println("Choose an operation");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");

            int choose = sc.nextInt();

            if(choose == 5){
                exit = false;
                System.out.println("You are exit from System.");
                break; 
            }

            switch(choose){
                case 1 :
                    System.out.println("Enter Book ID :");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter book title");
                    String title = sc.nextLine();
                    System.out.println("Enter Author :");
                    String author = sc.nextLine();
                    Book book = new Book(id, title, author);
                    library.addBook(book);
                    break;
                case 2 :
                    library.showAllBooks();
                    break;
                case 3 :
                    System.out.println("Enter book id to issue :");
                    int issueId = sc.nextInt();
                    library.issueBook(issueId, user);
                    break;
                case 4 :
                    System.out.println("Enter Book Id to return :");
                    int returnId = sc.nextInt();
                    library.returnBook(returnId);
                    break;
                default :
                System.out.println("Invalid choice");
                continue;
            }
        }
    }
}
