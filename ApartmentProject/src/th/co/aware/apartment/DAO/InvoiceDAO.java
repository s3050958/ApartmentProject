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

import th.co.aware.apartment.bean.Invoice;
import th.co.aware.apartment.bean.Room;
//import th.co.aware.apartment.bean.User;
import th.co.aware.apartment.bean.User;

public class InvoiceDAO {

	@Autowired
	DataSource dataSource;

	public List<Invoice> getAllInvoiceRowMapper() {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.query(
				"select i.i_id , r.r_id , u.u_fname , u.u_lname , i.i_water , i.i_light , r.r_price , i.i_total , i.i_status "
						+ "from room r , user u , invoice i " + "where i.u_id = u.u_id and u.r_id = r.r_id ",
				new RowMapper<Invoice>() {

					@Override
					public Invoice mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub

						Invoice e = new Invoice();

						e.setI_id(rs.getInt("i.i_id"));
						e.setR_id(rs.getInt("r.r_id"));
						e.setU_fname(rs.getString("u.u_fname"));
						e.setU_lname(rs.getString("u.u_lname"));
						e.setI_water(rs.getInt("i.i_water"));
						e.setI_light(rs.getInt("i.i_light"));
						e.setR_price(rs.getInt("r.r_price"));
						e.setI_total(rs.getInt("i.i_total"));
						e.setI_status(rs.getString("i.i_status"));

						return e;

					}

				});

	}

	public Invoice getInvoiceByIdRowMapper(int i_id) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Invoice> room = jdbcTemplate.query("select * from invoice where i_id = " + i_id, new RowMapper<Invoice>() {

			@Override
			public Invoice mapRow(ResultSet rs, int rownumber) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub

				Invoice e = new Invoice();

				e.setI_id(rs.getInt(1));
				e.setI_status("i_status");

				return e;

			}

		});

		if (room.size() != 0) {
			return room.get(0);
		}
		return null;

	}

	public Boolean saveInvoiceByPreparedStatement(final Room r) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		final int w = r.getR_water() * 20;
		final int l = r.getR_light() * 9;
		final int p = r.getR_price();
		final int t = w + l + p;

		String quary = "insert into invoice (i_water,i_light,i_total,u_id,r_id) values (?,?,?,?,?)";
		return jdbcTemplate.execute(quary, new PreparedStatementCallback<Boolean>() {

			@Override
			public Boolean doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
				// TODO Auto-generated method stub
				ps.setInt(1, w);
				ps.setInt(2, l);
				ps.setInt(3, t);
				ps.setInt(4, r.getU_id());
				ps.setInt(5, r.getR_id());
				return ps.execute();

			}

		});
	}

	public int updatePaidStatusG(Invoice e) {

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		String s = "<font color=\"green\">Paid</font>";


		String query = "update invoice set i_status = '" + s + "' where i_id = '" + e.getI_id() + "'";
		return jdbcTemplate.update(query);
	}

}
