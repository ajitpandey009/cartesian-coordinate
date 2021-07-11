# cartesian-coordinate
Steps to Run the project

Step 0: Get the project to local and get inside the folder

Step 1: Use 'mvn clean install' to run test cases and build the jar

Step 2: Run  'Spring Boot App' or  run "CartesianCoordinateApplication" java application

Step 3: Open browser and open the swagger link 'http://localhost:8080/swagger-ui/'

![Capture](https://user-images.githubusercontent.com/17667479/125191510-786bca80-e260-11eb-8ff7-97ae83e5cb60.PNG)

API's 
1:Definition of a line by means of two points<br>
API: GET /v1/definition-of-line-by-two-points/{x1}/{y1}/{x2}/{y2}

![Capture1](https://user-images.githubusercontent.com/17667479/125191644-1cee0c80-e261-11eb-959e-4edd8197f7ed.PNG)


2:Definition of a line by means of gradient and y-intercept<br>
API: GET /v1/definition-of-line-by-gradient-intercept/{m}/{c}
![Capture2](https://user-images.githubusercontent.com/17667479/125191726-8d952900-e261-11eb-9090-fb352c7d93ef.PNG)


3:Condition of parallelism of two lines<br>
API GET /lines-are-parallel/{x1}/{y1}/{x2}/{y2}/{x3}/{y3}/{x4}/{y4}
![Capture3](https://user-images.githubusercontent.com/17667479/125191781-c8975c80-e261-11eb-9f7c-6cfd78fdb6f7.PNG)


4:Condition of perpendicularity of two lines<br>
API: GET /lines-are-perpendicular/{x1}/{y1}/{x2}/{y2}/{x3}/{y3}/{x4}/{y4}
![Capture4](https://user-images.githubusercontent.com/17667479/125191865-39d70f80-e262-11eb-93c4-371bb7eeb879.PNG)

5:Condition of incidence of two lines and definition of the incidence point<br>
API: GET /intersection-point-of-two-lines/{x1}/{y1}/{x2}/{y2}/{x3}/{y3}/{x4}/{y4}
![Capture5](https://user-images.githubusercontent.com/17667479/125191925-95090200-e262-11eb-94f9-445af58d60d8.PNG)
