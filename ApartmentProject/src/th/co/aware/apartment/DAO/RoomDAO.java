package th.co.aware.apartment.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import th.co.aware.apartment.bean.Room;
import th.co.aware.apartment.bean.User;

public class RoomDAO {

	@Autowired
	DataSource dataSource;

	public List<Room> getAllRoomRowMapper() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query("SELECT r.r_id , r.r_status ,r.r_water , r.r_light ,u.u_id, r.r_price , u.u_fname , u.u_lname FROM room r LEFT OUTER JOIN user u ON r.u_id = u.u_id", new RowMapper<Room>() {

			@Override
			public Room mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				Room e = new Room();

				e.setR_id(rs.getInt("r.r_id"));
				e.setR_status(rs.getString("r.r_status"));
				e.setR_water(rs.getInt("r.r_water"));
				e.setR_light(rs.getInt("r.r_light"));
				e.setR_price(rs.getInt("r.r_price"));
				e.setU_id(rs.getInt("u.u_id"));
				e.setU_fname(rs.getString("u.u_fname"));
				e.setU_lname(rs.getString("u.u_lname"));

				return e;

			}

		});

	}

	public Room getRoomByIdRowMapper(int r_id) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Room> room = jdbcTemplate.query("select * from room where r_id = " + r_id, new RowMapper<Room>() {

			@Override
			public Room mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				Room e = new Room();

				e.setR_id(rs.getInt(1));
				e.setR_status(rs.getString(2));
				e.setR_water(rs.getInt(3));
				e.setR_light(rs.getInt(4));
				e.setR_price(rs.getInt(5));
				e.setU_id(rs.getInt(6));

				return e;

			}

		});

		if (room.size() != 0) {
			return room.get(0);
		}
		return null;

	}

	public List<Room> getIdRoomrRowMapper(int r_id) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query("select * from user where r_id = '" + r_id + "'", new RowMapper<Room>() {

			@Override
			public Room mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				Room e = new Room();

				e.setR_id(rs.getInt(1));
				e.setR_water(rs.getInt(3));
				e.setR_light(rs.getInt(4));
				e.setU_id(rs.getInt(6));

				return e;

			}

		});

	}

	public int updateLAndWtatus(Room e) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String query = "update room set r_light = '" + e.getR_light() + "', r_water = '" + e.getR_water() + "' where r_id = '" + e.getR_id() + "'";
		
		return jdbcTemplate.update(query);
	}

	public int updateRoomStatusR(User e) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String s = "<font color=\"red\">Not Available</font>";

		String query = "update room set r_status = '" + s + "', u_id = " + e.getU_id() + " where r_id = "+ e.getR_id();
		
		return jdbcTemplate.update(query);
	}

	public int updateRoomStatusG(User e) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String s = "<font color=\"green\">Available</font>";

		int n = 0;

		String query = "update room set r_status = '" + s + "', u_id = '" + n + "' where r_id = '" + e.getR_id() + "'";
		
		return jdbcTemplate.update(query);
	}

	public int updateRoomStatus0(Room e) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String query = "update room set r_water = 0 , r_light = 0 where r_id = '" + e.getR_id() + "'";
		
		return jdbcTemplate.update(query);
	}

	public Room getRoomDBRowMapper(int r_id) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Room> room = jdbcTemplate.query("select * from room ", new RowMapper<Room>() {

			@Override
			public Room mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				Room e = new Room();

				e.setR_id(rs.getInt(1));
				e.setR_status(rs.getString(2));
				e.setR_water(rs.getInt(3));
				e.setR_light(rs.getInt(4));
				e.setR_price(rs.getInt(5));
				e.setU_id(rs.getInt(6));

				return e;

			}

		});

		if (room.size() != 0) {
			return room.get(0);
		}
		return null;

	}

	public List<Room> getAvaliableRoomRowMapper() {

		String s = "<font color=\"green\">Available</font>";
		
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query("SELECT r_id , r_price from room where r_status like '" + s+"'", new RowMapper<Room>() {

			@Override
			public Room mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				Room e = new Room();

				e.setR_id(rs.getInt("r_id"));
				e.setR_price(rs.getInt("r_price"));
				
				return e;

			}

		});

	}
	
	public int updateROID(Room e) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String query = "update room set r_oid = '" + e.getR_id() + "' where r_id = '" + e.getR_id() + "'";
		
		return jdbcTemplate.update(query);
	}

	
}
