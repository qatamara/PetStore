//1 - pacote
package petstore;
//2 - bibliotecas


//import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;


//3 - classes
public class Pet {
    // 3.1 - atributos

    String uri = "https://petstore.swagger.io/v2/pet";//endereço da entidade pet


    //3.2 - metodos e funçoes

    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }
    //incluir--create-post
    @Test //identifica o metodo ou função como um teste para testNG
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");


        //sintaxe gherkin
        //dado - quando - então
        //given - when- then

        given()//dado pre condições
                .contentType("application/json")//comum em api rest
                .log().all()//qual tipo de inf vai transmitir registre tudo"
                .body(jsonBody)
        .when()//ação(metodo)
                .post(uri)
        .then()//então
               .log().all()//registra a volta
               .statusCode(200)


        ;



    }

}
