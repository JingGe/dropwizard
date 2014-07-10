Dropwizard Application View Resource
======================

Dropwizard application shows how to render and return a html page based on freemarker.

Important classes:

- BookView.java
- BookViewResource.java
- App.java: take a look at the initialize(..) and run(...) methods
- book.ftl: the path equals the package name of BookView class

Bootstrap is used. This application has been kept as simple as possible.
You can put other JS library, e.g. AngularJS in the freemarker template file to turn the html page into a single page application.

---------------------
Try yourself
---------------------

1. run the application
2. point your browser to http://localhost:8080/views/book/1

