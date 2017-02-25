package com.sapient.rsn.ace.spring.core.factory;

import com.sapient.rsn.ace.spring.core.bean.Book;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */
public class BookFactory {
    public static Book createBookByAuthor(String author){
        Book book = new Book();

        if("Craig".equalsIgnoreCase(author)){
            book.setName("Spring in Action");
        }else if("Chak lam".equalsIgnoreCase(author)){
            book.setName("Hadoop in Action");
        }else if("Bloch".equalsIgnoreCase(author)){
            book.setName("Effective java");
        }else{
            throw new IllegalArgumentException("Invalid Author");
        }
        return book;
    }
}
