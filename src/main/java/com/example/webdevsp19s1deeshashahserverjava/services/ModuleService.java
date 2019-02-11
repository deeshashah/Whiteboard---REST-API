package com.example.webdevsp19s1deeshashahserverjava.services;

import org.springframework.web.bind.annotation.RestController;

import com.example.webdevsp19s1deeshashahserverjava.model.Course;
import com.example.webdevsp19s1deeshashahserverjava.model.Module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@RestController
public class ModuleService {
	@Autowired
	CourseService courseService = new CourseService();
		
	@GetMapping("/api/courses/{courseId}/modules")
	public List<Module> findAllModules(@PathVariable("courseId") Integer cid){
		return courseService.findCourseById(cid).getModules();
	}
	
	@GetMapping("/api/modules/{mid}")
	public Module findModuleById(@PathVariable("mid") Integer id) {
		List<Course> courses = courseService.findAllCourses();
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
	public Module createModule(@PathVariable("cid") Integer id, @RequestBody Module module) {
		Course course = courseService.findCourseById(id);
		List<Module> modules = course.getModules();
		modules.add(module);
		return module;
	}
	
	@PutMapping("/api/modules/{mid}")
	public Module updateModule(@PathVariable("mid") Integer id, @RequestBody Module newModule) {
		List<Course> courses = courseService.findAllCourses();
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
	public void deleteModule(@PathVariable("mid") Integer id) {
		List<Course> courses = courseService.findAllCourses();
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
