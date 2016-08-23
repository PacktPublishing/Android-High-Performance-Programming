public class Book extends SugarRecord<Book> {
    String isbn;
    String title;
    String author;
    
    public Book() { }

    public Book(String isbn, String title,String author){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }
}


//

Book exampleBook = new Book(getContext(),"isbn","title",”author”); exampleBook.save(); 
