/**
 * 
 */
package com.sridhar.springbootjava.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

	/*
	 * Arrays.asList gives an immutable array to list.so, declare it like new
	 * ArrayList<>(Arrays.asList.....
	 */
	private List<Topic> topicList = new ArrayList<>(
			Arrays.asList(new Topic("Spring", "Spring Controller", "Spring description"),
					new Topic("Hibernate", "hibernate Controller", "Hibernate description"),
					new Topic("JS", "JS Controller", "JS description")));

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

		// return topicList.stream().filter(t ->
		// t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicList.add(topic);
	}

	public void updateTopic(String id, Topic topic) {
		if (!StringUtils.isEmpty(id) && topic != null) {
			for (int i = 0; i < topicList.size(); i++) {
				if (topicList.get(i).getId().equals(id)) {
					topicList.set(i, topic);
					return;
				}
			}
		}
	}

	public void deleteTopic(String id) {
		// topicList.removeIf(new Predicate<Topic>() {
		//
		// @Override
		// public boolean test(Topic t) {
		// return t.getId().equals(id);
		// }
		// });
		topicList.removeIf(t -> t.getId().equals(id));
	}

}
