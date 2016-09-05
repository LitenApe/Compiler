# INF 2100
Pascal compilator

# How to run
  - Download ant
    - MacOS:
        - run brew install ant
    - Linux Distribution (Ubuntu)
        - run apt-get install ant
    - Windows
        - Go to [Apache Ant download pages](http://ant.apache.org/bindownload.cgi)
        - Download the **.zip** binary distribution and extract it to a preferred location
        - Create an environment variable called **ANT_HOME** and give the path of the location of the folder from previous step in the "System Variables"-section.
        -  Use the **ANT_HOME** variable so that you can execute the *ant* command by adding **%ANT_HOME%\bin** to your **PATH** variable.
        - Run **ant -v** to check if the command is run
  - Compiling & running
    - Compile: run **ant compile**
    - Run: run **ant run**

  By using **ant run** the project will compile and build itself.

# To Do
  - [ ] Part 1: Scanner
    - [ ] Ignore/Remove Comments
    - [ ] Find and create tokens
  - [ ] Part 2: Parser
  - [ ] Part 3: Checker
  - [ ] Part 4: Code generator
