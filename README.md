# Enterprise-Java-Development-4.04

### Did you use the same type of route to update patient information and to update an employee department?
### Why did you choose the strategy that you chose?
----> No, since the type of information to update was different in both cases.
      For the patient information I used the PUT verb, since it was all patient data. And for the employee update I used the PATCH verb because it was unique and concrete data to change.

### What are the pros and cons of the strategies you chose for creating these routes?
----> I think there are no pros and cons, everything will depend on the need of the project and what and how we want to update the information of an object.
      Obviously the put method is simpler, but you run the risk of altering data that we are not interested in modifying.

### What are the tradeoffs between PUT and PATCH?
----> Advantages: Ability to define what data we are interested in modifying, and speed management when changing the same data in different objects.
