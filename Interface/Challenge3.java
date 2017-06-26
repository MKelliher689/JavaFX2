import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javafx.stage.WindowEvent;

public class Challenge3
{
    private static TextField textFieldMessage;

    public static void main(String args[])
    {
        launchFX();
    }

    private static void launchFX()
    {
        new JFXPanel();
        Platform.runLater(() -> initialiseGUI());
    }

    private static void initialiseGUI()
    {
        Stage stage = new Stage();
        stage.setTitle("Hello World");
        stage.setResizable(false);
        Pane rootPane = new Pane();
        stage.setScene(new Scene(rootPane));
        stage.setWidth (1024);
        stage.setHeight(768);
        stage.setOnCloseRequest((WindowEvent we) -> terminate());
        stage.show();

        textFieldMessage = new TextField();
        textFieldMessage.setLayoutX(400);
        textFieldMessage.setLayoutY(250);
        textFieldMessage.setPrefWidth(100);
        textFieldMessage.setPromptText("Enter your message");
        rootPane.getChildren().add(textFieldMessage);

        Button btn = new Button();
        btn.setText("Click Me!");
        btn.setLayoutX(350);
        btn.setLayoutY(50);
        btn.setOnAction((ActionEvent ae) -> printMessage());
        rootPane.getChildren().add(btn);
    }

    public static void terminate()
    {
        System.out.println("bye bye");
        System.exit(0);
    }

    private static void printMessage(){
        String message = textFieldMessage.getText();
        System.out.println(message);
    }
}