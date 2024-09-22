package dev.rr.learn_spring.run;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


//Controllers usually do not have a lot of logic. Just need to take in a request and return a response.

@RestController
@RequestMapping("/api/runs") //Rather than having individual lines of code for each of get, post etc, use requestmapping

public class RunController {

    private final RunRepository runRepository;

    public RunController(RunRepository runRepository){
        this.runRepository = runRepository;
    }


    
    //@GetMapping("/api/runs")
    @GetMapping("")
    List <Run> findAllFromRepo(){
        return runRepository.findAll();
    }


    @GetMapping("/{id}")
    Run findIdFromRepo(@PathVariable Integer id){
        Optional <Run> run = runRepository.findById(id);

        if(run.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return run.get();
    }

    //post
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createRunFromRepo(@RequestBody Run run){
        runRepository.createRun(run);

    }
    
    //put

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")

    void updateFromRepo(@RequestBody Run run, @PathVariable Integer id){
        runRepository.update(run, id);

    }

    //delete

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")

    void deleteFromRepo(@PathVariable Integer id){
        runRepository.delete(id);   
    }

}
