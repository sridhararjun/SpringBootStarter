/**
 * 
 */
package com.sridhar.springbootjava.topic;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author muralesx
 *
 */
@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		/*
		 * The generated JSON as a result of hitting this endpoint has key names
		 * corresponding to property names of the TOPIC class
		 */
		return topicService.getTopicList();
	}

	@RequestMapping("/topics/{id}")
	public Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}

	/*
	 * 
	 * @RequestBody takes care of converting the incoming type in the request to the
	 * specified argument type Its like telling the application to take the TOPIC
	 * instance from the request payload
	 * 
	 * Also, When trying to hit the POST request from a rest-api client like POSTMAN
	 * make sure you set the content-type = application/json, because by default it
	 * thinks that the sent body is a string.so we had to explicitly let the
	 * application knwo that its a JSON object
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopics(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void addTopics(@RequestBody Topic topic, @PathVariable("id") String id) {
		topicService.updateTopic(id, topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopics(@PathVariable("id") String id) {
		topicService.deleteTopic(id);
	}

}
