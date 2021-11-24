package ict.kosovo.growth.usertodoapplication;

import ict.kosovo.growth.helpers.ApplicationSession;
import ict.kosovo.growth.helpers.GenericHelper;
import ict.kosovo.growth.usertodoapplication.models.TodoItem;
import ict.kosovo.growth.usertodoapplication.services.TodoService;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    @FXML
    private Label lblUsername;

    @FXML
    private BorderPane mainView;

    @FXML
    private TableView<TodoItem> tvTodoItems;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblUsername.setText(ApplicationSession.username);

        TableColumn<TodoItem, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<TodoItem, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<TodoItem, String> deadlineColumn = new TableColumn<>("Deadline");
        deadlineColumn.setCellValueFactory(new PropertyValueFactory<>("deadline"));


        TableColumn<TodoItem, String> colorColumn = new TableColumn<>("Color");
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));

        tvTodoItems.getColumns().addAll(nameColumn, descriptionColumn, deadlineColumn, colorColumn);
        tvTodoItems.setItems(TodoService.getInstance().getItems());


        tvTodoItems.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                GenericHelper.createAndShowAlert(Alert.AlertType.INFORMATION,t1.getName(),t1.getDescription());
            }
        });
    }

    public void closeApplication(ActionEvent event) {
        Platform.exit();
    }

    public void showTodoDialog(ActionEvent event) {
//        Dialog<ButtonType> dialog = new Dialog<>();
//        dialog.initOwner(mainView.getScene().getWindow());
//        dialog.setTitle("New Todo Item!");
//        dialog.setHeaderText("Ju lutem te plotesoni te gjithe t edhenat per todo!!!!");
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(HelloApplication.class.getResource("todo-create-view.fxml"));
//
//        try {
//            dialog.getDialogPane().setContent(loader.load());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
//        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
//
//        Optional<ButtonType> result = dialog.showAndWait();//showDialog();

        FXMLLoader loader = new FXMLLoader();
        Optional<ButtonType> result = GenericHelper.showDialogBoxFor("todo-create-view.fxml", "New Todo Item",
                "Ju lutem plotesoni te dhenat sakt!!!", mainView, loader);
        if (result.isPresent() && result.get() == ButtonType.OK) {
            TodoCreateViewController ctrl = loader.getController();
            TodoItem newTodoItem = ctrl.getTodoItem();
            TodoService.getInstance().add(newTodoItem);
            //GenericHelper.createAndShowAlert(Alert.AlertType.INFORMATION, "SUCCESS", newTodoItem.getDescription());
        } else {
            GenericHelper.createAndShowAlert(Alert.AlertType.INFORMATION, "Pishmanli!!!", "Nuk po don me regjistru!!");
        }


    }
}
