package main;

import configuration.JPAConfig;
import entity.BookEntity;
import java.util.ArrayList;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.BookRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class MainCRUD {
    static ApplicationContext context =new AnnotationConfigApplicationContext(JPAConfig.class);
    static BookRepository bookRepository=(BookRepository) context.getBean("bookRepository");
    public static void main(String[]args){
//        createNewBook();
//        readBook();
//        readBook(1);
//        updateBook();
//        deleteBook();
//        findByAuthor();
//        thanPrice();
//        thanPrice();
//        deleteAuthor("Peter");
//        findName("Java");
    }
    private static void  createNewBook(){
        BookEntity bookEntity=new BookEntity();
        bookEntity.setName("Java A-Z");
        bookEntity.setAuthor("Roger");
        bookEntity.setCategory(" IT Books");
        bookEntity.setIsbn("ISIBF1219323");
        bookEntity.setNumberOfPage(234);
        bookEntity.setPrice(20.5);
        bookEntity.setPublishDate(LocalDate.parse("2016-08-25"));
        BookEntity result=bookRepository.save(bookEntity);
        if (result !=null){
            System.out.println("A new book saved successfully, book ID" +bookEntity.getId());
        }
    }
    private static void  readBook(){
        List<BookEntity> bookList=(List<BookEntity>) bookRepository.findAll();
        System.out.println("Found "+bookList.size()+" books in the table book");
        System.out.println("they are : ");
        for (BookEntity book: bookList){
            System.out.println(book.toString());
        }
    }
    private static void  readBook(int bookID){
        Optional<BookEntity> bookList=bookRepository.findById(bookID);
        if (bookList.isPresent()){
            System.out.println("Found a book with book ID = " +bookID);
            System.out.println(bookList.toString());
        }else {
            System.out.println("not any book  with book Id =" +bookID);
        }
    }
    private static void updateBook(){
        BookEntity bookEntity=bookRepository.findById(1).get();
        System.out.println("Book data before updating");
        System.out.println(bookEntity.toString());
        bookEntity.setAuthor("Jame");
        bookEntity.setNumberOfPage(199);
        bookEntity.setPrice(201.0);
        bookRepository.save(bookEntity);
        System.out.println("Book data after updating");
        System.out.println(bookEntity.toString());
    }
    private static void deleteBook(){
        BookEntity bookEntity=bookRepository.findById(1).get();
        if (bookEntity !=null){
            bookRepository.delete(bookEntity);
        }
        bookRepository.deleteAll();
    }
    private static void findByAuthor(){
        List<BookEntity> bookList=bookRepository.findByAuthor("Roger");
        if (bookList.size() != 0){
            System.out.println("Found "+bookList.size()+"books of Roger");
            System.out.println("they are: ");
            for (BookEntity book:bookList){
                System.out.println(book.toString());
            }
        }
    }
    private static void thanDate(){
        List<BookEntity> bookList=(List<BookEntity>) bookRepository.findAll();
        for (BookEntity book:bookList){
            if (book.getPublishDate().isAfter(LocalDate.now())){
                System.out.println(book.toString());
            }
        }
    }
    private static void thanPrice(){
        List<BookEntity> bookList=(List<BookEntity>) bookRepository.findAll();
        for (BookEntity book:bookList){
            if (book.getPrice()>=100){
                book.setPrice(90.0);
                bookRepository.save(book);
            }
        }
        List<BookEntity> bookList1=(List<BookEntity>) bookRepository.findAll();
        for (BookEntity book:bookList1){
            System.out.println(book.toString());
        }
    }
    private static void deleteAuthor(String author){
        List<BookEntity> bookList= bookRepository.findByAuthor(author);
        int id=0;
        for (BookEntity book:bookList){
            id= book.getId();
            bookRepository.deleteById(id);
        }
    }
//    private static void findName(String name){
//        List<BookEntity> bookListShow = new ArrayList<>();;
//        List<BookEntity> bookList=(List<BookEntity>) bookRepository.findAll();
//        List<BookEntity> bookList1= bookRepository.findByNameContaining(name);
//        for (int i=0;i<=bookList.size();i++) {
//            for (int j = 0; j <= bookList1.size(); j++) {
//                if (bookList.get(i).getName().equals(bookList1.get(j).getName())) {
//                    bookList.remove(i);
//                }else {
//                    bookListShow=bookList;
//                }
//            }
//        }
//        for (BookEntity book:bookListShow){
//            System.out.println(book.toString());
//        }
//    }
}
