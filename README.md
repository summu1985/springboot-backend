**Spring Boot Data Access with Spring Data JPA and MySQL**

This repo is created for the purposes of demonstrating a simple Java based backend application that can accept simple data and save it in DB. 
It also allows basic CRUD operations using the data.

This program can run on local development environment as well as Openshift Container platform.

The pre-requisites for this program to run is a MYSQL DB.

In this README, I will enumerate the steps to deploy this application on Openshift.

The configuration for MySQL DB can be fed to the application via a secret or a config map. Both the yamls are provided to apply, just modify as
per your convenience.

You can use the S2I process to build and deploy this application on Openshift cluster easily (preferred) or you can build the container image
manually and then deploy it on Openshift using a deployment CRD or using the "Add" feature of Openshift Web Console and then selecting 
container image.

**Deployment**

The steps of deploying this application on Openshift is:
(1) Deploy a MySQL DB instance on Openshift.
(2) Update the configmap / secret with the appropriate values in the keys - MYSQL_HOST, MYSQL_USER, MYSQL_PASSWORD
(3) Deploy the application via S2I or as a container image
(4) Modify the deployment resource to add all values from the configmap / secret as environment variables to the application

**Testing**

Once the application is deployed, grab the route and then add some user using the below command
```
curl --location --request POST 'https://springboot-backend-git-summukhe-dev.apps.rm1.0a51.p1.openshiftapps.com/api/user?name=sumit&email=sumit@example.com'
Saved user id : 1
```

Now view the added user by the following command
```
curl --location --request GET 'https://springboot-backend-git-summukhe-dev.apps.rm1.0a51.p1.openshiftapps.com/api/users'
[{"id":1,"name":"sumit","email":"sumit@example.com"}]
```

Replace the URL of the service as per your settings.

**Further exploration**

This application also supports modifying a user, fetching a user by id and deleting a user by Id. Feel free to explore these operations.
Feel free to fork and adapt.

Happy Coding!!

-Sumit

Dummy add for testing push webhook
