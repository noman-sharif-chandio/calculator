package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainWindow extends Application {
    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("MainWindowInterface.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setResizable(false);
        stage.setTitle("Calculator");
        ((MainWindowController)fxmlLoader.getController()).init(stage);
        stage.show();
    }
    public void run(){launch();}

    public static void main(String[] args) {
        MainWindow mainWindow=new MainWindow();
        mainWindow.run();
    }
}
