package main;

import configuration.JPAConfig;
import entity.AccountEntity;
import entity.BookEntity;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repository.AccountRepository;
import repository.BookRepository;
import service.AccountService;

import java.time.LocalDate;
import java.util.Date;

public class MainTestTransaction {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static AccountRepository accountRepository = applicationContext.getBean("accountRepository", AccountRepository.class);
  //  static BookRepository bookRepository = applicationContext.getBean("bookRepository", BookRepository.class);
    static AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
    public static void main(String[] args) throws Exception {

    }

}
