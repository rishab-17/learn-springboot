package dev.rr.learn_spring.run;
import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;


@Repository
public class RunRepository {
    private List<Run> runs = new ArrayList<>(); //Type Run record. A sortof data storage to hold all the runs.

    List<Run> findAll(){
        return runs;
    }

    Optional<Run> findById(Integer id){

        return runs.stream().filter(run -> run.id() == id).findFirst();

    }

    @PostConstruct // Does initialisation. Method that needs to be executed after DI is done.

    private void init(){
        //code
        runs.add(new Run(1, "Nice Run", LocalDateTime.now(), LocalDateTime.now().plus(1, ChronoUnit.HOURS), 3, Location.OUTDOOR));
        runs.add(new Run(2, "Super Run", LocalDateTime.now(), LocalDateTime.now().plus(2, ChronoUnit.HOURS), 3, Location.OUTDOOR));

    }
}
