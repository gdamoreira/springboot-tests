package br.com.damoreira;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

	@RequestMapping(value = "/{barcode}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void validate(@PathVariable String barcode) {
		System.out.println(String.format("Barcode: %s", barcode));
	}

}