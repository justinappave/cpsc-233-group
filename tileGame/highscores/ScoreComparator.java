/** This class compares the two scores. sc1 is the new score and sc2 is the previous highest
 * score in the text file. If the first score is greater than -1 will be returned and sc2 will be moved down.
 * If sc1 is less than sc2 than +1 will be returned and sc1 will take the spot below sc2 */

import java.util.Comparator;

public class ScoreComparator implements Comparator<Score> {
  public int compare(Score score1, Score score2) {
    int sc1 = score1.getScore();
    int sc2 = score2.getScore();

    if (sc1 < sc2){
        return -1;
    }
    else if (sc1 > sc2){
        return +1;
    }
    else{
        return 0;
    }
  }
}
