/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Muhammad Adnan Mohib
 */
public class CourseResult {
    
    // Data members
    private String CourseID;
    private String CourseTitle;
    private int CreditHours;
    private int Semester;
    private int Marks;
    
    /**
     * Default Constructor
     */
    public CourseResult(){
        this.CourseID = "";
        this.CourseTitle = "";
        this.CreditHours = 0;
        this.Semester = 0;
    }
    /**
     * constructor with parameters 
     * @param id
     * @param title
     * @param CH
     * @param sem 
     * @param marks 
     */
    public CourseResult(String id, String title, int CH, int sem, int marks) {
        if(this.isValidCourseID(id) &&
           this.isValidCourseTitle(title) &&
           this.isValidSemester(sem) &&
           this.areValidCreditHours(CH) &&
           this.areValidMarks(marks)) {
            this.CourseID = id;
            this.CourseTitle = title;
            this.CreditHours = CH;
            this.Semester = sem;
            this.Marks = marks;
        }
    }
    
    /**
     * copy Constructor 
     * @param CourseRsult 
     */
    public CourseResult(CourseResult CourseRsult) {
        this.CourseID = CourseRsult.CourseID;
        this.CourseTitle = CourseRsult.CourseTitle;
        this.CreditHours = CourseRsult.CreditHours;
        this.Semester = CourseRsult.Semester;
        this.Marks = CourseRsult.Marks;
    }
    /**
     * setter functions for data members
     */
    /**
     * Setter Method for Course ID
     * @param id 
     */
    public boolean setCourseID(String id) {
        try{
            if (this.isValidCourseID(id)) {
                this.CourseID = id;
                return true;
            } else {
                throw  new Exception();
            }
        } catch (Exception e) {
            System.out.println("Invalid Course ID Entered");
            return false;
        }
    }
    /**
     * Setter Method for the Course Title
     * @param cTitle 
     */
    public boolean setCourseTitle(String cTitle) {
        try{
            if(this.isValidCourseTitle(cTitle)) {
                this.CourseTitle = cTitle;
                return true;
            } else {
                throw  new Exception();
            }
        } catch (Exception e ) {
            System.out.println("Invalid Course Title Entered");
            return false;
        }
    }
    /**
     * Setter Method for Credit Hours
     * @param cHours 
     */
    public boolean setCreditHours(int cHours) {
        try{
            if(this.areValidCreditHours(cHours)) {
                this.CreditHours = cHours;
                return true;
            } else {
                throw new Exception();
            }
        } catch(Exception e) {
            System.out.println("Invalid Credit Hours Entered");
            return false;
        }
        
    }
    /**
     * setter method for Marks
     * @param Marks 
     */
    public boolean setMarks(int Marks) {
        try{
            if(this.areValidMarks(Marks)) {
                this.Marks = Marks;
                return true;
            } else {
                throw new Exception();
            }
        } catch(Exception e) {
            System.out.println("Invalid Marks Entered");
            return false;
        }
            
    }
    /**
     * Setter Method for Semester
     * @param Sem 
     */
    public boolean setSemester(int Sem) {
        try{
            if(this.isValidSemester(Sem)) {
                this.Semester = Sem;
                return true;
            } else {
                throw new Exception();
                
            }
        } catch(Exception e) {
            System.out.println("Invalid Semseter Entered it be 1-8");
            return false;
        }
    }
    /**
     * getter methods for data members
     */
    /**
     * Getter Method for Course ID
     * @return String
     */
    public String getCourseID() {
        return this.CourseID;
    }
    /**
     * Getter Method for Course Title
     * @return String
     */
    public String getCourseTitle() {
        return this.CourseTitle;
    }
    /**
     * getter method for Credit Hours
     * @return  integer
     */
    public int getCreditHours() {
        return this.CreditHours;
    }
    /**
     * getter method for Marks
     * @return integer
     */
    public int getMarks() {
        return this.Marks;
    }
    /**
     * getter method for Semester
     * @return  integer
     */
    public int getSemester() {
        return this.Semester;
    }
    
    /**
     * member functions
     *get the grade points
     * @return double
     */ 
    
    public double getGradePoints() {
        // get the grade from getGrade() method
        String grade = this.getGrade();
        // return Course Points on basis of Grade
        switch(grade)
        {
            case "A":
            {
                return 4.0;
                // though case of switch statement requires break
                // but return statement will never let this statement to
                // execute so it is not written after every case of switch
                // break;
            }
            case "A-":
            {
                return 3.7;
            }
            case "B+":
            {
                return 3.3;
            }
            case "B-":
            {
                return 3.0;
            }
            case "C+":
            {
                return 2.7;
            }
            case "C":
            {
                return 2.3;
            }
            case "D":
            {
                return 1.0;
            }
            case "F":
            {
                return 0;
            }
        }
        return 0.0;
    }
    
    /**
     * function to get the grade of Subject
     * @return String
     */
    public String getGrade() {
        if(this.Marks < 40) {
            return "F";
        } else if (this.Marks < 50) {
            return "D";
        } else if (this.Marks < 55) {
            return "C";
        } else if (this.Marks < 60) {
            return "C+";
        } else if (this.Marks < 65) {
            return "B-";
        } else if (this.Marks < 70) {
            return "B+";
        } else if (this.Marks <= 80) {
            return "A-";
        } else if (this.Marks > 80) {
            return "A";
        }
        return "";
    }
    /**
     * overriding toString Method
     * @return String
     */ 
    @Override
    public String toString() {
        return "CourseResult{" + "CourseID=" + CourseID + ", CourseTitle=" + CourseTitle + 
                ", CreditHours=" + CreditHours + ", Semester=" + Semester + ", Marks=" + Marks + '}';
    }

//    @Override
//    public String toString(){
//        return "";
//    };
/**
     * Validator Functions
     */
    /**
     * validation of CourseID
     * @param courseID
     * @return boolean
     */
    private boolean isValidCourseID(String cID) {
        if(cID.length() >= 2 && cID.length() <=8) {
            // if first two or three charactes are alphabets 
            if(cID.substring(0, 2).chars().allMatch(Character::isLetter) ||
                    cID.substring(0, 3).chars().allMatch(Character::isLetter)) {
                if(cID.length() > 3){
                    if(cID.substring(2,5).chars().allMatch(Character::isDigit)||
                            cID.substring(3,6).chars().allMatch(Character::isDigit)) {
                        return true;
                    }        
                }
                else if(cID.length() ==7 && Pattern.matches("a-zA-Z", "" + cID.charAt(6))) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    /**
     * validation of course title
     * @param cTitle
     * @return boolean
     */
    private boolean isValidCourseTitle(String cTitle) {
        if(cTitle.length() >= 7 && cTitle.length() < 35) {
            Pattern p = Pattern.compile("[^A-Za-z ]");
            Matcher m = p.matcher(cTitle);
            boolean b = m.find();
            if (b == true)
                return false;
            else
             return true;
        }
        return false;
    }
    
    /**
     * validation of Marks
     * @param Marks
     * @return boolean
     */
    private boolean areValidCreditHours(int CH) {
        if(CH >= 1 && CH <= 3) {
            return true;
        }
        return false;
    }
    
    /**
     * validation of semester
     * @return boolean
     */
    
    private boolean isValidSemester( int sem) {
        if(sem >= 1 && sem <= 8){
            return true;
        }
        return false;
    }
    
    /**
     * Validation of Marks
     * @param marks
     * @return boolean
     */
    private boolean areValidMarks(int marks) {
        
        if(marks >= 0 && marks <= 100) {
            return true;
        }
        return false;
    }
    
}
