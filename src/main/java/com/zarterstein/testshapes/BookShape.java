package com.zarterstein.testshapes;

import com.zarterstein.chaxels.Shape;

import java.util.ArrayList;
import java.util.Arrays;

public class BookShape extends Shape {

    public BookShape() {
        // Constructor logic if needed
    }

    public Shape shape() {
        // Setting a grid of 24x12 for a cozy sitting cat profile
        reset(103, 35);

        // 1. The Character Map (The "ASCII" Art)
        applyText(new ArrayList<>(Arrays.asList(
                "                                              @@@@@@@                                                  ",
                "                                         M@@@@@@...@@@@@@@@@                                           ",
                "                                     @@@@@@l.....@@......d@@@@@@@@r                                    ",
                "                                @@@@@@@.....@@@@@ZdM@@@@@,......@@@@@@@@@                              ",
                "                           @@@@@@@.....-@@@@@dr@@@@@@cJZM@@@@@@@......<@@@@@@@a                        ",
                "                      @@@@@@@......@@@@@Mddddc@@....@@MMMMMaaZZM@@@@@@c......M@@@@                     ",
                "                   @@@@@c.....@@@@@@ddaadaaaMZ@@...l@@llllZ@MaMMMMMMdZM@@@@@@@@@@                      ",
                "                   @@@@d.,@@@@aZZdaaaaaaaaaaaZJ@@@@@@@@@@alllllllll@Md@@@@@@@@                         ",
                "                     @@@@@@@@@@@acccJZdaaadadaddJJJJcccJdM@@@@@@@@ll@@@@@@                             ",
                "                           @@@@@@@@@@@accJJJJddaaaaaaaaaddZc/1-Z@@1l@@@@@@                             ",
                "                             @@@@@a@@@@@@@@@@@JcZZJZdaZZJZc@@@@@@@cl<@@@@@                             ",
                "                             @@dZ@...@Z@@@@@@@@@@@@@@ZJ@@@@@@@@@@@lll@@@@@                             ",
                "                             @@a@@...@cdJJJddM@@@@@@@@@@@@@@Mdd@@lllll@@@@                             ",
                "                             @@dM@.,.@ZaddaaaZZZJcJJZ@@@@rZZaaZ@@ll@ll@@@@                             ",
                "                        @@@@@@@@Z@...@ZMaMaaaaaMaMMaZ@@@@ZMMaMJ@@ll@ll@@@@@@@@@@@/                     ",
                "                   @@@@@@@@lll@@@@@@-@cJJZJZaaaMaMaadM@@@JMaMMJ@@ll@ll@@@@////M@@@@@@@                 ",
                "                 @@@@lllll<@@<-1-ll/M@@@@@@@@JJZJZdddM@@@JdZZZc@@ll@ll@@@@//////r@@@@@                 ",
                "                @@ll<ll@@@lllllllll111--<<1M@@@@@@@arJ@@@J@@@@@@@@@@@@///r@@@@@@@.@@                   ",
                "               @@@l1r/@@M1/1llllllllllll<<lll11/1/@@@@@@@@@/1/11-//@@@@@@@l.......@@                   ",
                "               @@@</1<@@l1/cJJJJdZ-lllllll@@@lllllllll-<<<<r@@@@@@@c.......,......@@                   ",
                "                @@ll<l@@<-1111111/rJZJcZ/@@llllllllr1J@@@@@@/........-............@@d@                 ",
                "               @@@@@@@@@Zl<<<<<--111111-1@@lrccJccc1@@........,................/@@@@@@                 ",
                "             @@@allll@@@@@@@@@r//<l-<<<-1@@lc11111--@@.................-@@@@@@@aZZ@@                   ",
                "             @@ZZZZZZ@/llllllZZ@@@@@@@r/<@@l1-1-1111@@..........r@@@@@@ZZZZZZ@@@@@@@                   ",
                "             @@ZZZZZ@@ZZZZZZ-lllllllrZa@@@@@@Z/<--<-/@@..Z@@@@@@ZZZZZZ@@@@@a-...Z@@                    ",
                "             @@ZZZZZ@@ZZZZZZZZZZZZZrllllZ@dlJM@@@@@@@@@@@ZZZZZZ@@@@@@<...........@@                    ",
                "             @@@ZZZZ@@ZZZZZZZZZZZZZZZZZZ@@rlllll@@@ZZZZZ@@@@@@c.........Z@@Z.....@@@@@                 ",
                "              @@@@@@@@@ZZZZZZZZZZZZZZZZ@@ZZZZZZ@@ZZZ@@@@l.........a@@........@@@@@@@@@                 ",
                "                  @@@@@@@@@ZZZZZZZZZZZZ@@ZZZZZZ@ZZZ@@.......@@@.......,@@@@@@@@@                       ",
                "                        -@@@@@@@@@ZZZZZZ@ZZZZZZ@ZZZ@@.a@@.......Z@@@@@@@@@                             ",
                "                                @@@@@@@@@@ZZZZZ@@ZZ@@.....M@@@@@@@@Z                                   ",
                "                                       @@@@@@@@@@@Z@@@@@@@@@@Z                                         ",
                "                                              @@@@@@@@@J                                               ",
                "                                                                                                       ",
                "                                                                                                       "

        )));
// Cap (deep academic tones)
        addColorToTable('@', new int[] {0, 35, 0}, new int[] {0, 0, 0});    // ordinary black :)
        addColorToTable('A', new int[] {25, 25, 60}, new int[] {0, 0, 60});    // very dark blue
        addColorToTable('B', new int[] {40, 40, 90}, new int[] {40, 40, 150});    // dark blue
        addColorToTable('C', new int[] {70, 70, 130}, new int[] {70, 70, 180});   // mid blue
        addColorToTable('D', new int[] {110, 110, 170}, new int[] {110, 150, 220}); // highlight blue
        addBgColorToTable(' ', new int[] {255, 255, 255}); // highlight blue


// Books (leather + paper)
        addColorToTable('1', new int[] {60, 20, 10}, new int[] {90, 30, 20});   // DARRK brown
        addColorToTable('E', new int[] {150, 90, 40}, new int[] {120, 70, 30});   // dark brown
        addColorToTable('F', new int[] {190, 130, 70}, new int[] {160, 100, 50});  // mid brown
        addColorToTable('G', new int[] {200, 150, 90}, new int[] {160, 130, 70});  // light brown
        addBgColorToTable('H', new int[] {235, 220, 180}); // paper
        addBgColorToTable('Z', new int[] {35, 235, 100}); // GREENISH
        addBgColorToTable('Y', new int[] {45, 255, 120}); // GREENISH
        addBgColorToTable('X', new int[] {0, 205, 70}); // GREENISH
        addColorToTable('U', new int[] {0, 60, 10}, new int[] {0, 90, 30});

// Gold accents (tassel / details)
        addBgColorToTable('I', new int[] {180, 140, 20});
        addBgColorToTable('J', new int[] {220, 180, 40});
        addBgColorToTable('K', new int[] {255, 220, 90});

// Shadow / depth
        addColorToTable('L', new int[] {50, 30, 20}, new int[] {30, 40, 80});

        // 3. Applying Colors
        applyColorsFromTable(new ArrayList<>(Arrays.asList(
                "                                              LLLL@@@                                                  ",
                "                                         LLLL@@@DDD@@@@@@@@                                            ",
                "                                     LLLLL@DDDDDA@@AAAADDD@@@@@@@@A                                    ",
                "                                LLLL@@@DDDDD@@@@@BBB@@@@@AAAADDD@@@@@@@@@                              ",
                "                           LLLL@@@DDDDDD@@@@@BB@@@@@@AAAA@@@@@@@AAAAADDDD@@@@@A                        ",
                "                      LLLL@@@DDDDDD@@@@@BBBBBB@@KKKKGGAAAAAAAAAA@@@@@@AAAADDDDA@@@                     ",
                "                   LLLL@DDDDDD@@@@@@BBBBCCBBBB@@KKKKGGHHHHH@DDDDDDDDAAAAAAAAA@@@@                      ",
                "                   @@@@DDD@@@@BBBBBBBBBCCCCBBBB@@@@@@@@@@AHHHHHHHHH@DD@@@@@@@@                         ",
                "                     @@@@@@@@@@@AAAAAAAAAAAAAAAAAAAAAAAAAA@@@@@@@@JJ@AAAA@                             ",
                "                           @@@@@@@@@@@AAAAAAAAAAAAAAAAAAAAAAAAAA@@JJ@@AAA@                             ",
                "                             @@@@@A@@@@@@@@@@@AAAAAAAAAAAAA@@@@@@@JJJ@AAA@                             ",
                "                             @@AA@DDD@A@@@@@@@@@@@@@@JJ@@@@@@@@@@@JJJ@@AA@                             ",
                "                             @@AA@DDD@AAAAAAAA@@@@@@@@@@@@@@AAA@@JJJJJ@AA@                             ",
                "                             @@AA@DDD@AAAAAAAAAAAAAAA@@@@AAAAAA@@HJ@HJ@AA@                             ",
                "                        1111@@@@A@DDD@AAAAAAAAAAAAAAA@@@@AAAAAA@@HJ@HJ@AA@@@@@@@@A                     ",
                "                   11111111GGG11@@@@D@AAAAAAAAAAAAAAAA@@@AAAAAA@@HJ@HJ@@@@AAAAA@@@@@@@                 ",
                "                 1111KGGGGGG1GGGGGGGA@@@@@@@@AAAAAAAAA@@@AAAAAA@@HJ@HJ@@@@AAAAAAA@@@@@                 ",
                "                11FGGGG111KKGGGGGGGGGGGGGGGG@@@@@@@AAA@@@A@@@@@@@@@@@@AAAA111111GG11                   ",
                "               111FFFF11FFFGGGGGGGGGGGGGGGGGGGGGGG@@@@@@@@@AAAAAAAA111111GGGGHHHHH11                   ",
                "               111EEFF11FFFFFFFFKKGGGGGGGG111GGGGGGGGGGGGGGA11111GGGGHHHHHHHHHHHHH1@                   ",
                "                11EEEE11EEEEEFFFFFFFFFFKK11GGGGGGGGFFF11111GGHHHHHHHHHHHHHHHHHHHHH11A@                 ",
                "               111111111EEEEEEEEEEEEFFFFF11FFFFFFFKK11GGHHHHHHHHHHHHHHHHHHHHHHHH1111@@                 ",
                "             UUUYYYYY1111111EEEEEEEEEEEEE11EEEEEEEEE11HHHHHHHHHHHHHHHHHH11111EEHHHUU                   ",
                "             UUZZZZZZUYYYYYYYYY11111EEEEE11EEEEEEEEE11HHHHHHHHHHH1111EEEEEEEEGGGGUUU                   ",
                "             UUZZZZZUUZZZZZZYYYYYYYYYYY1111EEGEEEEEEE1@HHH1111EEEEEEEEUUUUUAGGHHHUUU                   ",
                "             UUXXZZZUUZZZZZZZZZZZZZYYYYYYUYYYY1111111111EEEEEEEUUUUUUGGHHHHHHHHHHUU                    ",
                "             UUUXXXXUUXXZZZZZZZZZZZZZZZZUUYYYYYYUUUYYYYZUUUUUUGGHHHHHHHHHHHHHHHHHHUUUU                 ",
                "              UUUUUUUUUXXXXXXXZZZZZZZZZUUZZZZZZUUYYYUUUUGGHHHHHHHHHHHHHHHHHHHHHHHUUUGG                 ",
                "                  UUUUUUUUUXXXXXXXZZZZZUUZZZZZZUZZZUUGGHHHHHHHHHHHHHHHHHHHHUUUUU                       ",
                "                        UUUUUUUUUUXXXXXXUZZZZZZUZZZUUHHHHHHHHHHHHHHHHUUUUU                             ",
                "                                UUUUUUUUUUXXXXXUUXZUUHHHHHHHHHUUUUUU                                   ",
                "                                       UUUUUUUUUUUXUHHHHUUUUUU                                         ",
                "                                              UUUUUUUUUU                                               ",
                "                                                                                                       ",
                "                                                                                                       "

        )));


        return this;
    }
}