package th.co.aware.apartment.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.RowMapper;

import th.co.aware.apartment.bean.User;

public class userDAO {

	@Autowired
	DataSource dataSource;

	public List<User> getAllUserRowMapper() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query("select * from user", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				User e = new User();

				e.setU_id(rs.getInt(1));
				e.setU_fname(rs.getString(2));
				e.setU_lname(rs.getString(3));
				e.setU_day(rs.getInt(4));
				e.setU_month(rs.getInt(5));
				e.setU_year(rs.getInt(6));
				e.setR_id(rs.getInt(7));
				e.setU_rid(rs.getInt(8));

				return e;

			}

		});

	}

	public User getUserByIdRowMapper(int u_id) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<User> user = jdbcTemplate.query("select * from user where u_id = " + u_id, new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				User e = new User();

				e.setU_id(rs.getInt(1));
				e.setU_fname(rs.getString(2));
				e.setU_lname(rs.getString(3));
				e.setU_day(rs.getInt(4));
				e.setU_month(rs.getInt(5));
				e.setU_year(rs.getInt(6));
				e.setR_id(rs.getInt(7));
				e.setU_rid(rs.getInt(8));

				return e;

			}

		});

		if (user.size() != 0) {
			return user.get(0);
		}
		return null;

	}

	public List<User> getIdUserRowMapper(int r_id) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query("select * from user where r_id = '" + r_id + "'", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				User e = new User();

				e.setU_id(rs.getInt(1));
				e.setU_fname(rs.getString(2));
				e.setU_lname(rs.getString(3));
				e.setU_day(rs.getInt(4));
				e.setU_month(rs.getInt(5));
				e.setU_year(rs.getInt(6));
				e.setR_id(rs.getInt(7));
				e.setU_rid(rs.getInt(8));

				return e;

			}

		});

	}

	public Boolean saveUserByPreparedStatement(final User u) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String quary = "insert into user (u_fname,u_lname,u_day,u_month,u_year,r_id) values (?,?,?,?,?,?) ";
					 
		return jdbcTemplate.execute(quary, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setString(1, u.getU_fname());
				ps.setString(2, u.getU_lname());
				ps.setInt(3, u.getU_day());
				ps.setInt(4, u.getU_month());
				ps.setInt(5, u.getU_year());
				ps.setInt(6, u.getR_id());
				return ps.execute();

			}

		});
	}
	
	public int userChangeUrid(User e) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String query = "update user set u_rid = '" + e.getR_id() + "' where u_id = " + e.getU_id();
		return jdbcTemplate.update(query);
	}
	
	public User getLastUserId(User u) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<User> user = jdbcTemplate.query("select * from user order by u_id DESC limit 1", new RowMapper<User>() {

			@Override
			public User mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				User e = new User();

				e.setU_id(rs.getInt(1));
				e.setU_fname(rs.getString(2));
				e.setU_lname(rs.getString(3));
				e.setU_day(rs.getInt(4));
				e.setU_month(rs.getInt(5));
				e.setU_year(rs.getInt(6));
				e.setR_id(rs.getInt(7));
				e.setU_rid(rs.getInt(8));

				return e;

			}

		});

		if (user.size() != 0) {
			return user.get(0);
		}
		return null;

	}

	public int deleteUser(User e) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String query = "delete from user where u_id = " + e.getU_id();
		return jdbcTemplate.update(query);
	}

	public int userChangeRoom(User e) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String query = "update user set r_id = '" + e.getR_id() + "' where u_id = " + e.getU_id();
		return jdbcTemplate.update(query);
	}
}
