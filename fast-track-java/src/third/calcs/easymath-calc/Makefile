SRC_DEPENDS_PATH=../basic-calc
CLASS_DEPENDS_PATH=.:../basic-calc

all:
	javac *.java -sourcepath $(SRC_DEPENDS_PATH)

run:
	java -ea -cp $(CLASS_DEPENDS_PATH)  EasyClient 

clean:
	rm -f *.class
