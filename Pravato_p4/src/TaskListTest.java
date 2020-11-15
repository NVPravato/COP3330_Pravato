import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {


    /*
    @Test
    void viewList(){
        TaskList list = new TaskList();
        list.viewList();
        assertEquals(null, list.viewList());

    }


    @Test
    void editingTaskItemTitleFailsWithInvalidIndex(){
        TaskList list = new TaskList();
        list.setEditItem(9);
        assertEquals("9", "Please enter a valid number.\n");
    }
    */





    @Test
    void addingTaskItemsIncreasesSize(){
        TaskList list = new TaskList();
        list.addItem("t1", "d1", "2020-10-10");
        assertEquals(1, list.getLength());

    }

    @Test
    void completingTaskItemChangesStatus(){

    }

    @Test
    void completingTaskItemFailsWithInvalidIndex(){
        //assertThrows();
    }

    @Test
    void editingTaskItemChangesValues(){

    }

    @Test
    void editingTaskItemDescriptionChangesValue(){

    }

    @Test
    void editingTaskItemDescriptionFailsWithInvalidIndex(){

    }

    @Test
    void editingTaskItemDueDateChangesValue(){

    }

    @Test
    void editingTaskItemDueDateFailsWithInvalidIndex(){

    }

    @Test
    void editingTaskItemTitleChangesValue(){

    }

    @Test
    void editingTaskItemTitleFailsWithInvalidIndex(){

    }

    @Test
    void gettingTaskItemDescriptionFailsWithInvalidIndex(){

    }

    @Test
    void gettingTaskItemDescriptionSucceedsWithValidIndex(){

    }

    @Test
    void gettingTaskItemDueDateFailsWithInvalidIndex(){

    }

    @Test
    void gettingTaskItemDueDateSucceedsWithValidIndex(){

    }

    @Test
    void gettingTaskItemTitleFailsWithInvalidIndex(){

    }

    @Test
    void gettingTaskItemTitleSucceedsWithValidIndex(){

    }

    @Test
    void newTaskListIsEmpty(){
        TaskList list = new TaskList();
        assertEquals(true, list.getEmpty());
    }

    @Test
    void removingTaskItemsDecreasesSize(){

    }

    @Test
    void removingTaskItemsFailsWithInvalidIndex(){

    }

    @Test
    void savedTaskListCanBeLoaded(){

    }

    @Test
    void uncompletingTaskItemChangesStatus(){

    }

    @Test
    void uncompletingTaskItemFailsWithInvalidIndex(){

    }


}