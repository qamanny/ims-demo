Coverage: 48%
# Inventory Management System

Create, Read, Update and Delete. CRUD is the basis at which any SQL database works, and this project aimed to provide such a system for Crud'ing inventory for anyone with such a need. This database has three main actions CUSTOMER, ITEM and ORDER and within these actions you have the ability to CREATE, READ, UPDATE and DELETE. 

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

In order to use this application you'll need to use a Java Runtime Environment. If you're using this application in early 2021, I recommend to stick to jdk14 version as during the building of this application there were some problems with running testing when using jdk15+. You will also need Maven in order to build the application and SQL [I recommend also getting the Workbench for easier viewing] for your CRUD functionality to have a table to build upon.

### Installing

Step 1: Fork this repository.
Step 2: Connect your local session to your forked repository.
Step 3: Git bash or command line into the directory on your pc.
Step 4: Enter "mvn clean package"
Step 5: The jar file should now be in your target folder, cd into there.
Step 6: Lastly, Enter "java -jar [name of file].jar 

## Running the tests

JUnit is the chosen method for running tests with this application, although do be aware slight knowledge of Mockito will prove useful but the tests are pretty intuitive.

### Unit Tests 

Unit Tests much as named tests individual units of the code in an application, for example as we use CRUD as the basis of this application all the three actions ORDER, ITEM and CUSTOMER have a CREATE, READ, UPDATE and DELETE method. A Unit test will test for example not all of the CREATES in one go, but you will have a test for the ORDER CREATE as well as the ITEM CREATE and as well as the CUSTOMER CREATE. This is great it provides us with the ability to know exactly which location an error from a method is coming from which helps us more easily fix bugs and errors. The second reason for UNIT TESTING is in how this application was made, (for the most part) this application was made with the intention of TestDrivenDevelopment[TDD], and having the ability to test a particular section of created code as soon as it is made to see if it functions as intended is the way to go when it comes to TDD.

## Deployment

Deployment was focused with the idea of CI, Continous Integration, this meant commiting to (pardon the pun) multiple commits a day on Github as well as regular testing with detailed commit messages. 

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management
* [Eclipse] (https://www.eclipse.org/) - IDE Used
* [GCP MySql] (https://cloud.google.com/) - Sql Database Host
* [JUnit] (https://junit.org) - Testing
* [Mockito] (https://site.mockito.org/) - Alternate Testing
* [Jira] (https://emmanuelqa.atlassian.net/secure/RapidBoard.jspa?rapidView=3&selectedIssue=IMS-11)

## Versioning

I used [Github](https://github.com/) for versioning.

## Authors

Emmanuel Lomax

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

Well, when you start a dumpster fire it's unfair to start thanking the manufacturer of the lighter on your personal blog. When I come back and improve this I'll give credit where it's due. 
