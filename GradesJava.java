/*Jisoo Park
 * This program will calulate a student's grade with the usage of if else
statements to avoid bad numeric values that might cause an error.
 */
package grades.java;

import java.util.Scanner;

public class GradesJava {

    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in) ;
        double hwweight = 0;
        double exam1weight = 0;
        double exam2weight = 0;
        int numberofassignments = 0;
        double assignmentgrade =0;
        double avghwgrade = 0;
        int numberoflatedaysused =0;
        int labsattended =0;
        double hwweightedscore =0;
        double exam1score =0;
        double exam1curve =0;
        double exam1weightedscore =0;
        double exam2score =0;
        double exam2curve =0;
        double exam2weightedscore =0;
        double finalgrade =0;
        double totalpoints =0;
        int totalpointspossible =0;
        double coursegrade =0;
        
    System.out.println("Homework weight?");
    hwweight = input.nextDouble();
    System.out.println("Exam 1 weight?");
    exam1weight = input.nextDouble();
    exam2weight = 100 - (exam1weight + hwweight);
    System.out.println("Number of assignments?");
    numberofassignments = input.nextInt();
    if (numberofassignments <= 0){
        hwweightedscore = hwweight;
        
    }else{
        System.out.println("Average Homework grade?");
        avghwgrade = input.nextDouble();
        assignmentgrade = numberofassignments*avghwgrade;
    if (avghwgrade <= 0){
        avghwgrade = 0;
    }else if (avghwgrade > 10){
        avghwgrade = 10;
    }
        System.out.println("Number of late days used?");
        numberoflatedaysused = input.nextInt();
        if (numberoflatedaysused > numberofassignments/2){
        assignmentgrade = assignmentgrade * .9;
    }else if(numberoflatedaysused ==0){
        assignmentgrade = assignmentgrade +5;
    }
    
        System.out.println("Labs attended?");
        labsattended = input.nextInt();
        totalpoints = (assignmentgrade) + (labsattended*4);
        totalpointspossible = (numberofassignments*14);
        if (totalpoints > totalpointspossible){
        totalpoints = totalpointspossible;
        }
        System.out.println("Total points = " + totalpoints + "/" + totalpointspossible);
        hwweightedscore = (totalpoints*hwweight)/totalpointspossible;
    }
    

    System.out.println("Weighted score = " +hwweightedscore);
    System.out.println("Exam 1:");
    System.out.println("Score?");
    exam1score = input.nextDouble();
    System.out.println("Curve?");
    exam1curve = input.nextDouble();
        if (exam1score <= 0){
        exam1score = 0;
    }else if (exam1score > 100){
        exam1score = 100;
    }
    exam1score = (exam1curve + exam1score); 
    totalpoints = (exam1score/100);
    System.out.println("Total Points = " +exam1score + "/" +100);
    exam1weightedscore = (totalpoints*exam1weight);
    System.out.println("Weighted score = "+exam1weightedscore);
    System.out.println("Exam 2:");
    System.out.println("Score?");
    exam2score = input.nextDouble();
    System.out.println("Curve?");
    exam2curve = input.nextDouble();
    exam2score = (exam2curve + exam2score); 
        if (exam2score <= 0){
        exam2score = 0;
    }else if (exam2score > 100){
        exam2score = 100;
    }
    totalpoints = (exam2score/100);
    System.out.println("Total Points = " +exam2score + "/" +100);
    exam2weightedscore = (totalpoints*exam2weight);
    System.out.println("Weighted score = "+exam2weightedscore);
    coursegrade = hwweightedscore+exam1weightedscore+exam2weightedscore;
    System.out.println("Course grade = " +coursegrade);
    
    
    }
    
}

