package it.com.cursospring.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.com.cursospring.converters.NumberConverter;
import it.com.cursospring.exceptions.UnsupportedMathOperationException;
import it.com.cursospring.math.SimpleMath;

@RestController
public class MathController {

	private static final String template = "Hello, %s!";
	private static final AtomicLong counter = new AtomicLong();
	
	private SimpleMath math = new SimpleMath();
	
//	@RequestMapping("/greeting")
//	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//		return new Greeting(counter.incrementAndGet(), String.format(template, name));
//	}
	
	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
					  @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/subtraction/{numberOne}/{numberTwo}")
	public Double subtraction(@PathVariable(value = "numberOne") String numberOne, 
							  @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/multiplication/{numberOne}/{numberTwo}")
	public Double multiplication(@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/division/{numberOne}/{numberTwo}")
	public Double division(@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable(value = "numberOne") String numberOne, 
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {
		
		if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
	}
	
	@GetMapping("/squareRoot/{number}")
	public Double squareRoot(@PathVariable(value = "number") String number) throws Exception {
		
		if(!NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Please set a numeric value!");
		}
		
		return math.squareRoot(NumberConverter.convertToDouble(number));
	}
	
	 
}