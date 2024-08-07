package ch.noseryoung;

import java.util.ArrayList;

public class Levels {
  public static void loadLevels() {
    String text = """
        ;Sokoban levels
        ;Rooms (c) Thinking Rabbitt

        ---

        ; 1

            #####
            #   #
            #$  #
          ###  $##
          #  $ $ #
        ### # ## #   ######
        #   # ## #####  ..#
        # $  $          ..#
        ##### ### #@##  ..#
            #     #########
            #######

        ---

        ; 2

        ############
        #..  #     ###
        #..  # $  $  #
        #..  #$####  #
        #..    @ ##  #
        #..  # #  $ ##
        ###### ##$ $ #
          # $  $ $ $ #
          #    #     #
          ############

        ---

        ; 3

                ########
                #     @#
                # $#$ ##
                # $  $#
                ##$ $ #
        ######### $ # ###
        #....  ## $  $  #
        ##...    $  $   #
        #....  ##########
        ########

        ---

        ; 4

                   ########
                   #  ....#
        ############  ....#
        #    #  $ $   ....#
        # $$$#$  $ #  ....#
        #  $     $ #  ....#
        # $$ #$ $ $########
        #  $ #     #
        ## #########
        #    #    ##
        #     $   ##
        #  $$#$$  @#
        #    #    ##
        ###########

        ---

        ; 5

                #####
                #   #####
                # #$##  #
                #     $ #
        ######### ###   #
        #....  ## $  $###
        #....    $ $$ ##
        #....  ##$  $ @#
        #########  $  ##
                # $ $  #
                ### ## #
                  #    #
                  ######

        ---

        ; 6

        ######  ###
        #..  # ##@##
        #..  ###   #
        #..     $$ #
        #..  # # $ #
        #..### # $ #
        #### $ #$  #
           #  $# $ #
           # $  $  #
           #  ##   #
           #########

        ---

        ; 7

               #####
         #######   ##
        ## # @## $$ #
        #    $      #
        #  $  ###   #
        ### #####$###
        # $  ### ..#
        # $ $ $ ...#
        #    ###...#
        # $$ # #...#
        #  ### #####
        ####

        ---

        ; 8

          ####
          #  ###########
          #    $   $ $ #
          # $# $ #  $  #
          #  $ $  #    #
        ### $# #  #### #
        #@#$ $ $  ##   #
        #    $ #$#   # #
        #   $    $ $ $ #
        #####  #########
          #      #
          #      #
          #......#
          #......#
          #......#
          ########

        ---

        ; 9

                  #######
                  #  ...#
              #####  ...#
              #      . .#
              #  ##  ...#
              ## ##  ...#
             ### ########
             # $$$ ##
         #####  $ $ #####
        ##   #$ $   #   #
        #@ $  $    $  $ #
        ###### $$ $ #####
             #      #
             ########

        ---

        ; 10

         ###  #############
        ##@####       #   #
        # $$   $$  $ $ ...#
        #  $$$#    $  #...#
        # $   # $$ $$ #...#
        ###   #  $    #...#
        #     # $ $ $ #...#
        #    ###### ###...#
        ## #  #  $ $  #...#
        #  ## # $$ $ $##..#
        # ..# #  $      #.#
        # ..# # $$$ $$$ #.#
        ##### #       # #.#
            # ######### #.#
            #           #.#
            ###############

        ---

        ; 11

                  ####
             #### #  #
           ### @###$ #
          ##      $  #
         ##  $ $$## ##
         #  #$##     #
         # # $ $$ # ###
         #   $ #  # $ #####
        ####    #  $$ #   #
        #### ## $         #
        #.    ###  ########
        #.. ..# ####
        #...#.#
        #.....#
        #######

        ---

        ; 12

        ################
        #              #
        # # ######     #
        # #  $ $ $ $#  #
        # #   $@$   ## ##
        # #  $ $ $###...#
        # #   $ $  ##...#
        # ###$$$ $ ##...#
        #     # ## ##...#
        #####   ## ##...#
            #####     ###
                #     #
                #######

        ---

        ; 13

           #########
          ##   ##  ######
        ###     #  #    ###
        #  $ #$ #  #  ... #
        # # $#@$## # #.#. #
        #  # #$  #    . . #
        # $    $ # # #.#. #
        #   ##  ##$ $ . . #
        # $ #   #  #$#.#. #
        ## $  $   $  $... #
         #$ ######    ##  #
         #  #    ##########
         ####

        ---

        ; 14

               #######
         #######     #
         #     # $@$ #
         #$$ #   #########
         # ###......##   #
         #   $......## # #
         # ###......     #
        ##   #### ### #$##
        #  #$   #  $  # #
        #  $ $$$  # $## #
        #   $ $ ###$$ # #
        #####     $   # #
            ### ###   # #
              #     #   #
              ########  #
                     ####

        ---

        ; 15

           ########
           #   #  #
           #  $   #
         ### #$   ####
         #  $  ##$   #
         #  # @ $ # $#
         #  #      $ ####
         ## ####$##     #
         # $#.....# #   #
         #  $..**. $# ###
        ##  #.....#   #
        #   ### #######
        # $$  #  #
        #  #     #
        ######   #
             #####

        ---

        ; 16

        #####
        #   ##
        #    #  ####
        # $  ####  #
        #  $$ $   $#
        ###@ #$    ##
         #  ##  $ $ ##
         # $  ## ## .#
         #  #$##$  #.#
         ###   $..##.#
          #    #.*...#
          # $$ #.....#
          #  #########
          #  #
          ####

        ---

        ; 17

           ##########
           #..  #   #
           #..      #
           #..  #  ####
          #######  #  ##
          #            #
          #  #  ##  #  #
        #### ##  #### ##
        #  $  ##### #  #
        # # $  $  # $  #
        # @$  $   #   ##
        #### ## #######
           #    #
           ######

        ---

        ; 18

             ###########
             #  .  #   #
             # #.    @ #
         ##### ##..# ####
        ##  # ..###     ###
        # $ #...   $ #  $ #
        #    .. ##  ## ## #
        ####$##$# $ #   # #
          ## #    #$ $$ # #
          #  $ # #  # $## #
          #               #
          #  ###########  #
          ####         ####

        ---

        ; 19

          ######
          #   @####
        ##### $   #
        #   ##    ####
        # $ #  ##    #
        # $ #  ##### #
        ## $  $    # #
         # $ $ ### # #
         # #  $  # # #
         # # #$#   # #
        ## ###   # # ######
        #  $  #### # #....#
        #    $    $   ..#.#
        ####$  $# $   ....#
        #       #  ## ....#
        ###################

        ---

        ; 20

            ##########
        #####        ####
        #     #   $  #@ #
        # #######$####  ###
        # #    ## #  #$ ..#
        # # $     #  #  #.#
        # # $  #     #$ ..#
        # #  ### ##     #.#
        # ###  #  #  #$ ..#
        # #    #  ####  #.#
        # #$   $  $  #$ ..#
        #    $ # $ $ #  #.#
        #### $###    #$ ..#
           #    $$ ###....#
           #      ## ######
           ########

        ---

        ; 21

        #########
        #       #
        #       ####
        ## #### #  #
        ## #@##    #
        # $$$ $  $$#
        #  # ## $  #
        #  # ##  $ ####
        ####  $$$ $#  #
         #   ##   ....#
         # #   # #.. .#
         #   # # ##...#
         ##### $  #...#
             ##   #####
              #####

        ---

        ; 22

        ######     ####
        #    #######  #####
        #   $#  #  $  #   #
        #  $  $  $ # $ $  #
        ##$ $   # @# $    #
        #  $ ########### ##
        # #   #.......# $#
        # ##  # ......#  #
        # #   $........$ #
        # # $ #.... ..#  #
        #  $ $####$#### $#
        # $   ### $   $  ##
        # $     $ $  $    #
        ## ###### $ ##### #
        #         #       #
        ###################

        ---

        ; 23

            #######
            #  #  ####
        ##### $#$ #  ##
        #.. #  #  #   #
        #.. # $#$ #  $####
        #.  #     #$  #  #
        #..   $#  # $    #
        #..@#  #$ #$  #  #
        #.. # $#     $#  #
        #.. #  #$$#$  #  ##
        #.. # $#  #  $#$  #
        #.. #  #  #   #   #
        ##. ####  #####   #
         ####  ####   #####

        ---

        ; 24

        ###############
        #..........  .####
        #..........$$.#  #
        ###########$ #   ##
        #      $  $     $ #
        ## ####   #  $ #  #
        #      #   ##  # ##
        #  $#  # ##  ### ##
        # $ #$###    ### ##
        ###  $ #  #  ### ##
        ###    $ ## #  # ##
         # $  #  $  $ $   #
         #  $  $#$$$  #   #
         #  #  $      #####
         # @##  #  #  #
         ##############

        ---

        ; 25

        ####
        #  ##############
        #  #   ..#......#
        #  # # ##### ...#
        ##$#    ........#
        #   ##$######  ####
        # $ #     ######@ #
        ##$ # $   ######  #
        #  $ #$$$##       #
        #      #    #$#$###
        # #### #$$$$$    #
        # #    $     #   #
        # #   ##        ###
        # ######$###### $ #
        #        #    #   #
        ##########    #####

        ---

        ; 26

         #######
         #  #  #####
        ##  #  #...###
        #  $#  #...  #
        # $ #$$ ...  #
        #  $#  #... .#
        #   # $########
        ##$       $ $ #
        ##  #  $$ #   #
         ######  ##$$@#
              #      ##
              ########

        ---

        ; 27

         #################
         #...   #    #   ##
        ##.....  $## # #$ #
        #......#  $  #    #
        #......#  #  # #  #
        ######### $  $ $  #
          #     #$##$ ##$##
         ##   $    # $    #
         #  ## ### #  ##$ #
         # $ $$     $  $  #
         # $    $##$ ######
         #######  @ ##
               ######

        ---

        ; 28

                 #####
             #####   #
            ## $  $  ####
        ##### $  $ $ ##.#
        #       $$  ##..#
        #  ###### ###.. #
        ## #  #    #... #
        # $   #    #... #
        #@ #$ ## ####...#
        ####  $ $$  ##..#
           ##  $ $  $...#
            # $$  $ #  .#
            #   $ $  ####
            ######   #
                 #####

        ---

        ; 29

        #####
        #   ##
        # $  #########
        ## # #       ######
        ## #   $#$#@  #   #
        #  #      $ #   $ #
        #  ### ######### ##
        #  ## ..*..... # ##
        ## ## *.*..*.* # ##
        # $########## ##$ #
        #  $   $  $    $  #
        #  #   #   #   #  #
        ###################

        ---

        ; 30

               ###########
               #   #     #
        #####  #     $ $ #
        #   ##### $## # ##
        # $ ##   # ## $  #
        # $  @$$ # ##$$$ #
        ## ###   # ##    #
        ## #   ### #####$#
        ## #     $  #....#
        #  ### ## $ #....##
        # $   $ #   #..$. #
        #  ## $ #  ##.... #
        #####   ######...##
            #####    #####

        ---

        ; 31

          ####
          #  #########
         ##  ##  #   #
         #  $# $@$   ####
         #$  $  # $ $#  ##
        ##  $## #$ $     #
        #  #  # #   $$$  #
        # $    $  $## ####
        # $ $ #$#  #  #
        ##  ###  ###$ #
         #  #....     #
         ####......####
           #....####
           #...##
           #...#
           #####

        ---

        ; 32

              ####
          #####  #
         ##     $#
        ## $  ## ###
        #@$ $ # $  #
        #### ##   $#
         #....#$ $ #
         #....#   $#
         #....  $$ ##
         #... # $   #
         ######$ $  #
              #   ###
              #$ ###
              #  #
              ####

        ---

        ; 33

        ############
        ##     ##  #
        ##   $   $ #
        #### ## $$ #
        #   $ #    #
        # $$$ # ####
        #   # # $ ##
        #  #  #  $ #
        # $# $#    #
        #   ..# ####
        ####.. $ #@#
        #.....# $# #
        ##....#  $ #
        ###..##    #
        ############

        ---

        ; 34

         #########
         #....   ##
         #.#.#  $ ##
        ##....# # @##
        # ....#  #  ##
        #     #$ ##$ #
        ## ###  $    #
         #$  $ $ $#  #
         # #  $ $ ## #
         #  ###  ##  #
         #    ## ## ##
         #  $ #  $  #
         ###$ $   ###
           #  #####
           ####

        ---

        ; 35

        ############ ######
        #   #    # ###....#
        #   $$#   @  .....#
        #   # ###   # ....#
        ## ## ###  #  ....#
         # $ $     # # ####
         #  $ $##  #      #
        #### #  #### # ## #
        #  # #$   ## #    #
        # $  $  # ## #   ##
        # # $ $    # #   #
        #  $ ## ## # #####
        # $$     $$  #
        ## ## ### $  #
         #    # #    #
         ###### ######

        ---

        ; 36

                    #####
        #####  ######   #
        #   ####  $ $ $ #
        # $   ## ## ##  ##
        #   $ $     $  $ #
        ### $  ## ##     ##
          # ##### #####$$ #
         ##$##### @##     #
         # $  ###$### $  ##
         # $  #   ###  ###
         # $$ $ #   $$ #
         #     #   ##  #
         #######.. .###
            #.........#
            #.........#
            ###########

        ---

        ; 37

        ###########
        #......   #########
        #......   #  ##   #
        #..### $    $     #
        #... $ $ #   ##   #
        #...#$#####    #  #
        ###    #   #$  #$ #
          #  $$ $ $  $##  #
          #  $   #$#$ ##$ #
          ### ## #    ##  #
           #  $ $ ## ######
           #    $  $  #
           ##   # #   #
            #####@#####
                ###

        ---

        ; 38

              ####
        ####### @#
        #     $  #
        #   $## $#
        ##$#...# #
         # $...  #
         # #. .# ##
         #   # #$ #
         #$  $    #
         #  #######
         ####

        ---

        ; 39

                     ######
         #############....#
        ##   ##     ##....#
        #  $$##  $ @##....#
        #      $$ $#  ....#
        #  $ ## $$ # # ...#
        #  $ ## $  #  ....#
        ## ##### ### ##.###
        ##   $  $ ##   .  #
        # $###  # ##### ###
        #   $   #       #
        #  $ #$ $ $###  #
        # $$$# $   # ####
        #    #  $$ #
        ######   ###
             #####

        ---

        ; 40

            ############
            #          ##
            #  # #$$ $  #
            #$ #$#  ## @#
           ## ## # $ # ##
           #   $ #$  # #
           #   # $   # #
           ## $ $   ## #
           #  #  ##  $ #
           #    ## $$# #
        ######$$   #   #
        #....#  ########
        #.#... ##
        #....   #
        #....   #
        #########

        ---

        ; 41

                   #####
                  ##   ##
                 ##     #
                ##  $$  #
               ## $$  $ #
               # $    $ #
        ####   #   $$ #####
        #  ######## ##    #
        #.            $$$@#
        #.# ####### ##   ##
        #.# #######. #$ $##
        #........... #    #
        ##############  $ #
                     ##  ##
                      ####

        ---

        ; 42

             ########
          ####      ######
          #    ## $ $   @#
          # ## ##$#$ $ $##
        ### ......#  $$ ##
        #   ......#  #   #
        # # ......#$  $  #
        # #$...... $$# $ #
        #   ### ###$  $ ##
        ###  $  $  $  $ #
          #  $  $  $  $ #
          ######   ######
               #####

        ---

        ; 43

                #######
            #####  #  ####
            #   #   $    #
         #### #$$ ## ##  #
        ##      # #  ## ###
        #  ### $#$  $  $  #
        #...    # ##  #   #
        #...#    @ # ### ##
        #...#  ###  $  $  #
        ######## ##   #   #
                  #########

        ---

        ; 44

         #####
         #   #
         # # #######
         #      $@######
         # $ ##$ ###   #
         # #### $    $ #
         # ##### #  #$ ####
        ##  #### ##$      #
        #  $#  $  # ## ## #
        #         # #...# #
        ######  ###  ...  #
             #### # #...# #
                  # ### # #
                  #       #
                  #########

        ---

        ; 45

        ##### ####
        #...# #  ####
        #...###  $  #
        #....## $  $###
        ##....##   $  #
        ###... ## $ $ #
        # ##    #  $  #
        #  ## # ### ####
        # $ # #$  $    #
        #  $ @ $    $  #
        #   # $ $$ $ ###
        #  ######  ###
        # ##    ####
        ###

        ---

        ; 46

        ##########
        #        ####
        # ###### #  ##
        # # $ $ $  $ #
        #       #$   #
        ###$  $$#  ###
          #  ## # $##
          ##$#   $ @#
           #  $ $ ###
           # #   $  #
           # ##   # #
          ##  ##### #
          #         #
          #.......###
          #.......#
          #########

        ---

        ; 47

                 ####
         #########  ##
        ##  $      $ #####
        #   ## ##   ##...#
        # #$$ $ $$#$##...#
        # #   @   #   ...#
        #  $# ###$$   ...#
        # $  $$  $ ##....#
        ###$       #######
          #  #######
          ####

        ---

        ; 48

          #########
          #*.*#*.*#
          #.*.*.*.#
          #*.*.*.*#
          #.*.*.*.#
          #*.*.*.*#
          ###   ###
            #   #
        ###### ######
        #           #
        # $ $ $ $ $ #
        ## $ $ $ $ ##
         #$ $ $ $ $#
         #   $@$   #
         #  #####  #
         ####   ####

        ---

        ; 49

               ####
               #  ##
               #   ##
               # $$ ##
             ###$  $ ##
          ####    $   #
        ###  # #####  #
        #    # #....$ #
        # #   $ ....# #
        #  $ # #.*..# #
        ###  #### ### #
          #### @$  ##$##
             ### $     #
               #  ##   #
               #########

        ---

        ; 50

              ############
             ##..    #   #
            ##..* $    $ #
           ##..*.# # # $##
           #..*.# # # $  #
        ####...#  #    # #
        #  ## #          #
        # @$ $ ###  #   ##
        # $   $   # #   #
        ###$$   # # # # #
          #   $   # # #####
          # $# #####      #
          #$   #   #    # #
          #  ###   ##     #
          #  #      #    ##
          ####      ######

        """;

    // remove blank lines
    text = text.replaceAll("(?m)^[ \t]*\r?\n", "");

    String[] levelTexts = text.split("---\n");

    for (String levelText : levelTexts) {
      // get max width
      int width = 0;
      int height = 0;

      for (String line : levelText.split("\n")) {
        if (line.startsWith(";"))
          continue;
        height++;
        width = Math.max(width, line.length());
      }

      // create level
      byte[][] level = new byte[height][width];

      int y = 0;
      for (String line : levelText.split("\n")) {
        if (line.startsWith(";")) {
          System.out.println(line);
          continue;
        }

        int x = 0;
        for (char c : line.toCharArray()) {
          byte field = 0;
          switch (c) {
            case '#':
              field = Game.WALL_MASK;
              break;
            case '.':
              field = Game.GOAL_MASK;
              break;
            case '$':
              field = Game.BOX_MASK;
              break;
            case '@':
              field = Game.PLAYER_MASK;
              break;
            case '*':
              field = Game.BOX_MASK | Game.GOAL_MASK;
              break;
          }
          level[y][x] = field;
          x++;
        }
        y++;
      }

      if (width == 0 || height == 0)
        continue;

      levels.add(level);
    }
  }

  public static ArrayList<byte[][]> levels = new ArrayList<>();

}
