# Hotels Project!

This is a solution to get hotels offers based on filters.

We used in this solution a RESTful API to retrieve hotel offers.

# App URL 
	`https://safe-bayou-61729.herokuapp.com/`

# Prerequisites

 1. Oracle Java JDK 1.8
 2. Maven 3.5
 
 
# How to start the Hotels application

 1. Clone the repository `git clone https://github.com/tariqfarahteh/hotels`
 2. Run `mvn clean install tomcat7:run` to build and start the application
 3. In a web browser navigate to the URL <http://localhost:9090>


## Front End:

A single web page with two parts:
An area to view the hotel offers
A search area to filter the hotels offers based on the search criteria.

## Configuration
There are two configuration files

 1.Config.properties
	This file contains:
		A-Base URL for the webservice.
		B-Required parameters with the values to make the values for the required parameters configurable.
		
 2.Log4j.properties
	This file contains the configuration for the log4j logging library, ex: log file path, File rolling, .... 


## Technologies
The Technologies used in this project are:

 1. Maven to resolve the dependencies and to build the project
 2. Jersey: rest webservice API provider and client
 3. Gson library to convert Objects from and to Json
 4. Log4j.