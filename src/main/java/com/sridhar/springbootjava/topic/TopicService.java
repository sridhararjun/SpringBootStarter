/**
 * 
 */
package com.sridhar.springbootjava.topic;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

/**
 * @author muralesx
 *
 */
/*
 * In Spring,Business Service is Singleton.It's like spring will create an
 * instance of the service at the start-up and stores it and whenever its
 * dependency is needed,it readily injects it.
 * 
 */
@Service
public class TopicService {

	private List<Topic> topicList = Arrays.asList(new Topic("Spring", "Spring Controller", "Spring description"),
			new Topic("Hibernate", "hibernate Controller", "Hibernate description"),
			new Topic("JS", "JS Controller", "JS description"));

	/**
	 * @return the topicList
	 */
	public List<Topic> getTopicList() {
		return topicList;
	}

	public Topic getTopic(String id) {
		return topicList.stream().filter(new Predicate<Topic>() {

			@Override
			public boolean test(Topic t) {
				return t.getId().equals(id);
			}
		}).findFirst().get();

		// return topicList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void add(Topic topic) {
		topicList.add(topic);
	}

}
