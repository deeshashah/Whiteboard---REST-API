package com.example.webdevsp19s1deeshashahserverjava.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsp19s1deeshashahserverjava.model.Course;
import com.example.webdevsp19s1deeshashahserverjava.model.Lesson;
import com.example.webdevsp19s1deeshashahserverjava.model.Module;
import com.example.webdevsp19s1deeshashahserverjava.model.Topic;


@RestController
public class CourseService {
	Course cs5610 = new Course(123, "CS5610");
	Course cs4500 = new Course(234, "CS4500");
	
	public List<Module> cs4500modules = new ArrayList<Module>();
	Module cs4500W1 = new Module(123, "Week1");
	Module cs4500W2 = new Module(234, "Week2");
	
	List<Lesson> cs4500W1Lessons = new ArrayList<Lesson>();
	Lesson w1Html = new Lesson(301, "HTML");
	Lesson w1Css = new Lesson(302, "CSS");
	Lesson w1Bootstrap = new Lesson(303, "Bootstrap");
	
	List<Lesson> cs4500W2Lessons = new ArrayList<Lesson>();
	Lesson w2Javascript = new Lesson(304, "Javascript");
	Lesson w2Jquery = new Lesson(305, "Jquery");
	
	List<Topic> htmlTopics = new ArrayList<Topic>();
	Topic topicDom = new Topic(601, "The DOM");
	Topic topicTags = new Topic(602, "Tags");
	
	List<Topic> cssTopics = new ArrayList<Topic>();
	Topic topicBorders = new Topic(603, "Borders");
	Topic topicColors = new Topic(604, "Colors");
	
	List<Topic> bootstrapTopics = new ArrayList<Topic>();
	Topic topicGrids = new Topic(605, "Grids");
	Topic topicCarousels = new Topic(606, "Carousels");
	
	List<Topic> javascriptTopics = new ArrayList<Topic>();
	Topic topicVariables = new Topic(607, "Variables");
	Topic topicCallbacks = new Topic(608, "Callbacks");
	
	List<Topic> jqueryTopics = new ArrayList<Topic>();
	Topic topicEvents = new Topic(609, "Events");
	
	List<Course> courses = new ArrayList<Course>();
	{
		//setting lessons for html
		htmlTopics.add(topicDom);
		htmlTopics.add(topicTags);
		w1Html.setTopics(htmlTopics);
		
		//setting lessons for css
		cssTopics.add(topicBorders);
		cssTopics.add(topicColors);
		w1Css.setTopics(cssTopics);
		
		//setting lessons for bootstrap
		bootstrapTopics.add(topicGrids);
		bootstrapTopics.add(topicCarousels);
		w1Bootstrap.setTopics(bootstrapTopics);
		
		//setting lessons for js
		javascriptTopics.add(topicVariables);
		javascriptTopics.add(topicCallbacks);
		w2Javascript.setTopics(javascriptTopics);
		
		
		//setting lessons for jquery
		jqueryTopics.add(topicEvents);
		w2Jquery.setTopics(jqueryTopics);
		
		
		// setting the lessons for module w1 in course cs4500
		cs4500W1Lessons.add(w1Html);
		cs4500W1Lessons.add(w1Css);
		cs4500W1Lessons.add(w1Bootstrap);
		cs4500W1.setLessons(cs4500W1Lessons);

		// setting the lessons for module w2 in course cs4500
		cs4500W2Lessons.add(w2Javascript);
		cs4500W2Lessons.add(w2Jquery);
		cs4500W2.setLessons(cs4500W2Lessons);
		
		cs4500modules.add(cs4500W1);
		cs4500modules.add(cs4500W2);
		
		cs4500.setModules(cs4500modules);
		courses.add(cs5610);
		courses.add(cs4500);
	}
	
	@PostMapping("/api/courses")
	public Course createCourse(@RequestBody Course course) {
		courses.add(course);
		return course;
	}
	
	@GetMapping("/api/courses")
	public List<Course> findAllCourses() {
		return courses;
	}
	
	@GetMapping("/api/courses/{courseId}")
	public Course findCourseById(@PathVariable("courseId") Integer id) {
		for(Course course:courses) {
			if(course.getId().equals(id)) {
				return course;
			}
		}
		return null;
	}
	
	@PutMapping("/api/courses/{courseId}")
	public Course updateCourse(@PathVariable("courseId") Integer id, @RequestBody Course newCourse) {
		for(Course course:courses) {
			if(course.getId().equals(id)) {
				course.setTitle(newCourse.getTitle());
//				List<Module> m = newCourse.getModules();
//				course.setModules(m);
				return course;
			}
		}
		return null;
	}
	
	@DeleteMapping("/api/courses/{courseId}")
	public void deleteCourse(@PathVariable("courseId") Integer id) {
		for(Course course: courses) {
			if(course.getId().equals(id)) {
				courses.remove(course);
				break;
			}
		}
	}
	
	
}

