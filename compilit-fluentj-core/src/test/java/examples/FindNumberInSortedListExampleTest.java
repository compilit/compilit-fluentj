package examples;

import com.compilit.fluentj.api.predicates.Predicates;
import org.junit.jupiter.api.Test;
import testutil.AbstractClockingTest;

import java.util.List;

import static com.compilit.fluentj.api.loops.Loops.takeEachEntryIn;
import static com.compilit.fluentj.api.operations.ConnectingOperations.and;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.predicates.Predicates.inCaseThat;
import static com.compilit.fluentj.api.predicates.Predicates.itIs;

class FindNumberInSortedListExampleTest extends AbstractClockingTest {

  @Test
  void internal() {
    final var list = List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
    System.out.println(list.indexOf(0));
  }

  @Test
  void regular() {
    final var list = new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4};
    int result = 0;
    for (int i = 0; i < list.length; i++) {
      if (list[i] == 0)
        result = i;
    }
    System.out.println(result);
  }

  @Test
  void findNumberInSortedList() {
    final var list = List.of(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5);
    takeEachEntryIn(list, and(inCaseThat(itIs(0), printIt())));
  }

  @Test
  void findNumberInSortedListAndReturnValue() {
    var result = findPositionOf(0, new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4});
    System.out.println(result);
    result = findPositionOf(1, new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4});
    System.out.println(result);
  }

  private int findPositionOf(final int numberToFind, final int[] source) {
    var a = 0;
    var b = source.length - 1;
    while (true) {
      var h = (a + b) / 2;
      if (source[h] == numberToFind)
        return h;
      else if (source[h] > numberToFind)
        b = h;
      else if (source[h] < numberToFind)
        a = h;
    }
  }
}
