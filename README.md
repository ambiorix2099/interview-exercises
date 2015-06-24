# CyberCoders Interview Answers: for ZipWhip - by Francisco Almonte

## My Coding Style
My coding style is influenced by seminal books such as:
[Clean Code](http://www.amazon.com/Clean-Code-Handbook-Software-Craftsmanship/dp/0132350882) and
[Effective Java](http://www.amazon.com/Effective-Java-Edition-Joshua-Bloch/dp/0321356683).
I highly value code clarity and testability. When it makes sense, I liberally use well-known libraries
and frameworks such as: Spring, Google Guava, RestEasy, Apache Commons, etc...
At other times, again when it makes sense, I might eschew those very same libraries/frameworks if their costs
outweigh their benefits.

A trio of, perhaps unusual coding quirks of mine:

1. I avoid creating unnecessary variables, i.e. those which would only be used once;

2. When practical, I avoid inline comments, in favor of expressive variable names and code statements; and

3. I avoid unnecessary line breaks, as I expressly use them, or not, to convey how related contiguous code lines are to one another.

## My Answers to the Coding Tasks

### Coding Task 1
Write a function to reverse a string.

My answers are located in
`com.cybercoders.interview.Exercise1.java` and
`com.cybercoders.interview.Exercise1Test.java`

### Coding Task 2
Print out the grade school multiplication table up to 12 x 12.

My answers are located in
`com.cybercoders.interview.Exercise2.java` and
`com.cybercoders.interview.Exercise2Test.java`

### Coding Task 3
Define a tree where every node can have many children.
Write a method to print out the elements of the tree breadth first backwards
starting with the bottom tier nodes and working up the tree.

My answers are located in
`com.cybercoders.interview.Exercise3.java` and
`com.cybercoders.interview.TreeNodeTest.java`

### Coding Task 4
Model the Animal kingdom as a class system, for use in a Virtual Zoo program.

Before delving into my design approach to the class system for this Zoo program, I feel it is important to point out that
my design approach would have been vastly different, and probably a lot simpler, had I been asked to design the same class system
for a brick 'n mortar zoo, probably interested in recording animal care. In that hypothetical situation, I would not have
to worry about modeling each physical action that animals are allowed to take, like moving on land, air, or sea.

For fear of getting too lost in the details when answering a design question like this, I'll stick to these high-level design objectives:

 * Clearly identify and model domain objects and any meaningful variations, e.g. Mammal, Reptile, Fish, Amphibian, Bird, etc...
 * Clearly identify application-level objects and not conflate them and their responsibilities with domain objects (I often see this problem).
 * Avoid an explosion of classes, and keep business logic simple, by strategically using interfaces to model animal behaviors that don't have to be shared
   all across the board, as would be the case if class inheritance were heavily relied on for the same. I guess what I'm trying to express here is the
   principle of "coding to interfaces".
 * Start with the simplest design possible, then iterate into more complex designs, only as necessary to meet some business or system requirement.

Given the above design objectives and my own design sensibilities, I expect that my design would include the minimum set of *perhaps*:

   * These classes: Mammal, Reptile, Fish, Amphibian, Bird, etc... each of these classes may contian a `subType` attribute (probably of type `enum`.
   * And these interfaces: ColdBlooded, HotBlooded, Flier, Swimmer, Domesticatable, Tamable, Untamable, etc...
   
### Coding Task 5
Examine the given Java code and answer the following questions:

1. What does it do? This is what the method name `func` does:
    * Accepts an array of strings and an integer as the input parameters `a` and `bottom`, respectively
    * Attempts to convert each `String` into a `Double` by reading them into a LinkedList named `converted`
    * Dumps the items in `converted`, except for the last one, into an array of primitive doubles named `b`
    * If input array parameter `a` had a length of one:
        * Attempts to Parse the `String` into a `Double` and return it
    * Otherwise:
        * Parse the last string in array `a` into a variable of type `Double`
        * Fails to evaluate the statements in the subsequent `if` statement, because of a bug resulting from reading outside the bounds of array `b`
        * If not for the above-mentioned bug and had the above-mentioned `if` statement evaluated to `true`, the intention of the subsequent code was to:
            * Replace the last value in array `b` with the last value in input array `a`
            * Marshal all the items in array `b` into an array of strings named `args`, while converting them to strings
            * Finally, the `func` method recursively calls itself, passing in `args` and `bottom` as input parameters
            * If we were to pretend that the previously-mentioned bug did not exist, the recursive calls would, indeed, stop as the length of the `args` array is reduced until it only contains one element, thus meeting the recursion's end case.  
2. Does it have any bugs?
    * Yes, there is that bug I pointed out in my answer to the previous question.
      Another bug is that of not handling `NumberFormatExceptions`, if any of the input strings could not be parsed into a `Double`.   
3. Describe the effectiveness of its use of Java classes to accomplish its goal?
    * I don't like how the values in the input `String` array are naively converted into `Doubles` without handling the unchecked `NumberFormatException`.
    * The input parameter `bottom` is never used for anything.
    * Brackets around `for` loops are sometimes used, sometimes not, this is sloppy styling.
4. Describe the effectiveness of its algorithm.
    * The algorithm is effective, for whatever the code's goal is (and bugs not-withstanding), but the recursion is not necessary and can be easily replaced with an iteration-based equivalent.

The code snippet I used to debug into what this sample code was trying to do can be found at:
`com.cybercoders.interview.Exercise5.java`