package AdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application{

	private Label msg;
	private Button button;
	private TextField oneText;
	int num1 = (int) (Math.random() * 100) + 1, tries = 0;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		oneText = new TextField();
		oneText.setPromptText("Esperando n�mero");
		oneText.setMaxWidth(150);
		
		button = new Button("Comprobar");
		button.setDefaultButton(true);
		button.setOnAction(e -> onVerificarButtonAction(e));
		
		msg = new Label("Introduce un numero entre 1 y 100");
		msg.setWrapText(true);
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(msg, oneText, button);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("AdivinApp");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void onVerificarButtonAction(ActionEvent e) {
		
		String numeroLetra = oneText.getText();
		
		try {
			int numero = Integer.parseInt(numeroLetra);
			if(numero==num1) {
				tries++;
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("Has ganado!");
				alert.setContentText("Solo has necesitado "+tries+" tries"+"\n"+"Vuelve a jugar y hazlo mejor.");

				alert.showAndWait();
				
			}else if(numero<num1) {
				tries++;
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("Has fallado!");
				alert.setContentText("El numero a adivinar es mayor que "+numero);
				
				alert.showAndWait();
			}else if (numero>num1){
				tries++;
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("Has fallado!");
				alert.setContentText("El numero a adivinar es menor que "+numero);
				
				alert.showAndWait();
			}else{
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("AdivinApp");
				alert.setHeaderText("Algo ha fallado");
				alert.setContentText("El numero introducido no es valido, verifica los rangos.");

				alert.showAndWait();
			}
				
		} catch (NumberFormatException error){
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("AdivinApp");
			alert.setHeaderText("Error");
			alert.setContentText("No has introducido un numero.");

			alert.showAndWait();
		}
	
	}
	
	public static void main(String[] args) {
		launch(args);

	}
}