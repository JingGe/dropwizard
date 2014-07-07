Simple Dropwizard Application
======================

This simple dropwizard application presents a sample Restful app with the minimum classes and resources:

- one yaml configuration file.
- one BookConfiguration class reflects the yaml file.
- one bean class: Book
- one Jersey resource class: BookResource
- one main class: App
- one unit test: AppTest

**validation example**

While creating a new book, the isdn property of the book will be validated.
This validation example is limited to jus one property and one method in purpose.It should be very easy to understand how it works by reading the code.

----------------------
About the Test
-----------------------
**Attention!** The official document contains a bug:

    verify(jersey).register(any(BookResource.class));

the any(Class) method doesn't really work in this case. Is has to be replaced with the method isA():

    verify(jersey).register(isA(BookResource.class));

---------------------
Try yourself
---------------------

**Run the application in terminal:**

1. cd to the root directory of the project.
2. mvn install
3. java -jar target/dropwizard-simpleapp-1.0-SNAPSHOT.jar server config.yml

**Run the application in IDE**

1. setup a run configuration in your IDE.
2. make sure the main class points to com.jingge.demo.msa.book.App.
3. make sure that program arguments contains "server config.yml"

**Call the Book Restful API**

The simple way is to point the browser to localhost:8080/book/1. You will see a json string.

You can also use cURL if you like to stay within the terminal.

I personally recommend using Postman - REST Client https://chrome.google.com/webstore/detail/postman-rest-client/fdmmgilgnpjigdojojpjoooidkmcomcm?hl=en

**isdn Validation**
try creating a new book with empty isdn.
