/**
 * Ted Mader
 * Student Grade Average Calculator
 * 9/29/2013
 **/

import java.util.Scanner;

public class GradeAverageCalculator{

	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args){
	
		int response = 0;
		
		double homeworkWeight = 0;
		double quizWeight = 0;
		double testWeight = 0;
		double remainingWeight = 1;
		
		double homeworkAvg = 0;
		double quizAvg = 0;
		double testAvg = 0;
		double finalAvg = 0;
		
		String studentName;
		String gradeType;
		
		response = mainMenu();
		
		if(response == 2){ //Option 2; exit
			
			System.exit(0);
		}
				
		if(response == 1){ //Option 1; run program
		
			System.out.println("\nEnter the name of the student.");
			studentName = input.next();

			gradeType = "homework";
			
			homeworkWeight = weightMethod(gradeType);
		
			gradeType = "quiz";
		
			quizWeight = weightMethod(gradeType);

			gradeType = "test";
			
			testWeight = weightMethod(gradeType);
			
			remainingWeight = remainingWeight - homeworkWeight - quizWeight - testWeight;
			
			if(homeworkWeight + quizWeight + testWeight > 1.0){ //If % exceeds 100
				
				System.out.println("\nThe total % of each grade type exceeds 100%. Please try again.");
				
				System.exit(0);
			}	
				
			if(homeworkWeight + quizWeight + testWeight < 1.0){ //If % is under 100
						
				System.out.println("\nWarning: " + remainingWeight + "% of the final average remains unallocated.");
			}

			else{
			}
			
			gradeType = "homework";
			
			homeworkAvg = avgMethod(gradeType);
			
			gradeType = "quiz";
			
			quizAvg = avgMethod(gradeType);
			
			gradeType = "test";
		
			testAvg = avgMethod(gradeType);
			
			finalAvg = finalAvgMethod(homeworkWeight, quizWeight, testWeight, homeworkAvg, quizAvg, testAvg, studentName);
		}
	}
		
	public static int mainMenu(){ //Method for main menu
	
		System.out.println("\nWhat would you like to do?");
		
		System.out.println("1) Average grades for a new student");
		
		System.out.println("2) Quit");
		
		int response = input.nextInt();			
		
		return response;
	}
	
	public static double weightMethod(String gradeType){ //Calculates how much of final grade each grade type is worth
		
		System.out.println("\nWhat percent of the final average are " + gradeType + " grades worth?\n");
		
		double weight = input.nextDouble();
	
		weight = weight / 100;
		
		return weight;
	}
	
	public static double avgMethod(String gradeType){ //Calculates average of each grade
		
		System.out.println("\nEnter " + gradeType + " grades. When done, type -1.\n");
		
		int count = 0;
		
		double grade = 0.0;
		double total = 0.0;
		double avg = 0.0;
		
		while(grade != -1){
			
			grade = input.nextDouble();
			if(grade != -1){
				total = total + grade;
				
				count = count + 1;
			}
			
			else{
			}
		}
		
		if(count > 0){

		avg = total / count;
		
		}
		
		else{
		
		avg = 0;
		
		}
		
		System.out.println( "\n" + gradeType + " grade average: " + avg);
		
		return avg;	
	}
		
	public static double finalAvgMethod(double homeworkWeight, double quizWeight, double testWeight, double homeworkAvg, double quizAvg, double testAvg, String studentName){ //Calculates final grade
		
		double finalAvg = (homeworkWeight * homeworkAvg) + (quizWeight * quizAvg) + (testWeight * testAvg);
	
		System.out.println("\n" + studentName + "'s Grades:");
		System.out.println("\nHomework Average: " + homeworkAvg);
		System.out.println("\nQuiz Average: " + quizAvg);
		System.out.println("\nTest Average: " + testAvg);
		System.out.println("\nFinal Average: " + finalAvg);
	
		return finalAvg;
	}
}