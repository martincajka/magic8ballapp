### Magic8Ball app - coding exercise

## Description
Web app that allows users to ask a question and get a random answer, based on the Magic 8 Ball toy.

Exercise:

Implement API where user can ask the ball a question and receive random predictions
Implement a paginated CRUD API for modifying Magic 8 Ball data
start with initial answers from https://en.wikipedia.org/wiki/Magic_8_Ball
* write unit tests [ ] - only one test added so far
* store source code on GitHub [x]
* Bonus: make data persistent (FS or a DB of your choice) [x] - H2 in-memory DB used. Initial data is loaded from on startup using data.sql file

# API endpoints specs
All endpoints are defined in [magic_ball_api_excersize.yaml](magic_ball_api_excersize.yaml)

## How to run
App can be run as a spring boot app using command: `mvn spring-boot:run`

## TODO
- [ ] Add more tests
- [ ] add more robust error handling
- [ ] add more logging
- [ ] add more documentation
- [ ] add more validation