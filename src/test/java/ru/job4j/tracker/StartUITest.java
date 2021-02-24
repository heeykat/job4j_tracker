package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {

    public static final String lineSeparator = System.lineSeparator();

    @Test
    public void whenCreate() {
        Output out = new StubOutput();
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        UserAction create = new CreateAction(out);
        create.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenShowAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ShowAction(out),
                new ExitAction(out)
        };
        Item item = new Item("new item");
        tracker.add(item);
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + lineSeparator
                        + "0. === Show all items ====" + lineSeparator
                        + "1. === Exit program ====" + lineSeparator
                        + "=== Show all items ====" + lineSeparator
                        + "Item{id=1, name='new item'}" + lineSeparator
                        + "Menu." + lineSeparator
                        + "0. === Show all items ====" + lineSeparator
                        + "1. === Exit program ====" + lineSeparator
                        + "=== Exit program ====" + lineSeparator
        ));
    }

    @Test
    public void whenReplace() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()),
                "replaced item"
        };
        UserAction edit = new ReplaceAction(out);
        edit.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDelete() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId())
        };
        UserAction delete = new DeleteAction(out);
        delete.execute(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(out),
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindByIdAction(){
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction(out)
        };
        Item item = new Item("new item");
        tracker.add(item);
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + lineSeparator
                        + "0. === Find item by Id ====" + lineSeparator
                        + "1. === Exit program ====" + lineSeparator
                        + "=== Find item by Id ====" + lineSeparator
                        + "Item find successfully" + " "
                        + "Item{id=1, name='new item'}" + lineSeparator
                        + "Menu." + lineSeparator
                        + "0. === Find item by Id ====" + lineSeparator
                        + "1. === Exit program ====" + lineSeparator
                        + "=== Exit program ====" + lineSeparator
        ));
    }

    @Test
    public void whenFindByNameAction(){
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "new item", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction(out)
        };
        Item item = new Item("new item");
        tracker.add(item);
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + lineSeparator
                        + "0. === Find item by name ====" + lineSeparator
                        + "1. === Exit program ====" + lineSeparator
                        + "=== Find item by name ====" + lineSeparator
                        + "Item{id=1, name='new item'}" + lineSeparator
                        + "Menu." + lineSeparator
                        + "0. === Find item by name ====" + lineSeparator
                        + "1. === Exit program ====" + lineSeparator
                        + "=== Exit program ====" + lineSeparator
        ));
    }

    @Test
    public void whenExitAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction(out)
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + lineSeparator
                        + "0. === Exit program ====" + lineSeparator
                        + "=== Exit program ====" + lineSeparator
        ));
    }


}