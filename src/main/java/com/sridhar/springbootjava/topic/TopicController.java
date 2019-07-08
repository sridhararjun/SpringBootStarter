/**
 * 
 */
package com.sridhar.springbootjava.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muralesx
 *
 */
@RestController
public class TopicController {

	@RequestMapping("/topics")
	public List<Topic> getAllTopics(){
/*		
 *		The generated JSON as a result of hitting this endpoint has key names corresponding to
 *		property names of the TOPIC class
 */		
		return Arrays.asList(
				new Topic("Spring","Spring Controller","Spring description"),
				new Topic("Hibernate","hibernate Controller","Hibernate description"),
				new Topic("JS","JS Controller","JS description")
				);
	}
	
}
