/**
 * Ted Mader
 * Grade Average Calculator
 * 9/23/2013
 **/

import java.util.Scanner;
 
public class GradeAverageCalculator{

	public static void main(String[] args){
	
		Scanner input = new Scanner(System.in);
	
		int response = 0;
		
		int homeworkCount = 0;
		int quizCount = 0;
		int testCount = 0;
		
		String studentName;
				
		double homeworkGrade = 0.0;
		double homeworkTotal = 0.0;
		double homeworkAvg = 0.0;
		double homeworkWeight = 0.0;
		
		double quizGrade = 0.0;
		double quizTotal = 0.0;
		double quizAvg = 0.0;
		double quizWeight = 0.0;
		
		double testGrade = 0.0;
		double testTotal = 0.0;
		double testAvg = 0.0;
		double testWeight = 0.0;
	
		double remainingWeight = 100.0;
		double finalAvg = 0.0;
	
		System.out.println("\nWhat would you like to do?");
		System.out.println("1) Average grades for a new student");
		System.out.println("2) Quit");
		response = input.nextInt();			

		if(response == 2){ //Option 2
			
			System.exit(0);
			
		}
				
		if(response == 1){ //Option 1
			
			System.out.println("\nEnter the name of the student.");
			studentName = input.next();
			
			System.out.println("\nWhat % of the final average are homework grades worth?"); //Homework grades
			homeworkWeight = input.nextDouble();
			
			remainingWeight = remainingWeight - homeworkWeight;
			
			homeworkWeight = homeworkWeight / 100;
			
			System.out.println("\nEnter number of homework grades.");
			homeworkCount = input.nextInt();
			
			for(int counter = 1; counter <= homeworkCount; counter++){ 
			
				System.out.println("\nEnter homework grade number " + counter + ".");
				homeworkGrade = input.nextInt();
				
				homeworkTotal = homeworkTotal + homeworkGrade;
				
				homeworkAvg = homeworkTotal / homeworkCount;

			}
			
			System.out.println("\nWhat % of the final average are quiz grades worth? Remaining %: " + remainingWeight); //Quiz grades
			quizWeight = input.nextDouble();
			
			remainingWeight = remainingWeight - quizWeight;
			
			quizWeight = quizWeight / 100;
			
			System.out.println("\nEnter number of quiz grades.");
			quizCount = input.nextInt();
			
			for(int counter = 1; counter <= quizCount; counter++){
			
				System.out.println("\nEnter quiz grade number " + counter + ".");
				quizGrade = input.nextInt();
				
				quizTotal = quizTotal + quizGrade;
				
				quizAvg = quizTotal / quizCount;

			}
			
			System.out.println("\nWhat % of the final average are test grades worth? Remaining %: " + remainingWeight); //Test grades
			testWeight = input.nextDouble();
			
			remainingWeight = remainingWeight - testWeight;
			
			testWeight = testWeight / 100;
			
			System.out.println("\nEnter number of test grades.");
			testCount = input.nextInt();
			
			for(int counter = 1; counter <= testCount; counter++){
			
				System.out.println("\nEnter test grade number " + counter + ".");
				testGrade = input.nextInt();
				
				testTotal = testTotal + testGrade;
				
				testAvg = testTotal / testCount;
				
			}
			
			if(homeworkWeight + quizWeight + testWeight > 1.0){ //If % exceeds 100
				
				System.out.println("\nThe total % of each grade type exceeds 100%. Please try again.");
			
			}
		
			if(homeworkWeight + quizWeight + testWeight < 1.0){ //If % is under 100
				
				System.out.println("\nWarning: " + remainingWeight + "% of the final average remains unallocated.");	
				
				finalAvg = (homeworkWeight * homeworkAvg) + (quizWeight * quizAvg) + (testWeight * testAvg);
			
				System.out.println("\n" + studentName + "'s Grades:");
				System.out.println("\nHomework Average: " + homeworkAvg);
				System.out.println("\nQuiz Average: " + quizAvg);
				System.out.println("\nTest Average: " + testAvg);
				System.out.println("\nFinal Average: " + finalAvg);
			
			}
			
			else{ //If % equals 100
			
				finalAvg = (homeworkWeight * homeworkAvg) + (quizWeight * quizAvg) + (testWeight * testAvg);
			
				System.out.println("\n" + studentName + "'s Grades:");
				System.out.println("\nHomework Average: " + homeworkAvg);
				System.out.println("\nQuiz Average: " + quizAvg);
				System.out.println("\nTest Average: " + testAvg);
				System.out.println("\nFinal Average: " + finalAvg);
			
			}
		}
	}
}