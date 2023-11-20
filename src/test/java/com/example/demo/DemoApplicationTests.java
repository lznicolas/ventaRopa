package com.example.demo;

import org.assertj.core.api.ClassBasedNavigableIterableAssert;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;

//import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

//@SpringBootTest
class DemoApplicationTests {

	Calculadora calculadora = new Calculadora();
	@Test
	void sumaDeValores() {
		//Given
		int num1=1;
		int num2=2;
		//When
		int expectativa = calculadora.sumarValores(num1,num2);

		//Then

		int resultadoEsperado = 3;
		assertThat(expectativa).isEqualTo(resultadoEsperado);

	}

	class Calculadora{
		int sumarValores(int num1, int num2){
			return num1+num2;
		}
	}

}
