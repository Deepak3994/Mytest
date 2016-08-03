SRC_DEPENDS_PATH=../../intpair
CLASS_DEPENDS_PATH=.:../../intpair

board:
	javac -sourcepath $(SRC_DEPENDS_PATH) Board.java BoardTest.java

run:
	java -ea -cp $(CLASS_DEPENDS_PATH) BoardTest

clean:
	rm *.class
