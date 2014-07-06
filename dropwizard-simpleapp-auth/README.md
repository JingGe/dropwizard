Simple Dropwizard Application with authentication
======================

This simple dropwizard application presents the basic authentication works.

- BookResource is protected.
- The authentication of getBook() method is optional. Different content will be returned for authenticated or unauthenticated visitor.

---------------------
Try yourself
---------------------

Again, using Postman - REST Client is recommended: https://chrome.google.com/webstore/detail/postman-rest-client/fdmmgilgnpjigdojojpjoooidkmcomcm?hl=en .
In the "Basic Auth" tab you can enter username and password. Enter "jing" and "jing" and press "Refresh headers" button you will then be authenticated.
You can enter some other text and refresh the headers and see what happens when you consume the BookResource API.
