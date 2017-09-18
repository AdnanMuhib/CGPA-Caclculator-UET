/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;
import java.awt.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Muhammad Adnan Mohib
 */
public class UetGradeBook { 
    /**
     * data member
     */
    private String StudentName;
    private String RegistrationNumber;
    private String Degree;
    private ArrayList<CourseResult> Courses;
    /**
     * setter for courses list 
     * @param Courses 
     */
    public void setCourses(ArrayList<CourseResult> Courses) {
        this.Courses = Courses;
    }
    
    /**
     * Constructors
     */
    
    /**
     * Default Constructor
     */
    public UetGradeBook(){
        this.StudentName = "";
        this.RegistrationNumber = "";
        this.Degree = "";
        this.Courses = new ArrayList<>();
    }
    /**
     * Setters for the Data Members
     */
    
    /**
     * Setter Method for Student Name
     * Throws Exception if the name of the Student
     * contains special characters or numbers
     * @param sName 
     * @return  
     * 
     */
    public boolean setStudentName(String sName){
        try {
            if(this.isValidName(sName)){
                this.StudentName = sName;
                return true;
            }
            else{
                throw new Exception();
            }
            
        }catch(Exception e){
            System.out.println("Invalid Student Name Entered , it can't contain numbers or Special characters");
            return false;
        }
    }
    /**
     * Setter Method for Student Registration Number
     * it validates the Registration number using
     * isValidRegNumber Method
     * @param RegNo 
     * @return  
     */
    public boolean setRegNumber(String RegNo){
        try
        {
            if(this.isValidRegNo(RegNo))
            {
                this.RegistrationNumber = RegNo.toUpperCase();
                return true;
            }
            else
            {
                throw new Exception();
            }
        }
        catch(Exception e)
        {
            System.out.println("Invalid Registration Number");
            return false;
        }
        
    }
    /**
     * Setter Method for Degree Name
     * Degree Name Can be MS, BS or BE
     * it is validated inside the setter
     * @param degree
     * @return 
     */
    public boolean setDegree(String degree){
        try{
            if(degree.toUpperCase().equals("MS") ||
               degree.toUpperCase().equals("BS") ||
               degree.toUpperCase().equals("BE")){
            this.Degree = degree.toUpperCase();
            return true;
            }
            else{
                throw new Exception();

            }
        }
        catch(Exception e ){
            System.out.println("Degree Name is Invalid , it must be MS , BS or BE");
            return false;
        }
    }
    /**
     * Setter Method to Set the Course object into the ArrayList of 
     * Courses
     * @param course 
     * @return  
     */
    public boolean setCourse(CourseResult course){
        // Object of CourseResult Class is Added to the Courses Array
        this.Courses.add(course);
        return true;
    }
    
    /**
     * Getters for the Data Members
     */
    /**
     * Getter Method to for Name of the Student
     * @return String
     */
    public String getStudentName(){
        return this.StudentName;
    }
    /**
     * Getter Method for the Student Registration Number
     * @return String
     */
    public String getRegNumber(){
        return this.RegistrationNumber;
    }
    /**
     * Getter method for Degree
     * @return String
     */
    public String getDegree(){
        return this.Degree;
    }
    /**
     * Getter Method for the list of Courses
     * @return ArrayList
     */
    public ArrayList<CourseResult> getCourses(){
        return this.Courses;
    }
    /**
     * This Method returns the reference Object with matching Course ID to update 
     * from List of Added Courses
     * @param crsID
     * @return 
     */ 
    public CourseResult getCoursebyID(String crsID){
         CourseResult crs;
         for(int i = 0; i < Courses.size(); i++){
            if(Courses.get(i).getCourseID().equals(crsID)){
                crs = Courses.get(i);
                return crs;
            }
         }
         return null;
     }
    /**
     * This Method removes a Course from List of Courses
     * @param crsID
     * @return boolean
     */
    public boolean removeCoursebyID(String crsID){
        for(int i = 0; i < Courses.size(); i++){
            if(Courses.get(i).getCourseID().equals(crsID)){
                Courses.remove(Courses.get(i));
                return true;
            }
        }
        return false;
    }
    /**
     * Validation Methods for the Data Members
     */
    /**
     * This Methods Checks whether the given name is Valid or not
     * @param name
     * @return boolean 
     */
    private boolean isValidName(String name){
        if(name.length()>0){
        Pattern p = Pattern.compile("[^A-Za-z ]");
        Matcher m = p.matcher(name);
        boolean b = m.find();
        if (b == true)
            return false;
        else
         return true;
        }
        return false;
    }
    
    /**
     * This Method Checks whether the given Registration number is valid or
     * not , it validates registration number of 2015-CS-51
     * type of Registration Numbers
     * @param RegNo
     * @return boolean
     */
    private boolean isValidRegNo(String RegNo){
        if(RegNo.length() >= 8){
            String year = "";// = ""+ RegNo.charAt(0) + RegNo.charAt(1) + RegNo.charAt(2) + RegNo.charAt(3);
            String dept = "";
            String regN = "";
            boolean dashDetect = false;

            for(int i =0; i< RegNo.length(); i++){
                if(RegNo.charAt(i) == '-')
                {
                    while(RegNo.charAt(i+1)!= '-' ){
                        dept += RegNo.charAt(i+1);
                        i++;
                    }
                    i += 2;
                    dashDetect = true;
                }
                if(dashDetect == false){
                    year += RegNo.charAt(i);
                }
                if(dashDetect == true){
                    regN += RegNo.charAt(i);
                }
            }
         if(Pattern.matches("\\d+", year) && 
            Pattern.matches("\\d+", regN) && 
            isValidName(dept) && 
            year.length()==4 && 
            dept.length() >1 && 
            regN.length()>0)
         {
                    return true;
         }
        }
        
        return false;
    }
    
    /**
     * This Function Calculates  the number of Semesters
     * in which a student has registered subjects
     * @return number of Semesters: integer
     */
    public int getSemesters(){
        int numberOfSemesters = 0;
        // HashObject object doesn't adds repeating value
        // inside of the List
        HashSet semesters = new HashSet();
        for (Iterator<CourseResult> i = Courses.iterator(); i.hasNext();) {
            semesters.add(i.next().getSemester());
        }
        
        numberOfSemesters = semesters.size();
        return numberOfSemesters;
    }
    /**
     * This Function calculates and returns the GPA 
     * of the required semester number
     * @param semester
     * @return double
     */
    public double getSemesterGPA(int semester){
        // return value upto 4 decimal places
        DecimalFormat abc = new DecimalFormat("#.####");
        return Double.valueOf(abc.format(getSemesterGradePoints(semester)/getSemesterCreditHours(semester)));
        //return (getSemesterGradePoints(semester)/getSemesterCreditHours(semester));
    }
    /**
     * This Method returns the CGPA of the Student
     * @return double: CGPA
     */
    public double getCGPA(){
        double courseGradePoints = 0;
        double totalCreditHours = this.getTotalCreditHours();
        HashSet semesters = new HashSet();
        CourseResult course;
        for (Iterator<CourseResult> i = Courses.iterator(); i.hasNext();) {
            course = i.next();
            courseGradePoints += (course.getGradePoints()* course.getCreditHours());
        }
        // return value upto 4 decimel places
        DecimalFormat abc = new DecimalFormat("#.####");
        return Double.valueOf(abc.format(courseGradePoints/totalCreditHours));
        //return courseGradePoints/totalCreditHours;
    }
    /**
     * This Function returns the total credit
     * hours in a particular semester
     * @param semester
     * @return integer
     */
    private double getSemesterGradePoints(int semester){
        double semesterGradePoints = 0;    
        HashSet semesters = new HashSet();
        for (Iterator<CourseResult> i = Courses.iterator(); i.hasNext();) {
            CourseResult course = i.next();
            if(course.getSemester() == semester){
                semesterGradePoints += (course.getGradePoints() * course.getCreditHours());
            }
        }
        return semesterGradePoints;
    }
    /**
     * This Method returns the Total Credit Hours in a Semester
     * Total is based on the number of registered Subjects
     * @param semester
     * @return integer: credit Hours
     */
    public int getSemesterCreditHours(int semester){
        if(this.Courses.size() > 0){
            int CH = 0;
            HashSet semesters = new HashSet();
            for (Iterator<CourseResult> i = Courses.iterator(); i.hasNext();) {
                CourseResult course = i.next();
                if(course.getSemester() == semester){
                    CH += course.getCreditHours();
                }
            }
            return CH;
        }
        return 0;
    }
    /**
     * This Function will return the total
     * credit hours of all semesters
     * Total is based on the number of registered Subjects
     * @return integer
     */
    public int getTotalCreditHours(){
        if(this.Courses.size() > 0){
            int CH = 0;
            HashSet semesters = new HashSet();
            for (Iterator < CourseResult> i = Courses.iterator(); i.hasNext();) {
                CourseResult course = i.next();
                    CH += course.getCreditHours();
                }
            return CH;
        }
        return 0;
    }
    /**
     * This Function will return the name of the 
     * discipline on the basis of registration number 
     * @return String  
     */
    public String getDescipline(){
        String[] arr = this.RegistrationNumber.split("-");
        if( arr.length ==  3) {
            return arr[1];
        }
        return "";
    }
    /**
     * This Function will return the Session year
     * on the basis of registration number
     * @return integer
     */
    public int getSession(){
        String[] arr = this.RegistrationNumber.split("-");
        if( arr.length ==  3) {
            return Integer.parseInt(arr[0]);
        }
        return 0;
    }
    /**
     * This function Displays the Course Details in Tabular Form
     * on a Dialogue box and always returns an Empty String
     * @return String
     */
    @Override
    public String toString() {
        Object[][] rows = new Object[Courses.size()][5];
        for(int i = 0; i < Courses.size(); i++){
                    rows[i][0] = Courses.get(i).getCourseID();
                    rows[i][1] = Courses.get(i).getCourseTitle();
                    rows[i][2] = Courses.get(i).getCreditHours();
                    rows[i][3] = Courses.get(i).getMarks();
                    rows[i][4] = Courses.get(i).getGrade();
        }
    Object[] Col_Names = {"ID","Name","CH","Marks", "Grade"};
    JTable table = new JTable(rows, Col_Names);
    table.setShowGrid(false);
    final TableColumnModel columnModel = table.getColumnModel();
    for (int column = 0; column < table.getColumnCount(); column++) {
        int width = 15; // Min width
        for (int row = 0; row < table.getRowCount(); row++) {
            TableCellRenderer renderer = table.getCellRenderer(row, column);
            final Component comp = table.prepareRenderer(renderer, row, column);
            width = Math.max(comp.getPreferredSize().width +1 , width);
        }
        if(width > 300)
            width=300;
        columnModel.getColumn(column).setPreferredWidth(width);
    }
    JOptionPane.showMessageDialog(null, new JScrollPane(table),"Courses Details",0);
    return "";
}
    /**
     * This Method Displays the DMC of Student with the detailed view of every semester
     * showing the Semester GPA and the CGPA overall.
     */
    public void showDMC(){
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));

        ArrayList<String> semesters = new ArrayList<String>();
        // label for Name
        JLabel name = new JLabel("Name: " + this.getStudentName() + 
                                            "    Degree: " + this.getDegree() +
                                            " "+ this.getDescipline()+"\n");
        name.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        JLabel regNo = new JLabel("Registration Number: " + this.getRegNumber());
        regNo.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        JLabel session = new JLabel("Session: " + this.getSession()+"\n\n");
        session.setAlignmentX(JLabel.LEFT_ALIGNMENT);
        panel.add(name);
        panel.add(regNo);
        panel.add(session);
        CourseResult temp;
        
        // get the unique numbers of semesters and add them to Array List of semesters
        for(int i=0;i < Courses.size(); i++){
            temp = Courses.get(i);
            if(!(semesters.contains(""+temp.getSemester()))){
                semesters.add(""+temp.getSemester());
            }
        }
        // sorting those semester in Ascending order
        Collections.sort(semesters);
        
        // Creating JTables for each semester
        // Columns Names for Every Table
        Object[] column_names = {"ID", "Name", "CH", "Marks", "Grade"};
        int row_index = 0;
        for(int i = 0; i < semesters.size(); i++){
            panel.add(new JLabel(" "));
            JLabel lbl = new JLabel("Semester " + semesters.get(i)+": ");
            lbl.setAlignmentX(JLabel.LEFT_ALIGNMENT);
            panel.add(lbl);
          Object[][] rows = new Object[this.getNumberOfSemsterSubjects(Integer.parseInt(semesters.get(i)))][5];
          for(int j=0; j<Courses.size(); j++){
              CourseResult temp1 =Courses.get(j);
              if(temp1.getSemester() == Integer.parseInt(semesters.get(i))){
                  rows[row_index][0] = temp1.getCourseID();
                  rows[row_index][1] = temp1.getCourseTitle();
                  rows[row_index][2] = temp1.getCreditHours();
                  rows[row_index][3] = temp1.getMarks();
                  rows[row_index][4] = temp1.getGrade();
                  row_index ++;
              }
          }
          row_index = 0;
           JTable table = new JTable(rows, column_names);
            // Making table Appearance Better
            table.setShowGrid(false);
            //<editor-fold defaultstate="collapsed" desc="Adjust the Widths of the Columns">
            final TableColumnModel columnModel = table.getColumnModel();
            for (int column = 0; column < table.getColumnCount(); column++) {
                int width = 15; // Min width
                for (int row = 0; row < table.getRowCount(); row++) {
                    TableCellRenderer renderer = table.getCellRenderer(row, column);
                    final Component comp = table.prepareRenderer(renderer, row, column);
                    width = Math.max(comp.getPreferredSize().width +1 , width);
                }
                if(width > 300)
                    width=300;
                columnModel.getColumn(column).setPreferredWidth(width);
            }
        // adding the table to the Scroll Panel and then Scroll to the JPanel
        // to show the Name of Columns
        JScrollPane scrlPane = new JScrollPane(table);
        scrlPane.setAlignmentX(JScrollPane.LEFT_ALIGNMENT);
        panel.add(scrlPane);
        panel.add(new JLabel(" "));
        JLabel semGPA = new JLabel("SGPA: "+getSemesterGPA(Integer.parseInt(semesters.get(i))));
        panel.add(semGPA);
        //panel.add(new JLabel("SGPA: "+getSemesterGPA(Integer.parseInt(semesters.get(i))),SwingConstants.RIGHT));
        }
        panel.add(new JLabel(" "));
        if(Courses.size()>0){
            JLabel cgpa = new JLabel("CGPA: "+this.getCGPA());
            //cgpa.setAlignmentX(JLabel.RIGHT_ALIGNMENT);
            panel.add(cgpa);
        }
        
        //panel.add(new JLabel("CGPA: "+this.getCGPA(),SwingConstants.RIGHT));
//</editor-fold>
        // displaying a message dialogue box with the content of JPanel
        // JOptionPane.showMessageDialog(null, panel);
        
        // Adding the JPanel to the Main Frame of DMC to show 
        // Making a new Frame and Adding JPanel in that frame 
        JFrame dmc = new JFrame();
        dmc.setTitle("Student DMC");
        dmc.setSize(800,600);
        dmc.add(panel);
        //dmc.setAlwaysOnTop(true);
        dmc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dmc.setVisible(true);
        dmc.show();
    }
    
    /**
     * This Method return the total number of enrolled subjects of the
     * given semester number
     * @param Semester
     * @return integer: Total number of Subjects a student is enrolled .
     */
    private int getNumberOfSemsterSubjects(int Semester){
        int semNo = 0;
        for(int i = 0; i < Courses.size(); i++){
            if(Courses.get(i).getSemester() == Semester){
                semNo += 1;
            }
        }
        return semNo;
    }
}
