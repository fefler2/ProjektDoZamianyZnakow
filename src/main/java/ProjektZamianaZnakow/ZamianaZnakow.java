package ProjektZamianaZnakow;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ZamianaZnakow extends Application {
    @Override
    public void start(Stage myStage) {

        myStage.setTitle("Zamiana bajtow");

        GridPane rootNode = new GridPane();
        rootNode.setPadding(new Insets(15));
        rootNode.setHgap(5);
        rootNode.setVgap(5);
        rootNode.setAlignment(Pos.CENTER);

        Scene myScene = new Scene(rootNode, 700, 300);

        rootNode.add(new Label("Wprowadz nazwe pliku jaki chcesz przeszukac (bez rozszerzenia):"), 0, 0);
        TextField firstValue = new TextField();
        rootNode.add(firstValue, 1, 0);

        rootNode.add(new Label("Wpisz rozszerzenie pliku (np .txt, .png, .jpg)"), 0, 1);
        TextField secondValue = new TextField();
        rootNode.add(secondValue, 1, 1);

        rootNode.add(new Label("Wpisz rozszerzenie pliku (np .txt, .png, .jpg)"), 0, 1);
        TextField thirdValue = new TextField();
        rootNode.add(thirdValue, 1, 4);

        rootNode.add(new Label("Wpisz df pliku (np .txt, .png, .jpg)"), 0, 1);
        TextField fourthValue = new TextField();
        rootNode.add(fourthValue, 1, 5);


        Button aButton = new Button("Wykonaj");
        rootNode.add(aButton, 1, 2);
        GridPane.setHalignment(aButton, HPos.LEFT);
        TextField result = new TextField();
        result.setEditable(false);
        rootNode.add(result, 1, 3);

        aButton.setOnAction(e -> {
            Integer value1 = Integer.valueOf(firstValue.getText());
            Integer value2 = Integer.valueOf(secondValue.getText());
            Integer r = value1 + value2;
            result.setText(r.toString());
        });

        myStage.setScene(myScene);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
