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

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

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

        rootNode.add(new Label("Wpisz ciag bajtow jaki chcesz zamienic"), 0, 2);
        TextField thirdValue = new TextField();
        rootNode.add(thirdValue, 1, 2);

        rootNode.add(new Label("Wpisz ciag bajtow na jaki chcesz zamienic poprzedni ciag"), 0, 3);
        TextField fourthValue = new TextField();
        rootNode.add(fourthValue, 1, 3);




        Button executiveButton = new Button("Wykonaj");
        rootNode.add(executiveButton, 1, 6);
        GridPane.setHalignment(executiveButton, HPos.LEFT);
        TextField result = new TextField();
        result.setEditable(false);
//        rootNode.add(result, 1, 3);

        // jezeli nacisnie sie przycisk
        executiveButton.setOnAction(e -> {



            String filePath = firstValue.getText() + "." + secondValue.getText();
            String newString = thirdValue.getText();
            String oldString = fourthValue.getText();
//            System.out.println(newString + " " + oldString);

//            try {
//                //text file, should be opening in default text editor
//                File file = new File(filePath);
//
//                //first check if Desktop is supported by Platform or not
//                if(!Desktop.isDesktopSupported()){
//                    System.out.println("Desktop is not supported");
//                    return;
//                }
//
//                Desktop desktop = Desktop.getDesktop();
//                if(file.exists()) desktop.open(file);
//
//
//            }
//            catch (IOException e1){
//
//                e1.printStackTrace();
//            }


            BufferedWriter out = null;


            try {




                String contents = new String(Files.readAllBytes(Paths.get(filePath)));
                System.out.println( contents);
                String contents2 = contents.replace(newString, oldString);
                System.out.println(contents2);


//                String fileAsString = sb.toString();
//                System.out.println(fileAsString);
//                @Todo
//                String replacedString = fstream.replace(fstream, );

//                out = new BufferedWriter(fstream);
//                out.write("\nsue");
            }

            catch (IOException e2) {
                System.err.println("Error: " + e2.getMessage());
            }
//
//            finally {
//                try {
//                    if(out != null) {
//                        out.close();
//                    }
//                }
//                catch (IOException e3){
//                    e3.printStackTrace();
//                }

//            }

        });

//        aButton.setOnAction(e -> {
//            Integer value1 = Integer.valueOf(firstValue.getText());
//            Integer value2 = Integer.valueOf(secondValue.getText());
//            Integer r = value1 + value2;
//            result.setText(r.toString());
//        });

        myStage.setScene(myScene);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
