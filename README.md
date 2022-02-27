# serving-protobuf-with-javalin

## Description

This is a community example of serving Protobuf over a REST API with Javalin. The project uses the Gradle build system and the official Google Gradle plugin for Protobuf generation. If Grade isn't your thing, the project also contains a pair of custom build scripts to help automate the protocol buffer compilation process to some degree.

## Getting Started

To start, clone or fork this repository. You could also download just the source if you desire. If using the build scripts, make sure both git and protoc are installed on the target system and in your path.

### Dependencies

```
dependencies {
    implementation 'org.slf4j:slf4j-simple:1.8.0-beta4'
    implementation 'io.javalin:javalin:4.3.0'
    implementation 'com.fasterxml.jackson.core:jackson-databind:2.13.1'
    implementation 'com.google.protobuf:protobuf-java:3.19.4'
}

```

## Authors

Cole Snyder AKA The-Funk

## License

This project is licensed under the zero-condition "Unlicense". Use it however you see fit.

## Acknowledgments

* Special thanks to David Åse (tipsy) and the contributors to the always awesome [javalin web framework](https://github.com/tipsy/javalin)
* Thank you to Bone Man from the official [Javalin Discord server](https://discord.com/invite/sgak4e5NKv) for the help with learning Gradle!