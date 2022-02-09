public class mazeTester {
    public static void main(String[] args) {
 //       MazeNavigator a = new MazeNavigator();
        // MazeNavigator a = new MazeNavigator(1, "src/PlayerOneMoves.txt");
        try {
/*            MazeNavigator[] mazeNavigators = {
                    new MazeNavigator(2, "src/PlayerTwoMoves.txt"),
                    new MazeNavigator(1, "src/PlayerOneMoves.txt")
            };*/
            String[]  strings={
                    new String("11"),
                    new String("21")
            };
            MazeNavigator[] mazeNavigators = {
                    new MazeNavigator(1, "src/PlayerOneMoves.txt"),
                    new MazeNavigator(2, "src/PlayerTwoMoves.txt")
            };
/*            MazeNavigator[]  mazeNavigators;
            mazeNavigators = new MazeNavigator[2];
            mazeNavigators[0]= new MazeNavigator(1, "src/PlayerOneMoves.txt");
            mazeNavigators[1]= new MazeNavigator(2, "src/PlayerTwoMoves.txt");*/


            for (int i = 0; i < mazeNavigators.length; i++) {
                // mazeNavigators[i].a();
                mazeNavigators[i].start();
            }
/*            for (int i = 0; i < mazeNavigators.length; i++) {
                mazeNavigators[i].join();
            }*/
        } catch (Exception ex) {
            ex.printStackTrace();
            return;
        }
    }
}

