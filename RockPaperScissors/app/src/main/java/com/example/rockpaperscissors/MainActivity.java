package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView textViewWinLoseMessage;
    ImageView imageViewComputer;
    Button playButton;
    TextView textViewPlayerMessages;
    ImageButton imageButtonRock;
    ImageButton imageButtonPaper;
    ImageButton imageButtonScissors;
    enum Choice {ROCK, PAPER, SCISSORS, NONE};
    Choice playerChoiceId = Choice.NONE;
    Choice computerChoiceId = Choice.NONE;
    Random random;
    public int GenerateNumber()
    {
        random = new Random();
        return random.nextInt(3); // 0, 1, 2
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetupControls();
        DisableImageButtons();
        CrossAllImageButtoms();
    }

    private void CrossAllImageButtoms() {
        imageButtonRock.setImageResource(R.drawable.rock_cross);
        imageButtonPaper.setImageResource(R.drawable.paper_cross);
        imageButtonScissors.setImageResource(R.drawable.scissors_cross);
    }

    private void DisableImageButtons() {
        imageButtonRock.setEnabled(false);
        imageButtonPaper.setEnabled(false);
        imageButtonScissors.setEnabled(false);
    }

    private void SetupControls() {
        textViewWinLoseMessage = (TextView)findViewById(R.id.textViewWinLoseMessage);
        imageViewComputer = (ImageView)findViewById(R.id.imageViewComputer);
        playButton = (Button)findViewById(R.id.playButton);
        textViewPlayerMessages = (TextView)findViewById(R.id.textViewPlayerMessages);
        imageButtonRock = (ImageButton)findViewById(R.id.imageButtonRock);
        imageButtonPaper = (ImageButton)findViewById(R.id.imageButtonPaper);
        imageButtonScissors = (ImageButton)findViewById(R.id.imageButtonScissors);
        playButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                SetImageViewComputer(R.mipmap.ic_launcher);
                SetWinLoseMessage(R.string.Computer_Waiting);
                EnableImageButtons();
                ResetImageButtomImages(); // non cross , non tick - images
                SetPlayButtonText(R.string.Waiting_For_Player);
            }

            private void SetWinLoseMessage(int imageId) {
                textViewWinLoseMessage.setText( imageId );
            }

            private void SetImageViewComputer(int imageId) {
                imageViewComputer.setImageResource( imageId );
            }

            private void SetPlayButtonText(int textId) {
                playButton.setText(textId);
            }

            private void ResetImageButtomImages() {
                imageButtonRock.setImageResource(R.drawable.rock);
                imageButtonPaper.setImageResource(R.drawable.paper);
                imageButtonScissors.setImageResource(R.drawable.scissors);
            }

            private void EnableImageButtons() {
                imageButtonRock.setEnabled(true);
                imageButtonPaper.setEnabled(true);
                imageButtonScissors.setEnabled(true);
            }
        });
        imageButtonRock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                playerChoiceId = Choice.ROCK;
                SetImageButtonRock(R.drawable.rock_tick);
                SetImageButtonPaper(R.drawable.paper_cross);
                SetImageButtonScissors(R.drawable.scissors_cross);
                ComputersChoice();
            }

            private void ComputersChoice() {
                int choice = 0;
                choice = GenerateNumber();
                if (choice == 0)
                {
                    computerChoiceId = Choice.ROCK;
                    SetImageForComputer(R.drawable.rock_tick);
                }
                else if (choice == 1)
                {
                    computerChoiceId = Choice.PAPER;
                    SetImageForComputer(R.drawable.paper_tick);
                }
                else if (choice == 2)
                {
                    computerChoiceId = Choice.SCISSORS;
                    SetImageForComputer(R.drawable.scissors_tick);
                }
                WhoWon();
                DisableImageButtons();
                SetPlayButtonText(R.string.Click_to_Play);
            }

            private void SetPlayButtonText(int textId) {
                playButton.setText(textId);
            }

            private void WhoWon() {
                if (playerChoiceId == computerChoiceId)
                {
                    // Draw
                    SetWinLoseMessage(R.string.Draw);
                }
                else if (playerChoiceId == Choice.ROCK)
                {
                    if (computerChoiceId == Choice.PAPER)
                    {
                        // Computer Win
                        SetWinLoseMessage(R.string.Computer_Wins);
                    }
                    else if (computerChoiceId == Choice.SCISSORS)
                    {
                        // Player Wins
                        SetWinLoseMessage(R.string.Computer_Loses);
                    }
                }
                else if (playerChoiceId == Choice.PAPER)
                {
                    if (computerChoiceId == Choice.ROCK)
                    {
                        // Player Win
                        SetWinLoseMessage(R.string.Computer_Loses);
                    }
                    else if (computerChoiceId == Choice.SCISSORS)
                    {
                        // Computer Wins
                        SetWinLoseMessage(R.string.Computer_Wins);
                    }
                }
                else if (playerChoiceId == Choice.SCISSORS)
                {
                    if (computerChoiceId == Choice.ROCK)
                    {
                        // Computer Win
                        SetWinLoseMessage(R.string.Computer_Wins);
                    }
                    else if (computerChoiceId == Choice.PAPER)
                    {
                        // Player Wins
                        SetWinLoseMessage(R.string.Computer_Loses);
                    }
                }

            }

            private void SetWinLoseMessage(int imageId) {
                textViewWinLoseMessage.setText( imageId );
            }

            private void SetImageForComputer(int imageId) {
                imageViewComputer.setImageResource(imageId);

            }

            private void SetImageButtonScissors(int imageId) {
                imageButtonScissors.setImageResource(imageId);
            }

            private void SetImageButtonPaper(int imageId) {
                imageButtonPaper.setImageResource(imageId);
            }

            private void SetImageButtonRock(int imageId) {
                imageButtonRock.setImageResource(imageId);
            }
        });
        imageButtonPaper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                playerChoiceId = Choice.PAPER;
                SetImageButtonRock(R.drawable.rock_cross);
                SetImageButtonPaper(R.drawable.paper_tick);
                SetImageButtonScissors(R.drawable.scissors_cross);
                ComputersChoice();
            }

            private void ComputersChoice() {
                int choice = 0;
                choice = GenerateNumber();
                if (choice == 0)
                {
                    computerChoiceId = Choice.ROCK;
                    SetImageForComputer(R.drawable.rock_tick);
                }
                else if (choice == 1)
                {
                    computerChoiceId = Choice.PAPER;
                    SetImageForComputer(R.drawable.paper_tick);
                }
                else if (choice == 2)
                {
                    computerChoiceId = Choice.SCISSORS;
                    SetImageForComputer(R.drawable.scissors_tick);
                }
                WhoWon();
                DisableImageButtons();
                SetPlayButtonText(R.string.Click_to_Play);
            }

            private void SetPlayButtonText(int textId) {
                playButton.setText(textId);
            }

            private void WhoWon() {
                if (playerChoiceId == computerChoiceId)
                {
                    // Draw
                    SetWinLoseMessage(R.string.Draw);
                }
                else if (playerChoiceId == Choice.ROCK)
                {
                    if (computerChoiceId == Choice.PAPER)
                    {
                        // Computer Win
                        SetWinLoseMessage(R.string.Computer_Wins);
                    }
                    else if (computerChoiceId == Choice.SCISSORS)
                    {
                        // Player Wins
                        SetWinLoseMessage(R.string.Computer_Loses);
                    }
                }
                else if (playerChoiceId == Choice.PAPER)
                {
                    if (computerChoiceId == Choice.ROCK)
                    {
                        // Player Win
                        SetWinLoseMessage(R.string.Computer_Loses);
                    }
                    else if (computerChoiceId == Choice.SCISSORS)
                    {
                        // Computer Wins
                        SetWinLoseMessage(R.string.Computer_Wins);
                    }
                }
                else if (playerChoiceId == Choice.SCISSORS)
                {
                    if (computerChoiceId == Choice.ROCK)
                    {
                        // Computer Win
                        SetWinLoseMessage(R.string.Computer_Wins);
                    }
                    else if (computerChoiceId == Choice.PAPER)
                    {
                        // Player Wins
                        SetWinLoseMessage(R.string.Computer_Loses);
                    }
                }

            }

            private void SetWinLoseMessage(int imageId) {
                textViewWinLoseMessage.setText( imageId );
            }

            private void SetImageForComputer(int imageId) {
                imageViewComputer.setImageResource(imageId);
            }

            private void SetImageButtonScissors(int imageId) {
                imageButtonScissors.setImageResource(imageId);
            }

            private void SetImageButtonPaper(int imageId) {
                imageButtonPaper.setImageResource(imageId);
            }

            private void SetImageButtonRock(int imageId) {
                imageButtonRock.setImageResource(imageId);
            }
        });
        imageButtonScissors.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                playerChoiceId = Choice.SCISSORS;
                SetImageButtonRock(R.drawable.rock_cross);
                SetImageButtonPaper(R.drawable.paper_cross);
                SetImageButtonScissors(R.drawable.scissors_tick);
                ComputersChoice();
            }

            private void ComputersChoice() {
                int choice = 0;
                choice = GenerateNumber();
                if (choice == 0)
                {
                    computerChoiceId = Choice.ROCK;
                    SetImageForComputer(R.drawable.rock_tick);
                }
                else if (choice == 1)
                {
                    computerChoiceId = Choice.PAPER;
                    SetImageForComputer(R.drawable.paper_tick);
                }
                else if (choice == 2)
                {
                    computerChoiceId = Choice.SCISSORS;
                    SetImageForComputer(R.drawable.scissors_tick);
                }
                WhoWon();
                DisableImageButtons();
                SetPlayButtonText(R.string.Click_to_Play);

            }

            private void SetPlayButtonText(int textId) {
                playButton.setText(textId);

            }

            private void WhoWon() {
                if (playerChoiceId == computerChoiceId)
                {
                    // Draw
                    SetWinLoseMessage(R.string.Draw);
                }
                else if (playerChoiceId == Choice.ROCK)
                {
                    if (computerChoiceId == Choice.PAPER)
                    {
                        // Computer Win
                        SetWinLoseMessage(R.string.Computer_Wins);
                    }
                    else if (computerChoiceId == Choice.SCISSORS)
                    {
                        // Player Wins
                        SetWinLoseMessage(R.string.Computer_Loses);
                    }
                }
                else if (playerChoiceId == Choice.PAPER)
                {
                    if (computerChoiceId == Choice.ROCK)
                    {
                        // Player Win
                        SetWinLoseMessage(R.string.Computer_Loses);
                    }
                    else if (computerChoiceId == Choice.SCISSORS)
                    {
                        // Computer Wins
                        SetWinLoseMessage(R.string.Computer_Wins);
                    }
                }
                else if (playerChoiceId == Choice.SCISSORS)
                {
                    if (computerChoiceId == Choice.ROCK)
                    {
                        // Computer Win
                        SetWinLoseMessage(R.string.Computer_Wins);
                    }
                    else if (computerChoiceId == Choice.PAPER)
                    {
                        // Player Wins
                        SetWinLoseMessage(R.string.Computer_Loses);
                    }
                }

            }

            private void SetWinLoseMessage(int imageId) {
                textViewWinLoseMessage.setText( imageId );
            }

            private void SetImageForComputer(int imageId) {
                imageViewComputer.setImageResource(imageId);
            }

            private void SetImageButtonScissors(int imageId) {
                imageButtonScissors.setImageResource(imageId);
            }

            private void SetImageButtonPaper(int imageId) {
                imageButtonPaper.setImageResource(imageId);

            }

            private void SetImageButtonRock(int imageId) {
                imageButtonRock.setImageResource(imageId);
            }
        });
    } // public void SetupControls()
    }
