package dev.rr.learn_spring.run;
import java.util.List;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Repository
public class RunRepository {


    private static final Logger log = LoggerFactory.getLogger(RunRepository.class);

    private final JdbcClient jdbcClient;

    // Advantage of Spring - No need to create a jdbc client as it knows we are gonna talk to a db
    public RunRepository(JdbcClient jdbcClient){ 
        this.jdbcClient = jdbcClient;
    }

    public List <Run> findAll(){
        return jdbcClient.sql("SELECT * FROM RUN")
        .query(Run.class)
        .list();

    }

    public Optional<Run> findById(Integer id){
        return jdbcClient.sql("SELECT id, title,started_on, completed_on,miles, location FROM Run WHERE id = :id" )
        .param("id", id)
        .query(Run.class) 
        .optional();
    }

}
