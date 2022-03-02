# Important mvn configuration

## Setup Consideration

* Most of the mvn configuration is in the parent pom [parent pom](../pom.xml)
* IntelliJ has sometimes difficulties finding this parent pom when the parent pom is not installed
* Issue from inside the parent project [parent project](../)

```shell
$ mvn install -f pom.xml -DskipTests=true
```

