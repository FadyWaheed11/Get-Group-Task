# Get-Group-Task
## Table of contents
* [Technologies](#technologies)
* [Concepts](#concepts)
* [Project Structure](#project-structure)
* [Test Scenario](#test-scenario)
## Technologies
Project is created with:
* Java version: JDK-18
* Selenium-java version: 4.10.0
* Selenium-support version: 4.10.0
* Testng version: 7.8.0
* Json-simple version: 1.1.1
* Jakson-databind version: 2.15.2
## Concepts
* [Page-Object-Model Pattern **POM**](#pom)
* [Singleton Design Pattern](#singleton-design-pattern)
* [Method Chaining Concept](#method-chaining-concept)
* [Static Factory Method](#static-factory-method)
* [Data Driven Techniques](#data-driven-techniques)
* [Read & Write from **JSON** File](#read-write-from-json-file)
## Project Structure
* **Consists of two part**
  - Main part which contains our framework
  - Test part which contains our test scenarios
  - ![Screenshot 2023-06-25 180727](https://github.com/FadyWaheed11/Get-Group-Task/assets/41761100/b7f7273c-ba23-4071-ad05-d48516fb25f2.png)
## POM
* Page Object Model (POM) is a design pattern, popularly used in test automation that creates Object Repository for web UI elements.
* The advantage of the model is that it reduces code duplication and improves test maintenance.
* We separate the framework (coding part) from the testing part
* We represent each webpage in our website by Class in the framework like this page
 - ![Screenshot 2023-06-25 181302](https://github.com/FadyWaheed11/Get-Group-Task/assets/41761100/977b41a2-3689-4a95-a969-29890d7ac685) ![Screenshot 2023-06-25](https://github.com/FadyWaheed11/Get-Group-Task/assets/41761100/6a1a7ed4-78f9-4c4c-9179-84135913f9a1)
* You can read more about POM structure on:
  - [Guru99](https://www.guru99.com/page-object-model-pom-page-factory-in-selenium-ultimate-guide.html)
  - [GeeksForGeeks](https://www.geeksforgeeks.org/page-object-model-pom/)
  - [Official Selenium](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
  - [BrowserStack](https://www.browserstack.com/guide/page-object-model-in-selenium)
## Singleton Design Pattern
* Singleton design pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the jvm
* So in our case we want to ensure that we have only one instance of WebDriver
 - ![carbon](https://user-images.githubusercontent.com/41761100/208140616-36f392ad-121e-41fb-9efa-ab9cff2ac6be.svg)
* You can read more about singleton design pattern on:
  - [TutorialsPoint](https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm)
  - [GeeksForGeeks](https://www.geeksforgeeks.org/java-singleton-design-pattern-practices-examples/)
  - [Medium](https://medium.com/geekculture/introduction-to-design-patterns-understanding-singleton-design-pattern-5a4d49960444#:~:text=The%20Singleton%20Design%20Pattern%20is,%3B%20in%20case%20of%20Java)
## Method Chaining Concept
* Method Chaining is the practice of calling different methods in a single line instead of calling other methods with the same object reference separately. Under this procedure, we have to write the object reference once and then call the methods by separating them with a (dot.).
* Syntax -> obj.method1().method2().method3();
* So in our case we made those methods return this which refers to the current object
  - ![carbon](https://github.com/FadyWaheed11/Get-Group-Task/assets/41761100/ef012880-88af-4aa2-bc7c-6033ce69b518)
* So in our Test part instead of calling methods like this:
  - ![carbon](https://github.com/FadyWaheed11/Get-Group-Task/assets/41761100/0469e135-864a-4b89-becc-ddd2feefeb45)
* We do this:
  - ![carbon](https://github.com/FadyWaheed11/Get-Group-Task/assets/41761100/0cc04aac-9a81-496f-a1f7-b57dab993b1d)
## Static Factory Method
* The most widely used technique to allow other parts of our Java programs, to get objects of a certain type, is to create public constructors.
* There is also another technique which is that provides various advantages and it would be highly recommendable for every programmer to know. Classes can provide static factory methods. This methods are another way of returning instances.
* #### Advantages of static factory method
  - The static factory method can have a meaningful name 
  - Static factory methods can return the same type that implements the method, a subtype, and also primitives.
  - Inside static factory method other than initialization if we want to perform any activity for every object creation like increasing count value for every object creation we can do this in the static factory method.
  - Encapsulate the construction logic.
* So How we will benefit from this in our framework ?
  - If we are testing the UI of website , we might have 50 pages or more 
  - And we had 50 test classes , we would have this new home page called 50 times:
    ![carbon](https://github.com/FadyWaheed11/Get-Group-Task/assets/41761100/3a4b70f1-9e7d-46bf-bfc3-eb4529f90deb)
  - Imagine if we decide to change the constructor of this class , we will have to change it in 50 different places 
  - But with this, it's only one place:
  - ![carbon](https://github.com/FadyWaheed11/Get-Group-Task/assets/41761100/8d1ffee9-fea7-411b-a328-e3efdbd58202)
* You can read more about Static Factory Method on:
  - [Medium](https://medium.com/javarevisited/static-factory-methods-an-alternative-to-public-constructors-73cbe8b9fda)
  - [GeeksForGeeks](https://www.geeksforgeeks.org/difference-between-constructor-and-static-factory-method-in-java/#:~:text=The%20static%20factory%20methods%20are,cached%20and%20reused%20if%20required)
  - [Baeldung](https://www.baeldung.com/java-constructors-vs-static-factory-methods)
  - [StackOverFlow](https://stackoverflow.com/questions/929021/what-are-static-factory-methods)
## Data Driven Techniques
* Data Driven Testing is a software testing method in which test data is stored in table or spreadsheet format.
* Data Driven Framework is an automation testing framework in which input values are read from data files and stored into variables in test scripts.
* Data Driven Testing is important because testers frequently have multiple data sets for a single test and creating individual tests for each data set can be time-consuming.
* In our case we will use JSON files for data driven.
#### Why JSON over Excel?
 - Most of data driven testing framework we have used Excel – Apache POI But there is other medium as well to store data into files such as csv, xml, json, text file, etc.
 - Excel is good to manage data and to use but it comes with its own limitations. Like MS Office needs to be installed on the system where the tests are being executed. 
 - As the test servers has never bound to have such dependencies.
 - If test is run on Mac, then again there is a different problem.
## Read Write From JSON File
* This function for reading JSON file:
  ![carbon (7)](https://user-images.githubusercontent.com/41761100/208143652-6b5089ba-9f8b-42d3-a5d9-37711fdcdcb4.svg)
* This function for updating specific value in JSON file:
  ![carbon (8)](https://user-images.githubusercontent.com/41761100/208144073-5f308434-c6a9-41f6-9ca7-f345b10aee4e.svg)
## Test Scenario
* Our test scenario is to go to [CodenBox AutomationLab](https://codenboxautomationlab.com/registration-form/)
* Fill register form
  - Enter First Name,Last Name,Email and Phone Number
  - Use different email for each run by using the machine date as a part of the email
  - Select random course for each run
  - Select random month for each run
  - Click on Linkedin readio button
  - Click on Register button
* Go to login page   
* Validate that the system open:
  - When try to login with registered email and password
