package controle;

import java.io.IOException;
import java.sql.SQLException;

import dao.DaoHotel;
import entidades.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaCadastroController {
	
	@FXML
	private BorderPane TelaCadastro;
	
	@FXML
	private TextField textFieldNome;
	
	@FXML
	private TextField textFieldEndereco;
	
	@FXML
	private TextField textFieldCep;
	
	
	public void clickCadastrar() throws IOException{
		
		
		String nome = textFieldNome.getText();
		String endereco = textFieldEndereco.getText();
		int cep = Integer.parseInt( textFieldCep.getText());
		
		Hotel hotel = new Hotel(nome, endereco, cep);
		
		DaoHotel daoHotel = new DaoHotel();
		
		try {
			daoHotel.inserir(hotel);
			
			clickVoltar();
		} catch (SQLException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Atenção");
			alert.setContentText("Erro: " + e.getMessage());
			alert.show();
		}
	}
	
	public void clickVoltar() throws IOException {
		BorderPane fxml = new FXMLLoader(
				getClass().getResource("/views/TelaInicial.fxml")).load();
		
		Scene cena = new Scene(fxml);
		
		Stage stage = (Stage) TelaCadastro.getScene().getWindow();
		
		stage.setScene(cena);
	}
	
}
