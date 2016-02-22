package br.com.damoreira;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestController
public class ExampleController {

	@RequestMapping(value = "/{barcode}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public void validate(@PathVariable String barcode) throws Exception {
		System.out.println(String.format("Barcode: %s", barcode));
		if ("200".equals(barcode)) {
			return;
		}
		throw new Exception("Not 200");
	}
	
	@ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleIOException(Throwable ex) {
        return ex.toString();
    }

}