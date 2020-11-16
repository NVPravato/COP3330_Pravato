import org.junit.After;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {
    private TaskList list;

    @BeforeEach
    public void setUp(){
        list = new TaskList();
    }

    @AfterEach
    public void tearDown(){
        list.clear();
        //list = null;
    }
    /*
    @Test
    void viewList(){
        list = new TaskList();
        list.viewList();
        assertEquals(null, list.viewList());

    }


    @Test
    void editingTaskItemTitleFailsWithInvalidIndex(){
        list = new TaskList();
        list.setEditItem(9);
        assertEquals("9", "Please enter a valid number.\n");
    }
    */





    @Test
    void addingTaskItemsIncreasesSize(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        assertEquals(1, list.getLength());

    }

    @Test
    void completingTaskItemChangesStatus(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        list.complete(0);
        assertEquals(true, list.getListItem(0).getCompleted());
    }

    @Test
    void completingTaskItemFailsWithInvalidIndex(){
        list = new TaskList();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.complete(10);
        });
    }

    @Test
    void editingTaskItemChangesValues(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        list.setEditItem(0, "ChangedT", "ChangedD", "2002-01-01");
        assertEquals("ChangedT", list.getListItem(0).getTitle());
        assertEquals("ChangedD", list.getListItem(0).getDesc());
        assertEquals("2002-01-01", list.getListItem(0).getDue());
    }

    @Test
    void editingTaskItemDescriptionChangesValue(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        list.setEditItem(0, "ChangedT", "ChangedD", "2002-01-01");

        assertEquals("ChangedD", list.getListItem(0).getDesc());

    }

    @Test
    void editingTaskItemDescriptionFailsWithInvalidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.setEditItem(2, "ChangedT", "d1", "2020-10-10");
        });
    }

    @Test
    void editingTaskItemDueDateChangesValue(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        list.setEditItem(0, "ChangedT", "ChangedD", "2002-01-01");

        assertEquals("2002-01-01", list.getListItem(0).getDue());
    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.setEditItem(5, "t1", "d1", "2020-11-11");
        });
    }

    @Test
    void editingTaskItemTitleChangesValue(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        list.setEditItem(0, "ChangedT", "ChangedD", "2002-01-01");

        assertEquals("ChangedT", list.getListItem(0).getTitle());
    }

    @Test
    void editingTaskItemTitleFailsWithInvalidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.setEditItem(1, "ChangedT", "d1", "2020-10-10");
        });
    }

    @Test
    void gettingTaskItemDescriptionFailsWithInvalidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getListItem(1).getDesc();
        });
    }

    @Test
    void gettingTaskItemDescriptionSucceedsWithValidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        assertEquals("d1", list.getListItem(0).getDesc());
    }

    @Test
    void gettingTaskItemDueDateFailsWithInvalidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getListItem(1).getDue();
        });
    }

    @Test
    void gettingTaskItemDueDateSucceedsWithValidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        assertEquals("2020-10-10", list.getListItem(0).getDue());
    }

    @Test
    void gettingTaskItemTitleFailsWithInvalidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.getListItem(1).getTitle();
        });
    }

    @Test
    void gettingTaskItemTitleSucceedsWithValidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        assertEquals("t1", list.getListItem(0).getTitle());
    }

    @Test
    void newTaskListIsEmpty(){
        list = new TaskList();
        assertEquals(true, list.getEmpty());
    }

    @Test
    void removingTaskItemsDecreasesSize(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        list.addItem("t2", "d2", "2121-11-11");
        list.removeItem(0);
        assertEquals(1, list.getLength());
    }

    @Test
    void removingTaskItemsFailsWithInvalidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        list.addItem("t2", "d2", "2121-11-11");
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.removeItem(3);
        });
    }

    @Test
    void savedTaskListCanBeLoaded() throws IOException {
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        list.addItem("t2", "d2", "2121-11-11");
        list.AccessSaveFile("Test1.txt");
        list.removeItem(1);
        list.removeItem(0);
        list.readFile("Test1.txt");

        assertEquals("t1", list.getListItem(0).getTitle());
        assertEquals("d1", list.getListItem(0).getDesc());
        assertEquals("2020-10-10", list.getListItem(0).getDue());

        assertEquals("t2", list.getListItem(1).getTitle());
        assertEquals("d2", list.getListItem(1).getDesc());
        assertEquals("2121-11-11", list.getListItem(1).getDue());
    }

    @Test
    void uncompletingTaskItemChangesStatus(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        list.complete(0);
        list.uncomplete(0);
        assertEquals(false, list.getListItem(0).getCompleted());
    }

    @Test
    void uncompletingTaskItemFailsWithInvalidIndex(){
        list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        list.complete(0);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.uncomplete(10);
        });
    }


}