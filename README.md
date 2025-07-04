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
    - [4. Maven(Optional)](#4-mavenoptional)
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
- *(Optional)* **Apache Maven** - used for compiling the project (`mvn compile`), but not required for running
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

### 4. Maven(Optional)

if you have Maven installed, you can also compile the project with:
```bash
mvn compile
```

Then run the program manually, just like above:
```bash
java -cp target/classes com.example.AnagramFinder resource
```

**or**

```bash
java -cp target/classes com.example.AnagramFinder file
```

## Project Structure

```
anagrams
|
├── data                                
│   ├── exampleUser.txt                 
│   └── words.txt                       
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       └── java
├── structure.txt
└── target
    ├── classes
    │   ├── com
    │   └── example.txt
    ├── generated-sources
    │   └── annotations
    ├── maven-status
    │   └── maven-compiler-plugin
    └── test-classes

16 directories, 5 files
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