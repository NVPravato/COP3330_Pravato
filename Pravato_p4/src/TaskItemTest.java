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
            test.setTitle("");
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
        TaskItem test = new TaskItem();
        test.setTitle("t1");
        assertEquals("t1", test.getTitle());
    }

    @Test
    void settingTaskItemDueDateFailsWithInvalidDate(){
        TaskItem test = new TaskItem();

        assertThrows(InputMismatchException.class,()->{test.setDue("2020-13-10");});
        //assertEquals("2020-10-10", test.getDue());
    }

    @Test
    void settingTaskItemDueDateSucceedsWithValidDate(){
        TaskItem test = new TaskItem();
        test.setDue("2020-10-10");
        assertEquals("2020-10-10", test.getDue());
    }

    @Test
    void settingTaskItemTitleFailsWithInvalidTitle(){
        TaskItem test = new TaskItem();

        assertThrows(InputMismatchException.class,()->{test.setTitle("");});
    }

    @Test
    void settingTaskItemTitleSucceedsWithValidTitle(){
        TaskItem test = new TaskItem();
        test.setTitle("t1");
        assertEquals("t1", test.getTitle());
    }




}