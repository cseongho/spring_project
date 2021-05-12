package net.developia.mvc.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class ProjDAOImpl implements ProjDAO{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private ProjDAOImpl() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/xciproj");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static ProjDAO getInstance() {
		return projDAO;
	}

	@Override
	public int signupMember(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO member(no, id, pwd, email) ");
		sql.append("VALUES (seq_member.NEXTVAL, ?, ?, ?) ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setString(1, projDTO.getId());
			ps.setString(2, projDTO.getPwd());
			ps.setString(3, projDTO.getEmail());
			return ps.executeUpdate();			
		}
	}

	@Override
	public ProjDTO loginMember(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no FROM member ");
		sql.append("WHERE id=? AND pwd=? ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setString(1, projDTO.getId());
			ps.setString(2, projDTO.getPwd());
			try (ResultSet rs = ps.executeQuery()) {
				if(rs.next()) {
					projDTO.setMemNo(rs.getLong("no"));
					return projDTO;
				}
				else return null;
			}
			
		}
	}

	@Override
	public List<ProjDTO> getCategoryList(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no, name ");
		sql.append("FROM category ");
		sql.append("WHERE member_no=? ");

		List<ProjDTO> list = new ArrayList<>();
		try (Connection conn = dataSource.getConnection();
				 PreparedStatement ps = conn.prepareStatement(sql.toString())){
				ps.setLong(1, projDTO.getMemNo());
				try (ResultSet rs = ps.executeQuery()) {
					while(rs.next()) {
						ProjDTO articleDTO = new ProjDTO();
						articleDTO.setCatNo(rs.getLong("no"));
						articleDTO.setName(rs.getString("name"));
						list.add(articleDTO);
				}
			}
		} 
			return list;
	}

	@Override
	public int categoryAdd(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO category(no,name,member_no) ");
		sql.append("VALUES (seq_category.NEXTVAL, ? , ?) ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setString(1, projDTO.getName());
			ps.setLong(2, projDTO.getMemNo());
			return ps.executeUpdate();			
		}
	}

	@Override
	public int categoryDelete(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM category ");
		sql.append("WHERE no=? AND member_no=? ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setLong(1, projDTO.getCatNo());
			ps.setLong(2, projDTO.getMemNo());
			return ps.executeUpdate();			
		}
	}

	@Override
	public int categoryUpdate(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE category ");
		sql.append("SET name=? ");
		sql.append("WHERE no=? AND member_no=? ");
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setString(1, projDTO.getName());
			ps.setLong(2, projDTO.getCatNo());
			ps.setLong(3, projDTO.getMemNo());
			return ps.executeUpdate();			
		}
	}

	@Override
	public List<ProjDTO> getSiteList(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no, title, link, content ");
		sql.append("FROM site ");
		sql.append("WHERE category_no=? ");

		List<ProjDTO> list = new ArrayList<>();
		try (Connection conn = dataSource.getConnection();
				 PreparedStatement ps = conn.prepareStatement(sql.toString())){
				ps.setLong(1, projDTO.getCatNo());
				try (ResultSet rs = ps.executeQuery()) {
					while(rs.next()) {
						ProjDTO articleDTO = new ProjDTO();
						articleDTO.setLinkNo(rs.getLong("no"));
						articleDTO.setTitle(rs.getString("title"));
						articleDTO.setLink(rs.getString("link"));
						articleDTO.setContent(rs.getString("content"));
						list.add(articleDTO);
				}
			}
		} 
			return list;
	}

	@Override
	public int siteAdd(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("INSERT INTO site(no,title,link,content,category_no) ");
		sql.append("VALUES (seq_site.NEXTVAL, ? , ?, ?, ?) ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setString(1, projDTO.getTitle());
			ps.setString(2, projDTO.getLink());
			ps.setString(3, projDTO.getContent());
			ps.setLong(4, projDTO.getCatNo());
			return ps.executeUpdate();			
		}
	}

	@Override
	public int siteDelete(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE FROM site ");
		sql.append("WHERE no=? AND category_no=? ");

		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setLong(1, projDTO.getLinkNo());
			ps.setLong(2, projDTO.getCatNo());
			return ps.executeUpdate();			
		}
		
	}

	@Override
	public int siteUpdate(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("UPDATE site ");
		sql.append("SET title=?, link=?, content=? ");
		sql.append("WHERE no=? AND category_no=? ");
		
		try (Connection conn = dataSource.getConnection();
			 PreparedStatement ps = conn.prepareStatement(sql.toString())){
			ps.setString(1, projDTO.getTitle());
			ps.setString(2, projDTO.getLink());
			ps.setString(3, projDTO.getContent());
			ps.setLong(4, projDTO.getLinkNo());
			ps.setLong(5, projDTO.getCatNo());
			return ps.executeUpdate();			
		}
		
	}

	@Override
	public List<ProjDTO> getSiteUpdateList(ProjDTO projDTO) throws SQLException {
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT no, title, link, content ");
		sql.append("FROM site ");
		sql.append("WHERE no=? ");

		List<ProjDTO> list = new ArrayList<>();
		try (Connection conn = dataSource.getConnection();
				 PreparedStatement ps = conn.prepareStatement(sql.toString())){
				ps.setLong(1, projDTO.getLinkNo());
				try (ResultSet rs = ps.executeQuery()) {
					while(rs.next()) {
						ProjDTO articleDTO = new ProjDTO();
						articleDTO.setLinkNo(rs.getLong("no"));
						articleDTO.setTitle(rs.getString("title"));
						articleDTO.setLink(rs.getString("link"));
						articleDTO.setContent(rs.getString("content"));
						list.add(articleDTO);
				}
			}
		} 
			return list;
	}

	


	
}
