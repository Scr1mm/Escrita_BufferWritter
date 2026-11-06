# 📝 Escrita de Arquivos em Java com BufferedWriter

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Projeto-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![CSV](https://img.shields.io/badge/Arquivos-CSV-blue?style=for-the-badge)
![UC](https://img.shields.io/badge/UC-LOPAL-purple?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen?style=for-the-badge)

Projeto desenvolvido em **Java** na **UC LOPAL (Dia 30)**. O programa lê um inventário de hosts de rede, classifica cada máquina pela **criticidade** do sistema operacional e grava os resultados em novos arquivos CSV usando **BufferedReader** e **BufferedWriter**.

---

## Sobre o projeto

O projeto simula uma ferramenta de **auditoria de inventário de TI**. Ele lê o arquivo `hosts.csv`, que tem o nome, o IP e o sistema operacional de cada máquina. Depois processa os registros linha por linha e gera relatórios com informações novas.

Os exercícios trabalham estes conceitos:

- Leitura de arquivos com `BufferedReader`
- Escrita de arquivos com `BufferedWriter`
- Manipulação de arquivos CSV
- Separação de campos com `split()`
- Estruturas condicionais (`if/else` e `switch`)
- Contadores dentro de laços de repetição
- Manipulação de datas com `LocalDate`
- Tratamento de exceções com `try/catch`

---

## Regra de criticidade

Cada host é classificado pelo sistema operacional:

| Sistema operacional | Criticidade |
|---------------------|:-----------:|
| Kali Linux | 🔴 Alta |
| Ubuntu, Debian, Rocky | 🟢 Baixa |
| Qualquer outro | 🟡 Media |

---

## Desafios

| Desafio | Descrição | Arquivo gerado |
|:-------:|-----------|----------------|
| 1 | Adiciona a coluna **status**: Windows recebe `Online` e Linux recebe `Em Monitoramento` | `inventario_desafio1.csv` |
| 2 | **Conta** quantos hosts usam Windows, Linux e macOS e mostra o resumo no console | `inventario_desafio2.csv` |
| 3 | Gera um segundo CSV **só com os hosts de criticidade Alta** | `hosts_criticos.csv` |
| 4 | Adiciona a coluna **data_auditoria** com a data de geração do relatório | `inventario_desafio4.csv` |
| 5 | Adiciona a coluna **risco** (de 1 a 10) para integração com o **NetSentinel** | `inventario_desafio5.csv` |

Cada desafio fica numa classe própria, com seu próprio `main`, e roda de forma **independente**.

---

## Desafio 5: Integração com o NetSentinel

A coluna `risco` converte a criticidade num valor numérico, que outros sistemas de monitoramento conseguem usar:

| Criticidade | Risco |
|:-----------:|:-----:|
| Alta | 9 |
| Media | 5 |
| Baixa | 2 |
| Indefinida | 1 |

---

## Exemplo de entrada e saída

**Entrada:** `hosts.csv`

```csv
host,ip,so
srv-web01,192.168.0.10,Ubuntu 22.04
pentest01,192.168.0.20,Kali Linux 2024.1
estacao-rh,192.168.0.30,Windows 11
```

**Saída:** `inventario_atualizado.csv`

```csv
host,ip,so,criticidade,status,data_auditoria,risco
srv-web01,192.168.0.10,Ubuntu 22.04,Baixa,Em Monitoramento,06/11/2026,2
pentest01,192.168.0.20,Kali Linux 2024.1,Alta,Em Monitoramento,06/11/2026,9
estacao-rh,192.168.0.30,Windows 11,Media,Online,06/11/2026,5
```

**Console (Desafio 2):**

```
 Resumo de Sistemas Operacionais
Windows: 3
Linux:   6
macOS:   1
Total:   10
```

---

## Tecnologias e conceitos

- **Java 17**
- **Maven**
- `BufferedReader` / `FileReader`
- `BufferedWriter` / `FileWriter`
- `String.split()`, `contains()` e `toLowerCase()`
- `LocalDate` e `DateTimeFormatter`
- Estruturas `if/else` e `switch`
- Laço `while`
- Tratamento de exceções com `IOException`

---

## Como executar

É preciso ter o **Java 17 ou superior** instalado.

**Verificar a instalação:**

```bash
java -version
javac -version
```

**Compilar o projeto** (a partir da pasta raiz):

```bash
javac -d out demo/src/main/java/com/example/*.java
```

**Rodar um desafio:**

```bash
java -cp out com.example.Desafio_1
java -cp out com.example.Desafio_2
java -cp out com.example.Desafio_3
java -cp out com.example.Desafio_4
java -cp out com.example.Desafio_5
```

> ⚠️ O arquivo `hosts.csv` precisa estar na **pasta raiz** do projeto, que é de onde o programa é executado.

**Pela IDE (VS Code, IntelliJ ou Eclipse):** abra a pasta raiz, escolha a classe do desafio e clique em **Run**.

---

## Estrutura

```
Escrita_BufferWritter/
├── hosts.csv                  # arquivo de entrada
├── inventario_atualizado.csv  # exemplo de saída completa
├── hosts_criticos.csv         # exemplo de saída só com hosts críticos
└── demo/
    ├── pom.xml
    └── src/
        └── main/
            └── java/
                └── com/example/
                    ├── Desafio_1.java
                    ├── Desafio_2.java
                    ├── Desafio_3.java
                    ├── Desafio_4.java
                    └── Desafio_5.java
```

---

## Objetivo

Projeto feito com **finalidade acadêmica**, para praticar **leitura e escrita de arquivos**, **manipulação de dados em CSV** e **lógica de programação em Java**, aplicadas a um cenário real de **auditoria de inventário de TI**.
