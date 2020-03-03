package com.deepankar.springbootdemo.course;

import com.deepankar.springbootdemo.topics.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllTopics(@PathVariable String id)
    {
        return courseService.getAllCourses (id);
    }

    @RequestMapping("/topics/{topicId}/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse (id);
    }

    @PostMapping(value = "/topics/{topicId}/courses")
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic (new Topic (topicId, "", ""));
        courseService.addCourse(course);
    }

    @PutMapping(value = "/topics/{topicId}/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id, @PathVariable String topicId){
        course.setTopic (new Topic (topicId, "", ""));
        courseService.updateCourse (id, course);
    }

    @DeleteMapping(value = "/topics/{topicId}/courses/{id}")
    public void deleteCourse(@PathVariable String id){
        courseService.deleteCourse(id);

    }
}
