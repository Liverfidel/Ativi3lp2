package controle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import dao.DaoHotel;
import entidades.Hotel;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class TelaInicialController implements Initializable{
	
	@FXML
	private BorderPane TelaInicial;
	
	@FXML
	private TableView<Hotel> Hoteis;
	
	@FXML
	private TableColumn<Hotel, Integer> id;
	
	@FXML
	private TableColumn<Hotel, String> nome;
	
	@FXML
	private TableColumn<Hotel, String> endereco;
	
	@FXML
	private TableColumn<Hotel, Integer> cep;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		id.setCellValueFactory( new PropertyValueFactory<>("idhotel") );
		nome.setCellValueFactory( new PropertyValueFactory<>("nome") );
		endereco.setCellValueFactory(new PropertyValueFactory<> ("endereco"));
		cep.setCellValueFactory( new PropertyValueFactory<>("cep") );
		
		DaoHotel daoHotel = new DaoHotel();
		try {
			List<Hotel> hoteis = daoHotel.buscarTodos();
			
			Hoteis.setItems( FXCollections.observableArrayList( hoteis ) ); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void clickCadastrar() throws IOException {
		BorderPane fxml = new FXMLLoader(
				getClass().getResource("/views/TelaCadastro.fxml")).load();
		
		Scene cena = new Scene(fxml);
		
		Stage stage = (Stage) TelaInicial.getScene().getWindow();
		
		stage.setScene(cena);
	}

}