## Getting Started

This is a activity for the course of Software Engineering at the University (UPTC) of Colombia. The activity is: "According to the following class diagram, make certain functionalities"
![Class diagram](https://i.ibb.co/2swJthv/1691539047-screensht.png)

## Prerequisites

- [Java 20](https://www.oracle.com/java/technologies/javase-downloads.html)
- [VSCode](https://code.visualstudio.com/download)
- [VSCode Extension: Java Extension Pack](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [VSCode Extension: Java Test Runner](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-junit5-test-runner)

## Running the App

### From VSCode

1. Clone the repositoryEnter a correct value
2. Open the project in VSCode
3. Open the `src` folder
4. Open the `src/view/Runner.java` file
5. Click on the `Run` button on the top right corner of the editor

### Or from the terminal

1. Clone the repository

```bash
git clone https://github.com/vvg1058/phones-project.git
cd phones-project
```

2. Compile the project

```bash
javac src/**/*.java -d bin
```

3. Run the project

```bash
java -cp bin view.Runner
```


## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies
- `test`: the folder to maintain test files

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Members of team

- Jean Carlos Valencia
- Valentina Vega

## Contributors 
Thanks to everyone who has contributed to this project:

[![Contributors](https://contrib.rocks/image?repo=vvg1058/phones-project)](https://github.com/vvg1058/phones-project/graphs/contributors)