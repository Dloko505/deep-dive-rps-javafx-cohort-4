package edu.cnm.deepdive.rps;

import edu.cnm.deepdive.rps.controller.Controller;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

  private static final String RESOURCES_DIR = "resources";
  private static final String UI_STRINGS = "/ui-strings";
  private static final String LAYOUT_RESOURCE = "/main.fxml";
  private static final String ICON_RESOURCE = "/rps.png";
  private static final String WINDOW_TITLE = "window_title";

  private Controller controller;

  @Override
  public void start(Stage stage) throws Exception {
    ClassLoader classLoader = getClass().getClassLoader();
    ResourceBundle bundle = ResourceBundle.getBundle(RESOURCES_DIR + UI_STRINGS);
    FXMLLoader fxmlLoader = new FXMLLoader(classLoader.getResource(RESOURCES_DIR + LAYOUT_RESOURCE), bundle);
    Parent root = fxmlLoader.load();
    controller = fxmlLoader.getController();
    Scene scene = new Scene(root);
    String window_title = WINDOW_TITLE;
    stage.setTitle(bundle.getString(window_title));
    stage.getIcons().add(new Image(classLoader.getResourceAsStream(RESOURCES_DIR + ICON_RESOURCE)));
    stage.setResizable(false);
    stage.setScene(scene);
    stage.show();
  }

  @Override
  public void stop() throws Exception {
    controller.stop(null);
    super.stop();
  }

  public static void main(String[] args) {
    launch(args);
  }

}
