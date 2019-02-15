package com.example.webdevsp19s1deeshashahserverjava.services;

import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsp19s1deeshashahserverjava.model.Course;
import com.example.webdevsp19s1deeshashahserverjava.model.Lesson;
import com.example.webdevsp19s1deeshashahserverjava.model.Module;

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
public class LessonService {
	int lessonId = 4000;
	
	@Autowired
	CourseService courseService = new CourseService();
	
	@Autowired
	ModuleService moduleService = new ModuleService();
	
	@GetMapping("/api/module/{mid}/lesson")
	public List<Lesson> findAllLessons(@PathVariable("mid") Integer id, HttpSession session){
		return moduleService.findModuleById(id, session).getLessons();
	}
	
	@GetMapping("api/lesson/{lid}")
	public Lesson findLessonById(@PathVariable("lid") Integer id, HttpSession session) {
		List<Course> courses = courseService.findAllCourses(session);
		for(Course course: courses) {
			List<Module> modules = course.getModules();
			for(Module module: modules) {
				List<Lesson> lessons = module.getLessons();
				for(Lesson lesson: lessons) {
					if(lesson.getId().equals(id)) {
						return lesson;
					}
				}
			}
		}
		return null;
	}
	
	@PostMapping("api/module/{mid}/lesson")
	public Lesson createLesson(@PathVariable("mid") Integer id, @RequestBody Lesson lesson, HttpSession session) {
		Module module = moduleService.findModuleById(id, session);
		lesson.setId(lessonId++);
		if(lesson.getTitle().equals("")){
			lesson.setTitle("New Lesson");
		}
		List<Lesson> lessons = module.getLessons();
		lessons.add(lesson);
		return lesson;
	}
	
	@PutMapping("/api/lesson/{lid}")
	public Lesson updateLesson(@PathVariable("lid") Integer id, @RequestBody Lesson newLesson, HttpSession session) {
		List<Course> courses = courseService.findAllCourses(session);
		for(Course course: courses) {
			List<Module> modules = course.getModules();
			for(Module module: modules) {
				List<Lesson> lessons = module.getLessons();
				for(Lesson lesson: lessons) {
					if(lesson.getId().equals(id)) {
						lesson.setTitle(newLesson.getTitle());
						return lesson;
					}
				}
			}
		}
		return null;
	}
	
	@DeleteMapping("/api/lesson/{lid}")
	public void deleteLesson(@PathVariable("lid") Integer id, HttpSession session) {
		List<Course> courses = courseService.findAllCourses(session);
		for(Course course: courses) {
			List<Module> modules = course.getModules();
			for(Module module: modules) {
				List<Lesson> lessons = module.getLessons();
				for(Lesson lesson: lessons) {
					if(lesson.getId().equals(id)) {
						lessons.remove(lesson);
						break;
					}
				}
			}
		}
	}

}
