//package ProjektZamianaZnakow;
//
//import javafx.geometry.Insets;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//
//public class ZamianaZnakow2 {
//    public static void main(String[] args) {
//        Label label1 = new Label("Name:");
//        TextField textField = new TextField ();
//        HBox hb = new HBox();
//        hb.getChildren().addAll(label1, textField);
//        hb.setSpacing(10);
//
//
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(10, 10, 10, 10));
//        grid.setVgap(5);
//        grid.setHgap(5);
//
////Defining the Name text field
//        final TextField name = new TextField();
//        name.setPromptText("Enter your first name.");
//        GridPane.setConstraints(name, 0, 0);
//        grid.getChildren().add(name);
//
////Defining the Last Name text field
//        final TextField lastName = new TextField();
//        lastName.setPromptText("Enter your last name.");
//        GridPane.setConstraints(lastName, 0, 1);
//        grid.getChildren().add(lastName);
//
////Defining the Comment text field
//        final TextField comment = new TextField();
//        comment.setPromptText("Enter your comment.");
//        GridPane.setConstraints(comment, 0, 2);
//        grid.getChildren().add(comment);
//
////Defining the Submit button
//        Button submit = new Button("Submit");
//        GridPane.setConstraints(submit, 1, 0);
//        grid.getChildren().add(submit);
//
////Defining the Clear button
//        Button clear = new Button("Clear");
//        GridPane.setConstraints(clear, 1, 1);
//        grid.getChildren().add(clear);
//
//    }
//}
