Overview
========

A general practice program for demonstrating keeping abstractions at a given level, building a simple project with Maven, 
and some simple behavioral testing.

Notes:

* pom.xml describes the project
* You should be able to "import" this project into Eclipse or IntelliJ as an existing maven project
* src/test/java is the location to put tests
* src/main/java is the place to put "production" code
* .gitignore contains the names of files/folders that should not be checked into git (any derived/compiled/IDE files) 
* The tests follow a "behavioral specification" model, but using JUnit. The idea is to name each test as a behavior that your 
  abstraction follows.
* You can right-click on any Spec and run it within your IDE as a JUnit Test