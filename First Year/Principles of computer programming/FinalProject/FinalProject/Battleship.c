#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int answer = 0;

typedef struct {
	char board[8][8];
	int ship[5][5];
	int shoots, hits, kills;
} side;


void removeElement(int *array, int index, int *size)
{
	for (; index < *size - 1; index++) array[index] = array[index + 1];
	*size -= 1;
}


int checkPossibility(int* cells, int* numbers, int cellsSize, int numberSize)
{
	int counter = 0;

	for (int i = 0; i < cellsSize; i++)
	{
		for (int j = 0; j < numberSize; j++)
		{
			if (cells[i] == numbers[j])
			{
				counter++;
				break;
			}
		}
	}

	if (counter == cellsSize)
	{
		return 0;
	}
	else
	{
		return 1;
	}
}


void generation(side* board)
{
	int numberSize = 64, firstCell;
	int *numbers = calloc(numberSize, sizeof(int));
	srand((unsigned int)time(NULL));

	for (int i = 5; i > 0; i--)
	{
		int check = 1;

		while (check)
		{
			firstCell = numbers[rand() % numberSize];
			int *nextCells = calloc(i - 1, sizeof(int));

			board->ship[i - 1][0] = firstCell;

			if (((firstCell + i - 1) / 8) == (firstCell / 8)) // right 
			{
				for (int j = 0; j < i - 1; j++)
				{
					nextCells[j] = firstCell + j + 1;
					board->ship[i - 1][j + 1] = nextCells[j];

					printf("%d", nextCells[j]);
					
				}

				check = checkPossibility(nextCells, numbers, i - 1, numberSize);
				
				break;
			}
			else if (((firstCell - i + 1) / 8) == (firstCell / 8)) // left
			{
				for (int j = 0; j < i - 1; j++)
				{
					nextCells[j] = firstCell - j - 1;
					board->ship[i - 1][j + 1] = nextCells[j];
				}

				check = checkPossibility(nextCells, numbers, i - 1, numberSize);
			}
			else if (firstCell + 8 * (i - 1) < 64) // down
			{
				for (int j = 0; j < i - 1; j++)
				{
					nextCells[j] = firstCell + ((j + 1) * 8);
					board->ship[i - 1][j + 1] = nextCells[j];
				}

				check = checkPossibility(nextCells, numbers, i - 1, numberSize);
			}
			else if (firstCell - 8 * (i - 1) > -1) // up
			{
				for (int j = 0; j < i - 1; j++)
				{
					nextCells[j] = firstCell - ((j + 1) * 8);
					board->ship[i - 1][j + 1] = nextCells[j];
				}

				check = checkPossibility(nextCells, numbers, i - 1, numberSize);
			}

		}

		printf("gen suc");

		for (int j = 0; j < 5; j++)
		{
			if (board->ship[i - 1][j] != -1)
			{
				for (int g = 0; g < numberSize; g++)
				{
					int cell = board->ship[i - 1][j];
					int cellVariations[9] = { cell - 9, cell - 8, cell - 7, cell - 1, cell, cell + 1, cell + 7, cell + 8, cell + 9 };

					for (int k = 0; k < 9; k++)
					{
						if (cellVariations[k] == numbers[g])
						{
							removeElement(numbers, g, &numberSize);
						}
					}
				}
			}
		}

	}
}


checkAnswer(int canswer)
{
	if (canswer == 0)
	{
		answer = 0;
		scanf("%*[^\n]%*c");
	}
}


int checkWin()
{

}


displayBoard(char* board)
{
	char abc[8] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

	printf("   1 2 3 4 5 6 7 8\n");

	for (int i = 0; i < 8; i++)
	{
		printf("  ------------------\n");
		printf("%c |", abc[i]);

		for (int j = 0; j < 8; j++)
		{
			printf("%с|", *(board + i * 8 + j));
		}

		printf("\n");
	}
}


int playerTurn(side* player1, side* player2)
{

	printf("Your board:\n");
	displayBoard(player1->board);

	printf("Opponent's board:\n");
	displayBoard(player2->board);

	return checkWin();
}


int computerTurn(side* computer, side* player)
{
	printf("Your board:\n");
	displayBoard(player->board);

	printf("Opponent's board:\n");
	displayBoard(computer->board);

	return checkWin();
}


int game(int turn, int mode, side* player1, side* player2) {

	if (mode == 1)
	{
		if (turn % 2 == 0)
		{
			return playerTurn(player1, player2);
		}
		else
		{
			return computerTurn(player2, player1);
		}
	}
	else
	{
		if (turn % 2 == 0)
		{
			return playerTurn(player1, player2);
		}
		else
		{
			return playerTurn(player2, player1);
		}
	}
}


int main()
{
	printf("Welcome to Battleship game!\n");

	while (answer != 3)
	{
		printf("\nPlease, choose option (1/2/3):\n1. Play game\n2. Load Game\n3. Exit\n");
		checkAnswer(scanf("%d", &answer));


		switch (answer)
		{
		case 1:
			printf("\nChoose option (1/2/3):\n1. Singleplayer (Player vs Bot)\n2. Multiplayer (Player vs Player)\n3. Exit\n");

			int mode, turn = 0;

			while (1)
			{
				checkAnswer(scanf("%d", &answer));

				if (answer == 1)
				{
					printf("\nsingi\n");

					mode = 1;
					side player, bot;

					memset(player.board, ' ', sizeof(player.board));
					memset(player.ship, -1, sizeof(player.ship));
					player.shoots = 0;
					player.hits = 0;
					player.kills = 0;

					memset(bot.board, ' ', sizeof(bot.board));
					memset(bot.ship, -1, sizeof(bot.ship));
					bot.shoots = 0;
					bot.hits = 0;
					bot.kills = 0;

					generation(&player);
					generation(&bot);


					while (game(turn, mode, &player, &bot))
					{
						turn++;
					}

					break;
				}
				else if (answer == 2)
				{
					printf("\nmulti\n");

					mode = 2;
					side player1, player2;

					memset(player1.board, ' ', sizeof(player1.board));
					memset(player2.board, ' ', sizeof(player2.board));

					while (game(turn, mode, &player1, &player2))
					{
						turn++;
					}

					break;
				}
				else if (answer == 3)
				{
					break;
				}
				else
				{
					printf("\nWrong answer, please, type '1' or '2' or '3'.\n");
				}
			}

			break;
		case 2:
			printf("B");
			break;
		case 3:
			break;
		default:
			printf("\nWrong answer, please, type '1' or '2' or '3'.\n");
			break;
		}
	}

	return 0;
}


//   1 2 3 4
//  ---------
// A| |O| | |
//  ---------
// B| | |X| |
//  ---------
// C|O| | |X|
//  ---------