package com.placement;

import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
 
import org.springframework.web.bind.annotation.*;
@CrossOrigin(allowedHeaders="*",origins="*") 
@RestController
public class CollegeController {
 
    @Autowired
    private CollegeService service;
     
    // RESTful API methods for Retrieval operations
    @GetMapping("/College")
    public List<College> list() {
        return service.listAll();
    }
    @GetMapping("/College/{id}")
    public ResponseEntity<College> get(@PathVariable Integer id) {
        try {
        	College College = service.get(id);
            return new ResponseEntity<College>(College, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<College>(HttpStatus.NOT_FOUND);
        }      
    }
    // RESTful API method for Create operation
    @PostMapping("/College")
    public void add(@RequestBody College College) {
        service.save(College);
    }
     
    // RESTful API method for Update operation
    @PutMapping("/College/{id}")
    public ResponseEntity<?> update(@RequestBody College College, @PathVariable Integer id) {
        try {
        	College existCollege = service.get(id);
            service.save(College);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }      
    }
    // RESTful API method for Delete operation
    @DeleteMapping("/College/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
    
   
}