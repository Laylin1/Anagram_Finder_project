# Anagram Finder Project

This project implements an anagram search tool.
It reads a file containing a list of words and outputs groups of words that are anagrams of each other.
The program is optimized for processing large datasets with efficient memory usage and minimal system load.


---


**Table of Contents**

<!-- toc -->
- [Anagram Finder Project](#anagram-finder-project)
  - [Technologies Used](#technologies-used)
  - [Requirements](#requirements)
  - [How to run](#how-to-run)
    - [1. Clone the repository](#1-clone-the-repository)
    - [2. Compile:](#2-compile)
    - [3. Run:](#3-run)
  - [How to Build and Run with Maven](#how-to-build-and-run-with-maven)
    - [1. Build the Project](#1-build-the-project)
    - [2. Run the Application](#2-run-the-application)
  - [Run with Docker](#run-with-docker)
    - [1. Build the docker image:](#1-build-the-docker-image)
    - [2. Run the Application](#2-run-the-application-1)
    - [3. Run using your own file:](#3-run-using-your-own-file)
  - [Project Structure](#project-structure)
  - [Example Output(from example.txt)](#example-outputfrom-exampletxt)
  - [Data Source](#data-source)

<!-- tocstop -->

## Technologies Used

- **java 17+**
- **Java Standard Library**:
    - Collections
    - Streams API
    - File I/O
- **Text processing**: 
    - Regular expressions
    - Character array sorting
- **Command-line arguments** for execution modes

## Requirements

- **Java Development Kit (JDK) 11+**
- *(Optional)* **Apache Maven** - used for build the project (`mvn compile`), but not required for running
- *(Optional)* **Docker** - launch on any environment
> You can also compile the code manually using `javac` if Maven is not installed 

## How to run

### 1. Clone the repository
```bash
git clone https://github.com/Laylin1/Anagram_Finder_project.git
cd anagrams
```

### 2. Compile:
```bash
javac -d target/classes src/com/example/*.java
```
>This compiles all source files into the target/classes/ directory 

### 3. Run:
```bash
java -cp target/classes com.example.AnagramFinder resource
```
- Run this command to use the built-in file `example.txt`(bundled in `resources/`)
  
**or**

```bash
java -cp target/classes com.example.AnagramFinder file
```

- Use `file` to read an external file from `data/words.txt`
- Also you can upload your own file to the directory `data/`, and change path in variable parameters:

```java
//  Read/Write/Change file. (User's file)
    public static File wordsAFile = new File("data/words.txt");
```

- Just upload file in the directory `data/` and change path `data/your_file.txt`

## How to Build and Run with Maven

### 1. Build the Project 

To compile and package the poject into a runnable `.jar`, run the folowing command:

```bash
mvn clean package
```

### 2. Run the Application

After building, you can run the program using:

```bash
java -jar target/anagrams-1.0-SNAPSHOT.jar resource
```

**or**

```bash
java -jar target/anagrams-1.0-SNAPSHOT.jar file
```

- Use `resource` to run the built-in example file (example.txt)
- Use `file` to read from external file.  


## Run with Docker

To use Docker, you first need to build the `.jar` file using [Maven](#how-to-build-and-run-with-maven)

### 1. Build the docker image:

```bash
docker build -t anagram-finder .
```

### 2. Run the Application

```bash
docker run --rm anagram-finder resource
```

**or**

```bash
docker run --rm anagram-finder file
```

### 3. Run using your own file:

If you have your own file in the `data/` directory, mount it like this:
```bash
docker run --rm -v "$(pwd)/data:/app/data" anagram-finder file 
```
> This mounts your local `data/` folder into the container 

## Project Structure

```
anagrams
├── data
│   ├── exampleUser.txt
│   └── words.txt
├── Dockerfile
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       └── java
├── structure.txt
└── target
    └── anagrams-1.0-SNAPSHOT.jar
```

## Example Output(from example.txt)

```md
act cat
tree
race care acre
bee
```

## Data Source 


File `words.txt` from directoy `data/` is based on the English word list from the following open-source repository:
[dwyl/english-words](https://github.com/dwyl/english-words)
> License: Unlicense license (as specified in their repository)