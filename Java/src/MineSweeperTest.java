import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by zhaoran on 10/4/14.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({MineSweeperTest._1x1_Test.class
                    , MineSweeperTest._2x1_Test.class
                    , MineSweeperTest._1x2_Test.class
                    , MineSweeperTest._3x1_Test.class
                    , MineSweeperTest._1x3_Test.class
                    , MineSweeperTest._2x2_Test.class})
public class MineSweeperTest {
    static public class _1x1_Test {
        private MineSweeper sweeper = new MineSweeper();

        @Test
        public void the_grid_with_mine_in_it_should_be_asterisk() throws Exception {
            assertArrayEquals(new String[]{"*"}, sweeper.sweep(new String[]{"*"}));
        }

        @Test
        public void the_grid_without_mine_in_it_should_be_dot() throws Exception {
            assertArrayEquals(new String[]{"."}, sweeper.sweep(new String[]{"."}));
        }
    }

    static public class _2x1_Test {
        private MineSweeper sweeper = new MineSweeper();

        @Test
        public void the_left_grid_with_mine_should_be_1() throws Exception {
            assertArrayEquals(new String[]{"*1"}, sweeper.sweep(new String[]{"*."}));
        }

        @Test
        public void the_right_grid_with_mine_should_be_1() throws Exception {
            assertArrayEquals(new String[]{"1*"}, sweeper.sweep(new String[]{".*"}));
        }
    }

    static public class _3x1_Test {
        private MineSweeper sweeper = new MineSweeper();

        @Test
        public void both_left_grid_and_right_grid_with_mine_should_be_2() throws Exception {
            assertArrayEquals(new String[]{"*2*"}, sweeper.sweep(new String[]{"*.*"}));
        }
    }

    static public class _1x2_Test {
        private MineSweeper sweeper = new MineSweeper();

        @Test
        public void has_mine_in_top_grid_should_be_1() throws Exception {
            assertArrayEquals(new String[]{"*", "1"}, sweeper.sweep(new String[]{"*", "."}));
        }

        @Test
        public void has_mine_in_bottom_grid_should_be_1() throws Exception {
            assertArrayEquals(new String[]{"1", "*"}, sweeper.sweep(new String[]{".", "*"}));
        }
    }

    static public class _1x3_Test {
        private MineSweeper sweeper = new MineSweeper();

        @Test
        public void both_top_grid_and_bottom_grid_with_mine_should_be_2() throws Exception {
            assertArrayEquals(new String[]{"*", "2", "*"}, sweeper.sweep(new String[]{"*", ".", "*"}));
        }
    }

    static public class _2x2_Test {
        private MineSweeper sweeper = new MineSweeper();

        @Test
        public void has_mine_in_top_left_grid_should_be_1() throws Exception {
            assertArrayEquals(new String[]{"*1", "11"}, sweeper.sweep(new String[]{"*.", ".."}));
        }

        @Test
        public void has_mine_in_top_right_grid_should_be_1() throws Exception {
            assertArrayEquals(new String[]{"1*", "11"}, sweeper.sweep(new String[]{".*", ".."}));
        }

        @Test
        public void has_mine_in_bottom_left_grid_should_be_1() throws Exception {
            assertArrayEquals(new String[]{"11", "*1"}, sweeper.sweep(new String[]{"..", "*."}));
        }

        @Test
        public void has_mine_in_bottom_right_grid_should_be_1() throws Exception {
            assertArrayEquals(new String[]{"11", "1*"}, sweeper.sweep(new String[]{"..", ".*"}));
        }
    }

    static public class _3x3_Test {
        private MineSweeper sweeper = new MineSweeper();

        @Test
        public void all_around_with_mine_should_be_8() throws Exception {
            assertArrayEquals(new String[]{"***", "*8*", "***"}, sweeper.sweep(new String[]{"***", "*.*", "***"}));
        }
    }
}
