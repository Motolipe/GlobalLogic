# Microservicio - usuario

### Documento referencia:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/#build-image)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

## 1. Instrucciones para levantar proyecto
Esta sección detalla como se levanta el proyecto microservicio.

1. Tener instalado Maven
2. En el Eclipse Marketplace descargar Spring
3. Importar el proyecto Maven

## 2. Usar el proyecto
1. Al momento de compilar el proyecto la pagina que deben ingresar es Post http://localhost:8080/api/user ingresando un usuario 17169623 y contraseña fernanda321 desde postman
2. Va generar un token y este debe ser copiado desde el Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiMTcxNjk2MjMiLCJpYXQiOjE1OTcxMDg0NDcsImV4cCI6MTU5NzEwOTA0MH0.tj1K5jGftfeFJtfGQTdemjRb1VzGLRLcRK-G848lu2o

{
    "token": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwic3ViIjoiMTcxNjk2MjMiLCJpYXQiOjE1OTcxMDg0NDcsImV4cCI6MTU5NzEwOTA0MH0.tj1K5jGftfeFJtfGQTdemjRb1VzGLRLcRK-G848lu2o",
    "contraseña": null,
    "usuario": "17169623"
}

3. en una nuevo request se debe registrar el token en Authorization generado anteriormente
4. registrar la url con GET http://localhost:8080/api/listar para listar todos los usuarios
5. para registrar un usuario nuevo se debe realizar el paso 3 y despues en una llamar una nueva url con post http://localhost:8080/api/usuario selecionando Body, raw e ingresar

{
"name":"Fernanda",
"email":"fernan1a@gmail.com",
"creatAt": "2020-08-02 21:33:58",
"password":"Fernanda33",
"enabled": "true"
}

6. Para validar si existe el un correo se debe realizar el paso 5 con el mismo correo
7. Para validar la contraseña se debe cambiar la contraseña que no cumpla con las indicaciones "debe tener las siguientes caracteres una Mayúscula, letras minúsculas, y dos números".