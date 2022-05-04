# compilit-fluentj

A "mad scientist" project to provide a fluent API for all Java's core operations.

The goal should never be to completely make programmers be able to program using plain English. Because plain English is
too vague. However, recent studies have suggested that the ability to learn new spoken languages is a far more important
skill than the ability to apply abstract math concepts. This made me think that it "might" be beneficial to abstract the
more unnatural parts of java
and hide them behind plain English interfaces. The result is FluentJ. English with restrictions, or Java that reads as
English. I've chosen a more functional approach for the fluent API then the more common OOP paradigm where you get
limited options after each word.

At first I wasn't convinced. And I still am not convinced! But I just get goose bumps whenever I see this. Behold a
simple switch:

```java
class Example {

  public void example(int theInput) {

    inCaseThat(theInput,
            is(1, printIt()),
            is(2, print("this is something else"))),
            is(3, print("this is also something else")),
            otherwise(print("none"));

  }

}

//as opposed to:
class Example {

  public void example(int theInput) {

    switch (theInput) {
      case 1:
        System.out.println(theInput);
      case 2:
        System.out.println("this is something else");
      case 3:
        System.out.println("this is also something else");
      default:
        System.out.println("none");
    }

  }
}

```

If that doesn't do it for you, then maybe some prime numbers?

```java

class Example {

  void fluentJPrimeNumbers() {
    //while
    //if-statement consumer visually a part of the loop
    startingWith(1,
            untilReachingOrGoingAbove(10000,
                    keep(adding(1)),
                    andInCaseThat(itIsAPrimeNumber(), printIt())));

    //while
    startingWith(1,
            untilReachingOrGoingAbove(10000, keep(adding(1))),
            andInCaseThat(itIsAPrimeNumber(), printIt()));

    //doWhile
    startingWith(1,
            keep(adding(1), untilReachingOrGoingAbove(10000)),
            andInCaseThat(itIsAPrimeNumber(), printIt()));
  }

}

```

