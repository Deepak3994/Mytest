all:
	make -C basic-calc
	make -C easymath-calc

run:
	java -ea -cp .:basic-calc:easymath-calc EasyClient

clean:
	make clean -C basic-calc
	make clean -C easymath-calc
