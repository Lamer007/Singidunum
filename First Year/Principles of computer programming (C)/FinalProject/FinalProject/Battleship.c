/* breaf documentation:
	The programm starts with main() wich gives the player access to a menu with the options "play game", "load game" and "quit".
	"play game" - starts game player vs bot by executing functions generation() and game()
	"load game" - loads saved games (in this version of programm it does not work)
	"exit" - finish the programm

	ganeration() - generates computer's or player's board

	game() - execute playerTurn() if the turn is even and computerTurn() if the turn is odd

	playerTurn() - promote playes to enter the cordinates, then checks if is it possible,
	if yes, then provides feedback and changes computer's board, in the end executes functions  displayBoard() and checkWin()

	displayInfo() - provide information about player's and computer's shots, hits and ships, and also executes displayBoard()

	displayBoard() - display computer's or player's board

	checkWin() - check's if computer or player wins

	computerTurn() - randomly choose the cordinates, then shoots players board,
	provides feedback and changes player's board, in the end executes functions  displayBoard() and checkWin()

	removeElement() - remove element from dinamic array and resize it

*/

#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* Structure for player and bot */
typedef struct { 
	char board[8][8]; // board 
	int ship[5]; // array of coordinates of ships
	int shoots, hits; // statistics of shoots and hits
} side;


void removeElement(int *array, int index, int *size)
{
	for (; index < *size - 1; index++) array[index] = array[index + 1]; // shifts all elements to the left
	*size -= 1; // decrease arrays size
}


void generation(side* board)
{
	int numberSize = 64, cell;
	int *numbers = calloc(numberSize, sizeof(int)); // array of cells where could be ship
	srand((unsigned int)time(NULL));

	/* filling array with munbers 0-63 */
	for (int i = 0; i < numberSize; i++)
	{
		numbers[i] = i; 
	}

	for (int i = 0; i < 5; i++) // loop for 5 ships
	{
		int check = 1; // flag


		cell = numbers[rand() % numberSize]; // random accessible cell
		board->ship[i] = cell; // writing cell to i ship

		int cells[9] = { cell - 9, cell - 8, cell - 7, cell - 1, cell, cell + 1, cell + 7, cell + 8, cell + 9 }; // array of cell which we need to delet from array numbers

		/* deliting cells from array numbers*/
		for (int j = 0; j < 9; j++)
		{
			for (int g = 0; g < numberSize; g++)
			{
				if (cells[j] == numbers[g])
				{
					removeElement(numbers, g, &numberSize);
					break;
				}
			}
		}
	}
}

int checkWin(side *player)
{
	if (player->hits == 5) // checks if player or computer hitted his opponent's ships 5 times
	{
		return 0;
	}
	else
	{
		return 1;
	}
}


void displayBoard(side *player)
{
	char abc[8] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' }; // columns

	printf("   1 2 3 4 5 6 7 8\n"); // rows

	for (int i = 0; i < 8; i++)
	{
		printf("  -----------------\n");
		printf("%c |", abc[i]);

		/* printing player's or computer's cells*/
		for (int j = 0; j < 8; j++)
		{
			printf("%c|", player->board[i][j]);
		}

		printf("\n");
	}
	printf("  -----------------\n");
}

void displayInfo(side* player, side* computer)
{
	printf("\nYour board:\n");
	displayBoard(player); // printing player's board
	printf("\nYour shoots: %d\nYour hits: %d\nYour ships: %d\n", player->shoots, player->hits, (5 - computer->hits)); // printing player's statistics

	printf("\nComputer's board:\n");
	displayBoard(computer); // printing computer's board
	printf("\nComputer's shoots: %d\nComputer's hits: %d\nComputer's ships: %d\n", computer->shoots, computer->hits, (5 - player->hits)); // printing computer's statistics
}


int playerTurn(side* player, side* computer)
{
	printf("\nEnter the cell you want to shoot at (e.g. 'A2' CUPS only):\n");
	printf("If you want to exit to menu type '11' if you want to save type '22'\n");
	char ans[] = "00";

	while(1)
	{
		scanf("%2s", ans); // entering answer
		scanf("%*[^\n]%*c"); // clearing buffer

		if (ans[0] == '1' && ans[1] == '1') // exit
		{
			return 0;
		}
		else if(ans[0] == '2' && ans[1] == '2') // save
		{
			printf("\nGame successfuly saved\n");
		}
		else if (((int)ans[0]) >= 65 && ((int)ans[0] <= 72) && ((int)ans[1] >= 49) && ((int)ans[1] <= 56)) //  Ensuring it is within the grid boundaries
		{
			if (computer->board[(int)ans[0] - 65][(int)ans[1] - 49] == ' ') // ensuring that player haven't shooted to this cell
			{
				int onFire = 0;

				/* cheking if there is computer's ship in the cell*/
				for (int i = 0; i < 5; i++)
				{
					if (computer->ship[i] == (((int)ans[0] - 65) * 8 + ((int)ans[1] - 49)))
					{
						onFire = 1;
						break;
					}
				}

				if (onFire) // hit
				{
					printf("\nYou sank the computer ship!\n");
					computer->board[(int)ans[0] - 65][(int)ans[1] - 49] = 'X'; // write to computer's cell 'X'
					player->hits += 1;
				}
				else // miss
				{
					printf("\nYou missed\n");
					computer->board[(int)ans[0] - 65][(int)ans[1] - 49] = 'O'; // write to computer's cell 'O'
				}

				player->shoots += 1;
				break;
			}
			else // already shooted
			{
				printf("\nYou have already shooted in this cell\n");
			}
		}
		else // wrong answer
		{
			printf("\nWrong answer, please, type correcly\n");
		}

	}

	displayInfo(player, computer); // printing statistics and boards

	/* cheking if player wins */
	if (checkWin(player))
	{
		return 1;
	}
	else
	{
		printf("\nPlayer wins!\n");
		return 0;
	}
}


int computerTurn(side *computer, side *player,int *numbers, int *numberSize)
{
	srand((unsigned int)time(NULL));
	int cell = numbers[rand() % *numberSize]; // choosing random cell to hit

	printf("\nComputer shooted to: %c%d\n", (65 + (cell / 8)), ((cell % 8) + 1)); // printing this cell

	if (player->board[cell / 8][cell % 8] == 'S') // hit
	{
		printf("\nComputer hitted your ship!\n");
		player->board[cell / 8][cell % 8] = 'X';
		computer->hits += 1;
	}
	else // miss
	{
		printf("\nComputer missed!\n");
		player->board[cell / 8][cell % 8] = 'O';
	}

	computer->shoots += 1;
	removeElement(numbers, cell, numberSize); // removing cell from array of cell that the bot can shoot at

	displayInfo(player, computer); // printing statistics and boards

	/* cheking if computer wins */
	if (checkWin(computer))
	{
		return 1;
	}
	else
	{
		printf("\nComputer wins\n");
		return 0;
	}
}


int game(int turn, side *player, side *computer, int* numbers, int* numberSize) {
	/* checking whose move it is */
	if (turn % 2 == 0) // player's
	{
		return playerTurn(player, computer);
	}
	else // computer's
	{
		return computerTurn(computer, player, numbers, numberSize);
	}
}


int main()
{
	int canswer = 0, answer = 0, turn = 0;
	side player, bot;

	/* initiation player's structure */
	memset(player.board, ' ', sizeof(player.board));
	memset(player.ship, -1, sizeof(player.ship));
	player.shoots = 0;
	player.hits = 0;

	/* initiation computer's structure */
	memset(bot.board, ' ', sizeof(bot.board));
	memset(bot.ship, -1, sizeof(bot.ship));
	bot.shoots = 0;
	bot.hits = 0;

	static int numberSize = 64;
	int* numbers = calloc(numberSize, sizeof(int)); // array of cells that the bot can shoot at

	/* filling array with munbers 0-63 */
	for (int i = 0; i < numberSize; i++)
	{
		numbers[i] = i; 
	}

	printf("Welcome to Battleship game!\n");

	while (answer != 3)
	{
		printf("\nPlease, choose option (1/2/3):\n1. Play game\n2. Load Game\n3. Exit\n");
		canswer = scanf("%d", &answer); // safely scaning answer
		
		if (canswer == 0) // cheking if answer was entered correct
		{
			answer = 0;
		}

		scanf("%*[^\n]%*c"); // cleaning buffer

		switch (answer)
		{
		case 1: // play game
			generation(&player); // generate player's board
			generation(&bot); // generate computer's board

			/* making visible player's ships in his board */
			for (int i = 0; i < 5; i++)
			{
				for (int j = 0; j < 8; j++)
				{
					for (int g = 0; g < 8; g++)
					{
						if (player.ship[i] == ((j * 8) + g))
						{
							player.board[j][g] = 'S';
						}
					}
				}
			}

			/* starting the game */
			while (game(turn, &player, &bot, numbers, &numberSize))
			{
				turn++;
			}
			break;
		case 2: // load game
			printf("Deadline is very soon");
			break;
		case 3: // finishing programm
			break;
		default: // wrong answer
			printf("\nWrong answer, please, type '1' or '2' or '3'.\n");
			break;
		}
	}

	return 0;
}