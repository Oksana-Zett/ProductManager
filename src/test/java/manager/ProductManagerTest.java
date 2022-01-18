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
   // Smartphone smartphone1 = new Smartphone(1, "name2", 20000, "Samsung");


    @Test
    void shouldSearchBy() {

        manager.add(book1);

        Product [] expected = new Product[] {book1};
        Product [] actual = manager.searchBy("name1");

        assertArrayEquals(expected, actual);
    }
}