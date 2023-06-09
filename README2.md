
## OAuth2 Security for ProductResource JAX_RS REST API

This document provides an overview of how to implement OAuth2 security for a REST API.

## What is OAuth2?

**OAuth2** is an authorization framework that allows third-party applications to access user data from a server. It builds upon the original OAuth protocol, adding additional security measures and simplifying the authorization process.

**OAuth2** works by allowing a user to grant access to their data on one website (the "OAuth2 provider") to another website (the "OAuth2 consumer"). This is achieved through the exchange of tokens, including access tokens and refresh tokens.

## Implementing OAuth2 security for a REST API involves several steps:

1. **Choose an OAuth2 provider:** Before implementing OAuth2 security, you must choose an OAuth2 provider. Some popular OAuth2 providers include Google, Facebook, and Microsoft.
2. **Register your application:** Once you have chosen an OAuth2 provider, you must register your application with the provider. This involves providing information about your application, such as its name and callback URL.
3. **Obtain client credentials:** After registering your application, you will be provided with client credentials, including a client ID and client secret. These credentials are used to authenticate your application with the OAuth2 provider.
4. **Authenticate users:** Once you have obtained client credentials, you can authenticate users by directing them to the OAuth2 provider's authentication endpoint. This endpoint will prompt the user to grant access to their data.
5. **Obtain access tokens:** After the user has granted access, the OAuth2 provider will provide your application with an access token. This token is used to make requests to the OAuth2 provider on behalf of the user.
7. **Use access tokens:** Once you have obtained an access token, you can use it to make requests to the OAuth2 provider on behalf of the user. These requests can include retrieving user data, posting content, or performing other actions.
8. **Implement refresh tokens:** Access tokens have a limited lifespan, after which they must be refreshed. Refresh tokens are used to obtain a new access token without requiring the user to re-authenticate.
9. **Secure endpoints:** Finally, it is important to secure your REST API endpoints to ensure that only authorized users can access them. This can be achieved by requiring the presence of an access token in requests to protected endpoints.

## How to Implement OAuth2 Security for ProductResource REST API


## 1. Add OAuth2 for Spring Security (spring-security-oauth2) as a dependency in pom.xml file.
```
<dependency>
 <groupId>org.springframework.security.oauth</groupId>
 <artifactId>spring-security-oauth2</artifactId>
 <version>2.3.8.RELEASE</version>
</dependency>
```
## 2. Setup OAuth2 server
OAuth2 Provider or Authorization server - this would be a diffrent server from the application server where our ProductResource API is exposed. but in our case, ProductResource API server act both as a **resource server** and as **OAUTH provider** , We used @EnableAuthorizationServer annotation to enable Authorization server.

```
@EnableAuthorizationServer
@SpringBootApplication
public class SpringBootJerseyApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringBootJerseyApplication().configure(new SpringApplicationBuilder(SpringBootJerseyApplication.class)).run(args);
    }
}
```

## 3. Setup Resource server
A Resource server is an application that protects resource via OAuth token. We can enable our application to act as resource server using **@EnableResourceServer**
```
@EnableResourceServer
@SpringBootApplication
public class SpringBootJerseyApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        new SpringBootJerseyApplication().configure(new SpringApplicationBuilder(SpringBootJerseyApplication.class)).run(args);
    }
}
```

## Configure the access details in application.properties file of ProductResource API as below
```
#Authentication detail of product resource owner / service producer
security.user.name=javaFeature
security.user.password=javaFeature

# Authentication detail of service consumer
security.oauth2.client.clientId=javaFeature
security.oauth2.client.clientSecret=test@#23

# Enables a client application to obtain authorized access to protected ProductResource API.
security.oauth2.client.authorized-grant-type=authorization_code,refresh_token,password
security.oauth2.client.scope=openid
```

**The Authorization Code grant type** is used by confidential and public clients to exchange an authorization code for an access token. After the user returns to the client via the redirect URL, the application will get the authorization code from the URL and use it to request an access token.


## 4. Running OAuth request
To access the ProductResource, first get the access token from the Authorization server and Excecute the request using tge given access token. 
1. Getting an access token from Authorization server. configure the client authentication detail which are user-name and password in the basic authentication on postman / soapUI.
 ```
 POST: http://localhost:8080/oauth/token
 Authorization:
 Type: Basic Auth
 username:javaFeature
 password:javaFeature
 
 ```
3. Excecute the request using access token.

## Conclusion

Implementing OAuth2 security for a REST API is an effective way to protect user data while allowing third-party applications to access that data. By following the steps outlined in this document, you can ensure that your REST API is secure and that user data is protected.
