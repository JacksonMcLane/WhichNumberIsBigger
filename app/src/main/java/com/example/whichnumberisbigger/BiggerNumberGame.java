package com.example.whichnumberisbigger;

public class BiggerNumberGame {
    private int numberL, numberR;
    private int score;
    private int upperLimit, lowerLimit;


    public BiggerNumberGame(int lowerLimit, int upperLimit) {
        score = 0;
        this.upperLimit = upperLimit;
        this.lowerLimit = lowerLimit;
    }


    public void generateRandomNumbers() {
        // generate a number between upper and lower limit -  inclusive
            //store in numberL
            //store another number that is different, store in numberR
        numberL = (int)(Math.random()*(upperLimit-lowerLimit+1) + lowerLimit);
        do {
            numberR = (int)(Math.random()*(upperLimit-lowerLimit+1) + lowerLimit);
        } while (numberR == numberL);

    }

    public String checkAnswer(int answer) {
        //determine if answer is right and return a relevant message
            // based on the values of numberLeft & numberRight
        int correctAnswer = Math.max(numberL, numberR);
        if(answer == correctAnswer) {
            score++;
            return "Correct!";
        }
        else {
            score--;
            return "Wrong!";
        }
    }

    public int getNumberLeft() {
        return numberL;
    }

    public void setNumberLeft(int numberLeft) {
        this.numberL = numberLeft;
    }

    public int getNumberRight() {
        return numberR;
    }

    public void setNumberRight(int numberRight) {
        this.numberR = numberRight;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(int upperLimit) {
        this.upperLimit = upperLimit;
    }

    public int getLowerLimit() {
        return lowerLimit;
    }

    public void setLowerLimit(int lowerLimit) {
        this.lowerLimit = lowerLimit;
    }
}
