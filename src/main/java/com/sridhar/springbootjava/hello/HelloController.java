/**
 * 
 */
package com.sridhar.springbootjava.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muralesx
 *
 */
@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String sayHi() {
		return "HEllo MArk!!!";
	}
	
	
}
