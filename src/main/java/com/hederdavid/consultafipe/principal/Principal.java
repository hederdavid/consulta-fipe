package com.hederdavid.consultafipe.principal;

import com.fasterxml.jackson.core.type.TypeReference;
import com.hederdavid.consultafipe.model.DadosModelos;
import com.hederdavid.consultafipe.model.ModeloVeiculo;
import com.hederdavid.consultafipe.model.Veiculo;
import com.hederdavid.consultafipe.services.ConsumoAPI;
import com.hederdavid.consultafipe.services.ConverteDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public void exibirInfo() {
        Scanner scanner = new Scanner(System.in);
        String tipoVeiculo = "", url = "", codigoDaMarca = "", modeloVeiculo = "";
        int opcaoEscolhida = 0;

        ConsumoAPI consumoAPI = new ConsumoAPI();
        ConverteDados converteDados = new ConverteDados();

        System.out.println("╔═══════════════════════╗");
        System.out.println("║      Menu de Opções   ║");
        System.out.println("╠═══════════════════════╣");
        System.out.println("║ 1. Motos              ║");
        System.out.println("║ 2. Carros             ║");
        System.out.println("║ 3. Caminhões          ║");
        System.out.println("╚═══════════════════════╝");
        System.out.print("Escolha uma opção: ");
        opcaoEscolhida = scanner.nextInt();

        switch (opcaoEscolhida) {
            case 1 -> tipoVeiculo = "motos";
            case 2 -> tipoVeiculo = "carros";
            case 3 -> tipoVeiculo = "caminhoes";
        }
        url = "https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo + "/marcas";
        var json = consumoAPI.consumirApi(url);

        List<ModeloVeiculo> marcaVeiculos = converteDados.obterDados(json, new TypeReference<>(){});
        for (ModeloVeiculo marcaVeiculo : marcaVeiculos) {
            System.out.println(marcaVeiculo);
        }

        System.out.print("Informe o código da marca para consulta: ");
        codigoDaMarca = scanner.next();

        url = "https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo + "/marcas/" + codigoDaMarca + "/modelos";
        json = consumoAPI.consumirApi(url);
        System.out.println(json);

        DadosModelos dadosModelos = converteDados.obterDados(json, DadosModelos.class);

        List<ModeloVeiculo> modelos = dadosModelos.getModelos();
        for (ModeloVeiculo modelo : modelos) {
            System.out.println("Código: " + modelo.getCodigo() + ", Nome: " + modelo.getNome());
        }



        System.out.print("Informe o código do modelo para consulta: ");
        modeloVeiculo = scanner.next();

        url = "https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo + "/marcas/" + codigoDaMarca + "/modelos/"
                + modeloVeiculo + "/anos";
        json = consumoAPI.consumirApi(url);

        List<ModeloVeiculo> anos = converteDados.obterDados(json, new TypeReference<>(){});


        List<Veiculo> veiculos = new ArrayList<>();
        for (ModeloVeiculo ano : anos) {
            url = "https://parallelum.com.br/fipe/api/v1/" + tipoVeiculo + "/marcas/" + codigoDaMarca + "/modelos/"
                    + modeloVeiculo + "/anos/" + ano.getCodigo();
            json = consumoAPI.consumirApi(url);
            veiculos.add(converteDados.obterDados(json, Veiculo.class));
        }

        for (Veiculo veiculo : veiculos) {
            System.out.println(veiculo);
        }




        


    }

}
