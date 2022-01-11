/**
 * Program that defines an object to represent the users grade 
 * in COMP 1210. Creates methods to be called in 'GradeGenerator.java'.
 * 
 * Activity 4B
 * @author Kevin Bumgarner - COMP - 1210 - 003
 * @version September 24th, 2018  
 */

public class Grade {

// ==================
// Instance variables 
// ==================

   private double exam1, exam2, finalExam;
   private double activityAvg;
   private double quizAvg;
   private double projectAvg;
   private String studentName;

// =========
// Constants
// =========

/**
 * initializes constants.
 */

   public static final int EXAM_1 = 1, EXAM_2 = 2, FINAL = 3;
   
   private static final double EXAM_WEIGHT = 0.15,
      FINAL_WEIGHT = 0.30, ACT_WEIGHT = 0.05, 
      QUIZ_WEIGHT = 0.10, PROJ_WEIGHT = 0.25;
   
   // ===========
   // Constructor
   // ===========
   
   /**
    * Constructor Method that defines comp1210Grade.
    * 
    * @param studentNameIn name of the student
    */
   
   public Grade(String studentNameIn) {
      
      studentName = studentNameIn;
   }
   
   // =======
   // Methods 
   // =======
   
   /**
    * Method to set lab Averages. 
    * 
    * @param activityAvgIn activity average score 
    * @param quizAvgIn quiz average score 
    */
   
   public void setLabAverages(double activityAvgIn, double quizAvgIn) {
      
      activityAvg = activityAvgIn;
      quizAvg = quizAvgIn;
   } 
   
   /**
    * Method to set project average.
    * 
    * @param projectAvgIn project average 
    */
   
   public void setProjectAvg(double projectAvgIn) {
      
      projectAvg = projectAvgIn;
   }
   
   /**
    * Method to set exam score.
    * 
    * @param examType type of exam 
    * @param examScoreIn exam score
    */
   
   public void setExamScore(int examType, double examScoreIn) {
      
      if (examType == EXAM_1) {
         exam1 = examScoreIn;
      }
      else if (examType == EXAM_2) {
         exam2 = examScoreIn;
      }
      else if (examType == FINAL) {
         finalExam = examScoreIn;  
      }
   }
   
   /**
    * Method to calculate grade.
    * 
    * @param 
    * @return grade returns users grade in COMP 1210
    */
   
   public double calculateGrade() {
      
      double grade = exam1 * EXAM_WEIGHT + exam2 * EXAM_WEIGHT
         + finalExam * FINAL_WEIGHT
         + activityAvg * ACT_WEIGHT
         + quizAvg * QUIZ_WEIGHT
         + projectAvg * PROJ_WEIGHT;
      
      return grade;
   }
   
   /**
    * Displays the object created as a String value. 
    *
    * @param
    * @return output returns string  
    */
   
   public String toString() {
      
      String output = "Name: " + studentName + "\n"
         + "Course Grade: " + calculateGrade();
         
      return output;
   }
   
   
   
   
   
    
    
    

}