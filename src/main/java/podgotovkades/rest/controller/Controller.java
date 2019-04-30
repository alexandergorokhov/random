package podgotovkades.rest.controller;

import podgotovkades.rest.service.BackenAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Autowired
    BackenAdapter backendAdapter;

    @GetMapping("/retry")
    @ExceptionHandler({ Exception.class })
    public String validateSPringRetryCapability(@RequestParam(required = false) boolean simulateretry,
                                                @RequestParam(required = false) boolean simulateretryfallback)
    {
        System.out.println("===============================");
        System.out.println("Inside RestController method..");

        return backendAdapter.getBackendResponse(simulateretry, simulateretryfallback);
    }
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return new ResponseEntity("Hello", HttpStatus.OK);

    }
}
