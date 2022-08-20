Bootstrap project for Java app or library.

It includes:

- publishing to artifactory
- generation of Javadoc and publishing it to SCM
- separate Maven profile for running integration tests
- separate Maven profile for building standalone application
- JUnit, slf4j, jacoco, spotless
- Jenkins job definition for release

# Build

Using Maven:

``` bash
mvn clean install
```

## Run integration tests

They are disable by default and activated with separate profile:

``` bash
mvn clean install -Pintegration-test
```

## Standalone application

To build standalone application which would include all its dependencies:

``` bash
mvn clean install -Papp
```

# Contributors

lambdaprime <intid@protonmail.com>
