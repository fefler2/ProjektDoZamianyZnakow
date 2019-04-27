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
import org.apache.commons.io.FileUtils;

import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Iterator;

import java.io.*;
import java.util.HashSet;

public class ZamianaZnakow10 extends Application {


    public void listFilesAndFilesSubDirectories(String directoryName) {


        File directory = new File(directoryName);

        File[] fList = directory.listFiles();
        assert fList != null;
        for (File file : fList) {


            try {
                if (file.isFile()) {

                    //
                    System.out.println(file.getAbsolutePath());

                }

                else if (file.isDirectory() && file.isDirectory()) {
                    listFilesAndFilesSubDirectories(file.getAbsolutePath());
                }


            } catch (NullPointerException e) {
                e.printStackTrace();
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

            final String directory = "C:\\";

            String filePath = firstValue.getText() + "." + secondValue.getText();
            String newString = thirdValue.getText();
            String oldString = fourthValue.getText();

//            BufferedWriter out = null;



            try {





                try {


                    FileOutputStream fos = null;
                    try {
                        String contents = new String(Files.readAllBytes(Paths.get(filePath)));
                        String contents2 = contents.replace(newString, oldString);


                        //



                        /////
                        /////

//                                    File root = new File("C:\\Users\\Maciej\\Desktop\\Java Projects3\\zamianaZnakow");
//                File root = new File("C:\\");


//                                    Collection files = FileUtils.listFiles(root, null, true);

//                                    @Todo
                        fos = new FileOutputStream(filePath); // domyslnie program jest w sciezce

                        DataOutputStream outStream = new DataOutputStream(new BufferedOutputStream(fos));

                        outStream.writeUTF(contents2); // wpisanie

                        outStream.close();

                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }


                    ////
                    PrintWriter pw = new PrintWriter(filePath);

                    BufferedReader br2 = new BufferedReader(new FileReader(filePath));

                    String line2 = br2.readLine();

                    // hashset for storing lines of delete.txt
                    HashSet<String> hs = new HashSet<String>();

                    // loop for each line of delete.txt
                    while(line2 != null)
                    {
                        hs.add(line2);
                        line2 = br2.readLine();
                    }

                    // BufferedReader object for input.txt
                    BufferedReader br1 = new BufferedReader(new FileReader("input.txt"));

                    String line1 = br1.readLine();

                    // loop for each line of input.txt
                    while(line1 != null)
                    {
                        // if line is not present in delete.txt
                        // write it to output.txt
                        if(!hs.contains(line1))
                            pw.println(line1);

                        line1 = br1.readLine();
                    }

                    pw.flush();

                    // closing resources
                    br1.close();
                    br2.close();
                    pw.close();

                    System.out.println("File operation performed successfully");


                    ////
                    ////
                    ////

                } catch (Exception e3) {
                    e3.printStackTrace();
                }


            } finally {

            }


        });


        myStage.setScene(myScene);

        myStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
