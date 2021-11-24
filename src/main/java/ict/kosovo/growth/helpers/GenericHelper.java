package ict.kosovo.growth.helpers;

import ict.kosovo.growth.usertodoapplication.HelloApplication;
import javafx.animation.PathTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.Optional;

public class GenericHelper {
    public static void createAndShowAlert(Alert.AlertType type, String title, String description) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(description);
        alert.show();
    }

    public static void loadMainForm(String url, String title, boolean isMaximized) {
        try {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource(url));
            Scene scene = new Scene(root);
            Stage mainStage = new Stage(StageStyle.DECORATED);
            mainStage.setScene(scene);
            mainStage.setTitle(title);
            mainStage.setMaximized(isMaximized);

            mainStage.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static Optional<ButtonType> showDialogBoxFor(String url, String title, String headerText, Node root,FXMLLoader loader) {
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(root.getScene().getWindow());
        dialog.setTitle(title);
        dialog.setHeaderText(headerText);

        loader.setLocation(HelloApplication.class.getResource(url));

        try {
            dialog.getDialogPane().setContent(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        return dialog.showAndWait();//showDialog();

    }
}
