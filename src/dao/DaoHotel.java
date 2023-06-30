package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entidades.Hotel;

public class DaoHotel {
	


		
		public boolean inserir(Hotel hotel) throws SQLException {
			
			Connection conexao = ConnectionFactory.getConexao();
			
			String sql = "insert into hotelaria (nome, endereco, cep) values(? ,?, ?);";
			PreparedStatement ps = conexao.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

			ps.setString(1, hotel.getNome());
			ps.setString(2, hotel.getEndereco());
			ps.setInt(3, hotel.getCep());
			
			int linhasAfetadas = ps.executeUpdate();
			
			ResultSet r = ps.getGeneratedKeys();
			
			if( r.next() ) {
				int idhotel = r.getInt(1);	
				hotel.setIdhotel(idhotel);
			}
			
			return (linhasAfetadas == 1 ? true : false);
		}
		
		
	
	
		public List<Hotel> buscarTodos() throws SQLException {
			Connection con = ConnectionFactory.getConexao();
			
			String sql = "select * from hotelaria";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet result = ps.executeQuery();
			
			List<Hotel> hotelaria = new ArrayList<Hotel>();
			
			while( result.next() ) {
				int idhotel = result.getInt("idhotel");
				String nome = result.getString("nome");
				String endereco = result.getString("endereco");
				int cep = result.getInt("cep");
				
				Hotel hotel = new Hotel(idhotel, nome, endereco, cep);
		
				hotelaria.add(hotel);
			}
			
			return hotelaria;
		}
	}

