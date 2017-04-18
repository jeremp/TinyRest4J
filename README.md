# TinyRest4J

A minimalist REST client for Java
 
## Simple, fluent and effective

```java 
String url = "http://petstore.swagger.io/v2/pet/findByStatus";
TinyRest tiny = new TinyRest();
RestResponse result = tiny.get(url).withParam("status", "available").doRequest();
```

## GET, DELETE, POST, PUT ... with request bodies

```java 
TinyRest tiny = new TinyRest();
String someJson = "{ \"name\":\"Idefix\", \"category\":\"dog\" }";
RestResponse result = tiny.post("http://petstore.swagger.io/v2/pet").withBody(someJson).doRequest();
```

## Basic Authentication support

```java
tiny.get(url)
   .basicAuth("login".getBytes(), "password".getBytes())
.doRequest();
```

## Tired of always sending the same parameters ?

There are convenient methods on the TinyRest class for that

```java
TinyRest tiny = new TinyRest()
    // ask this tiny instance to always send that Content-Type header
    .alwaysApplyHeader("Content-Type", "application/json")
    // ask this tiny instance to always use these credentials
    .alwaysApplyBasicAuth("login".getBytes(), "password".getBytes());

RestResponse aResult = tiny.get(aUrl).doRequest();
RestResponse anotherResult = tiny.delete(anotherUrl).doRequest();
```

## HTTP Proxy support

Proxy support is provided by Java's networking properties (host, port, non proxy hosts...)  learn more at https://docs.oracle.com/javase/7/docs/api/java/net/doc-files/net-properties.html

## GZIP Support

The `tiny.withGZip()` is a convenient method to ask the remote server for gzip compression. It adds the accept-encoding header.
 
```java
// this 
tiny.withGZip();  
// is shorter than this  
tiny.alwaysApplyHeader("accept-encoding", "gzip");
```