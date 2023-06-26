# Trabalho Final Programação para Dispositivos Móveis 2023-01
Professora Ana Karina  
Turma 02

### Alunos

- Tiago Giarranti Guidorizzi 
- Pedro Henrique Rocha de Oliveira
- Felippe Baes Sales Lara

### Ideia Principal

  #### Conceito Geral
  
  Um app de contratações para o mercado de trabalho remoto, a ideia central é conectar contratantes com candidatos de forma rápida e eficiente.  

### Papéis de Usuário

O usuário (candidato ou contratante) pode se candidatar à uma vaga ou criar uma vaga de emprego.   
Também haverá as funcionalidades de:

### Requisitos Obrigatórios

> #### Fazer testes de caixa preta e tratar erros como
>> um usuário não cadastrado conseguir acessar o sistema,
>> 
>> um campo vazio necessário, uma divisão por zero,
>> 
>> uma entrada errada como: permitir entrar com textos em um campo numérico.
>
> #### Ter uma **tela inicial de login** com cadastro de usuários
>> O ideal seria guardar somente o hash da senha para segurança
>> 
>> e guardar a foto do usuário.
>> 
>> Tentar associar as atividades aos usuários, por exemplo, se for um jogo, que o jogo guarde
o escore dos usuários.

### Outros Requisitos

RF-1 Permitir a remoção, edição ou adição de vagas com os seguintes atributos: 
ID, ID do contratante, nome do contratante, carga horaria, salario;  
RF-2 Permitir uma listagem de todos os candidatos para determinada vaga  
RF-3 Permitir uma listagem de todas as vagas que o candidato já participou  
RF-4 Permitir que o contratante visualize as informações de contato do candidato  

#### Requisitos de Cadastro

  RF-5 O sistema deve permitir a adição, edição ou remoção de usuários com os seguintes atributos: 
  ID, nome, telefone, email, expectativa salarial;  
  RF-6 O sistema deve permitir a adição, edição ou remoção de candidaturas com os seguintes atributos: 
  *instancia referenciando o candidato*  
  
#### Requisitos não funcionais 

RNF-1 Permitir a mudança de tamanho de fonte  
RNF-2 Permitir a mudança de tema de cores (escuro, claro ou Dimm)  
RNF-3 Permitir a remoção, edição ou adição de fotos novas do usuário  

### Recursos

Cores, Câmera, Fonte, ListView, Fragmentos
