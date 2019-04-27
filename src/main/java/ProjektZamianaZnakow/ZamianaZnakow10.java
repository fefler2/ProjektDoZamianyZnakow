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
//import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ZamianaZnakow10 extends Application {


    public void listFilesAndFilesSubDirectories(String directoryName, TextField firstValue, TextField secondValue, TextField thirdValue, TextField fourthValue) {


        File directory = new File(directoryName);
        String filePath = firstValue.getText() + "." + secondValue.getText();
        String newString = thirdValue.getText();
        String oldString = fourthValue.getText();


//        System.out.println(directory);

        File[] fList = directory.listFiles(); // albo tu?

        assert fList != null;
        for (File file : fList) {


            try {
                if (file.isFile()) {
                    if (file.getName().equals(filePath)) { // filePath to sciezka do pliku, a nie plik???
                        System.out.println(file.getName());


                        try {


                            String contents = new String(Files.readAllBytes(Paths.get(filePath))); // string
                            String contents2 = contents.replace(newString, oldString); // zmieniony string


                            FileOutputStream fos = null;
                            System.out.println(file.getAbsolutePath());

                            fos = new FileOutputStream(file.getAbsolutePath()); // moze tutaj jest blad domyslnie program jest w sciezce!!!!

                            DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));

                            outStream.writeUTF(contents2); // wpisanie

                            outStream.close(); // zamkniecie

                            System.out.println("operacja wykonana");

                        } catch (Exception e22) {
                            e22.printStackTrace();
                        }




                    }


                }
//                    System.out.println(file.getName());

                //
//                    System.out.println(file.getAbsolutePath()); // pokazuje sciezke

                else if (file.isDirectory()) {
                    listFilesAndFilesSubDirectories(file.getAbsolutePath(), firstValue, secondValue, thirdValue, fourthValue);
                }


            } catch (NullPointerException e) {

            }

        }

    }


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


        executiveButton.setOnAction(e -> {

            final String directory = "c:\\"; // c:\\ zamiast c: !!!

            listFilesAndFilesSubDirectories(directory, firstValue, secondValue, thirdValue, fourthValue);
//            File directory = new File(directoryName);

            //
            //
            //
            //
            //
            //
            //
            //
            //
            //
//            try{
//                String filePath = firstValue.getText() + "." + secondValue.getText();
//                String newString = thirdValue.getText();
//                String oldString = fourthValue.getText();
//
//                String contents = new String(Files.readAllBytes(Paths.get(filePath))); // string
//                String contents2 = contents.replace(newString, oldString); // zmieniony
//
//
//                FileOutputStream fos = null;
//
//                fos = new FileOutputStream(filePath); // domyslnie program jest w sciezce
//
//                DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));
//
//                outStream.writeUTF(contents2); // wpisanie
//
//                outStream.close(); // zamkniecie
//                System.out.println("operacja wykonana");
//
//            }
//            catch (Exception e22){
////             e22.printStackTrace();
//            }
            //
            //
            //
            //
            //
            //
            //
            //
            //

            System.out.println("koniec");

        });


        myStage.setScene(myScene);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
