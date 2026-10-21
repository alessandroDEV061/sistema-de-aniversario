import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeMap;

public class Main {
    private static HashMap<String, ArrayList<String>> aniversarios;
    private static Scanner scanner;
    
    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        aniversarios = inicializarAniversarios();
        
        exibirBemVindo();
        
        boolean continuar = true;
        while (continuar) {
            exibirMenu();
            int opcao = obterOpcao();
            
            switch (opcao) {
                case 1:
                    verificarAniversarioHoje();
                    break;
                case 2:
                    verificarDataEspecifica();
                    break;
                case 3:
                    listarTodosAniversarios();
                    break;
                case 4:
                    adicionarNovoAniversario();
                    break;
                case 5:
                    procurarAniversariosPorNome();
                    break;
                case 0:
                    continuar = false;
                    encerrar();
                    break;
                default:
                    System.out.println("❌ Opção inválida! Tente novamente.");
            }
            
            if (continuar) {
                System.out.print("\n[Pressione ENTER para continuar]");
                scanner.nextLine();
            }
        }
    }
    
    private static HashMap<String, ArrayList<String>> inicializarAniversarios() {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        adicionarAniversario(map, "16/10", "João Lucas");
        adicionarAniversario(map, "16/10", "Alessandro Vieira");
        adicionarAniversario(map, "12/05", "Fernanda Vieira");
        adicionarAniversario(map, "17/01", "Gabrielle Sampaio");
        adicionarAniversario(map, "06/11", "Alessandro Junior");
        
        return map;
    }
    
    private static void adicionarAniversario(HashMap<String, ArrayList<String>> map, String data, String nome) {
        if (!map.containsKey(data)) {
            map.put(data, new ArrayList<>());
        }
        map.get(data).add(nome);
    }
    
    private static void exibirBemVindo() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║   🎂 SISTEMA DE VERIFICAÇÃO DE ANIVERSÁRIOS 🎂   ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
    }
    
    private static void exibirMenu() {
        System.out.println("\n┌─── MENU PRINCIPAL ───┐");
        System.out.println("│ 1. Verificar hoje");
        System.out.println("│ 2. Verificar data específica");
        System.out.println("│ 3. Listar todos os aniversários");
        System.out.println("│ 4. Adicionar novo aniversário");
        System.out.println("│ 5. Procurar por nome");
        System.out.println("│ 0. Sair");
        System.out.println("└──────────────────────┘");
    }
    
    private static int obterOpcao() {
        System.out.print("Escolha uma opção: ");
        try {
            int opcao = Integer.parseInt(scanner.nextLine());
            return opcao;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    
    private static void verificarAniversarioHoje() {
        System.out.print("Digite a data de hoje (formato: DD/MM): ");
        String data = scanner.nextLine();
        
        if (!validarData(data)) {
            System.out.println("❌ Data inválida! Use o formato DD/MM");
            return;
        }
        
        exibirResultadoAniversario(data);
    }
    
    private static void verificarDataEspecifica() {
        System.out.print("Digite a data (formato: DD/MM): ");
        String data = scanner.nextLine();
        
        if (!validarData(data)) {
            System.out.println("❌ Data inválida! Use o formato DD/MM");
            return;
        }
        
        exibirResultadoAniversario(data);
    }
    
    private static void exibirResultadoAniversario(String data) {
        if (aniversarios.containsKey(data)) {
            ArrayList<String> pessoas = aniversarios.get(data);
            System.out.println("\n╔═══════════════════════════════════════════╗");
            for (String pessoa : pessoas) {
                System.out.println("║  🎉  Feliz Aniversário, " + String.format("%-20s", pessoa) + "! 🎉  ║");
            }
            System.out.println("╚═══════════════════════════════════════════╝");
        } else {
            System.out.println("ℹ️  Nenhum aniversário registrado para esta data.");
        }
    }
    
    private static void listarTodosAniversarios() {
        if (aniversarios.isEmpty()) {
            System.out.println("ℹ️  Nenhum aniversário registrado.");
            return;
        }
        
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║        📅 LISTA DE TODOS OS ANIVERSÁRIOS        ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        // Ordenar datas
        TreeMap<String, ArrayList<String>> sorted = new TreeMap<>(aniversarios);
        
        for (String data : sorted.keySet()) {
            ArrayList<String> pessoas = sorted.get(data);
            System.out.print("\n[" + data + "]: ");
            for (int i = 0; i < pessoas.size(); i++) {
                if (i > 0) System.out.print(", ");
                System.out.print(pessoas.get(i));
            }
        }
        System.out.println("\n");
    }
    
    private static void adicionarNovoAniversario() {
        System.out.print("Digite o nome da pessoa: ");
        String nome = scanner.nextLine();
        
        if (nome.trim().isEmpty()) {
            System.out.println("❌ Nome não pode estar vazio!");
            return;
        }
        
        System.out.print("Digite a data de aniversário (formato: DD/MM): ");
        String data = scanner.nextLine();
        
        if (!validarData(data)) {
            System.out.println("❌ Data inválida! Use o formato DD/MM");
            return;
        }
        
        adicionarAniversario(aniversarios, data, nome);
        System.out.println("✅ Aniversário de " + nome + " (" + data + ") adicionado com sucesso!");
    }
    
    private static void procurarAniversariosPorNome() {
        System.out.print("Digite o nome a procurar: ");
        String nomeBuscado = scanner.nextLine().toLowerCase();
        
        if (nomeBuscado.trim().isEmpty()) {
            System.out.println("❌ Nome não pode estar vazio!");
            return;
        }
        
        System.out.println("\n📋 Resultados da busca:");
        boolean encontrou = false;
        
        for (String data : aniversarios.keySet()) {
            for (String nome : aniversarios.get(data)) {
                if (nome.toLowerCase().contains(nomeBuscado)) {
                    System.out.println("  ✓ " + nome + " - Data: " + data);
                    encontrou = true;
                }
            }
        }
        
        if (!encontrou) {
            System.out.println("  ℹ️  Nenhum aniversário encontrado com esse nome.");
        }
    }
    
    private static boolean validarData(String data) {
        if (data == null || !data.matches("\\d{2}/\\d{2}")) {
            return false;
        }
        
        String[] partes = data.split("/");
        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            
            if (dia < 1 || dia > 31 || mes < 1 || mes > 12) {
                return false;
            }
            
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private static void encerrar() {
        System.out.println("\n╔════════════════════════════════════════════╗");
        System.out.println("║     Obrigado por usar o sistema! 👋       ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        scanner.close();
    }
}