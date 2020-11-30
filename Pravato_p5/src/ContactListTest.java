import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.InputMismatchException;

class ContactListTest {
    private ContactList list;

    @BeforeEach
    public void setUp(){
        list = new ContactList();
    }

    @AfterEach
    public void tearDown(){
        list.clear();
        //list = null;
    }

    @Test
    void addingItemsIncreasesSize(){
        list = new ContactList();
        list.addItem("Nick", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");
        assertEquals(1, list.getLength());
    }

    @Test
    void addingItemsFailsWithAllBlankValues(){
        list = new ContactList();

        assertThrows(InputMismatchException.class, () -> {
            list.addItem("", "", "", "");
        });



    }

    @Test
    void editingItemsFailsWithAllBlankValues(){
        list = new ContactList();
        list.addItem("Nick", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");
        assertThrows(InputMismatchException.class, () -> {
            list.setEditItem(0, "", "", "", "");
        });



    }

    @Test
    void editingItemsFailsWithInvalidIndex(){
        list = new ContactList();
        list.addItem("Nick", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.setEditItem(1, "Nick1", "Pravato2", "123-456-7890", "npravato@knights.ucf.edu3");
        });
    }

    @Test
    void editingSucceedsWithBlankFirstName(){
        list = new ContactList();
        list.addItem("Nick", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");

        list.setEditItem(0, "", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");
        assertEquals("", list.getListItem(0).getFname());
    }

    @Test
    void editingSucceedsWithBlankLastName(){
        list = new ContactList();
        list.addItem("Nick", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");

        list.setEditItem(0, "Nick", "", "123-456-7890", "npravato@knights.ucf.edu");
        assertEquals("", list.getListItem(0).getLname());
    }

    @Test
    void editingSucceedsWithBlankPhone(){
        list = new ContactList();
        list.addItem("Nick", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");

        list.setEditItem(0, "Nick", "Pravato", "", "npravato@knights.ucf.edu");
        assertEquals("", list.getListItem(0).getPhone());
    }

    @Test
    void editingSucceedsWithNonBlankValues(){
        list = new ContactList();
        list.addItem("Nick", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");

        list.setEditItem(0, "Kcin", "Otavarp", "098-765-4321", "knights@npravato.edu.ucf");
        assertEquals("Kcin", list.getListItem(0).getFname());
        assertEquals("Otavarp", list.getListItem(0).getLname());
        assertEquals("098-765-4321", list.getListItem(0).getPhone());
        assertEquals("knights@npravato.edu.ucf", list.getListItem(0).getEmail());
    }

    @Test
    void newListIsEmpty(){
        list = new ContactList();
        assertEquals(0, list.getLength());
    }

    @Test
    void removingItemsDecreasesSize(){
        list = new ContactList();
        list.addItem("Nick", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");
        list.addItem("Kcin", "Otavarp", "098-765-4321", "knights@npravato.edu.ucf");
        list.removeItem(0);
        assertEquals(1, list.getLength());
    }

    @Test
    void removingItemsFailsWithInvalidIndex(){
        list = new ContactList();
        list.addItem("Nick", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");
        list.addItem("Kcin", "Otavarp", "098-765-4321", "knights@npravato.edu.ucf");
        list.removeItem(0);
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeItem(2);
        });
    }

    @Test
    void savedContactListCanBeLoaded() throws IOException {
        list = new ContactList();
        list.addItem("Nick", "Pravato", "123-456-7890", "npravato@knights.ucf.edu");
        list.addItem("Kcin", "Otavarp", "098-765-4321", "knights@npravato.edu.ucf");
        list.AccessSaveFile("JunitTest.txt");
        list.clear();
        assertEquals(0, list.getLength());
        list.readFile("JunitTest.txt");
        assertEquals(2, list.getLength());

        assertEquals("Nick", list.getListItem(0).getFname());
        assertEquals("Pravato", list.getListItem(0).getLname());
        assertEquals("123-456-7890", list.getListItem(0).getPhone());
        assertEquals("npravato@knights.ucf.edu", list.getListItem(0).getEmail());

        assertEquals("Kcin", list.getListItem(1).getFname());
        assertEquals("Otavarp", list.getListItem(1).getLname());
        assertEquals("098-765-4321", list.getListItem(1).getPhone());
        assertEquals("knights@npravato.edu.ucf", list.getListItem(1).getEmail());
    }

}