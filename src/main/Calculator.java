package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Calculator extends Application{
    private final TextField tf= new TextField();
    private long num1=0;
    private String op="";
    @Override
    public void start(Stage primaryStage){
        tf.setFont(Font.font(20));
        tf.setPrefHeight(50);
        tf.setEditable(false);
        tf.setAlignment(Pos.CENTER_RIGHT);
        StackPane sp = new StackPane();
        sp.setPadding(new Insets(10));
        sp.getChildren().add(tf);

        TilePane tp = new TilePane();
        tp.setHgap(10);
        tp.setVgap(10);
        tp.setAlignment(Pos.TOP_CENTER);

        tp.getChildren().addAll(
                buttonforNumber("7"),
                buttonforNumber("8"),
                buttonforNumber("9"),
                buttonforOperator("/"),
                buttonforNumber("4"),
                buttonforNumber("5"),
                buttonforNumber("6"),
                buttonforOperator("X"),
                buttonforNumber("3"),
                buttonforNumber("2"),
                buttonforNumber("1"),
                buttonforOperator("-"),
                buttonforNumber("0"),
                buttonforClear(),
                buttonforOperator("="),
                buttonforOperator("+")
        );

        BorderPane root = new BorderPane();
        root.setTop(sp);
        root.setCenter(tp);
        Scene sc = new Scene(root,250,300);
        primaryStage.setScene(sc);
        primaryStage.setTitle("Calculator");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    private Button buttonforNumber(String ch) {
        Button btn= new Button(ch);
        btn.setPrefSize(50, 50);
        btn.setFont(Font.font(18));
        btn.setOnAction(this::processNumbers);
        return btn;
    }
    private Button buttonforOperator(String ch) {
        Button btn= new Button(ch);
        btn.setPrefSize(50, 50);
        btn.setFont(Font.font(18));
        btn.setOnAction(this::processOperators);
        return btn;
    }
    private Button buttonforClear() {
        Button btn= new Button("C");
        btn.setPrefSize(50, 50);
        btn.setFont(Font.font(18));
        btn.setOnAction(e->{
            tf.setText("");
            op="";
        });
        return btn;
    }
    private void processNumbers(ActionEvent e){
        String value=((Button)e.getSource()).getText();
        tf.setText(tf.getText()+value);
    }
    private void processOperators(ActionEvent e){
        String value=((Button)e.getSource()).getText();
        if(!value.equals("=")) {
            if(!op.isEmpty())
                return;
            num1=Long.parseLong(tf.getText());
            op=value;
            tf.setText("");
        }else {
            if(op.isEmpty())
                return;
            long num2=Long.parseLong(tf.getText());
            float result=calculate(num1,num2,op);
            tf.setText(String.valueOf(result));
            op="";
        }
    }
    private float calculate(long num1, long num2, String operator) {
        switch (operator) {
            case "+" -> {
                return num1 + num2;
            }
            case "-" -> {
                return num1 - num2;
            }
            case "X" -> {
                return num1 * num2;
            }
            case "/" -> {
                if (num2 == 0)
                    return 0;
                return (float)num1 / num2;
            }
            default -> {
                return 0;
            }
        }
    }
    public static void main(String [] args) {
        launch(args);
    }
}
