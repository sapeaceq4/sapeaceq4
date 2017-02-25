package com.sapient.rsn.ace.spring.core.factory;

import com.sapient.rsn.ace.spring.core.bean.Book;
import org.springframework.beans.factory.config.AbstractFactoryBean;

/**
 * Created by Ravdeep Singh on 25-02-2017.
 */
public class BookFactoryBean extends AbstractFactoryBean<Book> {

    String author;

    public BookFactoryBean(String author) {
        this.author = author;
    }

    //This method is required for autowiring to work correctly
    @Override
    public Class<?> getObjectType() {
        return null;
    }

    //This method will be called by container to create new instances
    @Override
    protected Book createInstance() throws Exception {
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
