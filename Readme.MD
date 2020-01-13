= Cucumber + Junit4 + Selenium with Spring Pet Clinic

This  project requires a tweaked version of the Spring Boot Pet Clinic example. You can run it with the docker-compose.yml

= Required Tools
- Docker for Mac
- Java 12  
-- Either through Oracle or use https://sdkman.io/
- VSCode
-- Extension "GitLens — Git supercharged": https://marketplace.visualstudio.com/items?itemName=eamodio.gitlens
-- Extension Cucumber:  https://marketplace.visualstudio.com/items?itemName=alexkrechik.cucumberautocomplete

- Open the VSCode workspace committed to git, this sets the correct pathts for the cucumber extension


= Notes

CUCUMBER_OPTIONS='--tags "@basic"' gradle test
