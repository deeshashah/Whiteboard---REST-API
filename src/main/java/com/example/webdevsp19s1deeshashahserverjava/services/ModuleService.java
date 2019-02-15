package com.example.webdevsp19s1deeshashahserverjava.services;

import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsp19s1deeshashahserverjava.model.Course;
import com.example.webdevsp19s1deeshashahserverjava.model.Lesson;
import com.example.webdevsp19s1deeshashahserverjava.model.Module;
import com.example.webdevsp19s1deeshashahserverjava.model.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
public class ModuleService {
	int moduleId = 2000;
	@Autowired
	CourseService courseService = new CourseService();
		
	@GetMapping("/api/courses/{courseId}/modules")
	public List<Module> findAllModules(@PathVariable("courseId") Integer cid, HttpSession session){
		return courseService.findCourseById(cid, session).getModules();
	}
	
	@GetMapping("/api/modules/{mid}")
	public Module findModuleById(@PathVariable("mid") Integer id, HttpSession session) {
		List<Course> courses = courseService.findAllCourses(session);
		for(Course course: courses) {
			List<Module> modules = course.getModules();
			for(Module module: modules) {
				if(module.getId().equals(id)) {
					return module;
				}
			}
		}
		
		return null;
	}
	
	@PostMapping("/api/courses/{cid}/modules")
	public Module createModule(@PathVariable("cid") Integer id, @RequestBody Module module, HttpSession session) {
		Course course = courseService.findCourseById(id, session);
		module.setId(moduleId++);
		if(module.getTitle().equals("")){
			module.setTitle("New Module");
			List<Lesson> lessons = new ArrayList<Lesson>();
			Lesson l = new Lesson(777, "New Lesson");
			
			List<Topic> topics = new ArrayList<Topic>();
			Topic t = new Topic(888, "New Topic");
			topics.add(t);
			l.setTopics(topics);
			lessons.add(l);
			module.setLessons(lessons);
		}
		List<Module> modules = course.getModules();
		modules.add(module);
		return module;
	}
	
	@PutMapping("/api/modules/{mid}")
	public Module updateModule(@PathVariable("mid") Integer id, @RequestBody Module newModule, HttpSession session) {
		List<Course> courses = courseService.findAllCourses(session);
		for(Course course: courses) {
			List<Module> modules = course.getModules();
			for(Module module: modules) {
				if(module.getId().equals(id)) {
					module.setTitle(newModule.getTitle());
					return module;
				}
			}
		}
		return null;
	}
	
	@DeleteMapping("/api/modules/{mid}")
	public void deleteModule(@PathVariable("mid") Integer id, HttpSession session) {
		List<Course> courses = courseService.findAllCourses(session);
		for(Course course: courses) {
			List<Module> modules = course.getModules();
			for(Module module: modules) {
				if(module.getId().equals(id)) {
					course.getModules().remove(module);
					break;
					
				}
			}
		}
	}
	
	
}
