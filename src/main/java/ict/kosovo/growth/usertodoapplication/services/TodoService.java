package ict.kosovo.growth.usertodoapplication.services;

import ict.kosovo.growth.usertodoapplication.models.TodoItem;
import ict.kosovo.growth.usertodoapplication.repository.TodoRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;

import java.time.LocalDate;
import java.util.List;

public class TodoService {
    //Sa per ilustrim ak me perdore SingleTon Pattern
    private static TodoService instance = new TodoService();
    private static ObservableList<TodoItem> items;

    private TodoService() {
        //qe mos me pas mundesi me thirr nga jasht!!!
        items = FXCollections.observableArrayList();

        initData();
    }

    private void initData() {
        //items.add(new TodoItem(1,"Learn JavaFX","Learn JavaFX for fun!!!", LocalDate.now().plusDays(10),true, Color.AQUA));

        List<TodoItem> dbItems = TodoRepository.getInstance().getAll();
        items.addAll(dbItems);
    }

    public static TodoService getInstance() {
//        if (instance == null) instance = new TodoService();
        return instance;
    }

    public ObservableList<TodoItem> getItems() {
        return items;
    }

    public void add(TodoItem item) {
        //items.add(item);

        if (TodoRepository.getInstance().add(item)) {
            items.add(item);
        }
    }
}
