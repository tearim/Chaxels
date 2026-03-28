package com.zarterstein.testshapes;

import com.zarterstein.chaxels.Shape;

import java.util.ArrayList;
import java.util.Arrays;

public class HatulMadanShape extends Shape {

    public HatulMadanShape() {
    }

    public Shape shape() {

        reset(64, 48);

        applyText(new ArrayList<>(Arrays.asList(
                "                  @%#*###*+*#@                                    ",
                "               @@#           =*#                                  ",
                "             @%%               -@                                 ",
                "            %%                  #                                 ",
                "           *%                 #@                                  ",
                "           *#                         -%%      *%                 ",
                "           *+                         -%+*#####%%                 ",
                "           +*                         =@        %                 ",
                "           +*+                        -@       =#                 ",
                "            +**                       -@=:+# ++*#                 ",
                "              =***        ###*********+%** **#*%#*******##        ",
                "                 =***     *####*******+%*+  =%****##**##          ",
                "                   =*#####*+==-==-    -@  ++#***    ===+%%        ",
                "                     =%               +       ##                  ",
                "                      ++              %   +#%%%%                  ",
                "                %**+  ++   #  #*+++**+%       %%                  ",
                "               *+    *%  *+%  ++     @        %%                  ",
                "               +*#*##@    =#  ==   *%@        %%                  ",
                "                  =           ##              %%                  ",
                "                            +#@               #%                  ",
                "                        +==+%#                #%                  ",
                "                                              *%                  ",
                "                       **                     #%                  ",
                "                 *     =**+#%*++++*#%@     #* %%                  ",
                "                +#    =+   =+-==-=#= =*       ##                  ",
                "                -%    +%+++=#  %% %  =%*      =+                  ",
                "                =#    *@*###      #   **+      %%                 ",
                "                 *%##@%@@#*      ++   -*+*     ##                 ",
                "                 ++               @    %=##    -#                 ",
                "                 +%                    =% #*    #%                ",
                "                 **                    =%  +#   =%                ",
                "                 *++                   %%   =**  +%               ",
                "                  *#                   ++    ++* =%               ",
                "                  #%                    +#    =** =#              ",
                "                  **                    %%     =#* +%             ",
                "                  ++                    =+       #**#             ",
                "                  ++                     %@       +**#            ",
                "                  **                     ##        +**#           ",
                "                  #%                     -*         +*#*          ",
                "                  *%                      %@         +###         ",
                "                 *#                       %%           *%%        ",
                "                 #@                       *#            *@@       ",
                "                @@                        +#             +%@@     ",
                "              @@@                         %@              #@@@    ",
                "           @@@@                          @@@                @@@   ",
                "         *#%%                           @@@                       ",
                "                                       @@@                        ",
                "                                     @@@                          "
        )));
        addColorToTable('A', new int[] {255, 155, 240}, new int[] {255, 105, 180}); // hot pink
        addColorToTable('B', new int[] {206, 105, 231}, new int[] {186, 85, 211});  // medium purple
        addColorToTable('C', new int[] {158, 63, 246}, new int[] {138, 43, 226});  // blue-violet
        addColorToTable('D', new int[] {30, 201, 255}, new int[] {0, 191, 255});   // neon cyan/sky blue
        addColorToTable('E', new int[] {0, 255, 0}, new int[] {0, 255, 0});     // bright green (eyes)
        addBgColorToTable('F', new int[] {0,   0, 0});     // BLACK
        addColorToTable(' ', new int[] {0,  0, 0}, new int[] {0,  0, 0});


        applyColorsFromTable(new ArrayList<>(Arrays.asList(
                "                  DDDDAAAAAAAA                                    ",
                "               DAA           DDA                                  ",
                "             DAA               DA                                 ",
                "            DA                  A                                 ",
                "           DA                 DA                                  ",
                "           DA                         DAB      DA                 ",
                "           DA                         DABBAAABBBA                 ",
                "           DA                         DA        A                 ",
                "           DAA                        DA       DA                 ",
                "            AAD                       DACEFE EFEA                 ",
                "              AAAD        CCCCCCCCCCCCDACC DACDABBBBBBBBBB        ",
                "                 AAAD     DDDDDDDDDDDDADAD  ADCCCCCCCCCC          ",
                "                   ADDAAACCCCCCCCC    AD  AAAAAD    DDDDDD        ",
                "                     AD               A       CD                  ",
                "                      AD              A   AAAAAD                  ",
                "                DAAA  AD   D  AAAAAAAAD       AD                  ",
                "               DA    AD  CAD  AD     D        AD                  ",
                "               DAAAADD    AD  AD   ADD        AD                  ",
                "                  D           AD              AD                  ",
                "                            AAD               AD                  ",
                "                        DAAADD                AD                  ",
                "                                              AD                  ",
                "                       BB                     AD                  ",
                "                 D     BBBBDAAAAAAAAAD     DA AD                  ",
                "                DA    DA   DACCCCCDC DD       AD                  ",
                "                DA    DABBBAD  BB D  DAD      AD                  ",
                "                DA    DABBAD      D   DAD      AD                 ",
                "                 DA AAAAADD      AD   DAAD     AD                 ",
                "                 DA               D    DAAD    AD                 ",
                "                 DA                    AD DA    AD                ",
                "                 DA                    AD  DA   AD                ",
                "                 DAA                   AD   DAA  AD               ",
                "                  DA                   AD    DDA AD               ",
                "                  DA                    AD    DDA AD              ",
                "                  DA                    AD     DDA AD             ",
                "                  DA                    AD       DAAD             ",
                "                  DA                     AD       DAAD            ",
                "                  DA                     AD        DAAD           ",
                "                  DA                     AD         DAAD          ",
                "                  DA                      AD         DAAD             ",
                "                 DA                       AD           DAD        ",
                "                 DA                       AD            DAD       ",
                "                DA                        AD             CDDC     ",
                "              DDA                         AD              CDDC    ",
                "           DDAA                          AAD                DDD   ",
                "         DDDA                           AAD                       ",
                "                                       AAD                        ",
                "                                     DDD                          "
        )));
        applyBRGBOpacityMask(new ArrayList<>(Arrays.asList(
                "               469DDDDAAAAAAAA964                                 ",
                "            469DAA99999999999DDA964                               ",
                "          469DAA964         469DA964                              ",
                "         469DA964            469A964  444      44                 ",
                "        469DA964            469A964 4699964  469964               ",
                "        469DA964                   469DAB964469DA964              ",
                "        469DA964                   469DABBAAABBBA964              ",
                "        469DA964                   469DA96666669A964              ",
                "        469DAA964                  469DA9666669DA964             ",
                "         469AAD964        666666666699DACEFE9EFEA996666666        ",
                "           469AAAD964  469CCCCCCCCCCCCDACC9DACDABBBBBBBBBB964     ",
                "              469AAAD96469DDDDDDDDDDDDADAD99ADCCCCCCCCCC964       ",
                "                 496DDAAACCCCCCCCC9669AD99AAAAAD9999DDDDD9642     ",
                "                  469AD99999999966   9A9999999CD9669666666        ",
                "                   469AD96363999999999A969AAAAAD964               ",
                "             469DAAA99AD696D66AAAAAAAAD9646669AD964               ",
                "            469DA6996AD66CAD66AD99999D964  469AD964               ",
                "            496DAAAADD6898A686AD969ADD     469AD964               ",
                "               469D964       9AD964        469AD964               ",
                "                 464       9AAD964         469AD964               ",
                "                       9DAAADD964          469AD964               ",
                "                 44    999999964666666     469AD964               ",
                "               46964469BB999999999999964  4669AD964               ",
                "              469D96469BBBBDAAAAAAAAAD96446DA9AD964               ",
                "             469DA9669DA999DACCCCCDC9DD964 669AD964               ",
                "             469DA9669DABBBAD99BB9D99DAD964469AD964               ",
                "             469DA9999DABBAD966999D969DAD964469AD964              ",
                "              469DA9AAAAADD964469AD969DAAD96669AD964              ",
                "              469DA9999999964  469D9669DAAD9669AD964              ",
                "              469DA966666664    4666469AD9DA9669AD964             ",
                "              469DA9644444       444469AD99DA969AD964             ",
                "              469DAA964             469AD969DAA99AD964            ",
                "               469DA964             496AD9669DDA9AD964            ",
                "               469DA964              469AD9669DDA9AD964           ",
                "               469DA964              469AD96469DDA9AD964          ",
                "               469DA964              469AD964 469DAAD964          ",
                "               469DA964               469AD964 469DAAD964         ",
                "               469DA964               469AD964  469DAAD964        ",
                "               469DA964               469AD964   469DAAD964       ",
                "               469DA964                469AD964   469DAAD964          ",
                "              469DA964                 469AD964     469DAD964     ",
                "              469DA964                 469AD964      469DAD964    ",
                "             469DA964                  469AD964       469CDDC964  ",
                "           469DDA964                   469AD964        469CDDC964 ",
                "        469DDAA964                    469AAD964          469DDD964",
                "      469DDDA964                     469AAD964             699996 ",
                "       66999666                     469AAD964               4444  ",
                "        44444                     469DDD964                       "
        )));


        return this;
    }
}