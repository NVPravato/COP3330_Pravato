import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;


class ContactItemTest {
    private ContactItem item;

    @BeforeEach
    public void setUp(){
        item = new ContactItem();
    }

    @AfterEach
    public void tearDown(){
        item.clear();
        //list = null;
    }


    @Test
    void creationFailsWithAllBlankValues(){
        assertThrows(InputMismatchException.class, () -> {
            item.setFname("");
            item.setLname("");
            item.setPhone("");
            item.setEmail("");
        });
    }

    @Test
    void creationSucceedsWithBlankEmail(){

        item.setFname("f");
        item.setLname("l");
        item.setPhone("111-111-1111");
        item.setEmail("");
        assertEquals("", item.getEmail());
    }

    @Test
    void creationSucceedsWithBlankFirstName(){
        item.setFname("");
        item.setLname("l");
        item.setPhone("111-111-1111");
        item.setEmail("email@email.email");
        assertEquals("", item.getFname());
    }

    @Test
    void creationSucceedsWithBlankLastName(){
        item.setFname("f");
        item.setLname("");
        item.setPhone("111-111-1111");
        item.setEmail("email@email.email");
        assertEquals("", item.getLname());
    }

    @Test
    void creationSucceedsWithBlankPhone(){
        item.setFname("f");
        item.setLname("l");
        item.setPhone("");
        item.setEmail("email@email.email");
        assertEquals("", item.getPhone());
    }

    @Test
    void creationSucceedsWithNonBlankValues(){
        item.setFname("f");
        item.setLname("l");
        item.setPhone("111-111-1111");
        item.setEmail("email@email.email");
        assertEquals("f", item.getFname());
        assertEquals("l", item.getLname());
        assertEquals("111-111-1111", item.getPhone());
        assertEquals("email@email.email", item.getEmail());
    }

    @Test
    void editingFailsWithAllBlankValues(){
        item.setFname("f");
        item.setLname("l");
        item.setPhone("111-111-1111");
        item.setEmail("email@email.email");
        assertEquals("f", item.getFname());
        assertEquals("l", item.getLname());
        assertEquals("111-111-1111", item.getPhone());
        assertEquals("email@email.email", item.getEmail());
        //System.out.println(item.getNumItems());
        assertThrows(InputMismatchException.class, () -> {
            item.setFname("");
            //System.out.println(item.getNumItems());
            item.setLname("");
            //System.out.println(item.getNumItems());
            item.setPhone("");
            //System.out.println(item.getNumItems());
            item.setEmail("");
            //System.out.println(item.getNumItems());
        });
    }

    @Test
    void editingSucceedsWithBlankEmail(){
        item.setFname("f");
        item.setLname("l");
        item.setPhone("111-111-1111");
        item.setEmail("email@email.email");
        assertEquals("f", item.getFname());
        assertEquals("l", item.getLname());
        assertEquals("111-111-1111", item.getPhone());
        assertEquals("email@email.email", item.getEmail());

        item.setFname("f2");
        item.setLname("l2");
        item.setPhone("111-111-1112");
        item.setEmail("");
        assertEquals("", item.getEmail());

    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        item.setFname("f");
        item.setLname("l");
        item.setPhone("111-111-1111");
        item.setEmail("email@email.email");
        assertEquals("f", item.getFname());
        assertEquals("l", item.getLname());
        assertEquals("111-111-1111", item.getPhone());
        assertEquals("email@email.email", item.getEmail());

        item.setFname("");
        item.setLname("l2");
        item.setPhone("111-111-1112");
        item.setEmail("email@email.email2");
        assertEquals("", item.getFname());
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        item.setFname("f");
        item.setLname("l");
        item.setPhone("111-111-1111");
        item.setEmail("email@email.email");
        assertEquals("f", item.getFname());
        assertEquals("l", item.getLname());
        assertEquals("111-111-1111", item.getPhone());
        assertEquals("email@email.email", item.getEmail());

        item.setFname("f2");
        item.setLname("");
        item.setPhone("111-111-1112");
        item.setEmail("email@email.email2");
        assertEquals("", item.getLname());
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        item.setFname("f");
        item.setLname("l");
        item.setPhone("111-111-1111");
        item.setEmail("email@email.email");
        assertEquals("f", item.getFname());
        assertEquals("l", item.getLname());
        assertEquals("111-111-1111", item.getPhone());
        assertEquals("email@email.email", item.getEmail());

        item.setFname("f2");
        item.setLname("l2");
        item.setPhone2("");
        item.setEmail2("email@email.email2");
        assertEquals("", item.getPhone());
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        item.setFname("f");
        item.setLname("l");
        item.setPhone("111-111-1111");
        item.setEmail("email@email.email");
        assertEquals("f", item.getFname());
        assertEquals("l", item.getLname());
        assertEquals("111-111-1111", item.getPhone());
        assertEquals("email@email.email", item.getEmail());

        item.setFname("f2");
        item.setLname("l2");
        item.setPhone("111-111-1112");
        item.setEmail("email@email.email2");
        assertEquals("f2", item.getFname());
        assertEquals("l2", item.getLname());
        assertEquals("111-111-1112", item.getPhone());
        assertEquals("email@email.email2", item.getEmail());
    }

    @Test
    void testToString(){
        item.setFname("f");
        item.setLname("l");
        item.setPhone("111-111-1111");
        item.setEmail("email@email.email");
        assertEquals("Name: f l\nPhone: 111-111-1111\nEmail: email@email.email", item.toString());
    }
}