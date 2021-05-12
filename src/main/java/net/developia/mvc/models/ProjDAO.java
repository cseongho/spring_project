package net.developia.mvc.models;

import java.sql.SQLException;
import java.util.List;


public interface ProjDAO {
	
	int signupMember(ProjDTO projDTO) throws SQLException;

	ProjDTO loginMember(ProjDTO projDTO) throws SQLException;

	List<ProjDTO> getCategoryList(ProjDTO projDTO) throws SQLException;

	int categoryAdd(ProjDTO projDTO) throws SQLException;

	int categoryDelete(ProjDTO projDTO) throws SQLException;

	int categoryUpdate(ProjDTO projDTO) throws SQLException;

	List<ProjDTO> getSiteList(ProjDTO projDTO) throws SQLException;

	int siteAdd(ProjDTO projDTO) throws SQLException;

	int siteDelete(ProjDTO projDTO) throws SQLException;

	int siteUpdate(ProjDTO projDTO) throws SQLException;

	List<ProjDTO> getSiteUpdateList(ProjDTO projDTO) throws SQLException;


	
}
