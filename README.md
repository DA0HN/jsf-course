# Java Server Faces

Curso da Udemy de Java Server Faces para iniciante.

[Configuração básica de JSF usando maven](http://javaonlineguide.net/2015/06/jsf-2-2-hello-world-tutorial-with-example-basic-concepts.html)

### Page Structure

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
