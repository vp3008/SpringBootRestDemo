package com.deepankar.springbootdemo.lesson;

import com.deepankar.springbootdemo.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @RequestMapping("/topics/{topicId}/courses/{id}/lessons")
    public List<Lesson> getAllLessons(@PathVariable  String id) {
        return lessonService.getAllLessons(id);
    }

    @RequestMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
    public Lesson getLesson(@PathVariable  String id){
        return lessonService.getLesson (id);
    }

    @PostMapping(value = "/topics/{topicId}/courses/{courseId}/lessons")
    public void addLesson(@RequestBody  Lesson lesson, @PathVariable String courseId, @PathVariable String topicId){
        lesson.setCourse (new Course (courseId, "", "", topicId));
        lessonService.addLesson(lesson);
    }

    @PutMapping(value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void updateLesson(@RequestBody Lesson lesson, @PathVariable String lessonId,
                             @PathVariable String topicId, @PathVariable String courseId){
        lesson.setCourse (new Course (courseId, "", "", topicId));
        lessonService.updateLesson(lessonId, lesson);
    }

    @DeleteMapping(value = "/topics/{topicId}/courses/{courseId}/lessons/{lessonId}")
    public void deleteLesson(@PathVariable String lessonId){
        lessonService.deleteLesson(lessonId);
    }
}
