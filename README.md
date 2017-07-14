uPortal Tester Webapp
===============
This app can test if uPortal is responding normally. We needed this for our F5 BIG-IP
load balancer since there were too many redirects and it was dropping its health check.

[uPortal Official Site](http://www.apereo.org/uportal) is the leading open source
enterprise portal framework built by and for the higher education community.  
uPortal continues to evolve through contributions from its global community and is
supported by resources, grants, donations, and memberships fees from academic
institutions, commercial affiliates, and non-profit foundations.

Getting Started
---------------

Required:
- Servlet container (i.e. Tomcat 7)
- JDK 6+ (i.e. OpenJDK, Oracle JDK)
- Maven 3+
- uPortal 4.1 (can be configured to work with other versions)

Compiling and Deploying:
- Clone this project
- `mvn clean package`
- Deploy the war file in target to your servlet container

That's it!

Customization
-------------
You can change what CSS ID the program is looking for 
in file: src/main/java/edu/oakland/uPortalTesterWebapp/web/Application.java

Change portalPageBody in the following block to whatever ID you want to look for 
and recompile and redeploy the app.
> return (document.getElementById("portalPageBody").html() ).length() > 0;

Getting Involved
----------------
For any questions, comments, or feedback on use or development of this product,
please sign up on the [uPortal mailing
lists](http://www.apereo.org/uportal/mailing-lists).



