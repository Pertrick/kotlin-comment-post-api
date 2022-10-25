 # Software Architecture Pattterns

An architectural pattern is a general, reusable solution to a commonly occurring problem in software architecture within a given context.


    Layered Architecture
Layered architecture style is one of te most common architectural styles. The idea behind layered 
architecture is that modules or components with similar functionalities are organized into horizontal layers
each performing a specific role within the application.

- Although the layered architecture pattern does not specify the number and types of layers that must exist
in the pattern, most layered architectures consist of four standard layers:

1. Presentation Layer : This layer would be responsible for handing all user interface and browser communication logic.
   It consists of Views. i.e., the front-end part of the application. It handles the HTTP requests and performs authentication. 
It is responsible for converting the JSON field’s parameter to Java Objects and vice-versa.


2. Business Layer : This Layer would be responsible for executing specific business rules
associated with the request.It consists of services classes. It is responsible for validation and authorization.


3. Persistence Layer : The persistence layer contains all the database storage logic. 
It is responsible for converting business objects to the database row and vice-versa.


5. Database : The database layer contains all the databases such as MySql, MongoDB, etc. 
This layer can contain multiple databases. It is responsible for performing the CRUD operations.


Each Layer of the layer architecture pattern has a specific role and responsibility within the application.

note: Each of the layers in the architecture is marked as being closed.
this is a very important concept in the architecture pattern.
A closed layer means that as a request moves from layer to layer, it must
got through the layer right below it to get to the next layer below that one.

* for instance - Presentation layer must first go through the business
layer and then to the persistence layer before finally hitting the database layer


    