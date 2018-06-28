package gussinku.dropwizard.microservice.db;


import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;

public interface UserDAO {


    @SqlUpdate("create table form (id int primary key, name varchar(100), email varchar(20), " +
            "personalsDescription varchar(100)")
    void createFormTable();

    @SqlUpdate("insert into form (id, name, description, email) values (:id, :name, :description, :email)")
    void insert(@Bind("id") int id, @Bind("name") String name, @Bind("age") int age, @Bind("email") String email);

    @SqlQuery("select name from form where id = :id")
    String findNameById(@Bind("id") int id);

}
