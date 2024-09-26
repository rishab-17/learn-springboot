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

    
}
