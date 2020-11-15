import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;


class TaskItemTest {

    @Test
    void creatingTaskItemFailsWithInvalidDueDate(){
        TaskItem test = new TaskItem();
        assertThrows(InputMismatchException.class, () -> {
            test.setDue("2020-13-90");
        });
    }

    @Test
    void creatingTaskItemFailsWithIncompleteDueDate(){
        TaskItem test = new TaskItem();
        assertThrows(InputMismatchException.class, () -> {
            test.setDue("2020-1");
        });
    }

    @Test
    void creatingTaskItemFailsWithInvalidTitle(){
        TaskItem test = new TaskItem();
        assertThrows(InputMismatchException.class, () -> {
            test.setDue("2020-1");
        });
    }

    @Test
    void creatingTaskItemSucceedsWithValidDueDate(){
        TaskItem test = new TaskItem();
        test.setDue("2020-10-10");
        assertEquals("2020-10-10", test.getDue());
    }

    @Test
    void creatingTaskItemSucceedsWithValidTitle(){

    }

    @Test
    void settingTaskItemDueDateFailsWithInvalidDate(){

    }

    @Test
    void settingTaskItemDueDateSucceedsWithValidDate(){

    }

    @Test
    void settingTaskItemTitleFailsWithInvalidTitle(){

    }

    @Test
    void settingTaskItemTitleSucceedsWithValidTitle(){

    }




}