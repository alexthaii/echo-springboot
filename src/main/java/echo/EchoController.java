package echo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
public class EchoController {

    private static final Logger log = LoggerFactory.getLogger(EchoController.class);

    private Echo echo;

    public EchoController(Echo echo) {
        this.echo = echo;
    }

    @PostMapping(value="/echo")
    String echo(@RequestBody String message){
        log.info("Message: {}", message);

        return echo.send(message);
    }

    @GetMapping(value="/ping/health")
	public ResponseEntity<String> ping() {
		
		StringBuilder sb = new StringBuilder("Application is running.");

		return new ResponseEntity<>(sb.toString(), HttpStatus.OK);

	}
}