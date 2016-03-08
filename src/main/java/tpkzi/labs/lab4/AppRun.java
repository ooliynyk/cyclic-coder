package tpkzi.labs.lab4;/**
 * Created by Таня on 06/03/2016.
 */

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import tpkzi.labs.lab4.coder.CyclicCoder;

import javax.swing.*;

public class AppRun extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Cyclic coder");
        final GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(25));
        Scene scene = new Scene(pane, 300, 300);
        pane.add(new Label("Input bits"), 0, 0);
        TextField inData = getBinaryTextField(4);
        //inData.setDisable(true);
        pane.add(inData, 0, 1);
        Button encodeDecode = new Button("Encode - decode!");
        pane.add(encodeDecode, 0, 2);
        pane.add(new Label("Decoding result"), 0, 4, 2, 1);
        TextArea outData = new TextArea();
        pane.add(outData, 0, 6);
        primaryStage.setScene(scene);
        primaryStage.show();
//коментар
        encodeDecode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int d = 0b1101;
                //int d = Integer.parseInt(inData.getText());
                int p = 0b1011;
                inData.setText(Integer.toBinaryString(d));
                CyclicCoder coder = new CyclicCoder();
                int x = coder.encode(d);
                //System.out.println(Integer.toBinaryString(x));
                outData.appendText(Integer.toBinaryString(x) + "\n");
                //System.out.println(Integer.toBinaryString(coder.decode(0b1100001)));
                outData.appendText(Integer.toBinaryString(coder.decode(0b1100001)));
            }
        });

    }
    
	private static TextField getBinaryTextField(int maxLen) {
    	TextField field = new TextField();
    	field.textProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				try {
					if (newValue.isEmpty()) {
						field.setText("");
						return;
					}
					
					StringBuilder sb = new StringBuilder();
					char[] chars = newValue.toCharArray();
					for (int i = 0; (i < chars.length) && (i < maxLen); i++) {
						char c = chars[i];
						if (c == '0' || c == '1') {
							sb.append(c);
						}
					}
					field.setText(sb.toString());
				} catch (Exception e) {
					field.setText(oldValue);
					e.printStackTrace();
				}
			}
    	});
    	return field;
    }
}
