Bootstrap project for Java app and library.

It includes:

- tests are moved into separate project which gives two benefits:
    - supports Java modularity
    - allows to use SNAPSHOT dependencies in the test project (otherwise you cannot release project which has SNAPSHOT dependencies)
- publishing to artifactory
- generation of Javadoc and publishing it to SCM
- separate Maven profile for running integration tests
- separate Maven profile for building standalone application
- JUnit, slf4j, jacoco, spotless
- Jenkins job definition for release

# Requirements

Java 17+

# Download

[Release versions](hello/release/CHANGELOG.md)
[Release versions](hello.app/release/CHANGELOG.md)

Or you can add dependency to it as follows:

Gradle:

```
dependencies {
  implementation 'io.github.lambdaprime:hello:2.0'
}
```

# Usage

Includes:
- full usage details or
- short but with links to further documentation

README.md is packaged inside the jar file

# Documentation

[Documentation](http://portal2.atwebpages.com/)

[Development](DEVELOPMENT.md)

# Contacts

lambdaprime <intid@protonmail.com>
