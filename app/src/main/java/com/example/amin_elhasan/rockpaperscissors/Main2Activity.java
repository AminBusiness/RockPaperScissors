package com.example.amin_elhasan.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.webkit.WebView;

import java.util.Random;


public class Main2Activity extends AppCompatActivity
{
    final int ROCK     = 1;
    final int PAPER    = 2;
    final int Scissors = 3;
    ///////////////////////////////////
    int     computerChoice;
    int     userChoice;
    boolean choiceMade;  //If true computer has chosen
    int     totUserWins;
    int     totComWins;
    int     totTies;
    String computer;
    String user;
    String winner;
    TextView Results;
    Toast t;
    WebView wv;
    final String READY = "TESTING ";
    /////////////////////////////////
    Random rand = new Random(); //Generates random number


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        wv=findViewById(R.id.rpsWebView);
        wv.loadUrl("file:///android_asset/rps.html");

        Results = (TextView) findViewById(R.id.textViewResults); //Makes sure that the results go into the textview


        BeginGame();
    }


    public void BeginGame()
    {

        t = Toast.makeText(this,READY,Toast.LENGTH_LONG);
        //If you don't put your code from top to bottom things will not work the way you want
        choiceMade = false;

        createComputerChoice(); //Generates a random number between 1 and 3 for the computer

        createComputerString(); //Generates the associated string from the number generated

        //At this point the computer has now made its choice
        choiceMade = true;

    }

    public void createComputerChoice()
    {
        computerChoice = rand.nextInt(3) + 1; //Generates random number between 1 and 3
    }

    public void createComputerString()
    {
        switch(computerChoice)
        {
            case 1:
                computer ="ROCK";
                break;
            case 2:
                computer ="PAPER";
                break;
            case 3:
                computer ="SCISSORS";
                break;

                default:
                computer = "ROCK";
        }

    }
    public void userChoiceRock(View v)
    {
        user  = "ROCK";
        userChoice = 1;

        createComputerChoice(); //This makes sure that each time you make a choice the computer will also make a choice
        createComputerString(); //This associates the computers choice with the correct String

        if(!choiceMade) //This says if no choice has been made then start a new game
        {

            BeginGame();
        }

        if(computerChoice == ROCK)
        {
            winner = "TIE GAME";
            totTies++;
        }
        else if(computerChoice == PAPER)
        {
            winner = "COMPUTER";
            totComWins++;
        }
        else if(computerChoice == Scissors)
        {
            winner = "USER";
            totUserWins++;
        }

        showResults();


    }
    public void userChoicePaper(View v)
    {
        user  = "PAPER";
        userChoice = 2;

        createComputerChoice(); //This makes sure that each time you make a choice the computer will also make a choice
        createComputerString(); //This associates the computers choice with the correct String

        if(!choiceMade)
        {
            BeginGame();
        }
        if(computerChoice == ROCK)
        {
            winner = "USER";
            totUserWins++;
        }
        else if(computerChoice == PAPER)
        {
            winner = "TIE GAME";
            totTies++;
        }
        else if(computerChoice == Scissors)
        {
            winner = "COMPUTER";
            totComWins++;
        }

        showResults();
    }
    public void userChoiceScissor(View v)
    {
        user  = "SCISSORS";
        userChoice = 3;

        createComputerChoice(); //This makes sure that each time you make a choice the computer will also make a choice
        createComputerString(); //This associates the computers choice with the correct String

        if(!choiceMade)
        {
            BeginGame();
        }
        if(computerChoice == ROCK)
        {
            winner = "COMPUTER";
            totComWins++;
        }
        else if(computerChoice == PAPER)
        {
            winner = "USER";
            totUserWins++;
        }
        else if(computerChoice == Scissors)
        {
            winner = "TIE GAME";
            totTies++;
        }

        showResults();
    }
    public void clearResults(View v)
    {
        Results.setText("");
        totComWins  = 0;
        totUserWins = 0;
        totTies     = 0;

    }
    public void showResults()
    {
        // At first i put a = instead of an +=, that was incorrect because i was comparing the two rather then adding them together
        String output = "Computer chose:\t\t" + computer    +  "\n";
               output += "User chose: \t\t"    + user        +  "\n";
               output += "The winner is: \t\t" + winner      +  "\n";
               output += "Computer wins: \t\t" + totComWins  + "\n";
               output += "User wins: \t\t"     + totUserWins + "\n";
               output += "Tie games: \t\t"     + totTies     + "\n";

               Results.setText(output);

     }

}
