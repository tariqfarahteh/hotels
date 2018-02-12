After I examined the provided API, I started testing the API using a web browser, so I examined the required query parameters for each web service call, and from which I was able to grasp the ideas I need to implement
in the application, I thought about extracting the schema of the model into Java objects so I used an online library to assist me with this task, afterwards I started with the application architecture which contained a plain html/JavaScript frontend part communicating with the backend using ajax webservice calls.
For the backend I used Java technology which I have around three years of experience in development and maintenance.

I used in this solution Jersey API to create a client webservice to access the Restful API.

I generate the business classes from sample JSON using online converter "http://pojo.sodhanalibrary.com/"

Throughout the exercise I explored new CI and hosting options (Heroku and Travis CI).
I used maven to as a build tool.

I was planning to add a feature to enable "Debug Mode", in which verbose logging will be enabled, so that extensive information is provided to assist in investigating problems and providing load statistics.
