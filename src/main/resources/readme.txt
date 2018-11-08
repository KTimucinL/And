I used Spring boot and java 8.
Project is downloaded from start.spring.io.
I will use rest-assured for testing and springfox-swagger for creating contract. These dependecies will be retrieved from mvnrepository.
I will use tdd red green mechanism. I will code test first.

Data will be kept as 2 in memory collections. 

Task

3 APIS requested

all phone numbers--> GET /phones

all phone numbers for a single customer --> GET /customer/{id}/phones

activate a phone number	--> POST phone/activate  