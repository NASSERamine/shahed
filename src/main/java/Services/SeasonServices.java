package Services;

import java.sql.SQLException;

import Dao.SeasonDAO;
import Entities.Season;

public class SeasonServices {
	SeasonDAO seasondao = new SeasonDAO();
	
	public  int getID( int num) throws SQLException {
		return seasondao.getID(num);
	}
	
	public  Season  getSeason(int NumSeason,int id_media ) throws SQLException {
		return seasondao.getSeason(NumSeason, id_media);
		
	}
	
	
	

}
