all: clean build

clean:
	rm -rf *.class

build:
	javac ConnectFour.java IBoard.java SimpleBoard.java Colors.java
