# 🎂 Sistema de Verificação de Aniversários

Aplicação de console desenvolvida em **Java** para consultar, cadastrar e buscar aniversários por meio de um menu interativo no terminal.

## 📋 Sobre o projeto

O sistema mantém uma agenda de aniversários em memória, organizada por data (`DD/MM`). Várias pessoas podem compartilhar a mesma data, e o programa exibe uma mensagem de parabéns para todas elas ao consultar o dia.

## ✨ Funcionalidades

| Opção | Descrição |
|-------|-----------|
| **1** | Verificar hoje: informa a data de hoje e mostra quem faz aniversário |
| **2** | Verificar data específica: consulta qualquer data no formato `DD/MM` |
| **3** | Listar todos os aniversários, ordenados por data |
| **4** | Adicionar novo aniversário (nome + data) |
| **5** | Procurar por nome (busca parcial, sem diferenciar maiúsculas de minúsculas) |
| **0** | Sair |

Outros recursos:

- Validação do formato de data (`DD/MM`), com dia entre 1 e 31 e mês entre 1 e 12
- Validação de nome vazio no cadastro e na busca
- Tratamento de opção inválida no menu
- Suporte a mais de uma pessoa na mesma data

## 🛠️ Tecnologias

- **Java** (JDK 8 ou superior)
- `HashMap` e `ArrayList` para armazenar os aniversários
- `TreeMap` para ordenar a listagem
- `Scanner` para leitura dos dados no terminal

## 📁 Estrutura do projeto

```
aniversario123/
├── src/
│   └── Main.java           # Código-fonte da aplicação
├── aniversario123.iml      # Configuração do módulo (IntelliJ IDEA)
└── .idea/                  # Configurações do projeto (IntelliJ IDEA)
```

## 🚀 Como executar

### Pré-requisito

- [JDK](https://www.oracle.com/java/technologies/downloads/) instalado (versão 8 ou superior)

### Pelo terminal

1. Acesse a pasta onde está o `Main.java`:

   ```bash
   cd aniversario123/src
   ```

2. Compile o código:

   ```bash
   javac Main.java
   ```

3. Execute o programa:

   ```bash
   java Main
   ```

### Pelo IntelliJ IDEA

1. Abra a pasta do projeto no IntelliJ (**File > Open**)
2. Abra o arquivo `Main.java`
3. Clique no botão ▶️ ao lado do método `main`

> 💡 O programa usa emojis e caracteres de caixa (`╔═╗`). Se aparecerem símbolos estranhos no terminal, configure-o para UTF-8.

## 💻 Exemplo de uso

```
┌─── MENU PRINCIPAL ───┐
│ 1. Verificar hoje
│ 2. Verificar data específica
│ 3. Listar todos os aniversários
│ 4. Adicionar novo aniversário
│ 5. Procurar por nome
│ 0. Sair
└──────────────────────┘
Escolha uma opção: 2
Digite a data (formato: DD/MM): 16/10
```

## ⚙️ Como funciona

Os aniversários ficam em um `HashMap<String, ArrayList<String>>`, em que a **chave** é a data (`DD/MM`) e o **valor** é a lista de nomes das pessoas que fazem aniversário naquele dia. Alguns aniversários de exemplo são carregados ao iniciar o programa. A listagem usa um `TreeMap` para exibir as datas em ordem.

## ⚠️ Limitações

- Os dados ficam apenas em memória: aniversários adicionados são perdidos ao encerrar o programa
- A opção "Verificar hoje" pede que o usuário digite a data, em vez de usar a data do sistema
- A validação aceita datas que não existem no calendário, como `31/02`
- A listagem ordena as datas como texto, ou seja, primeiro pelo dia e depois pelo mês, e não de forma cronológica

## 🔮 Possíveis melhorias

- [ ] Usar `LocalDate` para obter automaticamente a data de hoje
- [ ] Validar dias por mês (e anos bissextos)
- [ ] Ordenar a listagem cronologicamente (mês e depois dia)
- [ ] Salvar os aniversários em arquivo (CSV ou JSON) para manter os dados
- [ ] Permitir editar e remover aniversários
- [ ] Mostrar quantos dias faltam para o próximo aniversário

## 📄 Licença

Este projeto foi desenvolvido para fins de estudo e pode ser usado livremente.
