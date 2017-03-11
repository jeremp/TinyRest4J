# TinyRest4J

A minimalist REST client for Java
 
## Simple, fluent and effective

```java 
String url = "http://petstore.swagger.io/v2/pet/findByStatus";
TinyRest tiny = new TinyRest();		
RestResponse result = tiny.get(url).withParam("status", "available").doRequest();
```

## Basic Authentication support

```java
tiny.get(url)
   .basicAuth("login".getBytes(), "password".getBytes())
.doRequest();
```

