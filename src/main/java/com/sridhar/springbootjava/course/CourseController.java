/**
 * 
 */
package com.sridhar.springbootjava.course;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sridhar.springbootjava.topic.Topic;

/**
 * @author muralesx
 *
 */
@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id) {
		/*
		 * The generated JSON as a result of hitting this endpoint has key names
		 * corresponding to property names of the TOPIC class
		 */
		return courseService.getCourseList(id);
	}

	@RequestMapping("/topics/{topicId}/courses/{courseId}")
	public Course getCourse(@PathVariable("courseId") String id) {
		return courseService.getCourse(id);
	}

	/*
	 * 
	 * @RequestBody takes care of converting the incoming type in the request to the
	 * specified argument type Its like telling the application to take the COURSE
	 * instance from the request payload
	 * 
	 * Also, When trying to hit the POST request from a rest-api client like POSTMAN
	 * make sure you set the content-type = application/json, because by default it
	 * thinks that the sent body is a string.so we had to explicitly let the
	 * application knwo that its a JSON object
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable("topicId") String id) {
		course.setTopic(new Topic(id, "", ""));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
	public void updateCourses(@RequestBody Course course, @PathVariable("topicId") String topicId,@PathVariable("courseId") String courseId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
	public void deleteCourses(@PathVariable("courseId") String id) {
		courseService.deleteCourse(id);
	}

}
