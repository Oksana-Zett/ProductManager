package manager;

import domain.Book;
import domain.Product;
import domain.Smartphone;
import manager.ProductManager;
import org.junit.jupiter.api.Test;
import repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository=new ProductRepository();
    ProductManager manager = new ProductManager(repository);


   Book book1 = new Book (1, "name1", 100, "Nabokov");
   Smartphone smartphone1 = new Smartphone(1, "name1", 20000, "Samsung");
   Product table = new Product(1, "name3", 5000);


    @Test
    void shouldSearchByName() {

        manager.add(book1);
        manager.add(smartphone1);

        Product [] expected = new Product[] {book1, smartphone1};
        Product [] actual = manager.searchBy("name1");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {

        manager.add(book1);
        manager.add(smartphone1);

        Product [] expected = new Product[] {book1};
        Product [] actual = manager.searchBy("Nabokov");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByGenerator() {

        manager.add(smartphone1);
        manager.add(book1);

        Product [] expected = new Product[] {smartphone1};
        Product [] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNull() {

       // manager.add(smartphone1);
      //  manager.add(book1);
        manager.add(table);

        Product [] expected = new Product[] {};
        Product [] actual = manager.searchBy("Name2");

        assertArrayEquals(expected, actual);
    }
}