# RECIPE API

<h3>Note: </h3>
<ul>
    <li>For this project we are using Spring Boot 3.0.0 </li>
    <li>Spring Boot 3.0.0 requires Java 17</li>
    <li>Spring Boot 3.0.0 with Hibernate now depends on jakarta.persistence instead of javax.persistence </li>
    <li>We are using Spring Date for Persistence</li>
    <li>Spring Boot 3.0.0 is using Spring OpenApi Documentation</li>
    <li>For DTO creation we are using MapStruct</li>
    <li>Exception Handling is there with Hibernate Validator</li>
    <li>For this project we are using Maven 3.8.7</li>
    <li>For this project we are using MySQL 8.0</li>
    <li>For this project we are using H2 Embedded Database for Testing</li>
</ul>

<h3>How to run this project: </h3>
<ul>
    <li>Clone this project</li>
    <li>Open this project in your IDE</li>
    <li>Add environment property DB_USER & DB_PASSWORD for MySQL Database</li>
    <li>Build this project: mvn clean install</li>
    <li>Run this project: mvn spring-boot:run </li>
    <li>Here is the link <a href="http://localhost:8080/api/recipes">RECIPE API</a></li>
    <li>For Production we need to change ddl-auto to  & generate-ddl to false</li>
</ul>

<h3>How to run test: </h3>
<ul>
    <li>Run this command: mvn clean test</li>
</ul>

<h3>Documentation: </h3>
<ul>
    <li>For Documentation we are Spring OpenApi Documentation</li>
    <li>Here is the link <a href="http://localhost:8080/api/swagger-ui/index.html">OPEN API</a></li>
</ul>

<h3>Database: </h3>
<ul>
    <li>For Database we are using MySQL Database</li>
    <li>For Testing we are using H2 Database</li>
</ul>

