package br.com.matheuspadilha.hrworker.resources;

import br.com.matheuspadilha.hrworker.entities.Worker;
import br.com.matheuspadilha.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerRecource {
    
    private static final Logger logger = LoggerFactory.getLogger(WorkerRecource.class);
    
//    @Value("${test.config}")
//    private String testConfig;
    
    @Autowired
    private Environment env;
    
    @Autowired
    private WorkerRepository repository;
    
    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
//        logger.info("CONFIG = " + testConfig);
        
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> list = repository.findAll();
        
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(
            @PathVariable Long id
    ) throws InterruptedException {
        
        /*
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        */
        
        
        logger.info("PORT = " + env.getProperty("local.server.port") );
        
        Worker worker = repository.findById(id).get();
        
        return ResponseEntity.ok().body(worker);
    }
}
