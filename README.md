
| CS-665       | Software Design & Patterns   |
|--------------|------------------------------|
| Name         | Pranjal Ekhande              |
| Date         | 17/03/2024                   |
| Course       | Spring'24                    |
| Assignment # | 4 (Utilizing Legacy Systems) |

# Assignment Overview
The purpose of this application is to provide an interface to access legacy data that is accessed via USB and modernize it to be accessed instead by way of HTTPS requests (within context of a RESTful API, please note this project does not provide the RESTful API and only the classes necessary to convert data).

# GitHub Repository Link:


# Implementation Description
The project's implementation relies on the Adapter software design pattern, facilitating the interchangeability between different data types without requiring modifications to either class. In this particular case, the objective is to transition from accessing legacy data via USB to using `HTTPS` calls (via a RESTful API).

Legacy and modern data are represented by the `CustomerData_USB` and `CustomerData_HTTPS` interfaces respectively. Accompanying these interfaces are the `CustomerProfile_USB` and `CustomerProfile_HTTPS` classes, designed to provide input for storage within the `CustomerData` classes. The implementations of the USB and `HTTPS` data classes include additional methods for managing `CustomerProfile` objects within `CustomerData` classes, where profiles are stored in an ArrayList.

An important consideration is that due to the void return type of the methods defined in the provided interfaces, my project's implementation circumvents this limitation by introducing a method named `getActiveCustomer`. When either printCustomer or `getCustomer` methods are invoked, they also set the retrieved customer profile to the class itself. This design choice preserves the unmodified state of the interface while enabling direct access to the selected customer via their `customerId`. Consequently, when declaring new `CustomerData` objects, one must utilize the implementations of the interfaces rather than the interfaces themselves.

The `CustomerDataAdapter` serves as the focal point of the project, seamlessly integrating the Adapter pattern into the application. The Adapter facilitates the invocation of methods from the `CustomerData_USB` interface using HTTPS data via the `convertToHTTPS` method. Despite the method name still being `getCustomer_USB`, the Adapter class functions identically to the base `CustomerData` classes. This approach enables the retrieval of `USB` data as `HTTPS`, despite the apparent mismatch in method naming.

While the implementation prioritizes adhering to the constraints of the provided interfaces, it may not be the most practical approach. Nonetheless, it effectively utilizes the `Adapter` design pattern. In more complex scenarios, further steps would likely be necessary for modernizing legacy data. However, the `Adapter` class provided simplifies data conversion without necessitating modifications to the structure of the data classes themselves. Moreover, extending the project to adapt different forms of legacy data to conform to HTTPS would require modifying the `convertToHTTPS` method. If not for the constraints imposed by the assignment's interfaces, data conversion could potentially be performed within the Constructor of CustomerDataAdapter, eliminating the need for widespread use of convertToHTTPS.
# Maven Commands

We'll use Apache Maven to compile and run this project. You'll need to install Apache Maven (https://maven.apache.org/) on your system.

Apache Maven is a build automation tool and a project management tool for Java-based projects. Maven provides a standardized way to build, package, and deploy Java applications.

Maven uses a Project Object Model (POM) file to manage the build process and its dependencies. The POM file contains information about the project, such as its dependencies, the build configuration, and the plugins used for building and packaging the project.

Maven provides a centralized repository for storing and accessing dependencies, which makes it easier to manage the dependencies of a project. It also provides a standardized way to build and deploy projects, which helps to ensure that builds are consistent and repeatable.

Maven also integrates with other development tools, such as IDEs and continuous integration systems, making it easier to use as part of a development workflow.

Maven provides a large number of plugins for various tasks, such as compiling code, running tests, generating reports, and creating JAR files. This makes it a versatile tool that can be used for many different types of Java projects.

## Compile
Type on the command line:

```bash
mvn clean compile
```

## JUnit Tests
JUnit is a popular testing framework for Java. JUnit tests are automated tests that are written to verify that the behavior of a piece of code is as expected.

In JUnit, tests are written as methods within a test class. Each test method tests a specific aspect of the code and is annotated with the @Test annotation. JUnit provides a range of assertions that can be used to verify the behavior of the code being tested.

JUnit tests are executed automatically and the results of the tests are reported. This allows developers to quickly and easily check if their code is working as expected, and make any necessary changes to fix any issues that are found.

The use of JUnit tests is an important part of Test-Driven Development (TDD), where tests are written before the code they are testing is written. This helps to ensure that the code is written in a way that is easily testable and that all required functionality is covered by tests.

JUnit tests can be run as part of a continuous integration pipeline, where tests are automatically run every time changes are made to the code. This helps to catch any issues as soon as they are introduced, reducing the need for manual testing and making it easier to ensure that the code is always in a releasable state.

To run, use the following command:
```bash
mvn clean test
```

## Spotbugs

SpotBugs is a static code analysis tool for Java that detects potential bugs in your code. It is an open-source tool that can be used as a standalone application or integrated into development tools such as Eclipse, IntelliJ, and Gradle.

SpotBugs performs an analysis of the bytecode generated from your Java source code and reports on any potential problems or issues that it finds. This includes things like null pointer exceptions, resource leaks, misused collections, and other common bugs.

The tool uses data flow analysis to examine the behavior of the code and detect issues that might not be immediately obvious from just reading the source code. SpotBugs is able to identify a wide range of issues and can be customized to meet the needs of your specific project.

Using SpotBugs can help to improve the quality and reliability of your code by catching potential bugs early in the development process. This can save time and effort in the long run by reducing the need for debugging and fixing issues later in the development cycle. SpotBugs can also help to ensure that your code is secure by identifying potential security vulnerabilities.

Use the following command:

```bash
mvn spotbugs:gui 
```

For more info see
https://spotbugs.readthedocs.io/en/latest/maven.html

SpotBugs https://spotbugs.github.io/ is the spiritual successor of FindBugs.

## Checkstyle

Checkstyle is a development tool for checking Java source code against a set of coding standards. It is an open-source tool that can be integrated into various integrated development environments (IDEs), such as Eclipse and IntelliJ, as well as build tools like Maven and Gradle.

Checkstyle performs static code analysis, which means it examines the source code without executing it, and reports on any issues or violations of the coding standards defined in its configuration. This includes issues like code style, code indentation, naming conventions, code structure, and many others.

By using Checkstyle, developers can ensure that their code adheres to a consistent style and follows best practices, making it easier for other developers to read and maintain. It can also help to identify potential issues before the code is actually run, reducing the risk of runtime errors or unexpected behavior.

Checkstyle is highly configurable and can be customized to fit the needs of your team or organization. It supports a wide range of coding standards and can be integrated with other tools, such as code coverage and automated testing tools, to create a comprehensive and automated software development process.

The following command will generate a report in HTML format that you can open in a web browser.

```bash
mvn checkstyle:checkstyle
```

The HTML page will be found at the following location:
`target/site/checkstyle.html`




