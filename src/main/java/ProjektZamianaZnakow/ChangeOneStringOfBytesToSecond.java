package ProjektZamianaZnakow;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
Program bedzie sprzedawany wielu uzytkownikom. Zrobic program, ktory przyjmuje 4 parametry:
1. nazwe przeszukiwanego katalogu
 */

public class ChangeOneStringOfBytesToSecond extends Application {


    public void listFilesAndFilesSubDirectories(String directoryName, TextField firstValue, TextField secondValue, TextField thirdValue, TextField fourthValue) {

        File directory = new File(directoryName);
        String filePath = firstValue.getText() + "." + secondValue.getText();
        String newString = thirdValue.getText();
        String oldString = fourthValue.getText();



        File[] fList = directory.listFiles();

        assert fList != null;
        for (File file : fList) {


            try {
                if (file.isFile()) {
                    if (file.getName().equals(filePath)) {

                        try {

                            String contents = new String(Files.readAllBytes(Paths.get(filePath)));
                            String contents2 = contents.replace(newString, oldString);

                            FileOutputStream fos = null;

                            fos = new FileOutputStream(file.getAbsolutePath());

                            DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));

                            outStream.writeUTF(contents2);

                            outStream.close();



                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                else if (file.isDirectory()) {
                    listFilesAndFilesSubDirectories(file.getAbsolutePath(), firstValue, secondValue, thirdValue, fourthValue);
                }
            } catch (NullPointerException e) {

            }
        }
    }


    @Override
    public void start(Stage myStage) {

        myStage.setTitle("Zamiana ciagu bajtow");

        Stage stage2 = new Stage();
        stage2.setTitle("Abc");
        Popup popup = new Popup();
//        popup.
//        popup.setX(200);
//        popup.setY(140);


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

        rootNode.add(new Label("Wpisz ciag bajtow na jaki chcesz zamienic poprzedni ciag bajtow"), 0, 3);
        TextField fourthValue = new TextField();
        rootNode.add(fourthValue, 1, 3);


        Button executiveButton = new Button("Wykonaj");
        rootNode.add(executiveButton, 1, 6);



        executiveButton.setOnAction(e -> {

            final String directory = "c:\\";
            listFilesAndFilesSubDirectories(directory, firstValue, secondValue, thirdValue, fourthValue);
            System.out.println("koniec");
//            popup.show(stage2);

//            final Popup popup = new Popup();
            popup.setAutoFix(true);
            popup.setAutoHide(true);
            popup.setHideOnEscape(true);

            Stage popupwindow=new Stage();

            popupwindow.initModality(Modality.APPLICATION_MODAL);
            popupwindow.setTitle("This is a pop up window");

            Label label1= new Label("Pop up window now displayed");


            VBox layout= new VBox(10);


//            layout.getChildren().addAll(label1, button1);

            layout.setAlignment(Pos.CENTER);

            Scene scene1= new Scene(layout, 300, 250);

            popupwindow.setScene(scene1);

            popupwindow.showAndWait();
        });

        myStage.setScene(myScene);

        myStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}