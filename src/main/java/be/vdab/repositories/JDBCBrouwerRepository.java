package be.vdab.repositories;

import be.vdab.entities.Brouwer;
import be.vdab.valueobjects.Adres;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class JDBCBrouwerRepository implements BrouwerRepository {

	private final JdbcTemplate jdbcTemplate;
	private final SimpleJdbcInsert simpleJdbcInsert;
	private static final String BEGIN_SQL = "SELECT * FROM brouwers ";
	private static final String SQL_FIND_ALL = BEGIN_SQL + "ORDER BY naam";
	private static final String SQL_FIND_BY_NAAM = BEGIN_SQL + "WHERE naam LIKE ? ORDER BY naam";


	JDBCBrouwerRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		simpleJdbcInsert.withTableName("brouwers");
		simpleJdbcInsert.usingGeneratedKeyColumns("id");
	}

	@Override
	public void create(Brouwer brouwer) {
		Map<String, Object> kolomWaarden = new HashMap<>();
		kolomWaarden.put("naam", brouwer.getNaam());
		kolomWaarden.put("omzet", brouwer.getOmzet());
		kolomWaarden.put("straat", brouwer.getAdres().getStraat());
		kolomWaarden.put("huisNr", brouwer.getAdres().getHuisNr());
		kolomWaarden.put("postcode", brouwer.getAdres().getPostcode());
		kolomWaarden.put("gemeente", brouwer.getAdres().getGemeente());
		Number id = simpleJdbcInsert.executeAndReturnKey(kolomWaarden);
		brouwer.setBrouwerNr(id.longValue());
	}

	@Override
	public List<Brouwer> findAll() {
		return jdbcTemplate.query(SQL_FIND_ALL, rowMapper);
	}

	@Override
	public List<Brouwer> findByNaam(String beginNaam) {
		return jdbcTemplate.query(SQL_FIND_BY_NAAM, rowMapper, beginNaam + '%');
	}

	private final RowMapper<Brouwer> rowMapper = (resultSet, rowNum) -> {
		return new Brouwer(resultSet.getLong("id"),
				resultSet.getString("naam"),
				(Integer) resultSet.getObject("omzet"),
				new Adres(resultSet.getString("straat"),
						resultSet.getString("huisNr"),
						resultSet.getInt("postcode"),
						resultSet.getString("gemeente")));
	};
}
