/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import javax.swing.*;

/**
 *
 * @author Muhammad Adnan Mohib
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
CourseResult myCourseResult ;//= new CourseResult();
UetGradeBook myGradeBook =  new UetGradeBook();
String choice="";
while(true){
    
    //<editor-fold defaultstate="collapsed" desc="Menu To get user choice">
    choice = JOptionPane.showInputDialog(null, "\nChoose the Following Option:\n"
            + "Choose 1: To set basic information of Student\n"
            + "Choose 2: To Add new course in Grade Book\n"
            + "Choose 3: To edit a course\n"
            + "Choose 4: To Delete a course\n"
            + "Choose 5: To view all courses\n"
            + "Choose 6: To view CGPA\n"
            + "Choose 7: To view detailed marks certificate","UET Grade Book", JOptionPane.QUESTION_MESSAGE);
//</editor-fold>
    if(choice == ""){
        break;
    }
    else if(choice.chars().allMatch(Character::isDigit)){
        int op = Integer.parseInt(choice);
        if(op > 0 && op < 8 ){
            switch(op){
                //<editor-fold defaultstate="collapsed" desc="Enter Basic Student Information">
                case 1:{
                    String infoStd = JOptionPane.showInputDialog(null, "Please enter the basic information in the following format\nName,Registration Number,Degree\ne.g:\nMuhammad Adnan,2015-CS-51,BS","Student Basic Information", JOptionPane.QUESTION_MESSAGE);
                    String[] stdInfo = infoStd.split(",");
                    if(stdInfo.length == 3){
                        // removing extra spaces
                        for(int i=0; i<3; i++){
                            stdInfo[i].replaceAll("\\s{2,}", " ").trim();
                        }
                        
                        while(!(myGradeBook.setStudentName(stdInfo[0]) &&
                                myGradeBook.setRegNumber(stdInfo[1]) &&
                                myGradeBook.setDegree(stdInfo[2]))){
                            infoStd = JOptionPane.showInputDialog(null, "Please enter the basic information in the following format\n"
                                    + "Name, Registration Number, Degree","Student Basic Information", JOptionPane.QUESTION_MESSAGE);
                            stdInfo = infoStd.split(",");
                            if(stdInfo.length == 3){
                                // removing extra spaces
                                for(int i=0; i<3; i++){
                                    stdInfo[i].replaceAll("\\s{2,}", " ").trim();
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Incorrect parameters Entered","", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        JOptionPane.showMessageDialog(null, "Basic Information Added Successfully","Success", JOptionPane.PLAIN_MESSAGE);
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect parameters Entered","", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
//</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="Add new Course ">
                case 2:
                {
                    String infoCourse = JOptionPane.showInputDialog(null, "Please enter the course information in the following format\nCourse ID,Course Title,Credit Hours,Semester, Marks\ne.g:\nCS381L,Software Engineering,3,5,90","Student Basic Information", JOptionPane.QUESTION_MESSAGE);
                    String[] crsInfo = infoCourse.split(",");
                    if(crsInfo.length == 5){
                        // removing extra spaces
                        for(int i=0; i<5; i++){
                            crsInfo[i].replaceAll("\\s{2,}", " ").trim();
                            System.out.println(crsInfo[i]);
                        }
                        myCourseResult = new CourseResult();
                        while(!(myCourseResult.setCourseID(crsInfo[0]) &&
                                myCourseResult.setCourseTitle(crsInfo[1])&&
                                myCourseResult.setCreditHours(Integer.parseInt(crsInfo[2]))&&
                                myCourseResult.setSemester(Integer.parseInt(crsInfo[3]))&&
                                myCourseResult.setMarks(Integer.parseInt(crsInfo[4])))){
                            infoCourse = JOptionPane.showInputDialog(null, "Please enter the course information in the following format\nCourse ID,Course Title,Credit Hours,Semester, Marks\ne.g:\nCS381L,Software Engineering,3,5,90","Student Basic Information", JOptionPane.QUESTION_MESSAGE);
                            crsInfo = infoCourse.split(",");
                            if(crsInfo.length == 5){
                                // removing extra spaces
                                for(int i=0; i<5; i++){
                                    crsInfo[i].replaceAll("\\s{2,}", " ").trim();
                                    System.out.println(crsInfo[i]);
                                }
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Incorrect parameters Entered","", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        myGradeBook.setCourse(myCourseResult);
                        JOptionPane.showMessageDialog(null, "New Course Added Succesfully","Success", JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Incorrect parameters Entered","", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
//</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="Edit/Update a Course">
                case 3:
                {
                    String idCourse = JOptionPane.showInputDialog(null, "Enter course ID to update course(e.g CS381L)","Update a Course", JOptionPane.QUESTION_MESSAGE);
                    myCourseResult = myGradeBook.getCoursebyID(idCourse);
                    System.out.println(myCourseResult.toString());
                    if(myCourseResult != null){
                        String infoCourse = JOptionPane.showInputDialog(null, "Please enter the course information in the following format\nCourse ID,Course Title,Credit Hours,Semester, Marks\ne.g:\nCS381L,Software Engineering,3,5,90","Student Basic Information", JOptionPane.QUESTION_MESSAGE);
                        String[] crsInfo = infoCourse.split(",");
                        if(crsInfo.length == 5){
                            // removing extra spaces
                            for(int i=0; i<5; i++){
                                crsInfo[i].replaceAll("\\s{2,}", " ").trim();
                                System.out.println(crsInfo[i]);
                            }
                            while(!(myCourseResult.setCourseID(crsInfo[0]) &&
                                    myCourseResult.setCourseTitle(crsInfo[1])&&
                                    myCourseResult.setCreditHours(Integer.parseInt(crsInfo[2]))&&
                                    myCourseResult.setSemester(Integer.parseInt(crsInfo[3]))&&
                                    myCourseResult.setMarks(Integer.parseInt(crsInfo[4])))){
                                infoCourse = JOptionPane.showInputDialog(null, "Please enter the course information in the following format\nCourse ID,Course Title,Credit Hours,Semester, Marks\ne.g:\nMuhammad Adnan,2015-CS-51,BS","Student Basic Information", JOptionPane.QUESTION_MESSAGE);
                                crsInfo = infoCourse.split(",");
                                if(crsInfo.length == 5){
                                    // removing extra spaces
                                    for(int i=0; i<5; i++){
                                        crsInfo[i].replaceAll("\\s{2,}", " ").trim();
                                    }
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Incorrect parameters Entered","", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            JOptionPane.showMessageDialog(null, "Course Updated Successfully","Success", JOptionPane.PLAIN_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "Incorrect parameters Entered","", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Course Not Found.. ","", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
//</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="Delete a Course">
                case 4:
                {
                    String idCourse = JOptionPane.showInputDialog(null, "Enter course ID to delete course(e.g CS381L)","Delete a Course", JOptionPane.QUESTION_MESSAGE);
                    if(myGradeBook.removeCoursebyID(idCourse)){
                        JOptionPane.showMessageDialog(null,"Course Successfully Deleted..","Success",JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Course Not Found..","Success",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
//</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="Display Courses in Output Window">
                case 5:
                {
                    if(myGradeBook.getCourses().size() > 0){
                        myGradeBook.toString();
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"No Course Added in the List","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
//</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="Display CGPA">
                case 6:
                {
                 
                    if(myGradeBook.getCourses().size() > 0){
                    JOptionPane.showMessageDialog(null,"CGPA is : "+myGradeBook.getCGPA(),"CGPA",JOptionPane.INFORMATION_MESSAGE);
                    }
                    break;
                }
//</editor-fold>
                //<editor-fold defaultstate="collapsed" desc="Display DMC">
                case 7:
                {
                    myGradeBook.showDMC();
                    break;
                }
//</editor-fold>
            }

        }
        else{
            JOptionPane.showMessageDialog(null, "Wrong Number Entered","", JOptionPane.ERROR_MESSAGE);
        }
    }
    else{
        JOptionPane.showMessageDialog(null, "Alphabets or Null entry, choose a number from 1-7","", JOptionPane.ERROR_MESSAGE);
    }
    
}
        
    

    }
    
}
