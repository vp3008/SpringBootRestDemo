package com.deepankar.springbootdemo.lesson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonService {

    @Autowired
    private LessonRepository lessonRepository;

    public List<Lesson> getAllLessons (String id) {
        return lessonRepository.findByCourseId (id);
    }

    public Lesson getLesson(String id){
        return lessonRepository.findById (id).get ();
    }

    public void addLesson (Lesson lesson) {
        lessonRepository.save (lesson);
    }

    public void updateLesson (String id, Lesson lesson) {
        lessonRepository.save (lesson);

    }

    public void deleteLesson(String id){
        lessonRepository.deleteById (id);

    }
}
