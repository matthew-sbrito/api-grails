# API Rest in Grails

## About **Project**
I made this project in order to learn how to use the framework!   

## About **Grails**
Grails is a framework for you to spend more time with your family haha!  
Made in Groovy, on top of the mighty **Spring Boot**!   
It's intended to facilitate development, anticipate all database processes, creating everything through classes, all because of its poweful ORM (GORM)!

## To use this project you need!
I recommend downloading by __sdkman__! [click here][sdkman-link]

### You will need:
- Grails 3.0.0
- Java 8 ( Recommend the last version OPEN-JDK 8) 
- [Intellij 2021.1.3][intelijj-link] ( Premium version preferred )

```console
  foo@bar:~$ sdk list java
  foo@bar:~$ sdk install java VERSION
  
  foo@bar:~$ sdk list grails
  foo@bar:~$ sdk install grails VERSION
```

Basically intelijj will download all packages and run for you.  
It's very easy right? Nooo! if you configure something wrong, it won't compile. Good Luck! I'm kidding, if you have troble ask me!

The code in Groovy/Grails is a little peculiar, check this out:

```groovy
  def hello() {
    def myText = "hello word!"
    println myText
  }
```
I was used to Java and PHP so it waas a little weird for me, **don't judge me!**  
Looks like they simplified Java taking inspiration from Python

I'm sorry my english is weak, but I'm trying to improve!

[sdkman-link]:https://sdkman.io/
[intelijj-link]:https://www.jetbrains.com/idea/download/other.html
