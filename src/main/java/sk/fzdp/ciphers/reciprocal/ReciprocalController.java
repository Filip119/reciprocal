package sk.fzdp.ciphers.reciprocal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ReciprocalController {

	/** Flag for waiting when enabled */
    private boolean timeout = false;
    /** Flag for throwing a 503 when enabled */
    private boolean misbehave = false;
    
	@Autowired
	private ReciprocalService reciprocalService;

	@RequestMapping(path = "/reciprocal/encode/{text}", method = RequestMethod.GET)
	public String encodeReciprocal(@PathVariable String text) {
		if (timeout) {
			try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {
	        }
        }
        if (misbehave) {
        	throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Service misbehaving...");
        }
		return reciprocalService.encode(text);
	}
	
	@RequestMapping(path = "/reciprocal/decode/{text}", method = RequestMethod.GET)
	public String decodeReciprocal(@PathVariable String text) {

		return reciprocalService.decode(text);
	}

	@RequestMapping(path = "/reciprocal/timeout", method = RequestMethod.GET)
    public String flagTimeout() {
        this.timeout = true;
        return "Ok";
    }

	@RequestMapping(path = "/reciprocal/timein", method = RequestMethod.GET)
    public String flagTimein() {
        this.timeout = false;
        return "Ok";
    }

	@RequestMapping(path = "/reciprocal/misbehave", method = RequestMethod.GET)
    public String flagMisbehave() {
        this.misbehave = true;
        return "Ok";
    }

	@RequestMapping(path = "/reciprocal/behave", method = RequestMethod.GET)
    public String flagBehave() {
        this.misbehave = false;
        return "Ok";
    }
}
