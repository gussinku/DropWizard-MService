package gussinku.dropwizard.microservice.db;


import gussinku.dropwizard.microservice.api.CompanyForm;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public interface CompanyDAO {


    @SqlUpdate("create table if not exists company (id int primary key, name varchar(100), email varchar(20), " +
            "personalsDescription varchar(100))")
    void createTable();

    @SqlUpdate("insert into company (id, name, personalsDescription, email) values (:id, :name, :personalsDescription, :email)")
    void insert(@Bind("id") int id, @Bind("name") String name, @Bind("personalsDescription") String personalsDescription, @Bind("email") String email);

    @SqlQuery("select name from company where id = :id")
    CompanyForm findNameById(@Bind("id") int id);

    @SqlQuery("select * from company where id = :id")
    @Mapper(CompanyFormMapper.class)
    CompanyForm findById(@Bind("id") int id);

    @SqlQuery("select name,email from company where id = :id")
    @Mapper(CompanyFormMapper.class)
    CompanyForm findNameEmailById(@Bind("id") int id);

    @SqlQuery("select id, name,personalsDescription,email as TITLE from company")
    @Mapper(CompanyFormMapper.class)
    List<CompanyForm> listOfCompany();

    @SqlUpdate("delete from company where id = :id")
    void delete(@Bind("id") int id);

    class CompanyFormMapper implements ResultSetMapper<CompanyForm> {

        @Override
        public CompanyForm map(int index, ResultSet r, StatementContext ctx) throws SQLException {
            CompanyForm companyForm = new CompanyForm();
            companyForm.setId(r.getInt("id"));
            companyForm.setName(r.getString("name"));
            companyForm.setPersonalsDescription(r.getString("personalsDescription"));
            companyForm.setEmail(r.getString("email"));
            return companyForm;
        }
    }
}
