package com.example.webdevsp19s1deeshashahserverjava.services;

import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsp19s1deeshashahserverjava.model.Course;
import com.example.webdevsp19s1deeshashahserverjava.model.Lesson;
import com.example.webdevsp19s1deeshashahserverjava.model.Module;
import com.example.webdevsp19s1deeshashahserverjava.model.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@RestController
public class TopicService {
	@Autowired
	CourseService courseService = new CourseService();
	
	@Autowired
	ModuleService moduleService = new ModuleService();
	
	@Autowired
	LessonService lessonService = new LessonService();
	
	@GetMapping("/api/lesson/{lid}/topic")
	public List<Topic> findAllTopics(@PathVariable("lid") Integer id){
		return lessonService.findLessonById(id).getTopics();
	}
	
	@GetMapping("/api/topic/{tid}")
	public Topic findTopicById(@PathVariable("tid") Integer id) {
		List<Course> courses = courseService.findAllCourses();
		for(Course course: courses) {
			List<Module> modules = course.getModules();
			for(Module module: modules) {
				List<Lesson> lessons = module.getLessons();
				for(Lesson lesson: lessons) {
					List<Topic> topics = lesson.getTopics();
					for(Topic topic: topics) {
						if(topic.getId().equals(id)) {
							return topic;
						}
					}
				}
			}
		}
		return null;
	}
	
	@PostMapping("/api/lesson/{lid}/topic")
	public Topic createTopic(@PathVariable("lid") Integer id, @RequestBody Topic topic) {
		Lesson lesson = lessonService.findLessonById(id);
		List<Topic> topics = lesson.getTopics();
		topics.add(topic);
		return topic;
	}
	
	@PutMapping("/api/topic/{tid}")
	public Topic updateTopic(@PathVariable("tid") Integer id, @RequestBody Topic newTopic) {
		List<Course> courses = courseService.findAllCourses();
		for(Course course: courses) {
			List<Module> modules = course.getModules();
			for(Module module: modules) {
				List<Lesson> lessons = module.getLessons();
				for(Lesson lesson: lessons) {
					List<Topic> topics = lesson.getTopics();
					for(Topic topic: topics) {
						if(topic.getId().equals(id)) {
							topic.setTitle(newTopic.getTitle());
							return topic;
						}
					}
				}
			}
		}
		return null;
	}
	
	@DeleteMapping("/api/topic/{tid}")
	public void deleteTopic(@PathVariable("tid") Integer id) {
		List<Course> courses = courseService.findAllCourses();
		for(Course course: courses) {
			List<Module> modules = course.getModules();
			for(Module module: modules) {
				List<Lesson> lessons = module.getLessons();
				for(Lesson lesson: lessons) {
					List<Topic> topics = lesson.getTopics();
					for(Topic topic: topics) {
						if(topic.getId().equals(id)) {
							topics.remove(topic);
							break;
						}
					}
				}
			}
		}
	}
}
