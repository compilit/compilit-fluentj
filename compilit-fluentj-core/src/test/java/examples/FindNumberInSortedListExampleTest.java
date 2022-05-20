package examples;

import org.junit.jupiter.api.Test;
import testutil.AbstractClockingTest;

import java.util.List;

import static com.compilit.fluentj.api.loops.Loops.startingWith;
import static com.compilit.fluentj.api.loops.Loops.takeEachEntryIn;
import static com.compilit.fluentj.api.operations.LoggerOperations.printIt;
import static com.compilit.fluentj.api.predicates.Predicates.andInCaseThat;
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
    takeEachEntryIn(list, andInCaseThat(itIs(0), printIt()));
  }

  @Test
  void findNumberInSortedListAndReturnValue() {
   var result = findPositionOf(0);
    System.out.println(result);
  }

  private int findPositionOf(final int numberToFind) {
    final var list = new int[]{-5, -4, -3, -2, -1, 0, 1, 2, 3, 4};
    var a = 0;
    var b = list.length - 1;
    while(true) {
      var h = (a + b) / 2;
      if (list[h] == numberToFind)
        return h;
      else if (list[h] > numberToFind)
        b = h;
      else if (list[h] < numberToFind)
        a = h;
    }
  }
}
