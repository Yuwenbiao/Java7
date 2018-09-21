package Java虚拟机.引用类型.弱引用;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * HashMap类造成对象存活时间过长的示例
 *
 * @author yuwb
 * @date 2018/9/18 10:29
 */
public class BookKeeper {
    private Map<Book, Set<User>> books = new HashMap<>();
//    private WeakHashMap<Book, Set<User>> books = new WeakHashMap<>();

    public void borrowBook(Book book, User user) {
        Set<User> users = null;
        if (books.containsKey(book)) {
            users = books.get(book);
        } else {
            users = new HashSet<>();
            books.put(book, users);
        }
        users.add(user);
    }

    public void returnBook(Book book, User user) {
        if (books.containsKey(book)) {
            Set<User> users = books.get(book);
            users.remove(user);
        }
    }
}

class Book{}

class User{}
