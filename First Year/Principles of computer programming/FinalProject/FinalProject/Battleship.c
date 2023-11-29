#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
	char board[8][8];
	int ship[5];
	int shoots, hits;
} side;


void removeElement(int *array, int index, int *size)
{
	for (; index < *size - 1; index++) array[index] = array[index + 1];
	*size -= 1;
}


void generation(side* board)
{
	int numberSize = 64, cell;
	int *numbers = calloc(numberSize, sizeof(int));
	srand((unsigned int)time(NULL));

	for (int i = 0; i < numberSize; i++)
	{
		numbers[i] = i;
	}

	for (int i = 0; i < 5; i++)
	{
		int check = 1;

		while (check)
		{
			cell = numbers[rand() % numberSize];
			board->ship[i] = cell;

			for (int j = 0; j < numberSize; j++)
			{
				if (cell == numbers[j])
				{
					check = 0;
					break;
				}
			}

		}

		int cells[9] = { cell - 9, cell - 8, cell - 7, cell - 1, cell, cell + 1, cell + 7, cell + 8, cell + 9 };

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
	if (player->hits == 5)
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
	char abc[8] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H' };

	printf("   1 2 3 4 5 6 7 8\n");

	for (int i = 0; i < 8; i++)
	{
		printf("  -----------------\n");
		printf("%c |", abc[i]);

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
	displayBoard(player);
	printf("\nYour shoots: %d\nYour hits: %d\nYour ships: %d\n", player->shoots, player->hits, (5 - computer->hits));

	printf("\nComputer's board:\n");
	displayBoard(computer);
	printf("\nComputer's shoots: %d\nComputer's hits: %d\nComputer's ships: %d\n", computer->shoots, computer->hits, (5 - player->hits));
}


int playerTurn(side* player, side* computer)
{
	printf("\nEnter the cell you want to shoot at (e.g. 'A2' CUPS only):\n");
	printf("If you want to exit to menu type '11' if you want to save type '22'\n");
	char ans[] = "00";

	while(1)
	{
		scanf("%2s", ans);
		scanf("%*[^\n]%*c");

		if (ans[0] == '1' && ans[1] == '1')
		{
			return 0;
		}
		else if(ans[0] == '2' && ans[1] == '2')
		{
			printf("\nGame successfuly saved\n");
		}
		else if (((int)ans[0]) >= 65 && ((int)ans[0] <= 72) && ((int)ans[1] >= 49) && ((int)ans[1] <= 56))
		{
			if (computer->board[(int)ans[0] - 65][(int)ans[1] - 49] == ' ')
			{
				int onFire = 0;

				for (int i = 0; i < 5; i++)
				{
					if (computer->ship[i] == (((int)ans[0] - 65) * 8 + ((int)ans[1] - 49)))
					{
						onFire = 1;
						break;
					}
				}

				if (onFire)
				{
					printf("\nYou sank the computer ship!\n");
					computer->board[(int)ans[0] - 65][(int)ans[1] - 49] = 'X';
					player->hits += 1;
				}
				else
				{
					printf("\nYou missed\n");
					computer->board[(int)ans[0] - 65][(int)ans[1] - 49] = 'O';
				}

				player->shoots += 1;
				break;
			}
			else
			{
				printf("\nYou have already shooted in this cell\n");
			}
		}
		else
		{
			printf("\nWrong answer, please, type correcly\n");
		}

	}

	displayInfo(player, computer);

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
	int cell = numbers[rand() % *numberSize];

	printf("\nComputer shooted to: %c%d\n", (65 + (cell / 8)), ((cell % 8) + 1));

	if (player->board[cell / 8][cell % 8] == 'S')
	{
		printf("\nComputer hitted your ship!\n");
		player->board[cell / 8][cell % 8] = 'X';
		computer->hits += 1;
	}
	else
	{
		printf("\nComputer missed!\n");
		player->board[cell / 8][cell % 8] = 'O';
	}

	computer->shoots += 1;
	removeElement(numbers, cell, numberSize);

	displayInfo(player, computer);

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
	if (turn % 2 == 0)
	{
		return playerTurn(player, computer);
	}
	else
	{
		return computerTurn(computer, player, numbers, numberSize);
	}
}


int main()
{
	int canswer = 0, answer = 0, turn = 0;
	side player, bot;

	memset(player.board, ' ', sizeof(player.board));
	memset(player.ship, -1, sizeof(player.ship));
	player.shoots = 0;
	player.hits = 0;

	memset(bot.board, ' ', sizeof(bot.board));
	memset(bot.ship, -1, sizeof(bot.ship));
	bot.shoots = 0;
	bot.hits = 0;

	static int numberSize = 64;
	int* numbers = calloc(numberSize, sizeof(int));

	for (int i = 0; i < numberSize; i++)
	{
		numbers[i] = i;
	}

	printf("Welcome to Battleship game!\n");

	while (answer != 3)
	{
		printf("\nPlease, choose option (1/2/3):\n1. Play game\n2. Load Game\n3. Exit\n");
		canswer = scanf("%d", &answer);
		
		if (canswer == 0)
		{
			answer = 0;
		}

		scanf("%*[^\n]%*c");

		switch (answer)
		{
		case 1:
			generation(&player);
			generation(&bot);

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


			while (game(turn, &player, &bot, numbers, &numberSize))
			{
				turn++;
			}
			break;
		case 2:
			printf("Deadline is very soon");
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