**City Bike Challenge**
===
# **Problem Statement**
As a biker I would like to know the exact location of city bikes around the world in a given application.
Endpoint: http://api.citybik.es/v2/networks
Auth: No
HTTPS: No
 - Understands how the API works.
 - Create some BDD scenarios and automate them using Java to test the API
 - Test this particular scenario: “As a user I want to verify that the city Frankfurt is in Germany and return their corresponded latitude and longitude”
 - Criteria:
   - The code should be accessible/submitted as a github (open source repo) project link.
   - The code should be runnable from IDE or console

# **Technologies used**

- Java 11
- Cucumber
- Rest Assured

# **Build Requirements**
Before being able to build he code you need:
- Maven 3.3+
- Java 11

# **How to run the automation suite locally?**
````
git clone https://github.com/nehaoza/city-bikes-automation.git

cd city-bikes-automation
mvn clean test
````

# **Continuous Integration with GitHub Actions**

## **When it triggers?**
1. When commited to main branch
https://github.com/nehaoza/city-bikes-automation/commit/06475b8d802ed2091ca48b3e976bb6cbbb3a9fa0

2. When Merge request is raised against main branch
https://github.com/nehaoza/city-bikes-automation/pull/1

GitHub Actions flow - 
https://github.com/nehaoza/city-bikes-automation/runs/1853371141?check_suite_focus=true

Cucumber scenario overview in GitHUb Actions-
https://github.com/nehaoza/city-bikes-automation/runs/1853371141?check_suite_focus=true

## **What it does?**
1. Compiles and builds the code
2. Runs automation suitein GitHub Actions container
3. Does Sonar scan and pushes hte result to sonar dashboard.
4. Extract the sonar summery and attaches it to Merge Request in case of Merge Request
5. Attaches the summury of cucumber scenarios as a part of automation suite


# **Achieves**
1. Automated the City Bikes API with Rest Assured and Cucumber
2. Added CI pipeline with GitHUb Actions
3. Project is built with zero bugs and Vulnerabilities in Sonar. 
Sonar Dashboard : https://sonarcloud.io/dashboard?id=nehaoza_city-bikes-automation
