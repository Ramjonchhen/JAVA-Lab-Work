import java.io.File;
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;

public class Qno2 extends Application {
    public static void main(String[] args) {
        try {
            launch(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // create a menu
        Menu m = new Menu("Menu");

        // create menuitems
        MenuItem m1 = new MenuItem("menu item 1");
        MenuItem m2 = new MenuItem("menu item 2");
        MenuItem m3 = new MenuItem("menu item 3");

        // add menu items to menu
        m.getItems().add(m1);
        m.getItems().add(m2);
        m.getItems().add(m3);

        // create a menubar
        MenuBar mb = new MenuBar();

        // add menu to menubar
        mb.getMenus().add(m);

        VBox root = new VBox(10, mb);
        root.setAlignment(Pos.CENTER);

        // textfield and label
        TextField b1 = new TextField("Sample Textfiled");
        Label b = new Label("Label for Sample Textfield");
        b.setLabelFor(b1);

        // radio button
        Label radioButtonLabel = new Label("Label for radio button:");
        ToggleGroup tg = new ToggleGroup();
        RadioButton rbt1 = new RadioButton("Male");
        RadioButton rbt2 = new RadioButton("Female");
        RadioButton rbt3 = new RadioButton("Other");
        rbt1.setToggleGroup(tg);
        rbt2.setToggleGroup(tg);
        rbt3.setToggleGroup(tg);

        // adding various component to the scene
        root.getChildren().add(b);
        root.getChildren().add(b1);
        root.getChildren().add(radioButtonLabel);
        root.getChildren().add(rbt1);
        root.getChildren().add(rbt2);
        root.getChildren().add(rbt3);

        // checkboxes
        Label checkboxLabel = new Label("Label for check box");
        String st[] = { "Choice1", "Choice2", "Choice3" };
        root.getChildren().add(checkboxLabel);

        for (int i = 0; i < st.length; i++) {
            CheckBox c = new CheckBox(st[i]);
            root.getChildren().add(c);
            c.setIndeterminate(true);
        }

        // hyperlink
        Label hyperlinkLabel = new Label("Label for Hyperlink:");
        Hyperlink hp = new Hyperlink("http://www.javatpoint.com");
        hp.setOnAction(e -> System.out.println("Link Clicked"));
        root.getChildren().add(hyperlinkLabel);
        root.getChildren().add(hp);

        // tooltip for a label
        Tooltip toolTip = new Tooltip("tooltip popup for tooltip label");
        Label toolTipLabel = new Label("Tool Tip Label: ");
        toolTipLabel.setTooltip(toolTip);
        root.getChildren().add(toolTipLabel);

        // create a File chooser
        FileChooser fileChooser = new FileChooser();
        Label chooseFilelabel = new Label("File Chooser Options:");
        Label fileStatusLabel = new Label("no files selected");
        Button openFileButton = new Button("Show File Dialog");

        // create an Event Handler
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {

                // get the file selected
                File file = fileChooser.showOpenDialog(primaryStage);

                if (file != null) {

                    fileStatusLabel.setText(file.getAbsolutePath()
                            + "  selected");
                }
            }
        };

        openFileButton.setOnAction(event);

        root.getChildren().add(chooseFilelabel);
        root.getChildren().add(fileStatusLabel);
        root.getChildren().add(openFileButton);

        Scene scene = new Scene(root, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Question2 Output");
        primaryStage.show();
    }
}
