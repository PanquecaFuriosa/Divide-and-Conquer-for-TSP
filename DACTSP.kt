import java.io.File
import kotlin.math.*
import kotlin.system.exitProcess
/**
* Función que combina de manera ordenada los subarreglos creados por mergeSort
*	Argumentos:
*		A: Variable de tipo arreglo de doubles que se ordenará
*		p: Variable de tipo entero que representa la posición inicial del subarreglo
*		q: Variable de tipo entero que representa el final del primer subarreglo e inicio del segundo
*		r: Variable de tipo entero que representa la posición final del subarreglo	
*	Precondición: A debe ser de tipo DoubleArray no vacío, p debe ser un entero positivo que esté dentro de la longitud de A
*	q debe ser un entero positivo que sea la suma de p y r entre 2 y r debe ser un entero positivo que esté dentro de la longitud de A
*	Postcondición: El subarreglo de A que está delimitado por p y q debe resultar ordenado al terminar la función. Cuando se habla de subarreglo
*	se puede referir a un arreglo más pequeño dentro de A o el mismo arreglo A
*/

fun merge(A: DoubleArray, p: Int, q: Int, r: Int) {

	var n1 : Int = q-p+1
	var n2 : Int = r-q
	var L = DoubleArray(n1+1)
	var R = DoubleArray(n2+1)

	for (i in 0 until n1) {
		L[i] = A[p+i]
	}

	for (j in 0 until n2) {
		R[j] = A[q+j+1]
	}

	L[n1] = Double.MAX_VALUE
	R[n2] = Double.MAX_VALUE

	var i : Int = 0
	var j : Int = 0

	for (k in p until r+1) {
		if (L[i] <= R[j]) {
			A[k] = L[i]
			i++
		} else {
			A[k] = R[j]
			j++
		}
	}
}
/** Funcion que ordena un arreglo siguiendo el algoritmo Merge Sort
* 		Argumentos: 
*			A: Variable de tipo arreglo de doubles que se ordenará	
*			p: Variable de tipo entero que representa la posición inicial del arreglo
*			r: Variable de tipo entero que representa la posición final del arreglo	
*	Precondición: A debe ser de tipo DoubleArray, p debe ser un entero que represente al primer índice del arreglo y r debe ser un entero que represente
*	al último, es decir, el tamaño de A menos 1
*	Postcondición: El arreglo A debe resultar ordenado al terminar la función
*/
fun mergeSort(A: DoubleArray, p: Int, r: Int) {

	var q : Int 

	if (p < r) {
		q = (p+r)/2
		mergeSort(A, p, q)
		mergeSort(A, q+1, r)
		merge(A, p, q, r)
	}
}
/**
* Función que combina de manera ordenada los subarreglos creados por mergeSortX, está modificado para combinar
* arreglos de pares de doubles dependiendo de su primer elemento
*	Argumentos:
*		A: Variable de tipo arreglo de de pares que se ordenará
*		p: Variable de tipo entero que representa la posición inicial del subarreglo
*		q: Variable de tipo entero que representa el final del primer subarreglo e inicio del segundo
*		r: Variable de tipo entero que representa la posición final del subarreglo	
*	Precondición: A debe ser de tipo Array<Pair<Double, Double>> no vacío, p debe ser un entero positivo que esté dentro de la longitud de A
*	q debe ser un entero positivo que sea la suma de p y r entre 2 y r debe ser un entero positivo que esté dentro de la longitud de A
*	Postcondición: El subarreglo de A que está delimitado por p y q debe resultar ordenado según las primeras coordenadas del Pair, o elemento.first
*	al terminar la función. Cuando se habla de subarreglo se puede referir a un arreglo más pequeño dentro de A o el mismo arreglo A
*/
fun mergeX(P: Array<Pair<Double, Double>>, p: Int, q: Int, r: Int) {

	var n1 : Int = q-p+1
	var n2 : Int = r-q
	var L : Array<Pair<Double, Double>> = arrayOf()
	var R : Array<Pair<Double, Double>> = arrayOf()

	for (i in 0 until n1) {
		L += P[p+i]
	}

	for (j in 0 until n2) {
		R += P[q+j+1]
	}

	L += Pair(Double.MAX_VALUE, 0.000)
	R += Pair(Double.MAX_VALUE, 0.000)

	var i : Int = 0
	var j : Int = 0

	for (k in p until r+1) {
		if (L[i].first <= R[j].first) {
			P[k] = L[i]
			i++
		} else {
			P[k] = R[j]
			j++
		}
	}
}
/** Funcion que ordena un arreglo siguiendo el algoritmo Merge Sort, está moificado para 
* 	ordenar pares de doubles dependiendo de su primer elemento
* 		Argumentos: 
*			A: Variable de tipo arreglo de pares de doubles que se ordenará	
*			p: Variable de tipo entero que representa la posición inicial del arreglo
*			r: Variable de tipo entero que representa la posición final del arreglo	
*	Precondición: A debe ser de tipo Array<Pair<double, Double>>, p debe ser un entero que represente al primer índice del arreglo y r 
*	debe ser un entero que represente al último, es decir, el tamaño de A menos 1
*	Postcondición: El arreglo A debe resultar ordenado según las coordenadas x de los pair, o elemento.first, al terminar la función
*/
fun mergeSortX(P: Array<Pair<Double, Double>>, p: Int, r: Int) {

	var q : Int 

	if (p < r) {
		q = (p+r)/2
		mergeSortX(P, p, q)
		mergeSortX(P, q+1, r)
		mergeX(P, p, q, r)
	}
}
/**
* Función que combina de manera ordenada los subarreglos creados por mergeSortY, está modificado para combinar
* arreglos de pares de doubles dependiendo de su segundo elemento
*	Argumentos:
*		A: Variable de tipo arreglo de de pares que se ordenará
*		p: Variable de tipo entero que representa la posición inicial del subarreglo
*		q: Variable de tipo entero que representa el final del primer subarreglo e inicio del segundo
*		r: Variable de tipo entero que representa la posición final del subarreglo	
*	Precondición: A debe ser de tipo Array<Pair<Double, Double>> no vacío, p debe ser un entero positivo que esté dentro de la longitud de A
*	q debe ser un entero positivo que sea la suma de p y r entre 2 y r debe ser un entero positivo que esté dentro de la longitud de A
*	Postcondición: El subarreglo de A que está delimitado por p y q debe resultar ordenado según las segundas coordenadas del Pair, o elemento.second
*	al terminar la función. Cuando se habla de subarreglo se puede referir a un arreglo más pequeño dentro de A o el mismo arreglo A
*/
fun mergeY(P: Array<Pair<Double, Double>>, p: Int, q: Int, r: Int) {

	var n1 : Int = q-p+1
	var n2 : Int = r-q
	var L : Array<Pair<Double, Double>> = arrayOf()
	var R : Array<Pair<Double, Double>> = arrayOf()

	for (i in 0 until n1) {
		L += P[p+i]
	}

	for (j in 0 until n2) {
		R += P[q+j+1]
	}

	L += Pair(0.000, Double.MAX_VALUE)
	R += Pair(0.000, Double.MAX_VALUE)

	var i : Int = 0
	var j : Int = 0

	for (k in p until r+1) {
		if (L[i].second <= R[j].second) {
			P[k] = L[i]
			i++
		} else {
			P[k] = R[j]
			j++
		}
	}
}
/** Funcion que ordena un arreglo siguiendo el algoritmo Merge Sort, está moificado para 
* 	ordenar pares de doubles dependiendo de su segundo elemento
* 		Argumentos: 
*			A: Variable de tipo arreglo de pares de doubles que se ordenará	
*			p: Variable de tipo entero que representa la posición inicial del arreglo
*			r: Variable de tipo entero que representa la posición final del arreglo	
*	Precondición: A debe ser de tipo Array<Pair<double, Double>>, p debe ser un entero que represente al primer índice del arreglo y r 
*	debe ser un entero que represente al último, es decir, el tamaño de A menos 1
*	Postcondición: El arreglo A debe resultar ordenado según las coordenadas y de los pair, o elemento.second, al terminar la función
*/
fun mergeSortY(P: Array<Pair<Double, Double>>, p: Int, r: Int) {

	var q : Int 

	if (p < r) {
		q = (p+r)/2
		mergeSortY(P, p, q)
		mergeSortY(P, q+1, r)
		mergeY(P, p, q, r)
	}
}

/**
*	Función que obtienelos vértices del rectángulo que se forma a partir de las coordenadas
*	de las ciudades dadas
*		Argumentos:
*			P: Variable de tipo arreglo de pares de doubles. Contiene las coordenadas de las ciudades
*		Retorna:
*			Un arreglo de pares de doubles. El arreglo contiene las coordenadas de los vértices
*	Precondición: P debe ser un arreglo que contiene variables de tipo par que contiene dos elementos doubles, debe contener ciudades dadas
*	Postcondicion: Se debe retornar un arreglo que contiene 4 pares de elementos doubles
*/
fun obtenerRectangulo(P: Array<Pair<Double, Double>>): Array<Pair<Double, Double>> {

	var n : Int = P.size
	var primerasCoord = DoubleArray(n)
	var segundasCoord = DoubleArray(n)

	//guardo las coordenadas de las ciudades en arreglos
	for (i in 0 until n) {
		primerasCoord[i] = P[i].first
		segundasCoord[i] = P[i].second
	}
	//ordeno las coordenadas para determinar cuáles son las coordenadas más pequeñas y más grandes
	mergeSort(primerasCoord, 0, n-1)
	mergeSort(segundasCoord, 0, n-1)

	//determino los vértices del rectángulo con las coordenadas más grandes y más pequeñas que sirven de lados del mismo
	var v1 : Pair<Double, Double> = Pair(primerasCoord[0], segundasCoord[n-1])
	var v2 : Pair<Double, Double> = Pair(primerasCoord[0], segundasCoord[0])
	var v3 : Pair<Double, Double> = Pair(primerasCoord[n-1], segundasCoord[0])
	var v4 : Pair<Double, Double> = Pair(primerasCoord[n-1], segundasCoord[n-1])

	return arrayOf(v1, v2, v3, v4)
}
/**
*	Función que dados 3 vértices de un rectángulo, calcula las dimensiones del rectángulo,
*	 es decir, cuanto mide su lado paralelo al eje X y el paralelo al eje Y 
*		Argumentos:
*			v1: Variable de tipo par de doubles que representa la coordenada del vértice superior izquierdo
*			v2: Variable de tipo par de doubles que representa la coordenada del vértice inferior izquierdo
*			v3: Variable de tipo par de doubles que representa la coordenada del vértice inferior derecho
*		Retorna:
*			Una par que contiene en su primera coordenada, la dimensión X del rectángulo, en la 
*			segunda coordenada, la dimensión Y
*	Precondición: v1, v2 y v3 deben ser pares de elementos doubles
*	Postcondicion: Se debe retornar un par con dos elementos doubles correspondientes a los tamaños de v3-v2 en el eje x y v1-v2 en el eje y
*/
fun obtieneDimensiones(v1: Pair<Double, Double>, v2: Pair<Double, Double>, v3: Pair<Double, Double>): Pair<Double, Double> {

	//determino los tamaños de los lados restando los puntos de los extremos de los mismos
	var xDim : Double = v3.first - v2.first //x2-x1
	var yDim : Double = v1.second - v2.second //y2-y1

	return Pair(xDim, yDim)
}
/**
*	Función que obtiene el punto de corte de un rectángulo dependiendo de las ciudades dentro del mismo y del eje de corte
*		Argumentos:
*			P: Variable de tipo arreglo de pares de doubles que contiene las ciudades dentro del rectángulo
*			ejeDeCorte: Variebla de tipo string que indica el eje de corte
*		Retorna:
*			Un par que representa la ciudad que servirá de punto de corte del rectángulo
*	Precondición: P debe ser un arreglo que contiene variables de tipo par que contiene dos elementos doubles, debe contener ciudades dadas y 
*	ejeDeCorte de tener un valor de "Y" o "X"
*	Postcondicion: Se debe retornar un par de doubles, debe ser el elemento de P en la posición calculada "pos"
*/
fun obtenerPuntoDeCorte(P: Array<Pair<Double, Double>>, ejeDeCorte: String): Pair<Double, Double> {

	var n : Int = P.size
	var pos : Int = ceil((n/2).toDouble()).toInt() - 1

	//ordeno las ciudades dependiendo del eje de corte
	if (ejeDeCorte == "X") {
		mergeSortX(P, 0, n-1)
	} else {
		mergeSortY(P, 0, n-1)
	}

	return P[pos]
}
/**
*	Función que aplica el corte a un rectángulo dependiendo del eje de corte dado, y se divide en dos rectángulos más pequeños
*		Argumentos:
*			P: Variable de tipo arreglo de pares de doubles que contiene las ciudades dentro del rectángulo
*			ejeDeCorte: Variable de tipo string que indica el eje de corte
*			puntoDeCorte: Variable de tipo par que representa la ciudad que será el punto de corte
*			rectángulo: Variable de tipo arreglo de pares de doubles que representa el rectángulo que se dividirá
*		Retorna:
*			Un par de arreglos de pares de dobles. Es un par que contiene los dos rectángulos resultantes de la división, es decir, los vértices de
*			los rectángulos
*	Precondición: ejeDeCorte debe tener como valor "X" o "Y", punto de corte debe ser un par de dobles y debe estar en el arreglo de ciudades y
*	rectángulo debe ser un arreglos con 4 pares de doubles que son los vértices 
*	Postcondición: Se debe retornar un par de arreglos de pares de dobles, estos arreglos deben tener 4 vértices y 2 de los vértices de cada uno de los
* 	rectangulo nuevos deben coincidir con 2 de los vértices del rectángulo original, dependiendo del punto de corte
*
*/
fun aplicarCorte(ejeDeCorte: String, puntoDeCorte: Pair<Double, Double>, rectangulo: Array<Pair<Double, Double>>): Pair<Array<Pair<Double, Double>>, Array<Pair<Double, Double>>> {
	
	var rectanguloIzq : Array<Pair<Double, Double>>
	var rectanguloDer : Array<Pair<Double, Double>>
	val rIv1 : Pair<Double, Double> 
	val rIv2 : Pair<Double, Double>
	val rIv3 : Pair<Double, Double> 
	val rIv4 : Pair<Double, Double> 
	val rDv1 : Pair<Double, Double> 
	val rDv2 : Pair<Double, Double> 
	val rDv3 : Pair<Double, Double> 
	val rDv4 : Pair<Double, Double> 
	var xc : Double
	var yc : Double

	//determino los vértices de los rectángulos resultantes de la divisón del rectángulo grande
	if (ejeDeCorte == "X") {
		xc = puntoDeCorte.first
		rIv1 = rectangulo[0]
		rIv2 = rectangulo[1]
		rIv3 = Pair(xc, rIv2.second)
		rIv4 = Pair(xc, rIv1.second)
		rDv1 = Pair(rIv4.first + 0.0001, rIv4.second)
		rDv2 = Pair(rIv3.first + 0.0001, rIv3.second)
		rDv3 = rectangulo[2]
		rDv4 = rectangulo[3]
	} else {
		yc = puntoDeCorte.second
		rIv2 = rectangulo[1]
		rIv1 = Pair(rIv2.first, yc)
		rIv3 = rectangulo[2]
		rIv4 = Pair(rIv3.first, yc)
		rDv1 = rectangulo[0]
		rDv2 = Pair(rIv1.first, rIv1.second + 0.0001)
		rDv3 = Pair(rIv4.first, rIv4.second + 0.0001)
		rDv4 =  rectangulo[3]
	}

	//se crea cada rectángulo con sus vértices 
	rectanguloIzq = arrayOf(rIv1, rIv2, rIv3, rIv4)
	rectanguloDer = arrayOf(rDv1, rDv2, rDv3, rDv4)

	return Pair(rectanguloIzq, rectanguloDer)
}
/**
*	Función que obtiene las ciudades que están dentro de un rectángulo dado
*		Argumentos:
*			P: Variable de tipo arreglo de pares de doubles que contiene todas las ciudades
*			rectángulo: Variable de tipo arreglo de pares de doubles que representa los vértices del rectángulo
*		Retorna:
*			Un arreglo que contiene las ciudades que están dentro del rectángulo
*	Precondición: P debe ser un arreglo que contiene variables de tipo par que contiene dos elementos doubles, debe contener ciudades dadas
*	rectangulo debe ser un arreglo con 4 pares de dobles, estos pares deben ser los vértices del rectángulo 
*	Postcondicion: Se debe retornar un arreglo de pares de doubles, debe contener las ciudades que están dentro del rectángulo dado
*/
fun obtenerPuntosRectangulo(P: Array<Pair<Double, Double>>, rectangulo: Array<Pair<Double, Double>>): Array<Pair<Double, Double>>{

	var particion : Array<Pair<Double, Double>> = arrayOf()

	for (i in 0 until P.size) {
		var x : Double = P[i].first //guardo la primera coordenada de la ciudad actual
		var y : Double = P[i].second //guardo la segunda coordenada de la ciudad actual
		//verifico que las coordenadas de la ciudad actual esté dentro o en los lados del 
		//rectángulo, si no están, la ciudad no es agregada a la partición
		if ((rectangulo[1].first <= x && x <= rectangulo[2].first) && (rectangulo[1].second <= y && y <= rectangulo[0].second)) {
			particion += P[i]
		}
	}
	return particion
}
/**
*	Función que obtiene el punto de corte del rectángulo en caso de que al intentar obtenerlo con obtenerPuntoDeCorte() resulte un rectángulo
*	sin ciudades, aun después de intentarlo con ambos ejes de corte
*		Argumentos:
*			rectangulo: Variable de tipo arreglo de pares de doubles que representa el rectángulo a cortar
*			ejeDeCorte: Variable de tipo string que indica el eje de corte
*		Retorna:
*			Un par que representa la ciudad que servirá de punto de corte
*	Precondición: rectangulo debe ser un arreglo con 4 pares de dobles, estos pares deben ser los vértices del rectángulo y ejeDeCorte debe tener
*	como valor "X" o "Y"
*	Postcondición: Se debe retornar un par de doubles, debe corresponder con el valor x o y minimo y la mitad de una de las dimensiones del rectángulo
*	dependiendo del eje de corte
*/
fun obtenerPuntoDeCorteMitad(rectangulo: Array<Pair<Double, Double>>, ejeDeCorte: String): Pair<Double, Double>{

	var xMin : Double = rectangulo[1].first //obtengo la coordenada x del vértice inferior izquierdo ya que tiene el x más pequeño
	var yMin : Double = rectangulo[1].second //obtengo la coordenada y del vértice inferior izquierdo ya que tiene la y más pequeña
	var puntoDeCorte : Pair<Double, Double>

	if (ejeDeCorte == "X") {
		var xDim : Double = rectangulo[2].first - rectangulo[1].first //obtengo el tamaño del lado paralelo al eje x
		puntoDeCorte = Pair((xMin+xDim)/2, yMin) //obtengo el punto de corte con la altura mínima y con la mitad del tamaño del lado paralelo al eje x
	} else {
		var yDim : Double = rectangulo[0].second - rectangulo[1].second //obtengo el tamaño del lado paralelo al eje y
		puntoDeCorte = Pair(xMin, (yMin+yDim)/2) //obtengo el punto de corte con el x mínimo y con la mitad del tamaño del lado paralelo al eje y
	}

	return puntoDeCorte
}
/**
*	Función que obtiene pequeñas particiones de ciudades de un arreglo de todas las ciudades
*		Argumentos:
*			P: Variable de tipo arreglo de pares de doubles. Contiene a todas las ciudades
*		Retorna:
*			Un par de arreglos de pares de doubles. Un par que contiene dos particiones de ciudades
*	Precondición: P debe ser un arreglo que contiene variables de tipo par que contiene dos elementos doubles, debe contener ciudades dadas
*	Postcondicion: se debe retornar un par de arreglos de pares de doubles, deben corresponder con los arreglos de ciudades que están en los rectángulos
*	izquierdo y derecho
*/
fun obtenerParticiones(P: Array<Pair<Double, Double>>): Pair<Array<Pair<Double, Double>>, Array<Pair<Double, Double>>> {

	var rectangulo : Array<Pair<Double, Double>> = obtenerRectangulo(P) //se obtienen los vértices del rectángulo
	val v1 : Pair<Double, Double> = rectangulo[0]
	val v2 : Pair<Double, Double> = rectangulo[1]
	val v3 : Pair<Double, Double> = rectangulo[2]
	var dimR : Pair<Double, Double> = obtieneDimensiones(v1, v2, v3) //se obtiene la dimensión del rectángulo
	var xDim : Double = dimR.first
	var yDim : Double = dimR.second
	var ejeDeCorte : String
	var puntoDeCorte : Pair<Double, Double>
	var corte : Pair<Array<Pair<Double, Double>>, Array<Pair<Double, Double>>>
	var rectanguloIzq : Array<Pair<Double, Double>>
	var rectanguloDer : Array<Pair<Double, Double>>
	var particionIzq : Array<Pair<Double, Double>>
	var particionDer : Array<Pair<Double, Double>>

	//se determina el eje de corte dependiendo de que lado del rectángulo sea más grande
	if (xDim > yDim) {
		ejeDeCorte = "X"
	} else {
		ejeDeCorte = "Y"
	}

	puntoDeCorte = obtenerPuntoDeCorte(P, ejeDeCorte) //se obtiene el punto de corte
	corte = aplicarCorte(ejeDeCorte, puntoDeCorte, rectangulo) //se aplica el corte
	rectanguloIzq = corte.first // rectángulo izquierdo resultante del corte
	rectanguloDer = corte.second // rectángulo derecho resultante del corte
	particionIzq = obtenerPuntosRectangulo(P, rectanguloIzq) //partición de las ciudades que quedaron en el rectángulo izquierdo
	particionDer = obtenerPuntosRectangulo(P, rectanguloDer) //partición de las ciudades que quedaron en el rectángulo derecho

	//aquí se hace el mismo proceso pero cambiando el eje de corte, en caso de que al aplicar el corte anterior haya quedado un rectángulo sin ciudades
	if ((particionIzq.size == 0 && particionDer.size > 3) ||(particionIzq.size > 3 && particionDer.size == 0)) {

		if (ejeDeCorte == "X") {
			ejeDeCorte = "Y"
		} else {
			ejeDeCorte = "X"
		}
		puntoDeCorte = obtenerPuntoDeCorte(P, ejeDeCorte)
		corte = aplicarCorte(ejeDeCorte, puntoDeCorte, rectangulo)
		rectanguloIzq = corte.first
		rectanguloDer = corte.second
		particionIzq = obtenerPuntosRectangulo(P, rectanguloIzq)
		particionDer = obtenerPuntosRectangulo(P, rectanguloDer)
			//se intenta no obtener rectángulos vacíos por última vez aplicando un corte justo en el medio del eje de corte
		if ((particionIzq.size == 0 && particionDer.size > 3) || (particionIzq.size > 3 && particionDer.size == 0)) {
			puntoDeCorte = obtenerPuntoDeCorteMitad(P, ejeDeCorte)
			corte = aplicarCorte(ejeDeCorte, puntoDeCorte, rectangulo)
			rectanguloIzq = corte.first
			rectanguloDer = corte.second
			particionIzq = obtenerPuntosRectangulo(P, rectanguloIzq)
			particionDer = obtenerPuntosRectangulo(P, rectanguloDer)
		
		}
	}
	return Pair(particionIzq, particionDer)	
}
/**
*	Función que calcula la distancia de una ciudad a otra
*		Argumentos:
*			c1: Variable de tipo par de doubles que representa una de las ciudades
*			c2: Variable de tipo par de doubles que representa otra de las ciudades
*		Retorna:
*			Un double que representa la distancia entre las ciudades
*	Precondición: c1 y c2 deben ser dos de las ciudades dadas y deben ser pares de doubles
*	Postcondicion: Se debe retornar un double que es resultado de calcular la distancia entre los puntos de las coordenadas de las ciudades dadas
*/
fun distancia(c1: Pair<Double, Double>, c2: Pair<Double, Double>): Double {

	var x : Double = abs(c1.first.toDouble()-c2.first.toDouble()) //obtengo la diferencia de las coordenadas x
	var y : Double = abs(c1.second.toDouble()-c2.second.toDouble()) //obtengo la diferencia de las coordenadas y

	return Math.sqrt(x.pow(2)+y.pow(2)) //obtengo la distancia usando el teorema de Pitágoras, usando como catetos las distancias x y y	
}
/**
*	Función que calcula la diferencia entre la suma de dos lados viejos y dos nuevos
*		Argumentos:
*			dOLD1: Variable de tipo double que representa la distancia de un lado viejo
*			dOLD2: Variable de tipo double que representa la distancia de otro lado viejo
*			dNEW1: Variable de tipo double que representa la distancia de un nuevo lado
*			dNEW1: Variable de tipo double que representa la distancia de otro nuevo lado
*		Retorna:
*			Un double que representa la diferencia de la suma de los lados viejos y los nuevos
*	Precondición: Todas las variables que se pasan como argumentos deben ser doubles y números positivos ya que representan distancias
*	Postcondición: Se debe retornar la diferencia de la suma de las nuevas distancias menos la suma de las viejas distancias
*/
fun distanciaGanada(dOLD1: Double, dOLD2: Double, dNEW1: Double, dNEW2: Double): Double {
	return (dNEW1+dNEW2)-(dOLD1+dOLD2)
}
/**
*	Función que combina dos ciclos creando uno nuevo y más grande
*		Argumentos:
*			c1: Variable de tipo arreglo de arreglos de pares de doubles. Representa uno de los ciclos
*			c2: Variable de tipo arreglo de arreglos de pares de doubles. Representa otro de los ciclos
*		Retorna:
*			Un nuevo arreglo de arreglos de pares de doubles. Representa el nuevo ciclo resultante de la unión de los ciclos dados
*	Precondición: c1 y c2 deben ser dos ciclos de ciudades que se van a combinar, deben ser de tipo arreglo de arreglos de pares de doubles
*	Postcondicion: Se debe retornar un nuevo ciclo que resulta de fusionar los ciclos dados, debe tener todas las ciudades de c1 y c2 y debe
*	ser de tipo arreglo de arreglos de pares de doubles
*/
fun combinarCiclos(c1: Array<Array<Pair<Double, Double>>>, c2: Array<Array<Pair<Double, Double>>>): Array<Array<Pair<Double, Double>>> {

	var c3 : Array<Array<Pair<Double, Double>>> = arrayOf()
	var c1_2 : Array<Array<Pair<Double, Double>>> = arrayOf()
	var c2_2 : Array<Array<Pair<Double, Double>>> = arrayOf()
	var minG : Double = Double.MAX_VALUE
	var a : Pair<Double, Double> 
	var b : Pair<Double, Double> 
	var c : Pair<Double, Double> 
	var d : Pair<Double, Double> 
	var dOLD1 : Double
	var dOLD2 : Double 
	var dNEW1 : Double 
	var dNEW2 : Double 
	var dNEW3 : Double 
	var dNEW4 : Double 
	var g1 : Double 
	var g2 : Double 
	var ganancia : Double
	var ladosAgregarC1 : Array<Pair<Double, Double>> = arrayOf()
	var ladosAgregarC2 : Array<Pair<Double, Double>> = arrayOf()
	var ladosEliminarC1 : Array<Pair<Double, Double>> = arrayOf()
	var ladosEliminarC2 : Array<Pair<Double, Double>> = arrayOf()

	//si uno de los ciclos esá vacío, devuelve el otro
	if (c1.size == 0) {
		return c2
	} else if (c2.size == 0) {
		return c1
	}

	//en caso contrario, se obtienen nuevos lados para unir los ciclos y se reemplazan algunos de los viejos lados que no permiten la union
	for (i in 0 until c1.size) {
		a = c1[i][0]
		b = c1[i][1]
		dOLD1 = distancia(a, b)
		for (j in 0 until c2.size) {
			c = c2[j][0]
			d = c2[j][1]
			dOLD2 = distancia(c, d)
			dNEW1 = distancia(a, c)
			dNEW2 = distancia(b, d)
			dNEW3 = distancia(a, d)
			dNEW4 = distancia(b, c)
			g1 = distanciaGanada(dOLD1, dOLD2, dNEW1, dNEW2)
			g2 = distanciaGanada(dOLD1, dOLD2, dNEW3, dNEW4)
			ganancia = Math.min(g1, g2)
			if (ganancia < minG) {
				minG = ganancia
				if (g1 < g2) {
					ladosAgregarC1 = arrayOf(a, c)
					ladosAgregarC2 = arrayOf(b, d)
				} else {
					ladosAgregarC1 = arrayOf(a, d)
					ladosAgregarC2 = arrayOf(b, c)
				}
				ladosEliminarC1 = arrayOf(a, b)
				ladosEliminarC2 = arrayOf(c, d)
			}
		}
	}
	//se aregan a dos nuevos arreglos, los lados viejos sin contar los que se quieren reemplazar
	if (c1.size == 2) {
		c1_2 += c1[0]
	} else {
		for (i in 0 until c1.size) {
			//no se permiten los lados que coincidan con los que se quieren eliminar
			if ((c1[i][0] != ladosEliminarC1[0] || c1[i][1] != ladosEliminarC1[1]) && (c1[i][0] != ladosEliminarC1[1] || c1[i][1] != ladosEliminarC1[0])) {
				c1_2 += c1[i]
			}
		}
	}
	//el mismo proceso que el anterior
	if (c2.size == 2) {
		c2_2 += c2[0]
	} else {
		for (j in 0 until c2.size) {
			//no se permiten los lados que coincidan con los que se quieren eliminar
			if ((c2[j][0] != ladosEliminarC2[0] || c2[j][1] != ladosEliminarC2[1]) && (c2[j][0] != ladosEliminarC2[1] || c2[j][1] != ladosEliminarC2[0])) {
				c2_2 += c2[j]
			} 
		}
	}

	//se agregan los nuevos lados
	c1_2 += ladosAgregarC1
	c2_2 += ladosAgregarC2

	//se añaden a un nuevo arreglo, los elementos de los ciclos anteriores con los lados modificados
	for (k in 0 until c1.size) {
		c3 += c1_2[k]
	}
	for (l in 0 until c2.size) {
		c3 += c2_2[l]
	}
	return c3
}
/**
*	Función que devuelve un ciclo con una sola ciudad dada, tiene como único argumento un arreglo de tipo Array<Pair<Double, Double>> 
*	con una sola ciudad, y devuelve un arreglo de tipo Array<Array<Pair<Double, Double>>>, es un ciclo de una sola ciudad, con la ciudad dada
*	Precondición: P debe ser un arreglo que contiene variables de tipo par que contiene dos elementos doubles, debe contener una de las ciudades dadas
*	Postcondicion: Se debe retornar un arreglo de arreglos de pares de doubles, debe tener un ciclo con la ciudad dada
*/
fun cicloUnaCiudad(P: Array<Pair<Double, Double>>): Array<Array<Pair<Double, Double>>>{
	return arrayOf(arrayOf(P[0], P[0]))
}
/**
*	Función que devuelve un ciclo con dos ciudades dadas, tiene como único argumento un arreglo de tipo Array<Pair<Double, Double>> 
*	con dos ciudades, y devuelve un arreglo de tipo Array<Array<Pair<Double, Double>>>, es un ciclo de dos ciudades, con las únicas dos ciudades dadas
*	Precondición: P debe ser un arreglo que contiene variables de tipo par que contiene dos elementos doubles, debe contener 2 de las ciudades dadas
*	Postcondicion: Se debe retornar un arreglo de arreglos de pares de doubles, debe tener un ciclo con las 2 ciudades dadas
*/
fun cicloDosCiudades(P: Array<Pair<Double, Double>>): Array<Array<Pair<Double, Double>>> {
	return arrayOf(arrayOf(P[0], P[1]), arrayOf(P[1], P[0]))
}
/**
*	Función que devuelve un ciclo con tres ciudades dadas, tiene como único argumento un arreglo de tipo Array<Pair<Double, Double>> 
*	con tres ciudades, y devuelve un arreglo de tipo Array<Array<Pair<Double, Double>>>, es un ciclo de tres ciudades, con las únicas tres ciudades dadas
*	Precondición: P debe ser un arreglo que contiene variables de tipo par que contiene dos elementos doubles, debe contener 3 de las ciudades dadas
*	Postcondicion: Se debe retornar un arreglo de arreglos de pares de doubles, debe tener un ciclo con las 3 ciudades dadas
*/
fun cicloTresCiudades(P: Array<Pair<Double, Double>>): Array<Array<Pair<Double, Double>>> {
	return arrayOf(arrayOf(P[0], P[1]), arrayOf(P[1], P[2]), arrayOf(P[2], P[0]))
}
/**
*	Función que crea un tour con las ciudades dadas
*		Argumentos:
*			P: Variable de tipo arreglo de pares de doubles. Contiene a las ciudades del tour 
*		Retorna:
*			Un tour válido de las ciudades dadas
*	Precondición: P debe ser un arreglo que contiene variables de tipo par que contiene dos elementos doubles, debe contener ciudades dadas
*	Postcondicion: Se debe retornar un arreglo de arreglos de pares de doubles. Este arreglo debe contener un ciclo válido para las ciudades dadas
*/
fun divideAndConquerTSP(P: Array<Pair<Double, Double>>): Array<Array<Pair<Double, Double>>>{

	var n : Int = P.size

	//en caso de ser pocas ciudades, re retornan ciclos de 1, 2 o 3 ciudades
	if (n == 0) {
		return arrayOf()
	} else if (n == 1) {
		return cicloUnaCiudad(P)
	} else if (n == 2) {
		return cicloDosCiudades(P)
	}else if (n == 3) {
		return cicloTresCiudades(P)
	} else {
		//en caso contrario, se divide el problema en problemas más pequeños
		var c1 : Array<Array<Pair<Double, Double>>>
		var c2 : Array<Array<Pair<Double, Double>>>
		var particiones : Pair<Array<Pair<Double, Double>>, Array<Pair<Double, Double>>> = obtenerParticiones(P)
		var pderecha : Array<Pair<Double, Double>> = particiones.first
		var pizquierda : Array<Pair<Double, Double>> = particiones.second
		
		c1 = divideAndConquerTSP(pderecha)
		c2 = divideAndConquerTSP(pizquierda)

		return combinarCiclos(c1, c2)
	}
}
/**
*	Función que ordena un ciclo de ciudades dado y empieza desde la ciudad de origen
*		Parámetros:
*			cO: Variable de tipo par de doubles, es la ciudad de origen, que será la ciudad donde iniciará el ciclo
*			C: Variable de tipo arreglo de arreglos de pares de doubles, contiene el ciclo desordenado 
*		Retorna:
*			Un arreglo de arreglos de pares de doubles. Este arreglo es un ciclo ordenado hecho a partir de ciclo desordenado dado de parámetro
*	Precondición: El parámetro cO debe ser de tipo Pair<Double, Double> y debe representar la primera ciudad introducida en el arreglo de ciudades
*	original y C debe ser de tipo Array<Array<Pair<Double, Double>>> y debe ser un ciclo de las ciudades dadas en la función principal
*	Postdoncidión: Se debe retornar un Array<Array<Pair<Double, Double>>>, es decir un arreglo de arreglos de pares de doubles. Debe ser el 
*	ciclo de las ciudades, debe estar ordenado y debe empezar por la primera ciudad indicada en la función principal.
*/
fun ordenaCiclo(cO: Pair<Double, Double>, C: Array<Array<Pair<Double, Double>>>): Array<Array<Pair<Double, Double>>>{

	var ciudadMin : Pair<Double, Double> = cO
	var ciudadBuscar : Pair<Double, Double> = Pair(0.000, 0.000)
	var cicloOrdenado : Array<Array<Pair<Double, Double>>> = arrayOf()
	var k : Int = 0
	var buscar : Boolean = true

	//Busco en el arreglo el primer par con la ciudad de origen
	for (i in 0 until C.size) {
		if (C[i][0] == ciudadMin) {
			ciudadBuscar = C[i][1] //guardo la ciudad que le sigue
			break
		} else if (C[i][1] == ciudadMin) {
			ciudadBuscar = C[i][0] // guardo la ciudad que le sigue
			break
		}
	}
	//agrego el lado de la primera ciudad con otra ciudad con la que comparta uno de sus lados
	cicloOrdenado += arrayOf(ciudadMin, ciudadBuscar)

	//incio el proceso de buscar las siguientes ciudades de manera que se ordenen los lados 
	for (j in 0 until C.size-1) {
		while (buscar && k < C.size) {
			//comparo las ciudades de manera que obtengo el siguiente lado de la ciudad buscada, pero no el lado que comparte con ciudades ya encontradas
			if (C[k][0] == ciudadBuscar && C[k][1] != ciudadMin) { 
				cicloOrdenado += arrayOf(C[k][0], C[k][1])
				ciudadMin = C[k][0] 
				ciudadBuscar = C[k][1]
				buscar = false
			} else if (C[k][1] == ciudadBuscar && C[k][0] != ciudadMin) {
				cicloOrdenado += arrayOf(C[k][1], C[k][0])
				ciudadMin = C[k][1]
				ciudadBuscar = C[k][0]
				buscar = false
			}
			k++
		}
		buscar = true
		k = 0
	}
	return cicloOrdenado

}
/**
*	Función que lee un archivo localizado en una ruta dada y obtiene las ciudades de ciclo a partir de los datos del archivo
*		Argumentos:
*			path: Una variable de tipo String que contiene la ruta del archivo a leer
*		Retorna:
*			Un arreglo de pares de doubles. Este arreglo contiene las ciudades porporcionadas por el archivo
*	Precondición: path debe ser un String, debe ser también una ruta válida donde se encuentra un archivo .txt con las ciudades
*	Postcondición: Se debe retornar un Array<Pair<Double, Double>>, este arreglo debe contener a todas las ciudades proporcionadas por el archivo
*/
fun leeArchivo(path: String): Array<Pair<Double, Double>> {

	val archivo : File = File(path)
	var lineasLista : MutableList<String> = mutableListOf<String>()
	var lineasArreglo : Array<String> = arrayOf() 
	var ciudades : Array<Pair<Double, Double>> = arrayOf()

	//obtengo las líneas del archvio y se almacenan en una lista mutable
	archivo.useLines { lines -> lines.forEach {lineasLista.add(it) } }

	//se cambia a un arreglo, pero solo se pasan las líneas después de la 6, ya que en la 7 comienzan a aparecer las ciudades
	for (i in 0 until lineasLista.size) {
		if (i > 5) {
			lineasArreglo += lineasLista[i]
		}
	}

	//obtiene las coordenadas, las toma como string y las convierte a doubles y las agrega al arreglo de ciudades
	for (j in 0 until lineasArreglo.size) {
		if (lineasArreglo[j] != "EOF") {
			var coordXStr : String = ""
			var coordYStr : String = ""
			var coordX : Double 
			var coordY : Double
			var numLin : String = ""
			var k : Int = 0
			while (k < lineasArreglo[j].length) {
				while (lineasArreglo[j][k].toString() == " "){
					k++
				}
				while (lineasArreglo[j][k].toString() != " "){		
					numLin = "$numLin${lineasArreglo[j][k]}"
					k++
				}
				while (lineasArreglo[j][k].toString() == " "){
					k++
				}
				while (lineasArreglo[j][k].toString() != " "){		
					coordXStr = "$coordXStr${lineasArreglo[j][k]}"
					k++
				}
				while (lineasArreglo[j][k].toString() == " "){
					k++
				}
				while (k < lineasArreglo[j].length){		
					coordYStr = "$coordYStr${lineasArreglo[j][k]}"
					k++
				}
			}
			coordX = coordXStr.toDouble()
			coordY = coordYStr.toDouble()
			ciudades += Pair(coordX, coordY)
		} else { break }
	}

	return ciudades 
}
/**
*	Función que calcula la distancia total de un tour dado
*		Argumentos:
*			ciclo: Variable de tipo Array<Array<Pair<Double, Double>>>, es un arreglo de arreglos de pares de doubles y representa el tour
*		Retorna:
*			Un double que representa la distancia total del tour
*	Precondición: ciclo debe ser de tipo Array<Array<Pair<Double, Double>>> y debe ser el tour
*	Postcondición: Se debe retornar un double que coincida con la distancia total de tour, debe ser un número positivo
*/
fun distanciaTotal(ciclo: Array<Array<Pair<Double, Double>>>): Double {

	var distanciaTotal : Double = 0.000

	for (i in 0 until ciclo.size) {
		distanciaTotal += distancia(ciclo[i][0], ciclo[i][1]) //sumo la distancia de cada lado
	}

	return distanciaTotal
}
/**
*	Busca el nombre deseado del archivo de salida especificado en la ruta donde se creará el archivo
*		Argumentos:
*			path: Variable de tipo String, es la ruta de creación del archico y de donde se obtendrá el nombre del archivo
*		Retorna:
*			Un string que representa el nombre desdeado del archivo
*	Precondición: path debe ser un string y debe tener indicado el nombre deseado con su extensión
*	Postcondición: Se debe retornar un string que coincida con el nombre deseado
*/
fun buscaNombre(path: String): String {

	var nombre : String = ""
	var primerChar : Int = 0

	for (i in path.length-1 downTo 0) {
		if (path[i].toString() == "/") { //se busca el primer / de derecha a izquierda, ya que después de ese slash que especifica la carpeta, está el nombre
			primerChar = i + 1
			break
		}
	}
	for (j in primerChar until path.length) {
		nombre = "$nombre${path[j]}" //se obtiene el nombre completo agregando caracter por caracter
	}

	return nombre
}
/**
*	Función que crea un archivo de salida con la solución del tour más corto
*		Argumentos:
*			path: Variable de tipo string que contiene la ruta de creación del archivo
*			ciudades: Variable de tipo Array<Pair<Double, Double>>. Es un arreglo que contiene todas las ciudades en su orden original
*			ciclo: Variable de tipo Array<Array<Pair<Double, Double>><. Es un arreglo que contiene arreglos que a su vez contienen los lados del tour
*			distanciaTotal: Variable de tipo Double que proporciona la distancia total del tour
*	Precondición: path debe ser un string que contenga la ruta de creación del archivo, por lo tanto también debe contener el nombre del mismo,
*	ciudades debe ser de tipo Array<Pair<Double, Double>> y debe tener todas las ciudades en el orden de entrada, ciclo debe ser un tour con los lados ordenados
*	y distanciaTotal debe ser un double positivo que represente la istancia total del tour
*	Postcondición: Se debe crear un archivo con el nombre espeficicado, en la ruta especificada, que contenga información del tour como la dimensión,
*	la distancia total recorrida y el orden más óptimo
*/
fun creaArchivo(path: String, ciudades: Array<Pair<Double, Double>>, ciclo: Array<Array<Pair<Double, Double>>>, distanciaTotal: Int) {

	val archivo : File = File(path)
	val nombre : String = buscaNombre(path)

	archivo.printWriter().use { out ->
		out.println("NAME : $nombre")
		out.println("COMMENT : Length $distanciaTotal")
		out.println("TYPE : TOUR")
		out.println("DIMENSION : ${ciclo.size}")
		out.println("TOUR_SECTION")
		for (i in 0 until ciclo.size) {
			var num : Int = ciudades.indexOf(ciclo[i][0]) + 1
			out.println("$num")
		}
		out.println("-1")
		out.print("EOF")
	}
}
/**
*	Función que comprueba que el ciclo es válido para ser un tour. De no ser válido proporciona un mensaje de error y termina la ejecución del programa
*		Argumentos:
*			ciudades: Variable de tipo Array<Pair<Double, Doule>>. Es un arreglo que contiene las ciudades especificadas en la entrada del programa
*			ciclo: Variable de tipo Array<Array<Pair<Double, Double>>>. Es un arreglo de arreglos que contienen los lados del ciclo
*	Precondición: ciudades debe ser de tipo Array<Pair<Double, Double>>, debe contener todas las ciudades en el orden especificado en la entrada del programa,
*	ciclo debe ser de tipo Array<Array<Pair<Double, Double>>>, debe contener todos los lados del tour de manera ordenada
*	Postcondición: Debe arrojar un mensaje de error y detener la ejecución si el ciclo no es válido, es decir, si está desordenado, o no empieza y termina
*	en la misma ciudad, o el número de lados no es igual al número de ciudades, o se repiten los lados o las ciudades no aparecen 2 veces en el ciclo
*/
fun compruebaCiclo(ciudades: Array<Pair<Double, Double>>, ciclo: Array<Array<Pair<Double, Double>>>) {

	var count : Int

	//verifico que haya igual número de lados que de ciudades
	if (ciudades.size != ciclo.size) {
		println("Disculpe, hubo un error de ejecución, el ciclo no es válido.")
		exitProcess(1)
	}
	//verifico que el ciclo empiece y termine en la primera ciudad especificada
	if (ciudades[0] != ciclo[0][0] || ciudades[0] != ciclo[ciclo.size-1][1]) {
		println("Disculpe, hubo un error de ejecución, el ciclo no es válido.")
		exitProcess(1)
	}
	for (i in 0 until ciclo.size) {
		count = 0
		for (j in 0 until ciclo.size) {
			//verifico que no se repitan los lados
			if ((ciclo[j] == ciclo[i] && i != j) || (ciclo[j][0] == ciclo[i][1] && ciclo[j][1] == ciclo[i][0])) {
				println("Disculpe, hubo un error de ejecución, el ciclo no es válido.")
				exitProcess(1)
			}
			//verifico que esté ordenado
			if (i != ciclo.size-1) {
				if (ciclo[i][1] != ciclo[i+1][0]) {
					println("Disculpe, hubo un error de ejecución, el ciclo no es válido.")
					exitProcess(1)
				}
			}
			//verifico cuantas veces aparecen las ciudades
			if (ciudades[i] == ciclo[j][0] || ciudades[i] == ciclo[j][1]) {
				count++
			}
		}
		//verifico que las ciudades aparezcan 2 veces
		if (count != 2) {
			println("Disculpe, hubo un error de ejecución, el ciclo no es válido.")
			exitProcess(1)
		}
	}

}
fun main(args: Array<String>) {
	val ciudades : Array<Pair<Double, Double>> = leeArchivo(args[0])
	var ciudadesCambiar : Array<Pair<Double, Double>> = ciudades.copyOf()
	var ciudadOrigen : Pair<Double, Double> = ciudades[0]
	var ciclo : Array<Array<Pair<Double, Double>>> = divideAndConquerTSP(ciudadesCambiar)
	val dTotal : Int
	val nombreInstancia : String = buscaNombre(args[0])

	ciclo = ordenaCiclo(ciudadOrigen, ciclo)
	dTotal = distanciaTotal(ciclo).toInt()
	compruebaCiclo(ciudades, ciclo)
	println("Instancia $nombreInstancia")
	println("Distancia total del tour: $dTotal")
	println("")
	creaArchivo(args[1], ciudades, ciclo, dTotal.toInt())
	
}
