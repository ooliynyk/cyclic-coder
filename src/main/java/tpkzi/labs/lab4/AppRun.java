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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import tpkzi.labs.lab4.coder.CyclicCoder;

import javax.swing.*;
import javax.swing.plaf.synth.Region;

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
        pane.setStyle("-fx-background-color: #ccffff; -fx-font: 14px Georgia");
        Scene scene = new Scene(pane, 320, 320);
        pane.add(new Label("Input bits"), 0, 0);
        Button encode = new Button("Encode!");
        encode.setStyle("-fx-background-color: #33cc99");
        pane.add(encode, 1, 1);
        TextField inData = getBinaryTextField(4);
        //inData.setStyle();
        pane.add(inData, 0, 1);
        pane.add(new Label("Encoding result"), 0, 2);
        TextField codeResult = new TextField();
        codeResult.setEditable(false);
        pane.add(codeResult, 0, 3);
        pane.add(new Label("Input encode signal"), 0, 5);
        TextField inEncodeSignal = getBinaryTextField(7);
        pane.add(inEncodeSignal, 0, 6);
        Button decode = new Button("Decode!");
        decode.setStyle("-fx-background-color: #33cc99");
        pane.add(decode, 1, 6);
        pane.add(new Label("Decoding result"), 0, 7);
        TextField decodeResult = new TextField();
        decodeResult.setEditable(false);
        pane.add(decodeResult, 0, 8);
        primaryStage.setScene(scene);
        primaryStage.show();

        CyclicCoder coder = new CyclicCoder();

        encode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //int d = 0b1101;
                int d = Integer.parseInt(inData.getText(), 2);
                int p = 0b1011;
                inData.setText(Integer.toBinaryString(d));

                int x = coder.encode(d);
                //System.out.println(Integer.toBinaryString(x));
                codeResult.setText(Integer.toBinaryString(x) + "\n");
                //System.out.println(Integer.toBinaryString(coder.decode(0b1100001)));

            }
        });

        decode.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int p = Integer.parseInt(inEncodeSignal.getText(), 2);
                decodeResult.setText(Integer.toBinaryString(coder.decode(p)));
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
