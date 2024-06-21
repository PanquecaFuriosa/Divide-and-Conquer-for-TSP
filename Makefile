KC=	kotlinc
KFLAGS= -include-runtime
PROG= hola.jar
SRC= DACTSP.kt

all :
	$(KC) $(KFLAGS) $(SRC) -d $(PROG)

. PHONY : clean

clean:
	rm -rf hola.jar