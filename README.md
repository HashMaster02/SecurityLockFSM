# README #

## What is this repository for? ##

This repository contains Java demo code for a trivial Security Device (SD) that utilizes a FSM. The code here is meant to help students get started with their project.

Here is the original [programming assignment](http://cs.iit.edu/~virgil/cs330/mail.fall2022/pa.html).

This code implements a much simpler FSM that has only three states; the SD Unlocks  when digit 1 is in the input and Locks when the input digit is 4; any other digit in the input brings the FSM to its initial state.

![State Transition Diagram](http://thesleepless.com/cs330/FSM-security-device-demo.png)


Any input that cannot be interpreted as an integer will be discarded before it reaches the FSM.

### How do I get set up? ###

Instructions in this README file are for a Linux environment (Ubuntu 22.04).

#### Summary of set up ####

You must have `gradle` installed before you can complete the setup.

#### Configuration ####

1. Clone the repository:
```
$ git clone https://bistriceanu@bitbucket.org/vbistriceanu/gradle-demo.git
```

2. Make sure all the unit tests pass:
```
$ ./gradlew test
```
Use your browser to view the test html report, it's at `./app/build/reports/tests/test/packages/edu.iit.cs330.fall2022.html`

3. Build an executable jar:
```
$ ./gradlew jar
```

4. Run the executable:
```
$ java -jar ./app/build/libs/app.jar
```
Enter characters from the keyboard, one at a time, followed
by Enter/Return and notice how anything other than 1 and 4 will be ignored.

  Alternatively you can use the keyboard to enter multiple characters separated by space, e.g. '2 9 7 4 a r 4 1 4' followed by Enter/Return: the application will consume the symbols in the string one at a time and print 'Lock'/'Unlock' as it encounters 4 or 1 respectively.

  You could also put data in a file and feed that data to the application, like this:
```
$ cat mydata | java -jar ./app/build/libs/app.jar
```

 or like this:
```
$ java -jar ./app/build/libs/app.jar < mydata
```

5. Generate jacoco unit-test coverage report:
```
$ ./gradlew jacocoTestReport
```
Use your browser to load the html report, it's at `./app/build/reports/jacoco/test/html/edu.iit.cs330.fall2022/index.html`

### Known bugs ###

* Strings that represent integers bigger than 9 will raise an exception.
* Strings that represent negative integers are returned by readInput() as positive integers, need to look into the Scanner class as to why.

### License ###

[GNU Public License](https://www.gnu.org/licenses/gpl-3.0.html)

### Who do I talk to? ###

Email bistriceanu@iit.edu
