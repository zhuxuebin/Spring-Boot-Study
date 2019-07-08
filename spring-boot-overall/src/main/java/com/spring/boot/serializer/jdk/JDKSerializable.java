package com.spring.boot.serializer.jdk;

import com.spring.boot.entity.Book;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @Description jdk自带的序列化方式
 *
 * Created by xuery on 2019/6/22.
 */
@Slf4j
public class JDKSerializable<T> {

    public static void main(String[] args) {
        Book book = new Book();
        book.setId(123L);
        book.setAuthor("zxb");

        JDKSerializable<Book> jdkSerializable = new JDKSerializable<>();
//        jdkSerializable.serializer(book);
        Book book1 = jdkSerializable.deserializer("object.out");
        System.out.println(book1);
    }

    public void serializer(Object object){

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.out"))){
            oos.writeObject(object);
        } catch (Exception e){
            log.error("JDKSerializable.serializer.error" ,e);
        }
    }

    public T deserializer(String source){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(source))){
            return (T)ois.readObject();
        } catch (Exception e){
            log.error("JDKSerializable.deserializer.error", e);
        }
        return null;
    }

}
