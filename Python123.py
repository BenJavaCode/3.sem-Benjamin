#Python version of TicTacToe
#DEtte spil udviklede jeg 19-02-20, med hendblik på at træne en ai til at spille det.
def print_board(array):
    x = 0
    for i in range(len(array)):
        x += 1
        print(" | ", end='')
        print(array[i], end='')
        if x == 3:
            x = 0
            print(" | ", end='')
            print()


def make_move(array, player):
    current_player = "l"

    if(player == 1):
        current_player = "x"
    else:
        current_player = "o"
    c = 1
    while c == 1:
        print("Press the number for the square you want to take")
        try:
            move = int(input()) - 1
            if array[move] != "x" and array[move] != "o":
                array[move] = current_player
                c = 2
            else:
                print("You cannot take a square that is already occupied.. try again:")
        except ValueError:
            print("this is not i valid number try again..")





def conditions(array):
    # Hor
    if array[0] == array[1] and array[0] == array[2]:
        if array[0] == "x":
            return 2
        else:
            return 3

    if array[3] == array[4] and array[3] == array[5]:
        if array[3] == "x":
            return 2
        else:
            return 3
    if array[6] == array[7] and array[6] == array[8]:
        if array[6] == "x":
            return 2
        else:
            return 3
    # Ver
    if array[0] == array[3] and array[0] == array[6]:
        if array[0] == "x":
            return 4
        else:
            return 5
    if array[1] == array[4] and array[1] == array[7]:
        if array[1] == "x":
            return 4
        else:
            return 5
    if array[2] == array[5] and array[2] == array[8]:
        if array[3] == "x":
            return 4
        else:
            return 5
    # Dia
    if array[0] == array[4] and array[0] == array[8]:
        if array[0] == "x":
            return 6
        else:
            return 7

    if array[2] == array[4] and array[2] == array[6]:
        if array[2] == "x":
            return 6
        else:
            return 7
    #Draw
    list_check = [1,2,3,4,5,6,7,8,9]

    check = any(item in list_check for item in array)

    if check == True:
        return 1
    else:
        return 8




    return 1


#Main
def main():
    player = 1
    play = 1
    arr = [1,2,3,4,5,6,7,8,9]
    while play == 1:
        print_board(arr)
        make_move(arr, player)

        if (player == 1):
            player = 2
        else:
            player = 1

        play = conditions(arr)

        if play == 2:
            print("x wins horizontally! ")
        if play == 3:
            print("o wins horizontally! ")
        if play == 4:
            print("x wins vertically! ")
        if play == 5:
            print("o wins vertically! ")
        if play == 6:
            print("x wins diagonally! ")
        if play == 7:
            print("o wins diagonally! ")
        if play == 8:
            print("its a draw :P ")

        if play != 1:
            print("do you want to play again?")
            print("type 'no' for no, press enter for yes")
            question = input()
            if question != "no":
                play = 1
                arr = [1, 2, 3, 4, 5, 6, 7, 8, 9]
            else:
                play = 2







#Main exe
main()









