import java.io.File;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class Main extends Application {

    private TextField directoryPathField;
    private TextField searchField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Browser and Search");
        initializeFields();

        Button browseButton = createBrowseButton();
        Button searchButton = new Button("Search");

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(directoryPathField, browseButton);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, searchField, searchButton);

        Scene scene = new Scene(vBox, 600, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initializeFields() {
        directoryPathField = new TextField();
        directoryPathField.setPromptText("Enter directory path");

        searchField = new TextField();
        searchField.setPromptText("Enter search phrase");
    }

    private Button createBrowseButton() {
        Button browseButton = new Button("Browse");
        browseButton.setOnAction(e -> browseDirectory());
        return browseButton;
    }

    private void browseDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(null);
        if (selectedDirectory != null) {
            directoryPathField.setText(selectedDirectory.getAbsolutePath());
        }
    }
}
