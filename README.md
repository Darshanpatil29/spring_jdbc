//Maven Build Guide
Maven is a build automation tool used primarily for Java projects. It helps manage project dependencies, build processes, and project documentation.

Key features of Maven include:
It simplifies the build process by managing dependencies, compiling source code, packagingit into a deliverable (such as a JAR file), and deploying it to a repository.
Maven is based on the concept of a Project Object Model (POM), which is a central piece ofinformation that manages a project’s build, reporting, and documentation.
nderstanding the .m2 Directory and settings.xml
The .m2 directory is a hidden folder in your user home directory that Maven uses to storets configuration files and local repository.
The settings.xml file is located in the .m2 directory and is used to configure Maven’sehavior. It can include settings such as repository locations, proxy configurations, andther preferences.

pom.xml File
The pom.xml file is the core of a Maven project. It contains information about the projectand configuration details used by Maven to build the project.

Structure of pom.xml
      <project xmlns="<http://maven.apache.org/POM/4.0.0>"
            xmlns:xsi="<http://www.w3.org/2001/XMLSchema-instance>"
            xsi:schemaLocation="<http://maven.apache.org/POM/4.0.0>
                                <http://maven.apache.org/xsd/maven-4.0.0.xsd>">
        <modelVersion>4.0.0</modelVersion>

        <groupId>com.example</groupId>
        <artifactId>my-app</artifactId>
        <version>1.0-SNAPSHOT</version>
        <packaging>jar</packaging>

        <name>My App</name>
        <url><http://maven.apache.org></url>

        <dependencies>
            <dependency>
                <groupId>junit</groupId>
                <artifactId>junit</artifactId>
                <version>4.12</version>
                <scope>test</scope>
            </dependency>
        </dependencies>

        <build>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>3.8.1</version>
                    <configuration>
                        <source>1.8</source>
                        <target>1.8</target>
                    </configuration>
                </plugin>
            </plugins>
        </build>
    </project>

modelVersion: Specifies the POM schema version, usually 4.0.0.

groupId: Uniquely identifies the project across all projects (reverse domain convention).

artifactId: Name of the project/jar without the version.

version: Current version of the project (e.g., 1.0.0 or SNAPSHOT).

packaging: Type of artifact produced (jar, war, pom; default is jar).

name & url: Optional human-readable project name and URL.

dependencies: Lists external libraries the project needs; Maven downloads them automatically.

build: Specifies build instructions, plugins, resources, and custom directories.

Maven dependency management:
1) compile (default):

    Available in all build phases (compile, test, package).

    Included in the final artifact.

    Typical use: libraries needed for building, testing, and running.

2) provided:

    Available at compile-time but not in the final artifact.

    Runtime environment provides it (e.g., servlet API).

    Typical use: dependencies supplied by the server or container.

3) runtime:

    Not needed for compilation, required only at runtime.

    Included in the final artifact.

    Typical use: JDBC drivers, runtime-only libraries.

4) test:

    Available only for test compilation and execution.

    Not included in the final artifact.

    Typical use: testing frameworks like JUnit or Mockito.

5) system:

    Available for compile and test but must be manually provided.

    Not included in the final artifact.

    Typical use: local libraries not in any repository; path specified via <systemPath>.

Maven Build Lifecycle:
1. Default Lifecycle (Build)

    Handles the main build and deployment of a project. Key phases:

    a) validate: Checks if the project is correct and all info is available.

    b) compile: Compiles the source code.

    c) test: Runs unit tests (e.g., JUnit).

    d) package: Packages compiled code into JAR/WAR.

    e) verify: Performs checks to ensure package is valid.

    f) install: Installs package into local repository.

    g) deploy: Copies package to a remote repository for sharing.

Commands:

mvn compile       # Compile source code
mvn test          # Run unit tests
mvn package       # Build JAR/WAR
mvn install       # Install to local repo
mvn deploy        # Deploy to remote repo

2. Clean Lifecycle

    Cleans up artifacts from previous builds. Key phases:

    a) pre-clean: Processes before cleaning.

    b) clean: Removes files from previous build.

    c) post-clean: Processes after cleaning.

Command:

mvn clean         # Executes clean lifecycle

3. Site Lifecycle

    Generates project site/documentation. Key phases:

    a) pre-site: Processes before site generation.

    b) site: Generates the project site.

    c) post-site: Processes after site generation.

    d) site-deploy: Deploys the site to a web server.

Commands:

mvn site          # Generate project site
mvn site:deploy   # Deploy generated site

Types of Maven Repositories

1) Local Repository:

    Stored on your machine (default: ~/.m2/repository or C:\Users\YourUsername\.m2\repository).

    Maven checks it first before downloading dependencies.

    Can be customized in settings.xml using <localRepository>.

2) Central Repository:

    Public repository hosted by the Maven project.

    Default source for dependencies not found locally.

    Automatically connected by Maven when needed.

3) Remote Repository:

    Any repository hosted on a web server other than central.

    Used for proprietary artifacts or organization-specific libraries.

    Configured in pom.xml or settings.xml:

    <repositories>
        <repository>
            <id>my-company-repo</id>
            <url>http://repository.mycompany.com/maven2</url>
        </repository>
    </repositories>

* Maven Dependency Resolution Order

1) Local Repository: Checked first.

2) Remote Repositories: Checked if not found locally.

3) Central Repository: Checked if not found in remote repositories.

4) Fail: Build fails if dependency is unavailable in any repository.
