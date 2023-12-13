package ar.com.educacionit.bootcamp.streams;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> valores = List.of(5,7,9,8,15 );
		
		//a partir de la coleccion genero el stream
		
		Stream<Integer> sti = valores.stream();
		
		//aplico operacion intermedia o varias
		
		sti = sti.filter(v -> v>9);
		
		//aplico operacion terminal
		
		List<Integer> filtered = sti.collect(Collectors.toList());
		
		//todo junto
		var filtered2 = valores.stream()				
				.filter(v -> v>9)//filtros
				.map(v -> v * 1.1)//operaciones
				.peek(v->System.out.println(v))//puedo ver que esta haciendo
				.collect(Collectors.toList());
		
		System.out.println(filtered);
		System.out.println(filtered2);
		
		//reducir a una suma todos los valores
		var suma =valores.stream()
				.reduce(0,(x,y)->x+y);
		System.out.println(suma);
		
		//devuelve el mayor
		
		Optional<Integer> max = valores.stream().max(Integer::max);
		System.out.println(max.get());
	}

}
