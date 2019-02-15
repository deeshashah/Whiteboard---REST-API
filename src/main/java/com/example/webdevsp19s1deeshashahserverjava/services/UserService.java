package com.example.webdevsp19s1deeshashahserverjava.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.webdevsp19s1deeshashahserverjava.model.Course;
import com.example.webdevsp19s1deeshashahserverjava.model.HeadingWidget;
import com.example.webdevsp19s1deeshashahserverjava.model.ImageWidget;
import com.example.webdevsp19s1deeshashahserverjava.model.Lesson;
import com.example.webdevsp19s1deeshashahserverjava.model.LinkWidget;
import com.example.webdevsp19s1deeshashahserverjava.model.Module;
import com.example.webdevsp19s1deeshashahserverjava.model.ParagraphWidget;
import com.example.webdevsp19s1deeshashahserverjava.model.Topic;
import com.example.webdevsp19s1deeshashahserverjava.model.User;
import com.example.webdevsp19s1deeshashahserverjava.model.Widget;

import java.util.*;

import javax.servlet.http.HttpSession;

@RestController
@CrossOrigin(origins = "http://faculty-whiteboard.herokuapp.com", allowCredentials = "true", allowedHeaders = "*")
public class UserService {
	int userId = 0;
	User alice = new User(123, "alice","rabbit", "Alice", "Wonderland", "FACULTY", "87645321934", "alice@gmail.com");
	User bob   = new User(234, "bob","rab", "Bob", "Marley", "FACULTY", "9738432345", "bob@gmail.com");
	List<User> users = new ArrayList<User>();
	
	List<Course> aliceCourses = new ArrayList<Course>();
	List<Course> bobCourses = new ArrayList<Course>();
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
	
	List<Widget> domWidgets = new ArrayList<Widget>();
	Widget domHeadingWidget = new HeadingWidget(801, "Heading", "HEADING", "The DOM", 1);
	Widget domParagraphWidget = new ParagraphWidget(802, "Paragraph", "PARAGRAPH", "This topic introduces the DOM");
	Widget domImageWidget = new ImageWidget(803, "Image", "IMAGE", "https://picsum.photos/200");
	{
		domWidgets.add(domHeadingWidget);
		domWidgets.add(domParagraphWidget);
		domWidgets.add(domImageWidget);
		topicDom.setWidgets(domWidgets);
	}
	
	
	List<Widget> tagsWidgets = new ArrayList<Widget>();
	Widget tagsHeadingWidget = new HeadingWidget(803, "Heading", "HEADING", "Tags", 1);
	Widget tagsParagraphWidget = new ParagraphWidget(804, "Paragraph", "PARAGRAPH", "This topic introduces the tags in HTMl");
	{
		tagsWidgets.add(tagsHeadingWidget);
		tagsWidgets.add(tagsParagraphWidget);
		
		topicTags.setWidgets(tagsWidgets);
	}
	
	List<Topic> cssTopics = new ArrayList<Topic>();
	Topic topicBorders = new Topic(603, "Borders");
	Topic topicColors = new Topic(604, "Colors");
	
	List<Widget> borderWidgets = new ArrayList<Widget>();
	Widget borderHeadingWidget = new HeadingWidget(805, "Heading", "HEADING", "Borders", 1);
	Widget borderParagraphWidget = new ParagraphWidget(806, "Paragraph", "PARAGRAPH", "This topic introduces the borders in css");
	Widget borderImageWidget = new ImageWidget(807, "Image", "IMAGE", "https://picsum.photos/200");
	{
		borderWidgets.add(borderHeadingWidget);
		borderWidgets.add(borderParagraphWidget);
		borderWidgets.add(borderImageWidget);
		
		topicBorders.setWidgets(borderWidgets);
		
	}
	
	List<Widget> colorWidgets = new ArrayList<Widget>();
	Widget colorHeadingWidget = new HeadingWidget(809, "Heading", "HEADING", "Colors", 1);
	Widget colorParagraphWidget = new ParagraphWidget(810, "Paragraph", "PARAGRAPH", "This topic introduces colors in CSS");
	Widget colorLinkWidget = new LinkWidget(811, "Link", "LINK", "flatcolors.io", "www.flatcolors.io");
	
	{
		colorWidgets.add(colorHeadingWidget);
		colorWidgets.add(colorParagraphWidget);
		colorWidgets.add(colorLinkWidget);
		
		topicColors.setWidgets(colorWidgets);
	}
	
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
		
		aliceCourses.add(cs4500);
		bobCourses.add(cs5610);
		alice.setAuthoredCourses(aliceCourses);
		bob.setAuthoredCourses(bobCourses);
	}
	
	
	UserService(){
		users.add(alice);
		users.add(bob);
	}

	
	@PostMapping("/api/login")
	public User login(@RequestBody User loginUser, HttpSession session) {
		for(User user: users) {
			if(user.getUsername().equals(loginUser.getUsername()) && user.getPassword().equals(loginUser.getPassword())) {
				session.setAttribute("currUser", user);
				return user;
			}
		}
		return null;
	}
	
	@PostMapping("/api/register")
	public User register(@RequestBody User user, HttpSession session) {
		for(User u: users) {
			if(u.getUsername().equals(user.getUsername())) {
				
				return null;
			}
		}
		user.setId(userId++);
		session.setAttribute("currUser", user);
		users.add(user);
		return user;
	}
	
	@GetMapping("/api/profile")
	public User profile(HttpSession session) {
		System.out.println((User)session.getAttribute("currUser"));
		return (User)session.getAttribute("currUser");
	}
	
	@GetMapping("/api/users")
	public User[] findAllUser() {
		User[] users = new User[this.users.size()];
		return this.users.toArray(users);
	}

	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@GetMapping("/api/user/{userId}")
	public User findUserById(
			@PathVariable("userId") Integer id) {
		for(User user: users) {
			if(id == user.getId().intValue())
				return user;
		}
		return null;
	}

	@PostMapping("/api/user")
	public User createUser(@RequestBody User user) {
		users.add(user);
		return user;
	}

	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(
		@PathVariable("userId") Integer id) {
		for(User usr: users){
			if(id == usr.getId().intValue())
				users.remove(usr);
		}
	}

	@PutMapping("api/user/{userId}")
	public @ResponseBody User updateUser(
		@PathVariable("userId") String id, @RequestBody User user) {
		
		for(int i=0;i<users.size();i++){
			if(users.get(i).getUsername().equals(id)){
				users.get(i).setEmail(user.getEmail());
				users.get(i).setPhone(user.getPhone());
				users.get(i).setRole(user.getRole());
				//session.setAttribute("currUser", user);
				return user;
			}
		}

		return null;
	}
}