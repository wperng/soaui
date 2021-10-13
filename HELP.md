# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.4/maven-plugin/reference/html/#build-image)
* [YAML to JAVA](https://jsonformatter.org/yaml-to-java)
* [Jackson to YAML](https://www.baeldung.com/jackson-yaml)
* [LDAP Reference](https://medium.com/codeops/spring-boot-security-ldap-example-1ce1bdfc5816)
* [spring boot jsp example](https://www.baeldung.com/spring-boot-jsp)
* [poc site](https://kongblue-manager.caas-poc-green.msbx.spratingsvpc.com/login)
* [JGIT](https://www.vogella.com/tutorials/JGit/article.html)
* [springboot](https://howtodoinjava.com/spring-boot-tutorials/)
* [springboot](https://mkyong.com/spring-boot/spring-boot-hello-world-example-thymeleaf/)
* [Role Based Authen](https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial)
* [Role in database](https://stackoverflow.com/questions/16697925/spring-security-with-ldap-and-database-roles)
* [Thymeleaf handform](https://www.codejava.net/frameworks/spring-boot/spring-boot-thymeleaf-form-handling-tutorial)
* [Thymeleaf spring security, gui](https://www.javadevjournal.com/spring-security/spring-security-with-thymeleaf/) 
* [model attribute]
* [Spring Boot How to load initial data on startup] (https://www.onlinetutorialspoint.com/spring-boot/spring-boot-how-to-load-initial-data-on-startup.html)
* [webjar ref](https://frontbackend.com/thymeleaf/spring-boot-bootstrap-thymeleaf-radio-button)
* [error] (https://www.baeldung.com/spring-thymeleaf-error-messages)
* [validation] (https://www.baeldung.com/spring-valid-vs-validated)


### Uses Cases
1. Generate YAML by form
    -store metadata to db
    -create template
    -create data file
    -store blog to db
    -check in template into azure
    -(opt)check data file into Azure
2. Update by db record
    -update metadata to db
    -read db info
    -copy data to old table
3. Get detail by id 
4. overwrite falue

### GUI
1. Introduction to Kong, useful link, Kong Video
2. I want to update tracker, I want to onboard API, view current status

### Datebase

#### Table 1
1. ID (`<team>-<service name>api` or `<team>-<service name>service`)(rap-datadirectapi)
2. createddate
3. createdby
4. temlpate
5. template-data
6. template-consumer ???
#### Table 2
1. API consumer

/*
        <div th:if="${#fields.hasAnyErrors()}">
            <h4>All errors:</h4>
            <ul>
                <li th:each="err : ${#fields.allErrors()}" th:text="${err}" />
            </ul>
        </div>
        */



