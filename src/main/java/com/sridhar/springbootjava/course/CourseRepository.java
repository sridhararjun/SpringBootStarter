package com.sridhar.springbootjava.course;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sridhar.springbootjava.topic.Topic;

@Repository
public interface CourseRepository extends CrudRepository<Course, String> {

	/*
	 * One might wonder what is happening on here. I have declared a method in an
	 * interface but i haven't implemented it in the class that i implemented this
	 * interface. OK.SO.What Spring-Data-JPA does is , since it's CRUDREPORSITORY's
	 * find methods start with "find" we have to declare a method with the same name
	 * as "find".So next? i am going to search by a parameter, so "By" and what is
	 * it topic ID right.But, see the Course.java, the return type of topic is
	 * Topic.class , but the argument is a string which is topicId,so "TopicId", the
	 * Id as in the Topic.java class.Simple as that.Now just call this method from
	 * the autowired courseRepository and the rest is taken care by Spring-Data-JPA
	 * 
	 * The KEY is in the naming. The name should be findBy<the-property> If the
	 * property is the property of an object.Then narrow it down correctly
	 */
	public List<Course> findByTopicId(String topicId);

}
