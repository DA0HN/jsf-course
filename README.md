# Java Server Faces

Curso da Udemy de Java Server Faces para iniciante.

[Configuração básica de JSF usando maven](http://javaonlineguide.net/2015/06/jsf-2-2-hello-world-tutorial-with-example-basic-concepts.html)

## Page Structure

```xhtml
<!DOCTYPE html>
<html lang="en"
      xmlns="http://www.w3.org/1999/xhtml"
      xmlns:h="http://xmlns.jcp.org/jsf/html"> <--- importação de namespace

    <h:head>  <---  chamada de um componente jsf
        <title>Student Registration Form</title>
    </h:head>
    
    <h:body>
        <h:form>
            ...
        </h:form>
    </h:body>
    
</html>
```


### JSF UI Components

* JSF includes components that will generate HTML for you.

|JSF UI Component             | Description              |
|-----------------------------|--------------------------|
|```h:form```                 |```main form container``` |
|```h:inputText```            |```text field```          |
|```h:selectBooleanCheckBox```|```check box```           |
|```h:selectOneRadio```       |```radio buttons```       |
|```h:selectOneListBox```     |```drop down list```      |
|```more...```                |```...```      |


### How To Reference JSF UI Components

* Specify the JSF namespace at beginning of HTML file

|JSF UI Component           | Description                             |
|---------------------------|-----------------------------------------|
|```Core components```      |```http://xmlns.jcp.org/jsf/core```      |
|```HTML components```      |```http://xmlns.jcp.org/jsf/html```      |
|```Facelets components```  |```http://xmlns.jcp.org/jsf/facelets```  |
|```Composite components``` |```http://xmlns.jcp.org/jsf/composite``` |
|```more...```              |```...```                                |


## What are Managed Beans?

* A managed bean is a regular Java class
* Commonly used to hold form data
* Can also contain business logic
* Created and managed by JSF... hence "managed bean" !

**Warning: Not to be confused with Enterprise Java Beans (EJB)**

### Requirements for Managed Beans

* Must follow these rules:
    * Public no-arg constructor
    * Expose properties via public getter/setter methods
* JSF 2 added support for annotation: ```@ManagedBean```

### Scopes of Managed Beans

| Scope            | Description                                                     |
|------------------|-----------------------------------------------------------------|
|```Request```     | New bean is created for every request. Short-lived              |
|```Session```     | Bean is created once for user's browser session. Unique for user|
|```Application``` | Bean is created once for application and shared by ALL users    |

#### Application Scope

* Bean is created once for application and shared by ALL users.
* Commonly used to share an instance of a utility class.
* For example a database utility class.

Example:

```java
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named                        // @ManagedBean = @Named (usando especificação do CDI)
@ApplicationScoped            // Esse bean é compartilhado por todos os usuários
public class Counter {
  private int value = 0;
  
  public String increment() {
    this.value++;             // incrementa o contador
    return "increment-view";  // atualiza a tela
  }
}
```

```xhtml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:h="http://java.sun.com/jsf/html"
      xml:lang="en"
      lang="en">

  <h:outputText value="Counter value: #{counter.increment}"/>
  <br/>
  <h:form>
    <h:commandButton value="Increment"
                     action="#{counter.increment()}"
    />
  </h:form>
</html>
```

#### Session Scope

* Bean is created once for user's browser session. Unique for this user.
* Commonly used when you need to keep track of the user's actions.
  * Shopping cart
  * Online banking
  * Online Exam

#### Request Scope

* New bean is created for every request. Short lived.
* Commonly used for submitting form data... one time use
* _Note: This is the DEFAULT scope if none is specified_


## JSF Expression Language

* The JSF expression language is used to
  * Access properties of a managed bean
  * Other logic functions are available too
* Basic syntax: ```#{<beanName>.<property>}```
* To access a bean setter property from JSF form:
  * ```<h:inputText value="#{student.firstName}"/>```
  * When form is submitted JSF will call: ```student.setFirstName```
* To access a bean getter property from JSF form:
  * ```Student's name is: #{student.firstName}```
  * When page is processed JSF will call: ```student.getFirstName```
  

## JSF Validation Features

|Validation Features            |
|-------------------------------|
| required                      |
| validateLength                |
| validateDouble / validateLong |
| validateRegex                 |
| custom validation             |