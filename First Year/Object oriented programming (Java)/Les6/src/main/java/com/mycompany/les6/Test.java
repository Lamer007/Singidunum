package com.mycompany.les6;

public class Test {
    String name;
    String course;
    String correctAnswer;
    
    
    public double calcPoints(String studentAnswer) {
        
        double totalPoints = 0;
        int counter = 0;
        
        for(int i = 0; i < correctAnswer.length(); i++) {
            if(correctAnswer.charAt(i) == studentAnswer.charAt(i)) {
                totalPoints += 10;
                counter++;
            } else {
                totalPoints -= 2;
            }
        }
        
        if(counter == correctAnswer.length()) {
            totalPoints *= 1.1;
        }
        
        System.out.println("No of correct answers" + counter + "and total points" + totalPoints);
        return totalPoints;
    }
    
}
