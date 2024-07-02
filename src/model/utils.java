/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author nitishahuja
 */
public class Utils {
    CourseDirectory courseDirectory;
    AssignmentDirectory assignmentDirectory;
    UserDirectory userDirectory;
    UserToCourseDirectory userToCourseDirectory;
    
    public Utils(){
        this.courseDirectory = new CourseDirectory();
        this.assignmentDirectory = new AssignmentDirectory();
        this.userDirectory = new UserDirectory();
        this.userToCourseDirectory = new UserToCourseDirectory();
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger bigInt = new BigInteger(1, messageDigest);
            return bigInt.toString(16);
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static int generateRandomId() {
        Random random = new Random();
        int randomId = random.nextInt(10000); // You can adjust the range as needed
        return randomId;
    }
    
    public ArrayList<Course> getCourse(){
        return courseDirectory.getCourses();
    }

    public ArrayList<Assignment> getAssignment(){
        return assignmentDirectory.getAssignments();
    }
    
    public User getUserDetails(String username){
        return userDirectory.getUserByUsername(username);
    }
    
    public boolean enrollStudentToCourse(Course course, User user){
        return courseDirectory.enrollStudent(course, user);
    }
    
    public boolean createCourse(Course course, String profName, int profId){
        return courseDirectory.createCourse(course, profName, profId);
    }
    
//    public ArrayList<User> getCourseByUserId(int userId){
//        return userDirectory.getUserById(userId);
//    }
    
    public ArrayList<UserToCourse> getCoursesByStudentId(int studentId){
        return userToCourseDirectory.getStudentsByUserId(studentId);
    }
    
    public boolean createAssignment(ArrayList<UserToCourse> students, Assignment newAssignment){
        return assignmentDirectory.createAssignment(students, newAssignment);
    }
    
    public ArrayList<UserToCourse> getStudentsByCourseId(int courseId){
        return userToCourseDirectory.getStudentsByCourseId(courseId);
    }
    
    public ArrayList<Course> getCoursesWithProfID(int profID){
        return courseDirectory.getCoursesWithProfID(profID);
    }
    
    public boolean UpdateStudentScore(int score, int studentId){
        return userToCourseDirectory.updateStudentScore(score, studentId);
    }
    
    public boolean UpdateAttendance(int courseId, int userId, int attendance){
        return userToCourseDirectory.updateAttendance(courseId, userId, attendance);
    }
    
    public ArrayList<Course> getCoursesByCourseId(ArrayList<UserToCourse> userToCourse){
        return courseDirectory.getCoursesByCourseId(userToCourse);
    }
    
    public ArrayList<Assignment> getAssignmentsWithStudentID(int studentId){
        return assignmentDirectory.getAssignmentsWithStudentID(studentId);
    }
}
